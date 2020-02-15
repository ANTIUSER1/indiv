package pns.mathutil.stringOperators;

import pns.mathutil.numberOperators.Rnd;

public class StrDataOperator {
    public static String rndString(int a, int b, int len) {
        if (len == 0) return "" + ((char) Rnd.rndByteBetween(a, b));
        StringBuffer sbf = new StringBuffer();
        for (int k = 0; k < len; k++) {
            byte bt = Rnd.rndByteBetween(a, b);
            sbf.append((char) bt);
        }
        return sbf.toString();
    }

    public static String[] rndStringArray(int a, int b) {
        int len = Rnd.rndIntegerBetween(2, 5);
        String[] res = new String[len];
        for (int k = 0; k < len; k++) {
            int lengh = Rnd.rndIntegerBetween(6, 15);
            res[k] = rndString(a, b, lengh);
        }
        return res;
    }

    public static String[] rndStringArray(int a, int b, int len) {
        String[] res = new String[len];
        for (int k = 0; k < len; k++) {
            int lengh = Rnd.rndIntegerBetween(6, 15);
            res[k] = rndString(a, b, lengh);
        }
        return res;
    }

    public static String[] rndStringArray(int a, int b, int len, int deg) {
        String[] res = new String[len];
        for (int k = 0; k < len; k++) {
            res[k] = rndString(a, b, deg);
        }
        return res;
    }

    public static String[][] rndStringDoubleArray(int a, int b, int lenX, int lenY, int deg) {
        String[][] res = new String[lenX][lenY];
        for (int k = 0; k < lenX; k++) {
            for (int m = 0; m < lenY; m++) {
                res[k][m] = rndString(a, b, deg);
            }
        }
        return res;
    }


    public static String[][] rndStringDoubleArray(int a, int b, int lenX, int lenY) {
        String[][] res = new String[lenX][lenY];
        for (int k = 0; k < lenX; k++) {
            for (int m = 0; m < lenY; m++) {
                int deg = Rnd.rndIntegerBetween(6, 15);
                res[k][m] = rndString(a, b, deg);
            }
        }
        return res;
    }


}
