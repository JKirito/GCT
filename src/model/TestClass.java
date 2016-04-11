package model;

import java.util.ArrayList;
import java.util.List;

public class TestClass
{
	/**
	 * String de la Clase Test a generar
	 */
	private StringBuilder		_stringClassTest;

	/**
	 * métodos de la Clase Test a generar
	 */
	private List<StringBuilder>	_methods;

	/**
	 * Nombre de la clase a generar
	 */
	private String				_className;

	/**
	 * Número de método
	 */
	private int					_methodNum;

	public TestClass(String classToTest)
	{
		this._stringClassTest = new StringBuilder();
		this._methods = new ArrayList<>();
		this._className = classToTest;
	}

	public String getGenerateTestClass()
	{
		this._stringClassTest.append("//Agregar paquete de clase\n");
		this._stringClassTest.append("import org.junit.Test;\n");
		this._stringClassTest.append("import static org.junit.Assert.assertEquals;\n");
		this._stringClassTest.append("//Importar " + this._className);
		this._stringClassTest.append("\n\n");

		this._stringClassTest.append("public class Z3SolverTest\n {\n");

		for (StringBuilder method : this._methods)
		{
			this._stringClassTest.append("\n" + method + "\n");
		}

		this._stringClassTest.append("\n}");

		return this._stringClassTest.toString();
	}

	public void addMethodTest(String methodName, List<Integer> parameters)
	{
		StringBuilder method = new StringBuilder();
		method.append("\t@test\n");
		method.append("\tpublic void " + methodName + this._methodNum + "()\n\t{\n");
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
		this._methodNum++;
	}

}
