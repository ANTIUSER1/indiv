package pns.mathutil.numberOperators;

public class ReducerArrays {


    public static double[] reduceMod(double[] d, double mm) {
        double[] res = new double[d.length];
        for (int k = 0; k < res.length; k++) {
            res[k] = Reducer.reduceMod(d[k], mm);
        }
        return res;
    }

    public static int[] reduceMod(int[] d, int mm) {
        int[] res = new int[d.length];
        for (int k = 0; k < res.length; k++) {
            res[k] = Reducer.reduceMod(d[k], mm);
        }
        return res;
    }

    public static int[] reduceMod(byte[] d, int mm) {
        int[] res = new int[d.length];
        for (int k = 0; k < res.length; k++) {
            res[k] = Reducer.reduceMod(d[k], mm);
        }
        return res;
    }

    public static double[][] reduceMod(double[][] d, double mm) {
        double[][] res = d.clone();
        for (int k = 0; k < res.length; k++) {
            for (int m = 0; m < res[0].length; m++) {
                res[m][k] = Reducer.reduceMod(d[m][k], mm);
            }
        }
        return res;
    }

    public static int[][] reduceMod(int[][] d, int mm) {
        int[][] res = d.clone();
        for (int k = 0; k < res.length; k++) {
            for (int m = 0; m < res[0].length; m++) {
                res[m][k] = Reducer.reduceMod(d[m][k], mm);
            }
        }
        return res;
    }

    public static int[][] reduceMod(byte[][] d, int mm) {

        int[][] res = new int[d[0].length][d.length];
        for (int k = 0; k < res.length; k++) {
            for (int m = 0; m < res[0].length; m++) {
                res[m][k] = Reducer.reduceMod(d[m][k], mm);
            }
        }
        return res;
    }
}
