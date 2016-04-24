package instrument;
public class Ejemplo {
    public void m0(int x) {
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
                    {
                        i_xeditx_1 = i_xeditx_1 + 1;
                        String symbExprAssignment3 = symbResolver.getSymbolicExpression("i_xeditx_1 + 1",varSymValMap);
                        varSymValMap.put("i_xeditx_1",symbExprAssignment3);
                    }
                    model.SymbCondition symbExprConditional_4 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_1 < 5",varSymValMap));
                    if (i_xeditx_1 < 5) _conditions.add(symbExprConditional_4); else _conditions.add(symbExprConditional_4.makeNegado());
                    if (i_xeditx_1 < 5) {
                        i_xeditx_1 = i_xeditx_1 + 1;
                        String symbExprAssignment4 = symbResolver.getSymbolicExpression("i_xeditx_1 + 1",varSymValMap);
                        varSymValMap.put("i_xeditx_1",symbExprAssignment4);
                    } 
                } 
            } 
            model.SymbCondition symbExprConditional_5 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < 2",varSymValMap));
            if (x < 2) _conditions.add(symbExprConditional_5); else _conditions.add(symbExprConditional_5.makeNegado());
            if (x < 2) {
                {
                    x = x + 1;
                    String symbExprAssignment5 = symbResolver.getSymbolicExpression("x + 1",varSymValMap);
                    varSymValMap.put("x",symbExprAssignment5);
                    int i_xeditx_2 = x;
                    String symbExprLocalVar_2 = symbResolver.getSymbolicExpression("x",varSymValMap);
                    varSymValMap.put("i_xeditx_2",symbExprLocalVar_2);
                    model.SymbCondition symbExprConditional_6 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_2 < 5",varSymValMap));
                    if (i_xeditx_2 < 5) _conditions.add(symbExprConditional_6); else _conditions.add(symbExprConditional_6.makeNegado());
                    if (i_xeditx_2 < 5) {
                        i_xeditx_2 = i_xeditx_2 + 1;
                        String symbExprAssignment6 = symbResolver.getSymbolicExpression("i_xeditx_2 + 1",varSymValMap);
                        varSymValMap.put("i_xeditx_2",symbExprAssignment6);
                        model.SymbCondition symbExprConditional_7 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_2 < 5",varSymValMap));
                        if (i_xeditx_2 < 5) _conditions.add(symbExprConditional_7); else _conditions.add(symbExprConditional_7.makeNegado());
                        if (i_xeditx_2 < 5) {
                            {
                                i_xeditx_2 = i_xeditx_2 + 1;
                                String symbExprAssignment7 = symbResolver.getSymbolicExpression("i_xeditx_2 + 1",varSymValMap);
                                varSymValMap.put("i_xeditx_2",symbExprAssignment7);
                            }
                            model.SymbCondition symbExprConditional_8 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_2 < 5",varSymValMap));
                            if (i_xeditx_2 < 5) _conditions.add(symbExprConditional_8); else _conditions.add(symbExprConditional_8.makeNegado());
                            if (i_xeditx_2 < 5) {
                                i_xeditx_2 = i_xeditx_2 + 1;
                                String symbExprAssignment8 = symbResolver.getSymbolicExpression("i_xeditx_2 + 1",varSymValMap);
                                varSymValMap.put("i_xeditx_2",symbExprAssignment8);
                            } 
                        } 
                    } 
                }
                model.SymbCondition symbExprConditional_9 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < 2",varSymValMap));
                if (x < 2) _conditions.add(symbExprConditional_9); else _conditions.add(symbExprConditional_9.makeNegado());
                if (x < 2) {
                    x = x + 1;
                    String symbExprAssignment9 = symbResolver.getSymbolicExpression("x + 1",varSymValMap);
                    varSymValMap.put("x",symbExprAssignment9);
                    int i_xeditx_3 = x;
                    String symbExprLocalVar_3 = symbResolver.getSymbolicExpression("x",varSymValMap);
                    varSymValMap.put("i_xeditx_3",symbExprLocalVar_3);
                    model.SymbCondition symbExprConditional_10 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_3 < 5",varSymValMap));
                    if (i_xeditx_3 < 5) _conditions.add(symbExprConditional_10); else _conditions.add(symbExprConditional_10.makeNegado());
                    if (i_xeditx_3 < 5) {
                        i_xeditx_3 = i_xeditx_3 + 1;
                        String symbExprAssignment10 = symbResolver.getSymbolicExpression("i_xeditx_3 + 1",varSymValMap);
                        varSymValMap.put("i_xeditx_3",symbExprAssignment10);
                        model.SymbCondition symbExprConditional_11 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_3 < 5",varSymValMap));
                        if (i_xeditx_3 < 5) _conditions.add(symbExprConditional_11); else _conditions.add(symbExprConditional_11.makeNegado());
                        if (i_xeditx_3 < 5) {
                            {
                                i_xeditx_3 = i_xeditx_3 + 1;
                                String symbExprAssignment11 = symbResolver.getSymbolicExpression("i_xeditx_3 + 1",varSymValMap);
                                varSymValMap.put("i_xeditx_3",symbExprAssignment11);
                            }
                            model.SymbCondition symbExprConditional_12 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_3 < 5",varSymValMap));
                            if (i_xeditx_3 < 5) _conditions.add(symbExprConditional_12); else _conditions.add(symbExprConditional_12.makeNegado());
                            if (i_xeditx_3 < 5) {
                                i_xeditx_3 = i_xeditx_3 + 1;
                                String symbExprAssignment12 = symbResolver.getSymbolicExpression("i_xeditx_3 + 1",varSymValMap);
                                varSymValMap.put("i_xeditx_3",symbExprAssignment12);
                            } 
                        } 
                    } 
                } 
            } 
        } 
    }

    public void m1(int x, int y) {
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

    public void m2(int x) {
        _parameters = new java.util.ArrayList<String>();
        _parameters.add("x");
        model.ConcolicExpression symbResolver= new model.ConcolicExpression();
        java.util.Map<String, String> varSymValMap = new java.util.HashMap<String, String>();
        varSymValMap.put("x","x0");
        model.SymbCondition symbExprConditional_1 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < 3",varSymValMap));
        if (x < 3) _conditions.add(symbExprConditional_1); else _conditions.add(symbExprConditional_1.makeNegado());
        if (x < 3) {
            model.SymbCondition symbExprConditional_2 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < 2",varSymValMap));
            if (x < 2) _conditions.add(symbExprConditional_2); else _conditions.add(symbExprConditional_2.makeNegado());
            if (x < 2) {
                model.SymbCondition symbExprConditional_3 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < 1",varSymValMap));
                if (x < 1) _conditions.add(symbExprConditional_3); else _conditions.add(symbExprConditional_3.makeNegado());
                if (x < 1) {
                } 
            } 
        } 
    }

    public java.util.LinkedHashSet<model.SymbCondition> _conditions = new java.util.LinkedHashSet<model.SymbCondition>();

    public java.util.List<java.lang.String> _parameters = null;
}