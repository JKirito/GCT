package tmp;
public class Ejemplo {
    public void max(int x, int y) {
        _parameters = new java.util.ArrayList<String>();
        _parameters.add("x");
        _parameters.add("y");
        model.ConcolicExpression symbResolver= new model.ConcolicExpression();
        java.util.Map<String, String> varSymValMap = new java.util.HashMap<String, String>();
        varSymValMap.put("y","y0");
        varSymValMap.put("x","x0");
        model.SymbCondition symbExprConditional_1 = new model.SymbCondition(symbResolver.getSymbolicExpression("x >= y",varSymValMap));
        if (x >= y) _conditions.add(symbExprConditional_1); else _conditions.add(symbExprConditional_1.makeNegado());
        if (x >= y) {
            x = 0;
            String symbExprAssignment1 = symbResolver.getSymbolicExpression("0",varSymValMap);
            varSymValMap.put("x",symbExprAssignment1);
        } else {
            y = 0;
            String symbExprAssignment2 = symbResolver.getSymbolicExpression("0",varSymValMap);
            varSymValMap.put("y",symbExprAssignment2);
        }
    }

    public void method(int x) {
        _parameters = new java.util.ArrayList<String>();
        _parameters.add("x");
        model.ConcolicExpression symbResolver= new model.ConcolicExpression();
        java.util.Map<String, String> varSymValMap = new java.util.HashMap<String, String>();
        varSymValMap.put("x","x0");
        java.lang.System.out.println("Condiciones!!!");
        model.SymbCondition symbExprConditional_1 = new model.SymbCondition(symbResolver.getSymbolicExpression("x >= 0",varSymValMap));
        if (x >= 0) _conditions.add(symbExprConditional_1); else _conditions.add(symbExprConditional_1.makeNegado());
        if (x >= 0) {
            x = 0;
            String symbExprAssignment1 = symbResolver.getSymbolicExpression("0",varSymValMap);
            varSymValMap.put("x",symbExprAssignment1);
        } else {
            model.SymbCondition symbExprConditional_2 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < (-10)",varSymValMap));
            if (x < (-10)) _conditions.add(symbExprConditional_2); else _conditions.add(symbExprConditional_2.makeNegado());
            if (x < (-10)) {
                x = x * 10;
                String symbExprAssignment2 = symbResolver.getSymbolicExpression("x * 10",varSymValMap);
                varSymValMap.put("x",symbExprAssignment2);
            } else {
                x = 0;
                String symbExprAssignment3 = symbResolver.getSymbolicExpression("0",varSymValMap);
                varSymValMap.put("x",symbExprAssignment3);
            }
        }
    }

    public java.util.LinkedHashSet<model.SymbCondition> _conditions = new java.util.LinkedHashSet<model.SymbCondition>();

    public java.util.List<String> _parameters = null;
}