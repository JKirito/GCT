package utils;


public class JEPUtils {
    private static final int NODO_HOJA = 0;

    private static final int NODO_UNICO_OPERADOR = 1;

    private static final java.lang.String EQUALS_OPERATOR = "==";

    private static final java.lang.String NOT_EQUALS_OPERATOR = "!=";

    private static final java.lang.String NOT_OPERATOR = "!";

    private static final java.lang.String AND_OPERATOR = "&&";

    private static final java.lang.String OR_OPERATOR = "||";

    private static final java.lang.String GT_OPERATOR = ">";

    private static final java.lang.String GE_OPERATOR = ">=";

    private static final java.lang.String LT_OPERATOR = "<";

    private static final java.lang.String LE_OPERATOR = "<=";

    private static final java.lang.String PLUS_OPERATOR = "+";

    private static final java.lang.String SUB_OPERATOR = "-";

    private static final java.lang.String DIV_OPERATOR = "/";

    private static final java.lang.String MULT_OPERATOR = "*";

    public static boolean isHoja(com.singularsys.jep.parser.Node node) {
        return (node.jjtGetNumChildren()) == (utils.JEPUtils.NODO_HOJA);
    }

    public static boolean isNumber(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isHojaAndNumber(node);
    }

    public static boolean isVariable(com.singularsys.jep.parser.Node node) {
        return !(utils.JEPUtils.isHojaAndNumber(node));
    }

    public static boolean isHojaAndNumber(com.singularsys.jep.parser.Node node) {
        if ((node.jjtGetNumChildren()) == (utils.JEPUtils.NODO_HOJA)) {
            return (node.getVar()) == null;
        } 
        return false;
    }

    public static boolean isNegativeNumberOrVariable(com.singularsys.jep.parser.Node node) {
        return (((node.jjtGetNumChildren()) == (utils.JEPUtils.NODO_UNICO_OPERADOR)) && ((node.getOperator()) != null)) && (node.getOperator().getSymbol().equals("-"));
    }

    public static boolean isNotEqualsOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.NOT_EQUALS_OPERATOR);
    }

    public static boolean isNotOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.NOT_OPERATOR);
    }

    public static boolean isOrOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.OR_OPERATOR);
    }

    public static boolean isAndOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.AND_OPERATOR);
    }

    public static boolean isEqualsOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.EQUALS_OPERATOR);
    }

    public static boolean isGTOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.GT_OPERATOR);
    }

    public static boolean isGEOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.GE_OPERATOR);
    }

    public static boolean isLTOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.LT_OPERATOR);
    }

    public static boolean isLEOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.LE_OPERATOR);
    }

    public static boolean isPlusOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.PLUS_OPERATOR);
    }

    public static boolean isSubOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.SUB_OPERATOR);
    }

    public static boolean isDivOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.DIV_OPERATOR);
    }

    public static boolean isMultOperator(com.singularsys.jep.parser.Node node) {
        return utils.JEPUtils.isOperator(node, utils.JEPUtils.MULT_OPERATOR);
    }

    private static boolean isOperator(com.singularsys.jep.parser.Node node, java.lang.String oper) {
        com.singularsys.jep.Operator op = node.getOperator();
        return (op != null) && (op.getSymbol().equals(oper));
    }
}

