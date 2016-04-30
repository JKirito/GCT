package preprocess;


public class Ejemplo {
    public java.lang.Integer m0(int x) {
        if (x < 2) {
            x = x + 1;
            int i_xeditx_1 = x;
            if (i_xeditx_1 < 5) {
                i_xeditx_1 = i_xeditx_1 + 1;
                if (i_xeditx_1 < 5) {
                    {
                        i_xeditx_1 = i_xeditx_1 + 1;
                    }
                    if (i_xeditx_1 < 5) {
                        i_xeditx_1 = i_xeditx_1 + 1;
                    } 
                } 
            } 
            if (x < 2) {
                {
                    x = x + 1;
                    int i_xeditx_2 = x;
                    if (i_xeditx_2 < 5) {
                        i_xeditx_2 = i_xeditx_2 + 1;
                        if (i_xeditx_2 < 5) {
                            {
                                i_xeditx_2 = i_xeditx_2 + 1;
                            }
                            if (i_xeditx_2 < 5) {
                                i_xeditx_2 = i_xeditx_2 + 1;
                            } 
                        } 
                    } 
                }
                if (x < 2) {
                    x = x + 1;
                    int i_xeditx_3 = x;
                    if (i_xeditx_3 < 5) {
                        i_xeditx_3 = i_xeditx_3 + 1;
                        if (i_xeditx_3 < 5) {
                            {
                                i_xeditx_3 = i_xeditx_3 + 1;
                            }
                            if (i_xeditx_3 < 5) {
                                i_xeditx_3 = i_xeditx_3 + 1;
                            } 
                        } 
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
        int i = 0;
        if (i < 10) {
            if (x <= 2) {
                y = y + 1;
            } else {
                x = x + 2;
            }
            i = i + 1;
            if (i < 10) {
                {
                    if (x <= 2) {
                        y = y + 1;
                    } else {
                        x = x + 2;
                    }
                    i = i + 1;
                }
                if (i < 10) {
                    if (x <= 2) {
                        y = y + 1;
                    } else {
                        x = x + 2;
                    }
                    i = i + 1;
                } 
            } 
        } 
    }

    public void m2(int x) {
        if (x < 5) {
            if (x < 3) {
                {
                    x = x - 1;
                    int i = 0;
                    if (i <= x) {
                        i = i + 1;
                        if (i <= x) {
                            {
                                i = i + 1;
                            }
                            if (i <= x) {
                                i = i + 1;
                            } 
                        } 
                    } 
                }
                if (x > 0) {
                    x = x - 1;
                    int i_xeditx_1 = 0;
                    if (i_xeditx_1 <= x) {
                        i_xeditx_1 = i_xeditx_1 + 1;
                        if (i_xeditx_1 <= x) {
                            {
                                i_xeditx_1 = i_xeditx_1 + 1;
                            }
                            if (i_xeditx_1 <= x) {
                                i_xeditx_1 = i_xeditx_1 + 1;
                            } 
                        } 
                    } 
                    if (x > 0) {
                        {
                            x = x - 1;
                            int i_xeditx_2 = 0;
                            if (i_xeditx_2 <= x) {
                                i_xeditx_2 = i_xeditx_2 + 1;
                                if (i_xeditx_2 <= x) {
                                    {
                                        i_xeditx_2 = i_xeditx_2 + 1;
                                    }
                                    if (i_xeditx_2 <= x) {
                                        i_xeditx_2 = i_xeditx_2 + 1;
                                    } 
                                } 
                            } 
                        }
                        if (x > 0) {
                            x = x - 1;
                            int i_xeditx_3 = 0;
                            if (i_xeditx_3 <= x) {
                                i_xeditx_3 = i_xeditx_3 + 1;
                                if (i_xeditx_3 <= x) {
                                    {
                                        i_xeditx_3 = i_xeditx_3 + 1;
                                    }
                                    if (i_xeditx_3 <= x) {
                                        i_xeditx_3 = i_xeditx_3 + 1;
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

