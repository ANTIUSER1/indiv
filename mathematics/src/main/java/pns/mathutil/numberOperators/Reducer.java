package pns.mathutil.numberOperators;

public class Reducer {

    public static double reduceMod(double d, double mm) {
        if (d < 0) {
            double t = Math.abs(d) % mm;
            d = mm - t;
        }

        double res = d % mm;
        return res;
    }

    public static int reduceMod(int d, int mm) {
        if (d < 0) {
            int t = Math.abs(d) % mm;
            d = mm - t;
        }

        int res = d % mm;
        return res;
    }

    public static int reduceMod(byte d, int mm) {
        int dd = d;
        if (d < 0) {
            int t = Math.abs(d) % mm;
            ;
            dd = mm - t;
        }

        int res = dd % mm;
        return res;
    }

    public static double reduceMod(double d, int mm) {
        if (d < 0) {
            double t = Math.abs(d) % mm;
            d = mm - t;
        }
        double res = d % mm;
        return res;
    }


}
