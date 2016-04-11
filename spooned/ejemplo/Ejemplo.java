package ejemplo;


public class Ejemplo {
    public void max(int x, int y) {
        if (x >= y) {
            x = 0;
        } else {
            y = 0;
        }
    }

    public void method(int x) {
        java.lang.System.out.println("Condiciones!!!");
        if (x >= 0) {
            x = 0;
        } else if (x < (-10)) {
            x = x * 10;
        } else {
            x = 0;
        }
    }
}

