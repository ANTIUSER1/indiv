package pns.mathutil.numberOperators;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysOperator {

    private static SecureRandom sr = new SecureRandom();

    public static double[] round(double[] input) {
        double[] res = new double[input.length];
        for (int k = 0; k < input.length; k++) {
            res[k] = Math.round(input[k]);
        }
        return res;
    }

    public static double[] convertToDouble(String input) {
        double[] res = new double[input.length()];
        for (int k = 0; k < input.length(); k++) {
            byte dv = (byte) input.charAt(k);
            res[k] = dv % Integer.MAX_VALUE;
        }
        return res;
    }

    public static double[] convertToDouble(String input, double coef) {
        double[] res = new double[input.length()];
        for (int k = 0; k < input.length(); k++) {
            byte dv = (byte) input.charAt(k);
            System.out.println(coef + "======   --------------->>>  " + (dv) * coef);
            res[k] = Reducer.roundAccuracy((dv) * coef);
        }
        return res;
    }


    public static double[] convertToDouble(String input, double coef, double shift) {
        double[] res = new double[input.length()];
        for (int k = 0; k < input.length(); k++) {
            byte dv = (byte) input.charAt(k);
            res[k] = Reducer.roundAccuracy((dv - shift) * coef);
        }
        return res;
    }

    public static double[] convertToDouble(byte[] input) {
        double[] res = new double[input.length];
        for (int k = 0; k < input.length; k++) {
            res[k] = input[k];
        }
        return res;
    }

    public static double[] convertToDouble(int[] input) {
        double[] res = new double[input.length];
        for (int k = 0; k < input.length; k++) {
            res[k] = input[k];
        }
        return res;
    }

    public static double[] convertToDouble(long[] input) {
        double[] res = new double[input.length];
        for (int k = 0; k < input.length; k++) {
            res[k] = input[k];
        }
        return res;
    }

    public static List<Number> convertToNumbers(List<Long> input) {
        return input.stream()
                .map(v -> v + "")
                .map(v -> (Long.parseLong(v) % (4)))
                .collect(Collectors.toList());
    }


    public static double[] convert(Number[] input) {
        return Arrays.asList(input).stream()
                .mapToDouble(v -> v.doubleValue())
                .toArray();
    }


    public static double[] createFromList(List<Number> input) {
        return input.stream()
                .mapToDouble(v -> v.doubleValue())
                .toArray();
    }


    public static double[] createRandomDouble(int input) {
        double[] res = new double[input];
        for (int k = 0; k < res.length; k++) {
            res[k] = sr.nextDouble();
        }
        return res;
    }

    public static double[] createRandomDouble(int input, int mult, int mod) {
        double[] res = new double[input];
        for (int k = 0; k < res.length; k++) {
            res[k] = (sr.nextDouble() * (mult * mult - 1) + mult) % mod;
        }
        return res;
    }

    public static double[] createRandomDouble(int input, int mult) {
        double[] res = new double[input];
        for (int k = 0; k < res.length; k++) {
            res[k] = sr.nextDouble() * mult;
        }
        return res;
    }

    public static int[] createRandomInt(int input) {
        int[] res = new int[input];
        for (int k = 0; k < res.length; k++) {
            res[k] = sr.nextInt();
        }
        return res;
    }

    public static long[] createRandomLong(int input) {
        long[] res = new long[input];
        for (int k = 0; k < res.length; k++) {
            res[k] = sr.nextLong();
        }
        return res;
    }


}
