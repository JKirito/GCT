package model;

import java.util.List;
import java.util.Set;

import com.singularsys.jep.ParseException;

import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.reflect.code.CtLocalVariableImpl;
import spoon.support.reflect.code.CtOperatorAssignmentImpl;
import spoon.support.reflect.code.CtUnaryOperatorImpl;

public class Instrumentator
{

	private final String	SYMB_MAP_VARNAME						= "varSymValMap";
	private final String	SYMB_CONDITIONS_LINKEDHASHSET_VARNAME	= "_conditions";
	private final String	PARAMS_LIST_VARNAME						= "_parameters";
	private final String	CONCOLICEXPR_CLASS_NAME					= "model.ConcolicExpression";
	private final String	CONCOLICEXPR_VARNAME					= "symbResolver";
	private final String	SYMBCONDITIONAL_CLASS_NAME				= "model.SymbCondition";

	private CtMethod<?>		_method;
	private Factory			_factory;

	public Instrumentator(CtMethod<?> method, Factory factory)
	{
		this._method = method;
		this._factory = factory;
	}

	public void process() throws ParseException
	{
		this.initialize();
		// this.showStatements();
		// this.preProcess();
		this.processAsigments();
		this.processConditionalStatements();
	}

	// TODO: preprocesar statements como a++(CtUnaryOperatorImpl),
	// a+=2(CtOperatorAssignmentImpl), a=b++ + c..
	/**
	 * Realiza un preproceso sobre el método deseado para reemplazar las
	 * sentencias que no son identificadas correctamente por Spoon(como a++,
	 * a+=2, a=b++) en el proceso principal. Reemplazo estas sentencias por
	 * sentencias sin "abreviaturas".Ejemeplos:<br/>
	 * si posee <b>"a++"</b> lo reemplazo por <b>"a = a + 1"</b> <br/>
	 * si posee <b>"a*=2+x"</b> lo reemplazo por <b>"a = a * (2+x)"</b> <br/>
	 * si posee <b>"int a = b++ + x"</b> lo reemplazo por dos sentencias: <b>
	 * "a = b + x"</b> y <b>"b = b + 1"</b> <br/>
	 * 
	 * @return true si se modificó el método, es decir, había sentencias que el
	 *         método process no identifica correctamente. <br/>
	 *         false si no se modifica el método.
	 */
	public boolean preProcess()
	{
		boolean change = false;
		UnaryOperatorsUtils unaryOperatorUtils = new UnaryOperatorsUtils();

		TypeFilter<CtUnaryOperatorImpl<?>> filterUnaryOperators = unaryOperatorUtils.getFilterUnaryOperator();
		List<CtUnaryOperatorImpl<?>> unaryOperatorsStatements = _method.getElements(filterUnaryOperators);

		for (CtUnaryOperatorImpl<?> unOperatorSt : unaryOperatorsStatements)
		{
			String unaryOpParsed = unaryOperatorUtils.getStringParsedUnaryOperator(unOperatorSt);
			CtCodeSnippetStatement snippetUnOperParsed = _factory.Code().createCodeSnippetStatement(unaryOpParsed);
			unOperatorSt.replace(snippetUnOperParsed);
			change = true;
		}

		TypeFilter<CtLocalVariableImpl<?>> filterLocalVar = new TypeFilter<CtLocalVariableImpl<?>>(
				CtLocalVariableImpl.class);
		List<CtLocalVariableImpl<?>> localVars = _method.getElements(filterLocalVar);

		for (CtLocalVariableImpl<?> localVar : localVars)
		{
			CtExpression<?> assignment = localVar.getAssignment();
			if (assignment.getElements(filterUnaryOperators).size() > 0)
			{
				unaryOperatorUtils.replaceUnaryOperatorAssignment(localVar, _factory);
				change = true;
			}
		}

		TypeFilter<CtAssignment<?, ?>> filterAssignment = new TypeFilter<CtAssignment<?, ?>>(CtAssignment.class);
		List<CtAssignment<?, ?>> assignments = _method.getElements(filterAssignment);

		for (CtAssignment<?, ?> concreteAssignment : assignments)
		{
			CtExpression<?> assignment = concreteAssignment.getAssignment();
			if (assignment.getElements(filterUnaryOperators).size() > 0)
			{
				unaryOperatorUtils.replaceUnaryOperatorAssignment(concreteAssignment, _factory);
				change = true;
			}
		}

		OperatorAssignmentUtils operatorAssiUtils = new OperatorAssignmentUtils();
		TypeFilter<CtOperatorAssignmentImpl<?, ?>> filterOperatorAssignment = operatorAssiUtils
				.getFilterUnaryOperator();
		List<CtOperatorAssignmentImpl<?, ?>> operatorAssignments = _method.getElements(filterOperatorAssignment);

		for (CtOperatorAssignmentImpl<?, ?> operAssignment : operatorAssignments)
		{
			String operAssignmentParsed = operatorAssiUtils.getStringParsedOperatorAssignment(operAssignment);
			CtCodeSnippetStatement snippetoperAssignmentParsed = _factory.Code()
					.createCodeSnippetStatement(operAssignmentParsed);
			operAssignment.replace(snippetoperAssignmentParsed);
			change = true;
		}

		return change;
	}

	/**
	 * Instrumenta el método agregando las condiciones que aparecen en los
	 * ifStatement del método en una lista
	 * 
	 * @throws ParseException
	 */
	private void processConditionalStatements() throws ParseException
	{
		TypeFilter<CtIf> filterAssignment = new TypeFilter<CtIf>(CtIf.class);
		List<CtIf> ifStatements = _method.getElements(filterAssignment);

		int n = 0;
		for (CtIf ifSt : ifStatements)
		{
			n++;
			String condition = ifSt.getCondition().toString();

			String varNameToAssignExpression = "symbExprConditional_" + n;
			CtCodeSnippetStatement snippetSymbExpr = _factory.Code().createCodeSnippetStatement(
					getDeclaringSymbolicCondition(varNameToAssignExpression, condition, SYMB_MAP_VARNAME));
			ifSt.insertBefore(snippetSymbExpr);

			CtCodeSnippetStatement snippetIf = _factory.Code()
					.createCodeSnippetStatement("if (" + condition + ") " + SYMB_CONDITIONS_LINKEDHASHSET_VARNAME
							+ ".add(" + varNameToAssignExpression + "); else " + SYMB_CONDITIONS_LINKEDHASHSET_VARNAME
							+ ".add(" + varNameToAssignExpression + ".makeNegado())");
			ifSt.insertBefore(snippetIf);
		}
	}

	/**
	 * Instrumenta el método agregando en el código luego de las asignaciones
	 * (incluye declaraciones locales) las sentencias necesarias para guardar en
	 * un Map<String,String> las valores simbólicos de las variables.
	 * 
	 * Ejemplo: "x = 12 + y" se guarda en un map(x:12+y0), siendo y0 el valor
	 * simbólico de 'y' en ese momento
	 * 
	 * @throws ParseException
	 */
	private void processAsigments() throws ParseException
	{

		TypeFilter<CtLocalVariableImpl<?>> filterLocalVar = new TypeFilter<CtLocalVariableImpl<?>>(
				CtLocalVariableImpl.class);
		List<CtLocalVariableImpl<?>> localVars = _method.getElements(filterLocalVar);

		// System.out.println("Declaraciones Locales: " + localVars);
		int i = 0;
		for (CtLocalVariableImpl<?> localVar : localVars)
		{
			i++;
			String var = localVar.getSimpleName();
			String assignment = localVar.getAssignment().toString();

			String varNameToAssignExpression = "symbExprLocalVar_" + i;
			CtCodeSnippetStatement snippetSymbExprLocalVar = _factory.Code().createCodeSnippetStatement(
					getDeclaringStringCondition(varNameToAssignExpression, assignment, SYMB_MAP_VARNAME));
			localVar.insertAfter(snippetSymbExprLocalVar);

			String sourcePutInMap = getStringPutSymbolicMap(SYMB_MAP_VARNAME, var, varNameToAssignExpression);
			CtCodeSnippetStatement snippetAssign = _factory.Code().createCodeSnippetStatement(sourcePutInMap);
			snippetSymbExprLocalVar.insertAfter(snippetAssign);
		}

		TypeFilter<CtAssignment<?, ?>> filterAssignment = new TypeFilter<CtAssignment<?, ?>>(CtAssignment.class);
		List<CtAssignment<?, ?>> assignments = _method.getElements(filterAssignment);

		// System.out.println("Asignaciones: " + assignments);
		int a = 0;
		for (CtAssignment<?, ?> concreteAssignment : assignments)
		{
			a++;
			String assigned = concreteAssignment.getAssigned().toString();
			String assignment = "";
			try
			{
				assignment = concreteAssignment.getAssignment().toString();
			} catch (Exception e)
			{
				System.err.println("NO SE ACEPTA LA ENTRADA '" + concreteAssignment.toString() + "'");
				e.printStackTrace();
				System.exit(1);
			}

			String varNameToAssignExpression = "symbExprAssignment" + a;
			CtCodeSnippetStatement snippetSymbExprAssignment = _factory.Code().createCodeSnippetStatement(
					getDeclaringStringCondition(varNameToAssignExpression, assignment, SYMB_MAP_VARNAME));
			concreteAssignment.insertAfter(snippetSymbExprAssignment);

			String sourcePutInMap = getStringPutSymbolicMap(SYMB_MAP_VARNAME, assigned, varNameToAssignExpression);
			CtCodeSnippetStatement snippetAssign = _factory.Code().createCodeSnippetStatement(sourcePutInMap);
			snippetSymbExprAssignment.insertAfter(snippetAssign);
		}

	}

	/**
	 * Agrega una <tt>LinkedHashSet</tt> como atributo de la clase que contendrá
	 * las condiciones del método con los valores simbólicos de las variables.
	 * Este atributo es public</br>
	 * 
	 * Crea el objeto ConcolicExpression para poder obtener los valores
	 * simbólicos de las asignaciones.</br>
	 * 
	 * Crea un Map para almacenar las variables y sus valores simbólicos,
	 * inicializándolo con las variables recibidas por parámetro en el
	 * método.</br>
	 */
	private void initialize()
	{
		CtClass<?> clas = _method.getParent(CtClass.class);

		// Agrego atributo List<symbCondition> a la clase
		CtType<Set<SymbCondition>> typeSet = _factory.Class()
				.create("java.util.LinkedHashSet<" + SYMBCONDITIONAL_CLASS_NAME + ">");
		CtTypeReference<Set<SymbCondition>> type = _factory.Type().createReference(typeSet);
		CtField<Set<SymbCondition>> snippetFieldListConditions = _factory.Code().createCtField(
				SYMB_CONDITIONS_LINKEDHASHSET_VARNAME, type,
				"new java.util.LinkedHashSet<" + SYMBCONDITIONAL_CLASS_NAME + ">()", ModifierKind.PUBLIC);
		clas.addField(snippetFieldListConditions);

		// Agrego atributo List<String> a la clase para tener los parametros del
		// método
		CtType<List<String>> typeListString = _factory.Class().create("java.util.List<String>");
		CtTypeReference<List<String>> typeList = _factory.Type().createReference(typeListString);
		CtField<List<String>> snippetFieldListSymbVars = _factory.Code().createCtField(PARAMS_LIST_VARNAME, typeList,
				"null", ModifierKind.PUBLIC);
		clas.addField(snippetFieldListSymbVars);

		// TODO_ crear metodo getCondition()
		// Set<ModifierKind> set = new HashSet<>();
		// set.add(ModifierKind.PUBLIC);
		// CtMethod<?> getMethod = _factory.Method().create(clas, set, type,
		// "getConditions", null, null);
		// CtCodeSnippetStatement bodyGetMethod = _factory.Code()
		// .createCodeSnippetStatement("return " +
		// SYMB_CONDITIONS_LIST_VARNAME);
		// CtBlock<?> bodyBlock = _factory.Code().createCtBlock(bodyGetMethod);
		// // getMethod.setBody(bodyGetMethod);
		// // getMethod.getBody().insertBefore(bodyGetMethod);

		CtCodeSnippetStatement snippetResolver = _factory.Code().createCodeSnippetStatement(
				CONCOLICEXPR_CLASS_NAME + " " + CONCOLICEXPR_VARNAME + "= new " + CONCOLICEXPR_CLASS_NAME + "()");
		_method.getBody().insertBegin(snippetResolver);

		CtCodeSnippetStatement snippetAddParams = _factory.Code()
				.createCodeSnippetStatement(PARAMS_LIST_VARNAME + " = new java.util.ArrayList<String>()");
		_method.getBody().insertBegin(snippetAddParams);

		CtCodeSnippetStatement snippetMap = _factory.Code().createCodeSnippetStatement(
				"java.util.Map<String, String> " + SYMB_MAP_VARNAME + " = new java.util.HashMap<String, String>()");
		snippetResolver.insertAfter(snippetMap);

		// Agrego al map como clave los parámetros y como valor el simbolico de
		// cada parametro. Ej: {x:x0,y:y0}
		// También agrego al set sólo los valores symbólicos: x0, y0.
		for (CtParameter<?> ctp : _method.getParameters())
		{
			String varName = ctp.getSimpleName();
			String symVarName = ctp.getSimpleName().toString() + "0";
			String soucePutInMap = getStringPutSymbolicMap(SYMB_MAP_VARNAME, varName, "\"" + symVarName + "\"");
			CtCodeSnippetStatement snippetMapAsign = _factory.Code().createCodeSnippetStatement(soucePutInMap);
			snippetMap.insertAfter(snippetMapAsign);

			String addSymbVar = PARAMS_LIST_VARNAME + ".add(\"" + varName + "\")";
			CtCodeSnippetStatement snippetAddSymbVar = _factory.Code().createCodeSnippetStatement(addSymbVar);
			snippetResolver.insertBefore(snippetAddSymbVar);
			// _method.getBody().insertEnd(snippetAddSymbVar);
		}
	}

	public String getStringPutSymbolicMap(String mapName, String varName, String symVarName)
	{
		return mapName + ".put(\"" + varName + "\"," + symVarName + ")";
	}

	public String getStringCallMethodGetSymbolicExpression(String assignment, String mapName)
	{
		return CONCOLICEXPR_VARNAME + ".getSymbolicExpression(\"" + assignment + "\"," + mapName + ")";
	}

	public String getDeclaringSymbolicCondition(String varNameToAssign, String assignment, String mapName)
	{
		return SYMBCONDITIONAL_CLASS_NAME + " " + varNameToAssign + " = new " + SYMBCONDITIONAL_CLASS_NAME + "("
				+ getStringCallMethodGetSymbolicExpression(assignment, mapName) + ")";
	}

	public String getDeclaringStringCondition(String varNameToAssign, String assignment, String mapName)
	{
		return "String " + varNameToAssign + " = " + getStringCallMethodGetSymbolicExpression(assignment, mapName);
	}

	// private void showStatements(CtMethod<?> method)
	// {
	// TypeFilter<CtStatement> f = new
	// TypeFilter<CtStatement>(CtStatement.class);
	// List<CtStatement> st = method.getElements(f);
	//
	// for (CtStatement s : st)
	// {
	// System.out.println("S--> " + s.toString() + " : " + s.getClass());
	//
	// }
	// }

}
