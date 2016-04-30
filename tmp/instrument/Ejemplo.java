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
        return 0;
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
        int i = 0;
        String symbExprLocalVar_1 = symbResolver.getSymbolicExpression("0",varSymValMap);
        varSymValMap.put("i",symbExprLocalVar_1);
        model.SymbCondition symbExprConditional_2 = new model.SymbCondition(symbResolver.getSymbolicExpression("i < 10",varSymValMap));
        if (i < 10) _conditions.add(symbExprConditional_2); else _conditions.add(symbExprConditional_2.makeNegado());
        if (i < 10) {
            model.SymbCondition symbExprConditional_3 = new model.SymbCondition(symbResolver.getSymbolicExpression("x <= 2",varSymValMap));
            if (x <= 2) _conditions.add(symbExprConditional_3); else _conditions.add(symbExprConditional_3.makeNegado());
            if (x <= 2) {
                y = y + 1;
                String symbExprAssignment3 = symbResolver.getSymbolicExpression("y + 1",varSymValMap);
                varSymValMap.put("y",symbExprAssignment3);
            } else {
                x = x + 2;
                String symbExprAssignment4 = symbResolver.getSymbolicExpression("x + 2",varSymValMap);
                varSymValMap.put("x",symbExprAssignment4);
            }
            i = i + 1;
            String symbExprAssignment5 = symbResolver.getSymbolicExpression("i + 1",varSymValMap);
            varSymValMap.put("i",symbExprAssignment5);
            model.SymbCondition symbExprConditional_4 = new model.SymbCondition(symbResolver.getSymbolicExpression("i < 10",varSymValMap));
            if (i < 10) _conditions.add(symbExprConditional_4); else _conditions.add(symbExprConditional_4.makeNegado());
            if (i < 10) {
                {
                    model.SymbCondition symbExprConditional_5 = new model.SymbCondition(symbResolver.getSymbolicExpression("x <= 2",varSymValMap));
                    if (x <= 2) _conditions.add(symbExprConditional_5); else _conditions.add(symbExprConditional_5.makeNegado());
                    if (x <= 2) {
                        y = y + 1;
                        String symbExprAssignment6 = symbResolver.getSymbolicExpression("y + 1",varSymValMap);
                        varSymValMap.put("y",symbExprAssignment6);
                    } else {
                        x = x + 2;
                        String symbExprAssignment7 = symbResolver.getSymbolicExpression("x + 2",varSymValMap);
                        varSymValMap.put("x",symbExprAssignment7);
                    }
                    i = i + 1;
                    String symbExprAssignment8 = symbResolver.getSymbolicExpression("i + 1",varSymValMap);
                    varSymValMap.put("i",symbExprAssignment8);
                }
                model.SymbCondition symbExprConditional_6 = new model.SymbCondition(symbResolver.getSymbolicExpression("i < 10",varSymValMap));
                if (i < 10) _conditions.add(symbExprConditional_6); else _conditions.add(symbExprConditional_6.makeNegado());
                if (i < 10) {
                    model.SymbCondition symbExprConditional_7 = new model.SymbCondition(symbResolver.getSymbolicExpression("x <= 2",varSymValMap));
                    if (x <= 2) _conditions.add(symbExprConditional_7); else _conditions.add(symbExprConditional_7.makeNegado());
                    if (x <= 2) {
                        y = y + 1;
                        String symbExprAssignment9 = symbResolver.getSymbolicExpression("y + 1",varSymValMap);
                        varSymValMap.put("y",symbExprAssignment9);
                    } else {
                        x = x + 2;
                        String symbExprAssignment10 = symbResolver.getSymbolicExpression("x + 2",varSymValMap);
                        varSymValMap.put("x",symbExprAssignment10);
                    }
                    i = i + 1;
                    String symbExprAssignment11 = symbResolver.getSymbolicExpression("i + 1",varSymValMap);
                    varSymValMap.put("i",symbExprAssignment11);
                } 
            } 
        } 
    }

    public void m2(int x) {
        _parameters = new java.util.ArrayList<String>();
        _parameters.add("x");
        model.ConcolicExpression symbResolver= new model.ConcolicExpression();
        java.util.Map<String, String> varSymValMap = new java.util.HashMap<String, String>();
        varSymValMap.put("x","x0");
        model.SymbCondition symbExprConditional_1 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < 5",varSymValMap));
        if (x < 5) _conditions.add(symbExprConditional_1); else _conditions.add(symbExprConditional_1.makeNegado());
        if (x < 5) {
            model.SymbCondition symbExprConditional_2 = new model.SymbCondition(symbResolver.getSymbolicExpression("x < 3",varSymValMap));
            if (x < 3) _conditions.add(symbExprConditional_2); else _conditions.add(symbExprConditional_2.makeNegado());
            if (x < 3) {
                {
                    x = x - 1;
                    String symbExprAssignment1 = symbResolver.getSymbolicExpression("x - 1",varSymValMap);
                    varSymValMap.put("x",symbExprAssignment1);
                    int i = 0;
                    String symbExprLocalVar_1 = symbResolver.getSymbolicExpression("0",varSymValMap);
                    varSymValMap.put("i",symbExprLocalVar_1);
                    model.SymbCondition symbExprConditional_3 = new model.SymbCondition(symbResolver.getSymbolicExpression("i <= x",varSymValMap));
                    if (i <= x) _conditions.add(symbExprConditional_3); else _conditions.add(symbExprConditional_3.makeNegado());
                    if (i <= x) {
                        i = i + 1;
                        String symbExprAssignment2 = symbResolver.getSymbolicExpression("i + 1",varSymValMap);
                        varSymValMap.put("i",symbExprAssignment2);
                        model.SymbCondition symbExprConditional_4 = new model.SymbCondition(symbResolver.getSymbolicExpression("i <= x",varSymValMap));
                        if (i <= x) _conditions.add(symbExprConditional_4); else _conditions.add(symbExprConditional_4.makeNegado());
                        if (i <= x) {
                            {
                                i = i + 1;
                                String symbExprAssignment3 = symbResolver.getSymbolicExpression("i + 1",varSymValMap);
                                varSymValMap.put("i",symbExprAssignment3);
                            }
                            model.SymbCondition symbExprConditional_5 = new model.SymbCondition(symbResolver.getSymbolicExpression("i <= x",varSymValMap));
                            if (i <= x) _conditions.add(symbExprConditional_5); else _conditions.add(symbExprConditional_5.makeNegado());
                            if (i <= x) {
                                i = i + 1;
                                String symbExprAssignment4 = symbResolver.getSymbolicExpression("i + 1",varSymValMap);
                                varSymValMap.put("i",symbExprAssignment4);
                            } 
                        } 
                    } 
                }
                model.SymbCondition symbExprConditional_6 = new model.SymbCondition(symbResolver.getSymbolicExpression("x > 0",varSymValMap));
                if (x > 0) _conditions.add(symbExprConditional_6); else _conditions.add(symbExprConditional_6.makeNegado());
                if (x > 0) {
                    x = x - 1;
                    String symbExprAssignment5 = symbResolver.getSymbolicExpression("x - 1",varSymValMap);
                    varSymValMap.put("x",symbExprAssignment5);
                    int i_xeditx_1 = 0;
                    String symbExprLocalVar_2 = symbResolver.getSymbolicExpression("0",varSymValMap);
                    varSymValMap.put("i_xeditx_1",symbExprLocalVar_2);
                    model.SymbCondition symbExprConditional_7 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_1 <= x",varSymValMap));
                    if (i_xeditx_1 <= x) _conditions.add(symbExprConditional_7); else _conditions.add(symbExprConditional_7.makeNegado());
                    if (i_xeditx_1 <= x) {
                        i_xeditx_1 = i_xeditx_1 + 1;
                        String symbExprAssignment6 = symbResolver.getSymbolicExpression("i_xeditx_1 + 1",varSymValMap);
                        varSymValMap.put("i_xeditx_1",symbExprAssignment6);
                        model.SymbCondition symbExprConditional_8 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_1 <= x",varSymValMap));
                        if (i_xeditx_1 <= x) _conditions.add(symbExprConditional_8); else _conditions.add(symbExprConditional_8.makeNegado());
                        if (i_xeditx_1 <= x) {
                            {
                                i_xeditx_1 = i_xeditx_1 + 1;
                                String symbExprAssignment7 = symbResolver.getSymbolicExpression("i_xeditx_1 + 1",varSymValMap);
                                varSymValMap.put("i_xeditx_1",symbExprAssignment7);
                            }
                            model.SymbCondition symbExprConditional_9 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_1 <= x",varSymValMap));
                            if (i_xeditx_1 <= x) _conditions.add(symbExprConditional_9); else _conditions.add(symbExprConditional_9.makeNegado());
                            if (i_xeditx_1 <= x) {
                                i_xeditx_1 = i_xeditx_1 + 1;
                                String symbExprAssignment8 = symbResolver.getSymbolicExpression("i_xeditx_1 + 1",varSymValMap);
                                varSymValMap.put("i_xeditx_1",symbExprAssignment8);
                            } 
                        } 
                    } 
                    model.SymbCondition symbExprConditional_10 = new model.SymbCondition(symbResolver.getSymbolicExpression("x > 0",varSymValMap));
                    if (x > 0) _conditions.add(symbExprConditional_10); else _conditions.add(symbExprConditional_10.makeNegado());
                    if (x > 0) {
                        {
                            x = x - 1;
                            String symbExprAssignment9 = symbResolver.getSymbolicExpression("x - 1",varSymValMap);
                            varSymValMap.put("x",symbExprAssignment9);
                            int i_xeditx_2 = 0;
                            String symbExprLocalVar_3 = symbResolver.getSymbolicExpression("0",varSymValMap);
                            varSymValMap.put("i_xeditx_2",symbExprLocalVar_3);
                            model.SymbCondition symbExprConditional_11 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_2 <= x",varSymValMap));
                            if (i_xeditx_2 <= x) _conditions.add(symbExprConditional_11); else _conditions.add(symbExprConditional_11.makeNegado());
                            if (i_xeditx_2 <= x) {
                                i_xeditx_2 = i_xeditx_2 + 1;
                                String symbExprAssignment10 = symbResolver.getSymbolicExpression("i_xeditx_2 + 1",varSymValMap);
                                varSymValMap.put("i_xeditx_2",symbExprAssignment10);
                                model.SymbCondition symbExprConditional_12 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_2 <= x",varSymValMap));
                                if (i_xeditx_2 <= x) _conditions.add(symbExprConditional_12); else _conditions.add(symbExprConditional_12.makeNegado());
                                if (i_xeditx_2 <= x) {
                                    {
                                        i_xeditx_2 = i_xeditx_2 + 1;
                                        String symbExprAssignment11 = symbResolver.getSymbolicExpression("i_xeditx_2 + 1",varSymValMap);
                                        varSymValMap.put("i_xeditx_2",symbExprAssignment11);
                                    }
                                    model.SymbCondition symbExprConditional_13 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_2 <= x",varSymValMap));
                                    if (i_xeditx_2 <= x) _conditions.add(symbExprConditional_13); else _conditions.add(symbExprConditional_13.makeNegado());
                                    if (i_xeditx_2 <= x) {
                                        i_xeditx_2 = i_xeditx_2 + 1;
                                        String symbExprAssignment12 = symbResolver.getSymbolicExpression("i_xeditx_2 + 1",varSymValMap);
                                        varSymValMap.put("i_xeditx_2",symbExprAssignment12);
                                    } 
                                } 
                            } 
                        }
                        model.SymbCondition symbExprConditional_14 = new model.SymbCondition(symbResolver.getSymbolicExpression("x > 0",varSymValMap));
                        if (x > 0) _conditions.add(symbExprConditional_14); else _conditions.add(symbExprConditional_14.makeNegado());
                        if (x > 0) {
                            x = x - 1;
                            String symbExprAssignment13 = symbResolver.getSymbolicExpression("x - 1",varSymValMap);
                            varSymValMap.put("x",symbExprAssignment13);
                            int i_xeditx_3 = 0;
                            String symbExprLocalVar_4 = symbResolver.getSymbolicExpression("0",varSymValMap);
                            varSymValMap.put("i_xeditx_3",symbExprLocalVar_4);
                            model.SymbCondition symbExprConditional_15 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_3 <= x",varSymValMap));
                            if (i_xeditx_3 <= x) _conditions.add(symbExprConditional_15); else _conditions.add(symbExprConditional_15.makeNegado());
                            if (i_xeditx_3 <= x) {
                                i_xeditx_3 = i_xeditx_3 + 1;
                                String symbExprAssignment14 = symbResolver.getSymbolicExpression("i_xeditx_3 + 1",varSymValMap);
                                varSymValMap.put("i_xeditx_3",symbExprAssignment14);
                                model.SymbCondition symbExprConditional_16 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_3 <= x",varSymValMap));
                                if (i_xeditx_3 <= x) _conditions.add(symbExprConditional_16); else _conditions.add(symbExprConditional_16.makeNegado());
                                if (i_xeditx_3 <= x) {
                                    {
                                        i_xeditx_3 = i_xeditx_3 + 1;
                                        String symbExprAssignment15 = symbResolver.getSymbolicExpression("i_xeditx_3 + 1",varSymValMap);
                                        varSymValMap.put("i_xeditx_3",symbExprAssignment15);
                                    }
                                    model.SymbCondition symbExprConditional_17 = new model.SymbCondition(symbResolver.getSymbolicExpression("i_xeditx_3 <= x",varSymValMap));
                                    if (i_xeditx_3 <= x) _conditions.add(symbExprConditional_17); else _conditions.add(symbExprConditional_17.makeNegado());
                                    if (i_xeditx_3 <= x) {
                                        i_xeditx_3 = i_xeditx_3 + 1;
                                        String symbExprAssignment16 = symbResolver.getSymbolicExpression("i_xeditx_3 + 1",varSymValMap);
                                        varSymValMap.put("i_xeditx_3",symbExprAssignment16);
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
    }

    public java.lang.Integer getMax(int x, int y, int z) {
        _parameters = new java.util.ArrayList<String>();
        _parameters.add("x");
        _parameters.add("y");
        _parameters.add("z");
        model.ConcolicExpression symbResolver= new model.ConcolicExpression();
        java.util.Map<String, String> varSymValMap = new java.util.HashMap<String, String>();
        varSymValMap.put("z","z0");
        varSymValMap.put("y","y0");
        varSymValMap.put("x","x0");
        java.lang.Integer max = java.lang.Integer.MIN_VALUE;
        String symbExprLocalVar_1 = symbResolver.getSymbolicExpression("java.lang.Integer.MIN_VALUE",varSymValMap);
        varSymValMap.put("max",symbExprLocalVar_1);
        model.SymbCondition symbExprConditional_1 = new model.SymbCondition(symbResolver.getSymbolicExpression("(x > y) && (x > z)",varSymValMap));
        if ((x > y) && (x > z)) _conditions.add(symbExprConditional_1); else _conditions.add(symbExprConditional_1.makeNegado());
        if ((x > y) && (x > z)) {
            max = x;
            String symbExprAssignment1 = symbResolver.getSymbolicExpression("x",varSymValMap);
            varSymValMap.put("max",symbExprAssignment1);
        } else {
            model.SymbCondition symbExprConditional_2 = new model.SymbCondition(symbResolver.getSymbolicExpression("(y > x) && (y > z)",varSymValMap));
            if ((y > x) && (y > z)) _conditions.add(symbExprConditional_2); else _conditions.add(symbExprConditional_2.makeNegado());
            if ((y > x) && (y > z)) {
                max = y;
                String symbExprAssignment2 = symbResolver.getSymbolicExpression("y",varSymValMap);
                varSymValMap.put("max",symbExprAssignment2);
            } else {
                model.SymbCondition symbExprConditional_3 = new model.SymbCondition(symbResolver.getSymbolicExpression("(z > y) && (z > x)",varSymValMap));
                if ((z > y) && (z > x)) _conditions.add(symbExprConditional_3); else _conditions.add(symbExprConditional_3.makeNegado());
                if ((z > y) && (z > x)) {
                    max = z;
                    String symbExprAssignment3 = symbResolver.getSymbolicExpression("z",varSymValMap);
                    varSymValMap.put("max",symbExprAssignment3);
                } else
                    return x;
                
            }
        }
        return max;
    }

    public java.util.LinkedHashSet<model.SymbCondition> _conditions = new java.util.LinkedHashSet<model.SymbCondition>();

    public java.util.List<java.lang.String> _parameters = null;
}