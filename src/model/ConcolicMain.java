package model;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import com.singularsys.jep.ParseException;

import spoon.Launcher;
import spoon.OutputType;
import spoon.compiler.SpoonCompiler;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.factory.Factory;
import utils.StoreFile;

public class ConcolicMain
{
	// R. Pawlak, C. Noguera, and N. Petitprez. Spoon:
	// Program analysis and transformation in java.
	// Technical Report 5901, INRIA, 2006.

	private static String	tmpPath				= "../tmp/";
	private static String	qualifiedClassName	= "tmp.";
	private static String	className;

	public static void main(String[] args) throws Exception
	{

		// compileAndRunClassExample();
		// if (true)
		// return;

		className = "SrcClass";
		String packagePathToInstrument = "src/input/";
		String classQualifiedNameToInstrument = "input." + className;
		String methodNameToInstrument = "method";

		tmpPath = packagePathToInstrument + tmpPath;
		qualifiedClassName = qualifiedClassName + className;

		init(classQualifiedNameToInstrument, methodNameToInstrument);

	}

	@SuppressWarnings("unused")
	private static void compileAndRunClassExample()
			throws ParseException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			InvocationTargetException, MalformedURLException, ClassNotFoundException
	{
		String pathName = "/home/javi/Escritorio/ejemplo/Ejemplo.java";

		Launcher spoon = new Launcher();
		CtClass<?> _ctClass;
		spoon.addInputResource(pathName);
		// TODO: si tira error es porque la clase no puede compilarse, por
		// ejemplo
		spoon.run();

		Factory factory = spoon.getFactory();
		_ctClass = (CtClass<?>) factory.Class().getAll().get(0);

		List<String> methodsList = new ArrayList<>();
		for (CtMethod<?> m : _ctClass.getAllMethods())
		{
			methodsList.add(m.getSimpleName());
			CtMethod<?> method = m;

			Instrumentator instrumentator = new Instrumentator(method, factory);
			instrumentator.process();
		}
		// System.out.println(_ctClass.getActualClass());
		System.out.println(methodsList);

		factory.getEnvironment().setComplianceLevel(8);
		SpoonCompiler compilerSpoon = spoon.createCompiler(factory);
		// compilerSpoon.build();
		// compilerSpoon.compile();
		compilerSpoon.generateProcessedSourceFiles(OutputType.CLASSES);
		// SpoonCompiler comp = new JDTBasedSpoonCompiler(spoon.getFactory());
		// comp.compileInputSources();

		// _ctClass.compileAndReplaceSnippets();
		// _ctClass.updateAllParentsBelow();
		// System.out.println("EJEMLPLO: " +
		// _ctClass.getMethodsByName("max").toString());
		//
		// Class<?> ejemplo = (Class<?>)
		// factory.Class().get("Ejemplo").getClass();
		// Object instanceEjemplo = ejemplo.newInstance();
		//
		// System.out.println("methodS: " +
		// instanceEjemplo.getClass().getDeclaredMethods().length);
		// Method methodCallEjemplo =
		// instanceEjemplo.getClass().getMethod("max", int.class, int.class);
		// System.out.println(methodCallEjemplo.invoke(instanceEjemplo, 2, 10));
		// System.out.println(methodCallEjemplo.invoke(instanceEjemplo, 1, 0));

		// Compile source file.
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(System.in, System.out, System.err, pathName);
		// Load and instantiate compiled class.
		URL dirUrl = new URL("file:" + "/home/javi/Escritorio/");
		System.out.println("URL:: " + dirUrl);
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { dirUrl });
		Class<?> loadedClass = Class.forName("ejemplo.Ejemplo", false, classLoader);
		Object instance = loadedClass.newInstance();

		System.out.println("methodS: " + instance.getClass().getDeclaredMethods().length);
		Method methodCall = instance.getClass().getMethod("max", Integer.TYPE, Integer.TYPE);
		System.out.println(methodCall.invoke(instance, 2, 10));
		System.out.println(methodCall.invoke(instance, 1, 0));
	}

	public static void init(String classQualifiedNameToInstrument, String methodNameToInstrument) throws Exception
	{
		SpoonedClass spoonedClass = new SpoonedClass(classQualifiedNameToInstrument);
		spoonedClass.loadClass();

		CtMethod<?> method = spoonedClass.getSpoonedMethod(methodNameToInstrument);
		Factory factory = spoonedClass.getFactory();
		CtClass<?> ctClass = spoonedClass.getSpoonedClass();

		Instrumentator instrumentator = new Instrumentator(method, factory);
		// TODO: revisar preprocess!! a= b++ - --b, etc...
		// if (instrumentator.preProcess())
		// {
		// storeClass(ctClass);
		//
		// init(tmpPath, qualifiedClassName, methodNameToInstrument);
		// return;
		// }

		instrumentator.process();

		storeClass(ctClass);
		Class<?> clas = CompilerTool.CompileAndGetClass("tmp." + ctClass.getSimpleName(),
				"package tmp;\n" + ctClass.toString(), "bin");
		System.out.println("CLASSNAME: " + "tmp." + ctClass.getSimpleName());
		System.out.println("************\n" + ctClass.toString() + "\n************");
		// if (true)
		// return;

		InstrumentedMethod methodRunner = new InstrumentedMethod(clas);
		methodRunner.generateInputs(methodNameToInstrument);

	}

	private static void storeClass(CtClass<?> ctClas) throws IOException
	{
		String className = ctClas.getSimpleName();
		String clazz = "package tmp;\n" + ctClas.toString();
		StoreFile sf = new StoreFile(tmpPath, ".java", clazz, className, "utf-8");
		sf.store();
	}

}
