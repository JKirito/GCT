package instrument;
public class Ejemplo {
    public java.lang.Integer m0(int x) {
        _parameters = new java.util.ArrayList<String>();
        _parameters.add("x");
        model.ConcolicExpression symbResolver= new model.ConcolicExpression();
        java.util.Map<String, String> varSymValMap = new java.util.HashMap<String, String>();
        varSymValMap.put("x","x0");
        model.SymbCondition symbExprConditional_1 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < 2",varSymValMap));
        if (x < 2) _conditions.add(symbExprConditional_1); else _conditions.add(symbExprConditional_1.makeNegado());
        if (x < 2) {
            x = x + 1;
            String symbExprAssignment1 = symbResolver.getSymbolicExpression("x + 1",varSymValMap);
            varSymValMap.put("x",symbExprAssignment1);
            int i_xeditx_1 = x;
            String symbExprLocalVar_1 = symbResolver.getSymbolicExpression("x",varSymValMap);
            varSymValMap.put("i_xeditx_1",symbExprLocalVar_1);
            model.SymbCondition symbExprConditional_2 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_1 < 5",varSymValMap));
            if (i_xeditx_1 < 5) _conditions.add(symbExprConditional_2); else _conditions.add(symbExprConditional_2.makeNegado());
            if (i_xeditx_1 < 5) {
                i_xeditx_1 = i_xeditx_1 + 1;
                String symbExprAssignment2 = symbResolver.getSymbolicExpression("i_xeditx_1 + 1",varSymValMap);
                varSymValMap.put("i_xeditx_1",symbExprAssignment2);
                model.SymbCondition symbExprConditional_3 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_1 < 5",varSymValMap));
                if (i_xeditx_1 < 5) _conditions.add(symbExprConditional_3); else _conditions.add(symbExprConditional_3.makeNegado());
                if (i_xeditx_1 < 5) {
                    i_xeditx_1 = i_xeditx_1 + 1;
                    String symbExprAssignment3 = symbResolver.getSymbolicExpression("i_xeditx_1 + 1",varSymValMap);
                    varSymValMap.put("i_xeditx_1",symbExprAssignment3);
                } 
            } 
            model.SymbCondition symbExprConditional_4 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < 2",varSymValMap));
            if (x < 2) _conditions.add(symbExprConditional_4); else _conditions.add(symbExprConditional_4.makeNegado());
            if (x < 2) {
                x = x + 1;
                String symbExprAssignment4 = symbResolver.getSymbolicExpression("x + 1",varSymValMap);
                varSymValMap.put("x",symbExprAssignment4);
                int i_xeditx_2 = x;
                String symbExprLocalVar_2 = symbResolver.getSymbolicExpression("x",varSymValMap);
                varSymValMap.put("i_xeditx_2",symbExprLocalVar_2);
                model.SymbCondition symbExprConditional_5 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_2 < 5",varSymValMap));
                if (i_xeditx_2 < 5) _conditions.add(symbExprConditional_5); else _conditions.add(symbExprConditional_5.makeNegado());
                if (i_xeditx_2 < 5) {
                    i_xeditx_2 = i_xeditx_2 + 1;
                    String symbExprAssignment5 = symbResolver.getSymbolicExpression("i_xeditx_2 + 1",varSymValMap);
                    varSymValMap.put("i_xeditx_2",symbExprAssignment5);
                    model.SymbCondition symbExprConditional_6 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_2 < 5",varSymValMap));
                    if (i_xeditx_2 < 5) _conditions.add(symbExprConditional_6); else _conditions.add(symbExprConditional_6.makeNegado());
                    if (i_xeditx_2 < 5) {
                        i_xeditx_2 = i_xeditx_2 + 1;
                        String symbExprAssignment6 = symbResolver.getSymbolicExpression("i_xeditx_2 + 1",varSymValMap);
                        varSymValMap.put("i_xeditx_2",symbExprAssignment6);
                    } 
                } 
            } 
        } 
        return 0;
    }

    public void m1(int x, int y) {
        if (x > 2) {
            y = x + 1;
        } else {
            y = y + 1;
        }
        for (int i = 0 ; i < 10 ; i++) {
            if (x <= 2) {
                y = y + 1;
            } else {
                x = x + 2;
            }
        }
    }

    public void m2(int x) {
        if (x < 5) {
            if (x < 3) {
                do {
                    x--;
                    for (int i = 0 ; i <= x ; i++) {
                    }
                } while (x > 0 );
            } 
        } 
    }

    public java.lang.Integer getMax(int x, int y, int z) {
        java.lang.Integer max = java.lang.Integer.MIN_VALUE;
        if ((x > y) && (x > z))
            max = x;
        else if ((y > x) && (y > z))
            max = y;
        else if ((z > y) && (z > x))
            max = z;
        else
            return x;
        
        return max;
    }

    public java.util.LinkedHashSet<model.SymbCondition> _conditions = new java.util.LinkedHashSet<model.SymbCondition>();

    public java.util.List<java.lang.String> _parameters = null;
}