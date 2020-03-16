package pns.BigNumbers;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class BigPareOperations {

    public static final BigDecimal unit = new BigDecimal(1);
    public static final BigDecimal zero = new BigDecimal(0);

    public static Set<Byte> generateDigitSet(int from, int to) {
        Set<Byte> res = new HashSet<>();
        for (int k = from; k <= to; k++) res.add((byte) k);
        System.out.println(res);
        return res;
    }

    public BigDecimal gcd(BigDecimal a, BigDecimal b) throws Exception {
        BigDecimal res = new BigDecimal(0);
        a = a.abs();
        b = b.abs();
        if (a.equals(zero) || b.equals(zero))
            throw new Exception("GCD Error on value " + super.toString());
        if (a.equals(b)) return a;
        if (a.compareTo(b) > 0) {
            BigDecimal c = a.subtract(b);
            res = gcd(b, c);
        } else {
            BigDecimal c = b.subtract(a);
            res = gcd(a, c);
        }
        return res;
    }

    public SuperLageNumber gcd(SuperLageNumber a, SuperLageNumber b) throws Exception {
        SuperLageNumber res = new SuperLageNumber("0");
        a = a.abs();
        b = b.abs();
        System.out.println(a + "   " + b + "   " + a.compareTo(b));

        if (a.equals(SuperLageNumber.ZERO) || b.equals(SuperLageNumber.ZERO))
            throw new Exception("GCD Error on value " + super.toString());
        if (a.equals(b)) return a;

        if (a.compareTo(b) > 0) {
            SuperLageNumber c = a.substact(b);
            res = gcd(b, c);
        } else {
            SuperLageNumber c = b.substact(a);
            res = gcd(a, c);
            System.out.println(res);
        }
        return res;
    }

    public BigDecimal lcm(BigDecimal a, BigDecimal b) throws Exception {
        BigDecimal gcd = gcd(a, b);
        BigDecimal m = a.multiply(b);
        return m.divide(gcd);

    }

    public SuperLageNumber lcm(SuperLageNumber a, SuperLageNumber b) throws Exception {
        SuperLageNumber gcd = gcd(a, b);
        SuperLageNumber m = a.multiply(b);
        return m.divide(gcd)[0];

    }

    public BigDecimal power(BigDecimal a, int b) {
        if (b == 0) return unit;

        if (b % 2 == 0) {
            BigDecimal p = power(a, b / 2);
            return p.multiply(p);
        } else {
            return power(a, b - 1).multiply(a);
        }
    }
}
