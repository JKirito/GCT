package test;


public class ConcolicExpressionTest {
    model.ConcolicExpression concreteExp;

    java.util.Map<java.lang.String, java.lang.String> symbolicMap;

    @org.junit.Before
    public void inicializarMap() {
        symbolicMap = new java.util.HashMap<>();
        symbolicMap.put("x", "x0");
        symbolicMap.put("y", "y0");
        symbolicMap.put("z", "z0");
        symbolicMap.put("t", "t0");
        symbolicMap.put("w", "w0");
        symbolicMap.put("x2", "x20");
        concreteExp = new model.ConcolicExpression();
    }

    @org.junit.Test
    public void getSymbolicExpressionNumber() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("1", concreteExp.getSymbolicExpression("1", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionNumberDouble() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("1", concreteExp.getSymbolicExpression("1.0", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionSumNumber() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(1)+(74)", concreteExp.getSymbolicExpression("1+74", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionSumNumberNegative() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(-10)", concreteExp.getSymbolicExpression("-10", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionVariable() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("x0", concreteExp.getSymbolicExpression("x", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionVariablePlusNumber() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(x0)+(1)", concreteExp.getSymbolicExpression("x+1", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionVariableMinusNum() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(x0)-(10)", concreteExp.getSymbolicExpression("x-10", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionNumPlusVariable() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(10)+(x0)", concreteExp.getSymbolicExpression("10+x", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionNumMinusVariable() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(45)-(x0)", concreteExp.getSymbolicExpression("45-x", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionTestParentesis() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("((1)-(7))*(2)", concreteExp.getSymbolicExpression("(1-7)*2", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionVariableNegative() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(-x20)", concreteExp.getSymbolicExpression("-x2", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionConditionalVarGTNum() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(x0)>(2)", concreteExp.getSymbolicExpression("x>2", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionConditionalVarLTNum() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(x0)<(10)", concreteExp.getSymbolicExpression("x < 10", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionConditionalVarGTVar() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(x0)>(y0)", concreteExp.getSymbolicExpression("x > y", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionConditionalVarLTNumNeg() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(x0)<((-102))", concreteExp.getSymbolicExpression("x < -102", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionConditionalVarLENum() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(x0)<=(15052)", concreteExp.getSymbolicExpression("x <= 15052", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionConditionalVarGENum() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(x0)>=(210)", concreteExp.getSymbolicExpression("x >= 210", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionConditionalVarGENumNegTRIM() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(t0)>=((-45))", concreteExp.getSymbolicExpression("t>=-45", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionConditionalVarGENumNeg() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(x0)>=((-4))", concreteExp.getSymbolicExpression("x >= -4", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionConditionalVarGENumWithParen() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(x0)>=(45)", concreteExp.getSymbolicExpression("((x)>=(45))", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionConditionalComplex() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(((x0)*(y0))+((4)/((t0)*((y0)+(2)))))>=((45)-(((y0)/(z0))+((5)*(x20))))", concreteExp.getSymbolicExpression("(x*y)+4/(t*(y+2)) >= 45-(y/z+5*x2)", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionNumComplex() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("(((((-2))*(8))*(7))+((1)*(7)))-(2)", concreteExp.getSymbolicExpression("-2*8*7+1*7-2", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionNumComplex2() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("((7)+((1)*(7)))-(2)", concreteExp.getSymbolicExpression("7+1*7-2", symbolicMap));
    }

    @org.junit.Test
    public void getSymbolicExpressionVarComplex() throws com.singularsys.jep.ParseException {
        org.junit.Assert.assertEquals("((5)-((y0)/(2)))-(7)", concreteExp.getSymbolicExpression("5-y/2-7", symbolicMap));
    }

    @org.junit.Test
    public void holaEstoEsUnTest() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("7+1*7-2");
        java.lang.System.out.println(nodeExample.getOperator().getSymbol());
        java.lang.System.out.println(nodeExample.jjtGetChild(0));
    }

    @org.junit.Test
    public void testXXX() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("!((((2)*((x0)+(1)))+(y0))!=(y0))");
        java.lang.System.out.println(nodeExample.getOperator().getSymbol());
        java.lang.System.out.println(nodeExample.jjtGetChild(0));
    }
}

