package model;

import java.util.Set;

import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.factory.Factory;

public class SpoonedClass
{
	private Launcher	_spoon;
	private CtClass<?>	_ctClass;
	private String		_pathJavaFile;

	public SpoonedClass(String pathFile)
	{
		this._spoon = new Launcher();
		this._pathJavaFile = pathFile;
	}

	public void loadClass() throws Exception
	{
		_spoon.addInputResource(_pathJavaFile);
		try
		{
			_spoon.run();
		} catch (Exception e)
		{
			throw new Exception(e);
		}

		Factory factory = _spoon.getFactory();
		// _ctClass = factory.Class().get(classQualifiedNameToInstrument);
		_ctClass = (CtClass<?>) factory.Class().getAll().get(0);
	}

	public Factory getFactory()
	{
		return _spoon.getFactory();
	}

	public ClassLoader getClassLoader()
	{
		return this._spoon.getEnvironment().getClassLoader();
	}

	// public CtMethod<?> getSpoonedMethod()
	// {
	// if (methodNameToInstrument.isEmpty() || methodNameToInstrument == null)
	// return null;
	// return _ctClass.getMethodsByName(methodNameToInstrument).get(0);
	// }

	// TODO: modificar! puede haber sobrecarga!
	public CtMethod<?> getSpoonedMethod(String method)
	{
		if (method.isEmpty() || method == null)
			return null;
		return _ctClass.getMethodsByName(method).get(0);
	}

	public CtClass<?> getSpoonedClass()
	{
		return this._ctClass;
	}

	public Launcher getLaucher()
	{
		return this._spoon;
	}

	public Set<CtMethod<?>> getAllMethods()
	{
		return _ctClass.getAllMethods();
	}

	public String getSpoonedClassName()
	{
		return this._ctClass.getSimpleName();
	}

	public String getPathJavaFile()
	{
		return _pathJavaFile;
	}

}
