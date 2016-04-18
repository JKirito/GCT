package model;

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

	public void addMethodTest(String methodName, List<Integer> parameters)
	{
		addCounterMethod(methodName);
		StringBuilder method = new StringBuilder();
		method.append("\t@Test\n");
		method.append("\tpublic void " + methodName + "_" + this._methodNum.get(methodName) + "()\n\t{\n");
		String varName = "var";
		method.append("\t\t" + this._className + " " + varName + " = new " + this._className + "();\n");
		String params = "";
		for (Integer p : parameters)
		{
			params += p + ", ";
		}
		// Saco los últimos caracteres (para sacar la ", ")
		params = params.substring(0, params.length() - 2);
		method.append("\t\t" + varName + "." + methodName + "(" + params + ");\n");
		// method.append("assertEquals(" + + ", " + + ")")
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

}
