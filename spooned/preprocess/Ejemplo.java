package preprocess;


public class Ejemplo {
    public void method(int x, int y) {
        y = x;
        if (x < 3) {
            x = x + 1;
            int i_xeditx_1 = 0;
            int c_xeditx_1 = 3;
            if ((i_xeditx_1 + c_xeditx_1) < 5) {
                i_xeditx_1 = i_xeditx_1 + 1;
                c_xeditx_1 = i_xeditx_1 - 1;
                if ((i_xeditx_1 + c_xeditx_1) < 5) {
                    i_xeditx_1 = i_xeditx_1 + 1;
                    c_xeditx_1 = i_xeditx_1 - 1;
                } 
            } 
            java.lang.System.out.println(("x = " + x));
            if (x < 3) {
                x = x + 1;
                int i_xeditx_2 = 0;
                int c_xeditx_2 = 3;
                if ((i_xeditx_2 + c_xeditx_2) < 5) {
                    i_xeditx_2 = i_xeditx_2 + 1;
                    c_xeditx_2 = i_xeditx_2 - 1;
                    if ((i_xeditx_2 + c_xeditx_2) < 5) {
                        i_xeditx_2 = i_xeditx_2 + 1;
                        c_xeditx_2 = i_xeditx_2 - 1;
                    } 
                } 
                java.lang.System.out.println(("x = " + x));
            } 
        } 
    }

    public java.util.LinkedHashSet<model.SymbCondition> _conditions = new java.util.LinkedHashSet<model.SymbCondition>();

    public java.util.List<java.lang.String> _parameters = null;
}

