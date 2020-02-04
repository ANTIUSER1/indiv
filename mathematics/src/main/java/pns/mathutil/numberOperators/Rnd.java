package pns.mathutil.numberOperators;

import java.security.SecureRandom;

public class Rnd {
    public static final SecureRandom rndGen = new SecureRandom();

    public static double rndDoubleBetween(double a, double b) {
        double r = rndGen.nextDouble();
        return r * a + (1 - r) * b;
    }

    public static int rndIntegerBetween(double a, double b) {
        return (int) rndDoubleBetween(a, b);
    }

    public static byte rndByteBetween(double a, double b) {
        return (byte) rndDoubleBetween(a, b);
    }

    public static long rndLongBetween(double a, double b) {
        return (long) rndDoubleBetween(a, b);
    }
}
