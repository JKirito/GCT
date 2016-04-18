package instrument;
public class Ejemplo {
    public void method(int x) {
        _parameters = new java.util.ArrayList<String>();
        _parameters.add("x");
        model.ConcolicExpression symbResolver= new model.ConcolicExpression();
        java.util.Map<String, String> varSymValMap = new java.util.HashMap<String, String>();
        varSymValMap.put("x","x0");
        int a = x;
        String symbExprLocalVar_1 = symbResolver.getSymbolicExpression("x",varSymValMap);
        varSymValMap.put("a",symbExprLocalVar_1);
        x = x - 1;
        String symbExprAssignment1 = symbResolver.getSymbolicExpression("x - 1",varSymValMap);
        varSymValMap.put("x",symbExprAssignment1);
        model.SymbCondition symbExprConditional_1 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < 2",varSymValMap));
        if (x < 2) _conditions.add(symbExprConditional_1); else _conditions.add(symbExprConditional_1.makeNegado());
        if (x < 2) {
            x = x + 1;
            String symbExprAssignment2 = symbResolver.getSymbolicExpression("x + 1",varSymValMap);
            varSymValMap.put("x",symbExprAssignment2);
            int i_xeditx_1 = x;
            String symbExprLocalVar_2 = symbResolver.getSymbolicExpression("x",varSymValMap);
            varSymValMap.put("i_xeditx_1",symbExprLocalVar_2);
            model.SymbCondition symbExprConditional_2 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_1 < 5",varSymValMap));
            if (i_xeditx_1 < 5) _conditions.add(symbExprConditional_2); else _conditions.add(symbExprConditional_2.makeNegado());
            if (i_xeditx_1 < 5) {
                i_xeditx_1 = i_xeditx_1 + 1;
                String symbExprAssignment3 = symbResolver.getSymbolicExpression("i_xeditx_1 + 1",varSymValMap);
                varSymValMap.put("i_xeditx_1",symbExprAssignment3);
                model.SymbCondition symbExprConditional_3 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_1 < 5",varSymValMap));
                if (i_xeditx_1 < 5) _conditions.add(symbExprConditional_3); else _conditions.add(symbExprConditional_3.makeNegado());
                if (i_xeditx_1 < 5) {
                    i_xeditx_1 = i_xeditx_1 + 1;
                    String symbExprAssignment4 = symbResolver.getSymbolicExpression("i_xeditx_1 + 1",varSymValMap);
                    varSymValMap.put("i_xeditx_1",symbExprAssignment4);
                } 
            } 
            model.SymbCondition symbExprConditional_4 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < 2",varSymValMap));
            if (x < 2) _conditions.add(symbExprConditional_4); else _conditions.add(symbExprConditional_4.makeNegado());
            if (x < 2) {
                x = x + 1;
                String symbExprAssignment5 = symbResolver.getSymbolicExpression("x + 1",varSymValMap);
                varSymValMap.put("x",symbExprAssignment5);
                int i_xeditx_2 = x;
                String symbExprLocalVar_3 = symbResolver.getSymbolicExpression("x",varSymValMap);
                varSymValMap.put("i_xeditx_2",symbExprLocalVar_3);
                model.SymbCondition symbExprConditional_5 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_2 < 5",varSymValMap));
                if (i_xeditx_2 < 5) _conditions.add(symbExprConditional_5); else _conditions.add(symbExprConditional_5.makeNegado());
                if (i_xeditx_2 < 5) {
                    i_xeditx_2 = i_xeditx_2 + 1;
                    String symbExprAssignment6 = symbResolver.getSymbolicExpression("i_xeditx_2 + 1",varSymValMap);
                    varSymValMap.put("i_xeditx_2",symbExprAssignment6);
                    model.SymbCondition symbExprConditional_6 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_2 < 5",varSymValMap));
                    if (i_xeditx_2 < 5) _conditions.add(symbExprConditional_6); else _conditions.add(symbExprConditional_6.makeNegado());
                    if (i_xeditx_2 < 5) {
                        i_xeditx_2 = i_xeditx_2 + 1;
                        String symbExprAssignment7 = symbResolver.getSymbolicExpression("i_xeditx_2 + 1",varSymValMap);
                        varSymValMap.put("i_xeditx_2",symbExprAssignment7);
                    } 
                } 
            } 
        } 
    }

    public java.util.LinkedHashSet<model.SymbCondition> _conditions = new java.util.LinkedHashSet<model.SymbCondition>();

    public java.util.List<java.lang.String> _parameters = null;
}