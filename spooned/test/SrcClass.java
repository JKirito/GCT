package test;


public class SrcClass {
    public int m1(int x, int y) {
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
        return x + y;
    }

    public int m2(int x) {
        if (x < 3) {
            if (x < 2) {
                if (x < 1) {
                    return 3;
                } 
                return 7;
            } 
            return -1;
        } 
        return 22;
    }
}

