package model;

import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.reflect.code.CtOperatorAssignmentImpl;

public class OperatorAssignmentUtils
{
	TypeFilter<CtOperatorAssignmentImpl<?, ?>> filterOperatorAssignment;

	public OperatorAssignmentUtils()
	{
		this.filterOperatorAssignment = new TypeFilter<CtOperatorAssignmentImpl<?, ?>>(CtOperatorAssignmentImpl.class);
	}

	public String getStringParsedOperatorAssignment(CtOperatorAssignmentImpl<?, ?> operatorAssignment)
	{
		String var = operatorAssignment.getAssigned().toString();
		String assignment = operatorAssignment.getAssignment().toString();
		String operator = "";
		switch (operatorAssignment.getKind())
		{
			case PLUS:
				operator = "+";
				break;
			case MUL:
				operator = "*";
				break;
			case DIV:
				operator = "/";
				break;
			case MINUS:
				operator = "-";
				break;
			default:
				break;
		}
		return var + " = " + var + " " + operator + " (" + assignment + ")";
	}

	// public void replaceUnaryOperatorAssignment(CtLocalVariableImpl<?>
	// localVar)
	// {
	// if (containsUnaryOperator(localVar))
	// {
	// Factory factory = localVar.getFactory();
	// String newLocalVarImpl = localVar.toString();
	// System.out.println("LOCAL VAR INITT: " + newLocalVarImpl);
	// for (CtUnaryOperatorImpl<?> uo :
	// localVar.getAssignment().getElements(this.getFilterUnaryOperator()))
	// {
	// // System.out.println("/////// " + uo.toString());
	// String parsed = getStringParsedUnaryOperator(uo);
	//
	// CtCodeSnippetStatement snippetUnOperParsed =
	// factory.Code().createCodeSnippetStatement(parsed);
	//
	// if (uo.getKind().equals(UnaryOperatorKind.POSTDEC) ||
	// uo.getKind().equals(UnaryOperatorKind.POSTINC))
	// {
	// localVar.insertAfter(snippetUnOperParsed);
	//
	// } else if (uo.getKind().equals(UnaryOperatorKind.PREDEC)
	// || uo.getKind().equals(UnaryOperatorKind.PREINC))
	// {
	// localVar.insertBefore(snippetUnOperParsed);
	// }
	// newLocalVarImpl = newLocalVarImpl.replace(uo.toString(),
	// uo.getOperand().toString());
	// }
	//
	// CtCodeSnippetStatement snippetLocalVarParsed =
	// factory.Code().createCodeSnippetStatement(newLocalVarImpl);
	// localVar.replace(snippetLocalVarParsed);
	//
	// }
	// }

	public TypeFilter<CtOperatorAssignmentImpl<?, ?>> getFilterUnaryOperator()
	{
		return this.filterOperatorAssignment;
	}

}
