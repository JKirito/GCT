package model;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import parameters.Parameters;
import spoon.reflect.declaration.CtMethod;
import utils.StoreFile;

public class ConcolicMain
{
	// R. Pawlak, C. Noguera, and N. Petitprez. Spoon:
	// Program analysis and transformation in java.
	// Technical Report 5901, INRIA, 2006.

	public static void main(String[] args) throws Exception
	{
		System.out.println("Starting...");
		System.out.println();
		String pathName = "/media/javi/DATOS/workspace/Eclipse/TPs_UNGS/GCT/src/test/Ejemplo.java";
		SpoonedClass spoonedClass = new SpoonedClass(pathName);
		try
		{
			spoonedClass.loadClass();
		} catch (Exception e)
		{
			e.printStackTrace();
			return;
		}

		Set<MethodToSelect> methods = new HashSet<>();
		for (CtMethod<?> M : spoonedClass.getAllMethods())
		{
			MethodToSelect m = new MethodToSelect(M);
			// if (M.getSimpleName().equals("getMax"))
			m.setSelected(true);
			methods.add(m);
		}

		UTGenerator generator = new UTGenerator(spoonedClass.getJavaFilePath(), methods,
				UTGenerator.TEMP_FILES.MANTENER);
		String testClass = null;
		int k = 2;
		try
		{
			testClass = generator.generarCasos(k);
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String classToTestName = spoonedClass.getSpoonedClassName();
		String pathToSave = spoonedClass.getJavaFilePath().replace(classToTestName + Parameters.JAVA_EXTENSION, "");
		StoreFile sf = new StoreFile(pathToSave, Parameters.JAVA_EXTENSION, testClass, classToTestName + "Test",
				StoreFile.CHARSET_UTF8);
		try
		{
			sf.store();
			System.out.println("se guardó el archivo en el path: " + pathToSave);
		} catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
	}

}
