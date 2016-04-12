package model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InstrumentedMethod
{
	private String				_conditionsFieldName	= "_conditions";
	private String				_symbParamFieldName		= "_parameters";
	private List<List<Integer>>	_inputs;
	private Class<?>			_instrumentedClass;

	public InstrumentedMethod(Class<?> clas)
	{
		this._instrumentedClass = clas;
	}

	public List<List<Integer>> generateInputs(String methodName, Class<?>... parameterTypes) throws Exception
	{
		this._inputs = new ArrayList<>();
		Object clazz = _instrumentedClass.newInstance();
		Method methodCall = clazz.getClass().getMethod(methodName, parameterTypes);

		// Inicializo los parametros del método a ejecutar con cero.
		Object[] values = new Object[parameterTypes.length];
		for (int i = 0; i < values.length; i++)
		{
			values[i] = 0;
		}
		try
		{
			methodCall.invoke(clazz, values);
		} catch (Exception e)
		{
		}
		addValuesToReturnList(values);

		Field conditionsField = clazz.getClass().getDeclaredField(_conditionsFieldName);
		@SuppressWarnings("unchecked")
		Collection<SymbCondition> conditionsSymb = (Collection<SymbCondition>) conditionsField.get(clazz);
		// System.out.println("Condiciones: " + conditionsSymb);

		Field symbParamField = clazz.getClass().getDeclaredField(_symbParamFieldName);
		@SuppressWarnings("unchecked")
		List<String> symbParams = (ArrayList<String>) symbParamField.get(clazz);

		while (!conditionsSymb.isEmpty())
		{
			// int sizeConditions = conditionsSymb.size();
			negarYMarcarUltimaCondicion(conditionsSymb);
			// if (sizeConditions > conditionsSymb.size())
			// {
			// deleteUsedConditions(conditionsSymb);
			// negarYMarcarUltimaCondicion(conditionsSymb);
			// }
			Z3Solver z3 = new Z3Solver();
			// System.out.println("Condiciones a satisfacer: " +
			// conditionsSymb);
			Map<String, Integer> mapValues = z3.getSatisfiableValues(conditionsSymb);

			// si z3 encontro valores, corro con esos valores
			if (!mapValues.isEmpty())
			{
				// System.out.println("mapValues: " + mapValues.toString());
				Object[] intParams = new Object[symbParams.size()];
				int i = 0;
				for (String param : symbParams)
				{
					// TODO: a tener en cuenta!
					// Si no interesan todos los parámetros para esta ejecución,
					// a los que no importa les asigno cualquier número
					if (mapValues.get(param) == null)
					{
						intParams[i] = 0;
						break;
					}
					intParams[i] = mapValues.get(param);
					i++;
				}
				addValuesToReturnList(intParams);
				methodCall.invoke(clazz, intParams);
			}
			deleteUsedConditions(conditionsSymb);
			// System.out.println("conditions processed: " + conditionsSymb);
		}

		// conditionsSymb = null;

		return _inputs;
	}

	/**
	 * Elimino en orden inverso las condiciones marcadas como ya negadas
	 * 
	 * @param conditionsSymb
	 */
	private void deleteUsedConditions(Collection<SymbCondition> conditionsSymb)
	{
		List<SymbCondition> copyConditions = new ArrayList<>(conditionsSymb);
		int sizeList = copyConditions.size() - 1;
		for (int i = sizeList; i >= 0; i--)
		{
			SymbCondition actualSymbCondition = copyConditions.get(i);
			if (!actualSymbCondition.isNegado())
				return;

			conditionsSymb.remove(actualSymbCondition);
		}
	}

	private void negarYMarcarUltimaCondicion(Collection<SymbCondition> conditionsSymb)
	{
		SymbCondition condition = null;
		Iterator<SymbCondition> allCond = conditionsSymb.iterator();
		while (allCond.hasNext())
		{
			condition = allCond.next();
		}
		conditionsSymb.remove(condition);
		condition = condition.makeNegado();
		condition.setNegado(true);
		conditionsSymb.add(condition);
	}

	private void addValuesToReturnList(Object... params)
	{
		List<Integer> values = new ArrayList<>();
		for (int i = 0; i < params.length; i++)
		{
			values.add((Integer) params[i]);
		}
		this._inputs.add(values);
	}

}
