package preprocess;


public class Ejemplo {
    public void method(int x) {
        int a = x;
        x = x - 1;
        if (x < 2) {
            x = x + 1;
            int i_xeditx_1 = x;
            if (i_xeditx_1 < 5) {
                i_xeditx_1 = i_xeditx_1 + 1;
                if (i_xeditx_1 < 5) {
                    i_xeditx_1 = i_xeditx_1 + 1;
                } 
            } 
            if (x < 2) {
                x = x + 1;
                int i_xeditx_2 = x;
                if (i_xeditx_2 < 5) {
                    i_xeditx_2 = i_xeditx_2 + 1;
                    if (i_xeditx_2 < 5) {
                        i_xeditx_2 = i_xeditx_2 + 1;
                    } 
                } 
            } 
        } 
    }

    public java.util.LinkedHashSet<model.SymbCondition> _conditions = new java.util.LinkedHashSet<model.SymbCondition>();

    public java.util.List<java.lang.String> _parameters = null;
}

