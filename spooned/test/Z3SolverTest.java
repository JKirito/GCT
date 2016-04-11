package test;


public class Z3SolverTest {
    @org.junit.Test
    public void getZ3Expression() {
        model.Z3Solver z3 = new model.Z3Solver();
        com.microsoft.z3.Context ctx = new com.microsoft.z3.Context();
        com.microsoft.z3.ArithExpr x = ctx.mkIntConst("x");
        com.microsoft.z3.ArithExpr y = ctx.mkIntConst("y");
        com.microsoft.z3.IntExpr five = ctx.mkInt(5);
        com.microsoft.z3.ArithExpr x_plus_y = ctx.mkAdd(x, y);
        com.microsoft.z3.BoolExpr bEsperado = ctx.mkGt(x_plus_y, five);
        com.microsoft.z3.BoolExpr bActual = ((com.microsoft.z3.BoolExpr)(z3.getZ3BoolExpression("x + y > 5")));
        org.junit.Assert.assertEquals(bActual.getSExpr(), bEsperado.getSExpr());
    }

    @org.junit.Test
    public void getZ3Expression2() {
        model.Z3Solver z3 = new model.Z3Solver();
        com.microsoft.z3.Context ctx = new com.microsoft.z3.Context();
        com.microsoft.z3.ArithExpr x = ctx.mkIntConst("x");
        com.microsoft.z3.ArithExpr y = ctx.mkIntConst("y");
        com.microsoft.z3.BoolExpr bEsperado = ctx.mkLt(x, y);
        com.microsoft.z3.BoolExpr bActual = ((com.microsoft.z3.BoolExpr)(z3.getZ3BoolExpression("x < y")));
        org.junit.Assert.assertEquals(bActual.getSExpr(), bEsperado.getSExpr());
    }

    @org.junit.Test
    public void getZ3Expression3() {
        model.Z3Solver z3 = new model.Z3Solver();
        com.microsoft.z3.Context ctx = new com.microsoft.z3.Context();
        com.microsoft.z3.ArithExpr x = ctx.mkIntConst("x");
        com.microsoft.z3.ArithExpr y = ctx.mkIntConst("y");
        com.microsoft.z3.BoolExpr bEsperado = ctx.mkGt(x, y);
        com.microsoft.z3.BoolExpr bActual = ((com.microsoft.z3.BoolExpr)(z3.getZ3BoolExpression("x < y")));
        org.junit.Assert.assertFalse(bActual.getSExpr().equals(bEsperado.getSExpr()));
    }

    @org.junit.Test
    public void getZ3Expression4() {
        model.Z3Solver z3 = new model.Z3Solver();
        com.microsoft.z3.Context ctx = new com.microsoft.z3.Context();
        com.microsoft.z3.ArithExpr x = ctx.mkIntConst("x");
        com.microsoft.z3.IntExpr three = ctx.mkInt(3);
        com.microsoft.z3.BoolExpr bEsperado = ctx.mkEq(x, three);
        com.microsoft.z3.BoolExpr bActual = ((com.microsoft.z3.BoolExpr)(z3.getZ3BoolExpression("x == 3")));
        org.junit.Assert.assertEquals(bActual.getSExpr(), bEsperado.getSExpr());
    }

    @org.junit.Test
    public void getZ3Expression5() {
        model.Z3Solver z3 = new model.Z3Solver();
        com.microsoft.z3.Context ctx = new com.microsoft.z3.Context();
        com.microsoft.z3.ArithExpr x = ctx.mkIntConst("x");
        com.microsoft.z3.IntExpr three = ctx.mkInt(3);
        com.microsoft.z3.BoolExpr b = ctx.mkEq(x, three);
        com.microsoft.z3.BoolExpr bEsperado = ctx.mkNot(b);
        com.microsoft.z3.BoolExpr bActual = ((com.microsoft.z3.BoolExpr)(z3.getZ3BoolExpression("x != 3")));
        org.junit.Assert.assertEquals(bActual.getSExpr(), bEsperado.getSExpr());
    }

    @org.junit.Test
    public void getZ3Expression6() {
        model.Z3Solver z3 = new model.Z3Solver();
        com.microsoft.z3.Context ctx = new com.microsoft.z3.Context();
        com.microsoft.z3.ArithExpr x = ctx.mkIntConst("x");
        com.microsoft.z3.ArithExpr y = ctx.mkIntConst("y");
        com.microsoft.z3.BoolExpr b = ctx.mkEq(x, y);
        com.microsoft.z3.BoolExpr bEsperado = ctx.mkNot(b);
        com.microsoft.z3.BoolExpr bActual = ((com.microsoft.z3.BoolExpr)(z3.getZ3BoolExpression("!(x == y)")));
        org.junit.Assert.assertEquals(bActual.getSExpr(), bEsperado.getSExpr());
    }

    @org.junit.Test
    public void getZ3Expression7() {
        model.Z3Solver z3 = new model.Z3Solver();
        com.microsoft.z3.Context ctx = new com.microsoft.z3.Context();
        com.microsoft.z3.ArithExpr x = ctx.mkIntConst("x");
        com.microsoft.z3.ArithExpr y = ctx.mkIntConst("y");
        com.microsoft.z3.IntExpr one = ctx.mkInt(1);
        com.microsoft.z3.BoolExpr b = ctx.mkGt(x, y);
        com.microsoft.z3.BoolExpr b2 = ctx.mkLe(x, one);
        com.microsoft.z3.BoolExpr bEsperado = ctx.mkAnd(b, b2);
        com.microsoft.z3.BoolExpr bActual = ((com.microsoft.z3.BoolExpr)(z3.getZ3BoolExpression("((x > y) && (x <= 1))")));
        org.junit.Assert.assertEquals(bActual.getSExpr(), bEsperado.getSExpr());
    }

    @org.junit.Test
    public void getZ3Expression8() {
        model.Z3Solver z3 = new model.Z3Solver();
        com.microsoft.z3.Context ctx = new com.microsoft.z3.Context();
        com.microsoft.z3.ArithExpr x = ctx.mkIntConst("x0");
        com.microsoft.z3.ArithExpr y = ctx.mkIntConst("y0");
        com.microsoft.z3.IntExpr one = ctx.mkInt(1);
        com.microsoft.z3.IntExpr two = ctx.mkInt(2);
        com.microsoft.z3.ArithExpr x0_plus_one = ctx.mkAdd(x, one);
        com.microsoft.z3.ArithExpr two_mult_x0PlusOne = ctx.mkMul(two, x0_plus_one);
        com.microsoft.z3.ArithExpr two_mult_x0PlusOne_plus_y = ctx.mkAdd(two_mult_x0PlusOne, y);
        com.microsoft.z3.BoolExpr b = ctx.mkEq(two_mult_x0PlusOne_plus_y, y);
        com.microsoft.z3.BoolExpr bEsperado = ctx.mkNot(b);
        com.microsoft.z3.BoolExpr bActual = ((com.microsoft.z3.BoolExpr)(z3.getZ3BoolExpression("(((2)*((x0)+(1)))+(y0))!=(y0)")));
        org.junit.Assert.assertEquals(bActual.getSExpr(), bEsperado.getSExpr());
    }

    @org.junit.Test
    public void getZ3Expression9() {
        model.Z3Solver z3 = new model.Z3Solver();
        com.microsoft.z3.Context ctx = new com.microsoft.z3.Context();
        com.microsoft.z3.ArithExpr x = ctx.mkIntConst("x");
        com.microsoft.z3.IntExpr one = ctx.mkInt((-1));
        com.microsoft.z3.BoolExpr bEsperado = ctx.mkGt(x, one);
        com.microsoft.z3.BoolExpr bActual = ((com.microsoft.z3.BoolExpr)(z3.getZ3BoolExpression("((x) > (-1))")));
        org.junit.Assert.assertEquals(bEsperado.getSExpr(), bActual.getSExpr());
    }

    @org.junit.Test
    public void getZ3Expression10() {
        model.Z3Solver z3 = new model.Z3Solver();
        com.microsoft.z3.Context ctx = new com.microsoft.z3.Context();
        com.microsoft.z3.ArithExpr x = ctx.mkIntConst("x");
        com.microsoft.z3.ArithExpr y = ctx.mkIntConst("y");
        com.microsoft.z3.IntExpr intNum = ctx.mkInt((-150));
        com.microsoft.z3.ArithExpr b1 = ctx.mkSub(x, y);
        com.microsoft.z3.BoolExpr bEsperado = ctx.mkEq(b1, intNum);
        com.microsoft.z3.BoolExpr bActual = ((com.microsoft.z3.BoolExpr)(z3.getZ3BoolExpression("((x)-(y) == (-150))")));
        org.junit.Assert.assertEquals(bEsperado.getSExpr(), bActual.getSExpr());
    }

    @org.junit.Test
    public void getZ3Expression11() {
        model.Z3Solver z3 = new model.Z3Solver();
        java.util.List<model.SymbCondition> conditionsSymb = new java.util.ArrayList<>();
        conditionsSymb.add(new model.SymbCondition("((x0)>(0))"));
        conditionsSymb.add(new model.SymbCondition("((y0)<(0))"));
        conditionsSymb.add(new model.SymbCondition("(((y0)+(x0))<(10))"));
        java.lang.System.out.println(z3.getSatisfiableValues(conditionsSymb));
        org.junit.Assert.assertEquals(2, z3.getSatisfiableValues(conditionsSymb).size());
    }
}

