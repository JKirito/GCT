package functions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * Dynamic java class compiler and executer <br>
 * Demonstrate how to compile dynamic java source code, <br>
 * instantiate instance of the class, and finally call method of the class <br>
 *
 * http://www.beyondlinux.com
 *
 * @author david 2011/07
 *
 */
public class CompilerTool
{
	/** where shall the compiled class be saved to (should exist already) */
	private static String _classOutputFolder;

	public static class MyDiagnosticListener implements DiagnosticListener<JavaFileObject>
	{
		@Override
		public void report(Diagnostic<? extends JavaFileObject> diagnostic)
		{

			System.out.println("Line Number->" + diagnostic.getLineNumber());
			System.out.println("code->" + diagnostic.getCode());
			System.out.println("Message->" + diagnostic.getMessage(Locale.ENGLISH));
			System.out.println("Source->" + diagnostic.getSource());
			System.out.println(" ");
		}
	}

	/**
	 * java File Object represents an in-memory java source file <br>
	 * so there is no need to put the source file on hard disk
	 **/
	public static class InMemoryJavaFileObject extends SimpleJavaFileObject
	{
		private String contents = null;

		public InMemoryJavaFileObject(String className, String contents) throws Exception
		{
			super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
			this.contents = contents;
		}

		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException
		{
			return contents;
		}
	}

	/**
	 * Get a simple Java File Object ,<br>
	 * It is just for demo, content of the source code is dynamic in real use
	 * case
	 * 
	 * @param sourceCode
	 * @param className
	 */
	private static JavaFileObject getJavaFileObject(String className, String sourceCode)
	{
		JavaFileObject so = null;
		try
		{
			so = new InMemoryJavaFileObject(className, sourceCode);
		} catch (Exception exception)
		{
			exception.printStackTrace();
		}
		return so;
	}

	/**
	 * compile your files by JavaCompiler Antes de compilar la clase, creo el
	 * directorio donde va a guardarse el .class(es necesario que exista!)
	 * 
	 * @return true si la compilación fue correcta
	 */
	private static boolean compile(Iterable<? extends JavaFileObject> files)
	{
		new File(_classOutputFolder).mkdirs();

		// get system compiler:
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		// for compilation diagnostic message processing on compilation
		// WARNING/ERROR
		MyDiagnosticListener c = new MyDiagnosticListener();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(c, Locale.ENGLISH, null);
		// specify classes output folder
		Iterable<String> options = Arrays.asList("-d", _classOutputFolder);
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, c, options, null, files);
		return task.call();
	}

	/**
	 * run class from the compiled byte code file by URLClassloader
	 * 
	 * @param className
	 * @throws ClassNotFoundException
	 * @throws MalformedURLException
	 */
	private static Class<?> LoadClass(String className) throws ClassNotFoundException, MalformedURLException
	{
		// Create a File object on the root of the directory
		// containing the class file
		File file = new File(_classOutputFolder);
		// Convert File to a URL
		@SuppressWarnings("deprecation")
		URL url = file.toURL(); // file:classOutputFolder
		URL[] urls = new URL[] { url };

		// Create a new class loader with the directory
		@SuppressWarnings("resource")
		ClassLoader loader = new URLClassLoader(urls);

		return loader.loadClass(className);
	}

	public static Class<?> CompileAndGetClass(String className, String sourceCode, String classOutputFolder)
			throws ClassNotFoundException, MalformedURLException
	{
		CompileFile(className, sourceCode, classOutputFolder);

		// 3.Load your class by URLClassLoader, then instantiate the instance,
		// and call method by reflection
		return LoadClass(className);
	}

	public static boolean CompileFile(String className, String sourceCode, String classOutputFolder)
	{
		_classOutputFolder = classOutputFolder;
		// 1.Construct an in-memory java source file from your dynamic code
		JavaFileObject file = getJavaFileObject(className, sourceCode);
		Iterable<? extends JavaFileObject> files = Arrays.asList(file);

		// 2.Compile your files by JavaCompiler
		return compile(files);
	}

}