package test;


public class JEPUtilsTest extends utils.JEPUtils {
    @org.junit.Test
    public void isNumberOkPositive() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("2");
        org.junit.Assert.assertTrue(utils.JEPUtils.isNumber(nodeExample));
    }

    @org.junit.Test
    public void isNumberNegative() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("-750");
        org.junit.Assert.assertFalse(utils.JEPUtils.isNumber(nodeExample));
    }

    @org.junit.Test
    public void isNumberVariable() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("x");
        org.junit.Assert.assertFalse(utils.JEPUtils.isNumber(nodeExample));
    }

    @org.junit.Test
    public void isNumberExpression() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("x+7*(x-6)");
        org.junit.Assert.assertFalse(utils.JEPUtils.isNumber(nodeExample));
    }

    @org.junit.Test
    public void isNumberSumNumbers() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("1+1");
        org.junit.Assert.assertFalse(utils.JEPUtils.isNumber(nodeExample));
    }

    @org.junit.Test
    public void isNumberRestNumbers() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("3-4");
        org.junit.Assert.assertFalse(utils.JEPUtils.isNumber(nodeExample));
    }

    @org.junit.Test
    public void isNumberZero() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("0");
        org.junit.Assert.assertTrue(utils.JEPUtils.isNumber(nodeExample));
    }

    @org.junit.Test
    public void isVariable() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("x");
        org.junit.Assert.assertTrue(utils.JEPUtils.isVariable(nodeExample));
    }

    @org.junit.Test
    public void isNegativeNumberOrVariableOk() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("-x");
        org.junit.Assert.assertTrue(utils.JEPUtils.isNegativeNumberOrVariable(nodeExample));
    }

    @org.junit.Test
    public void isNegativeNumberOrVariableNum() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("-1");
        org.junit.Assert.assertTrue(utils.JEPUtils.isNegativeNumberOrVariable(nodeExample));
    }

    @org.junit.Test
    public void isNegativeNumberOrVariableNumPos() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("10");
        org.junit.Assert.assertFalse(utils.JEPUtils.isNegativeNumberOrVariable(nodeExample));
    }

    @org.junit.Test
    public void isNegativeNumberOrVariableNumPosSymb() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("+10");
        org.junit.Assert.assertFalse(utils.JEPUtils.isNegativeNumberOrVariable(nodeExample));
    }

    @org.junit.Test
    public void isNegativeNumberOrVariableNot() throws com.singularsys.jep.ParseException {
        com.singularsys.jep.Jep j = new com.singularsys.jep.Jep();
        com.singularsys.jep.parser.Node nodeExample = j.parse("-x-1");
        org.junit.Assert.assertFalse(utils.JEPUtils.isNegativeNumberOrVariable(nodeExample));
    }
}

