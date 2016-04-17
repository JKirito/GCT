package instrument;
public class Ejemplo {
    public void method(int x, int y) {
        y = x;
        while (x < 3) {
            x = x + 1;
            int i = 0;
            int c = 3;
            while ((i + c) < 5) {
                i = i + 1;
                c = i - 1;
            }
            java.lang.System.out.println(("x = " + x));
        }
    }
}