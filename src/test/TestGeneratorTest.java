package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import functions.TestGenerator;
import model.SpoonedClass;
import utils.SpoonUtils;

public class TestGeneratorTest
{

	private SpoonedClass _spoonedClass;

	@Before
	public void setup()
	{
		_spoonedClass = new SpoonedClass("/media/javi/DATOS/workspace/Eclipse/TPs_UNGS/GCT/src/test/Ejemplo.java");
		try
		{
			_spoonedClass.loadClass();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testExecute1() throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, ClassNotFoundException
	{
		Object[] parameters = new Object[1];
		parameters[0] = 0;

		String methodName = "m0";
		Object ret = TestGenerator.execute("test.Ejemplo", methodName, parameters,
				SpoonUtils.getParametersTypes(_spoonedClass.getSpoonedMethod(methodName)));
		assertEquals(0, ret);
	}

	@Test
	public void testExecute2() throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, ClassNotFoundException
	{
		Object[] parameters = new Object[3];
		parameters[0] = 0;
		parameters[1] = 1;
		parameters[2] = 3;

		String methodName = "getMax";
		Object ret = TestGenerator.execute("test.Ejemplo", methodName, parameters,
				SpoonUtils.getParametersTypes(_spoonedClass.getSpoonedMethod(methodName)));
		assertEquals(3, ret);
	}

}
