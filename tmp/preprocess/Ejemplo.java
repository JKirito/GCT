package preprocess;
public class Ejemplo {
    public void m0(int x) {
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
};
                            if (i_xeditx_3 < 5)
                                {
    i_xeditx_3 = i_xeditx_3 + 1;
};
                            
                        } 
                    } 
                } 
            } 
        } 
    }

    public void m1(int x, int y) {
        if (x > 2) {
            y = x + 1;
        } else {
            y = y + 1;
        }
        if (x <= 2) {
            y = y + 1;
        } else {
            x = x + 2;
        }
    }

    public void m2(int x) {
        if (x < 3) {
            if (x < 2) {
                if (x < 1) {
                } 
            } 
        } 
    }

    public java.util.LinkedHashSet<model.SymbCondition> _conditions = new java.util.LinkedHashSet<model.SymbCondition>();

    public java.util.List<java.lang.String> _parameters = null;
}