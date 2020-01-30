package pns.mathutil.numberOperators;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysOperator {

    private static SecureRandom sr = new SecureRandom();

    public static double[] convertToDouble(byte[] input) {
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
