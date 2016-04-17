package examples;

import functions.RenameVar;

public class Main
{

	public static void main(String[] args)
	{
		String var = "i" + RenameVar.ADD_TO_VAR_IN_WHILE + "_12";
		System.out.println("var: " + var);
		System.out.println(RenameVar.isRenamedInWhile(var));

	}

}
