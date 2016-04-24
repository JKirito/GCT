package test;


public class Ejemplo {
    public void m0(int x) {
        while (x < 2) {
            x++;
            int i = x;
            while (i < 5) {
                i++;
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
}

