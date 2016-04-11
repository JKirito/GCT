package input;


public class SrcClass {
    public void method(int x, int y) {
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
}

