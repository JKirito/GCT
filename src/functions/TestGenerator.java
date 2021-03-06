package functions;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGenerator
{
	/**
	 * String de la Clase Test a generar
	 */
	private StringBuilder			_stringClassTest;

	/**
	 * métodos de la Clase Test a generar
	 */
	private List<StringBuilder>		_methods;

	/**
	 * Nombre de la clase a generar
	 */
	private String					_className;

	/**
	 * Número de método
	 */
	private Map<String, Integer>	_methodNum;

	private String					_packetClass;

	public TestGenerator(String classToTest, String packetClass)
	{
		this._stringClassTest = new StringBuilder();
		this._methods = new ArrayList<>();
		this._className = classToTest;
		this._packetClass = packetClass;
		this._methodNum = new HashMap<>();
	}

	public String getGenerateTestClass()
	{
		this._stringClassTest.append("package " + this._packetClass + ";\n");
		this._stringClassTest.append("import org.junit.Test;\n");
		this._stringClassTest.append("import static org.junit.Assert.assertEquals;\n");
		this._stringClassTest.append("\n\n");

		this._stringClassTest.append("public class " + this._className + "Test" + "\n {\n");

		for (StringBuilder method : this._methods)
		{
			this._stringClassTest.append("\n" + method + "\n");
		}

		this._stringClassTest.append("\n}");

		return this._stringClassTest.toString();
	}

	public void addMethodTest(String methodName, String returnType, Object[] parameters, Class<?>[] parametersTypes)
	{
		addCounterMethod(methodName);
		StringBuilder method = new StringBuilder();
		method.append("\t@Test\n");
		method.append("\tpublic void " + methodName + "_" + this._methodNum.get(methodName) + "()\n\t{\n");
		String varName = "var";
		method.append("\t\t" + this._className + " " + varName + " = new " + this._className + "();\n");
		String params = "";
		for (Object p : parameters)
		{
			params += p + ", ";
		}
		// Saco los últimos caracteres (para sacar la ", ")
		params = params.substring(0, params.length() - 2);
		String methodCall = varName + "." + methodName + "(" + params + ")";

		if (!returnType.equals("void"))
		{
			String returnVarName = "ret";
			method.append("\t\t" + returnType + " " + returnVarName + " = " + methodCall + ";\n");
			Object ret = null;
			try
			{
				ret = TestGenerator.execute(_packetClass + "." + _className, methodName, parameters, parametersTypes);
			} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// FIXME cambiar!!!!!! sólo para tipos enteros ahora!!!
			method.append("\t\tassertEquals(new Integer(" + ret + "), " + returnVarName + ");\n");
		} else
		{
			method.append("\t\t" + methodCall + ";\n");
		}

		method.append("\t}");
		this._methods.add(method);
	}

	private void addCounterMethod(String methodName)
	{
		Integer n = this._methodNum.get(methodName) == null ? 1 : (this._methodNum.get(methodName) + 1);
		this._methodNum.put(methodName, n);
	}

	public Integer getGeneratedMethodsCount()
	{
		Integer n = 0;
		for (String method : this._methodNum.keySet())
		{
			n += this._methodNum.get(method);
		}
		return n;
	}

	public static Object execute(String className, String methodName, Object[] parameters, Class<?>[] parametersTypes)
			throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException,
			ClassNotFoundException
	{
		Object clazz = Class.forName(className).newInstance();

		Method methodCall = clazz.getClass().getMethod(methodName, parametersTypes);
		Object ret = null;
		try
		{
			ret = methodCall.invoke(clazz, parameters);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return ret;
	}

}
