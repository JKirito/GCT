package model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import parameters.Parameters;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;
import utils.SpoonUtils;
import utils.StoreFile;

public class UTGenerator
{
	// R. Pawlak, C. Noguera, and N. Petitprez. Spoon:
	// Program analysis and transformation in java.
	// Technical Report 5901, INRIA, 2006.

	private SpoonedClass		_spoonedClass;
	private Set<MethodToSelect>	_methods;
	// private final String compiledClassFolder = "bin";
	// private final String packetNameOutput = "tmp";
	private String				_packetClass;
	private TestClass			_testClass;

	public UTGenerator(SpoonedClass spoonedClass, Set<MethodToSelect> methods)
	{
		this._spoonedClass = spoonedClass;
		this._packetClass = this._spoonedClass.getSpoonedClass().getPackage().getSimpleName();
		this._methods = methods;
	}

	public String generarCasos(int k) throws IOException
	{
		_testClass = new TestClass(_spoonedClass.getSpoonedClass().getSimpleName(), this._packetClass);
		CtClass<?> ctClass = _spoonedClass.getSpoonedClass();

		// XXXXXXX: Primero instrumento los métodos seleccionados
		for (MethodToSelect M : this._methods)
		{
			if (!M.isSelected())
				continue;

			CtMethod<?> actualMethod = M.getCtMethod();

			try
			{
				instrumentPreProcess(_spoonedClass.getPathJavaFile(), actualMethod, k);

				List<CtTypeReference<?>> typeReferences = SpoonUtils.getTypeReferences(actualMethod);

				Instrumentator instrumentator = new Instrumentator(Parameters.TMP_PATH_JAVA_PREPROCESS_CLASS);
				instrumentator.instrumentMethod(actualMethod.getSimpleName(), typeReferences);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// XXXXXXX: Guardo la clase instrumentada, la compilo y la cargo
		storeClass(ctClass, Parameters.TMP_PATH_JAVA_INSTRUMENTED_CLASS);

		Class<?> classInstrumented = null;
		try
		{
			// System.out.println("package " + packetNameOutput + ";\n" +
			// ctClass.toString());
			// TODO tmp... antes de compilar borro .class si está generado
			String qualifiedClassName = Parameters.getPackageInstrumented() + "." + ctClass.getSimpleName();
			String sourceClass = "package " + Parameters.getPackageInstrumented() + ";\n" + ctClass.toString();
			classInstrumented = CompilerTool.CompileAndGetClass(qualifiedClassName, sourceClass,
					Parameters.TMP_PATH_COMPILED_CLASS);
		} catch (ClassNotFoundException e)
		{
			// TODO: tratar excepcion
			e.printStackTrace();
		} catch (MalformedURLException e)
		{
			// TODO: tratar excepcion
			e.printStackTrace();
		}

		// XXXXXX: Ejecuto cada método instrumentado y guardo los valores
		// obtenidos por el solver
		for (MethodToSelect M : this._methods)
		{
			if (!M.isSelected())
				continue;
			CtMethod<?> actualMethod = M.getCtMethod();

			// XXXXXX: Obtengo los valores para testear el método
			InstrumentedMethod instrumentedMethod = new InstrumentedMethod(classInstrumented);
			List<List<Integer>> inputsGenerated = null;
			try
			{
				Class<?>[] parameterTypes = new Class<?>[actualMethod.getParameters().size()];
				for (int i = 0; i < actualMethod.getParameters().size(); i++)
				{
					parameterTypes[i] = actualMethod.getParameters().get(i).getType().getActualClass();
					// System.out.println(parameterTypes[i]);
				}
				inputsGenerated = instrumentedMethod.generateInputs(actualMethod.getSimpleName(), parameterTypes);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// XXXXXX: creo los casos de test para los inputs generados
			for (List<Integer> inputs : inputsGenerated)
			{
				_testClass.addMethodTest(M.getCtMethod().getSimpleName(), inputs);
			}
		}
		// XXXXXX: Devuelvo el String con la clase que contiene los casos de
		// test
		return _testClass.getGenerateTestClass();
	}

	private void instrumentPreProcess(String javaFilePath, CtMethod<?> actualMethod, int k) throws Exception
	{
		Instrumentator instrumentator = new Instrumentator(javaFilePath);

		List<CtTypeReference<?>> typeReferences = SpoonUtils.getTypeReferences(actualMethod);
		if (instrumentator.preProcessLoop(actualMethod.getSimpleName(), typeReferences, k))
		{
			storeClass(instrumentator.getInstrumentedClass(), Parameters.TMP_PATH_JAVA_PREPROCESS_CLASS);

			instrumentPreProcess(Parameters.TMP_PATH_JAVA_PREPROCESS_CLASS, actualMethod, k);
			return;
		}

	}

	public Integer getGeneratedMethodsCount()
	{
		return this._testClass.getGeneratedMethodsCount();
	}

	private void storeClass(CtClass<?> ctClas, String pathToSave) throws IOException
	{
		String className = ctClas.getSimpleName();

		String Stringclass = "package " + Parameters.getPackage(pathToSave) + ";\n" + ctClas.toString();
		StoreFile sf = new StoreFile(pathToSave + "/", ".java", Stringclass, className, "utf-8");
		sf.store();
	}

}
