package tmp;
public class SrcClass {
    public void method(int x, int y) {
        _parameters = new java.util.ArrayList<String>();
        _parameters.add("x");
        _parameters.add("y");
        model.ConcolicExpression symbResolver= new model.ConcolicExpression();
        java.util.Map<String, String> varSymValMap = new java.util.HashMap<String, String>();
        varSymValMap.put("y","y0");
        varSymValMap.put("x","x0");
        model.SymbCondition symbExprConditional_1 = new model.SymbCondition(symbResolver.getSymbolicExpression("x > 2",varSymValMap));
        if (x > 2) _conditions.add(symbExprConditional_1); else _conditions.add(symbExprConditional_1.makeNegado());
        if (x > 2) {
            y = x + 1;
            String symbExprAssignment1 = symbResolver.getSymbolicExpression("x + 1",varSymValMap);
            varSymValMap.put("y",symbExprAssignment1);
        } else {
            y = y + 1;
            String symbExprAssignment2 = symbResolver.getSymbolicExpression("y + 1",varSymValMap);
            varSymValMap.put("y",symbExprAssignment2);
        }
        model.SymbCondition symbExprConditional_2 = new model.SymbCondition(symbResolver.getSymbolicExpression("x <= 2",varSymValMap));
        if (x <= 2) _conditions.add(symbExprConditional_2); else _conditions.add(symbExprConditional_2.makeNegado());
        if (x <= 2) {
            y = y + 1;
            String symbExprAssignment3 = symbResolver.getSymbolicExpression("y + 1",varSymValMap);
            varSymValMap.put("y",symbExprAssignment3);
        } else {
            x = x + 2;
            String symbExprAssignment4 = symbResolver.getSymbolicExpression("x + 2",varSymValMap);
            varSymValMap.put("x",symbExprAssignment4);
        }
    }

    public java.util.LinkedHashSet<model.SymbCondition> _conditions = new java.util.LinkedHashSet<model.SymbCondition>();

    public java.util.List<String> _parameters = null;
}