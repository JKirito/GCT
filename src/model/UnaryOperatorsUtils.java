package model;

import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtRHSReceiver;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.reflect.factory.Factory;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.reflect.code.CtUnaryOperatorImpl;

public class UnaryOperatorsUtils
{
	TypeFilter<CtUnaryOperatorImpl<?>> filterUnaryOperators;

	public UnaryOperatorsUtils()
	{
		this.filterUnaryOperators = new TypeFilter<CtUnaryOperatorImpl<?>>(CtUnaryOperatorImpl.class);
	}

	public String getStringParsedUnaryOperator(CtUnaryOperatorImpl<?> unaryOperator)
	{
		String var = unaryOperator.getOperand().toString();
		String operator = "";
		switch (unaryOperator.getKind())
		{
			case POSTINC:
				operator = "+";
				break;
			case PREINC:
				operator = "+";
				break;
			case POSTDEC:
				operator = "-";
				break;
			case PREDEC:
				operator = "-";
				break;

			default:
				break;
		}

		return var + " = " + var + " " + operator + " " + 1;
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

	public void replaceUnaryOperatorAssignment(CtRHSReceiver<?> element, Factory factory)
	{
		if (containsUnaryOperator(element))
		{
			String newLocalVarImpl = element.toString();
			for (CtUnaryOperatorImpl<?> uo : element.getAssignment().getElements(this.getFilterUnaryOperator()))
			{
				String parsed = getStringParsedUnaryOperator(uo);

				CtCodeSnippetStatement snippetUnOperParsed = factory.Code().createCodeSnippetStatement(parsed);

				if (uo.getKind().equals(UnaryOperatorKind.POSTDEC) || uo.getKind().equals(UnaryOperatorKind.POSTINC))
				{
					((CtStatement) element).insertAfter(snippetUnOperParsed);

				} else if (uo.getKind().equals(UnaryOperatorKind.PREDEC)
						|| uo.getKind().equals(UnaryOperatorKind.PREINC))
				{
					((CtStatement) element).insertBefore(snippetUnOperParsed);
				}
				newLocalVarImpl = newLocalVarImpl.replace(uo.toString(), uo.getOperand().toString());
			}

			CtCodeSnippetStatement snippetLocalVarParsed = factory.Code().createCodeSnippetStatement(newLocalVarImpl);
			((CtStatement) element).replace(snippetLocalVarParsed);
		}
	}

	public boolean containsUnaryOperator(CtRHSReceiver<?> element)
	{
		CtExpression<?> assignment = element.getAssignment();
		return assignment.getElements(this.getFilterUnaryOperator()).size() > 0;
	}

	public TypeFilter<CtUnaryOperatorImpl<?>> getFilterUnaryOperator()
	{
		return this.filterUnaryOperators;
	}

}
