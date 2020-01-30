package pns.mathutil.numberOperators;

public class Reducer {
    public static double reduceMod(double d, double mm) {
        return d % mm;
    }

    public static double reduceMod(double d, int mm) {
        return d % mm;
    }

    public static double[] reduceMod(double[] d, double mm) {
        double[] res = new double[d.length];
        for (int k = 0; k < res.length; k++) res[k] = d[k] % mm;
        return res;
    }

}
