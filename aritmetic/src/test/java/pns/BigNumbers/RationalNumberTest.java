package pns.BigNumbers;

import org.junit.Test;

import java.math.BigDecimal;

public class RationalNumberTest {

    @Test
    public void add() throws Exception {
        System.out.println("      ADD     ");

        BigDecimal ad = new BigDecimal(24);
        BigDecimal bd = new BigDecimal(30);
        RationalNumber a = new RationalNumber(ad, bd);
        System.out.println("ad=" + ad + "  bd=" + bd + "ad/bd=" + a);

        BigDecimal ad1 = new BigDecimal(3);
        BigDecimal bd1 = new BigDecimal(7);
        RationalNumber b = new RationalNumber(ad1, bd1);
        System.out.println("ad1=" + ad1 + "  bd1=" + bd1 + "ad/bd=" + b);
        System.out.println("       a.equals(b) " + a.equals(b));

        RationalNumber m1 = a.add(b);
        RationalNumber m2 = b.add(a);
        System.out.println("m1=" + m1 + " m2=" + m2 + "equal: m1==m2 :" + m1.equals(m2));

    }

    @Test
    public void multiply() throws Exception {
        System.out.println("      MULTIPLY     ");

        BigDecimal ad = new BigDecimal(24);
        BigDecimal bd = new BigDecimal(30);
        RationalNumber a = new RationalNumber(ad, bd);
        System.out.println("ad=" + ad + "  bd=" + bd + "ad/bd=" + a);

        BigDecimal ad1 = new BigDecimal(3);
        BigDecimal bd1 = new BigDecimal(5);
        RationalNumber b = new RationalNumber(ad1, bd1);
        System.out.println("ad1=" + ad1 + "  bd1=" + bd1 + "ad/bd=" + b);
        System.out.println("       a.equals(b) " + a.equals(b));

        RationalNumber m1 = a.multiply(b);
        RationalNumber m2 = b.multiply(a);
        System.out.println("m1=" + m1 + " m2=" + m2 + "equal: m1==m2 :" + m1.equals(m2));

    }

    @Test
    public void negate() throws Exception {
        System.out.println("      NEGATE    ");
        BigDecimal ad1 = new BigDecimal(3);
        BigDecimal bd1 = new BigDecimal(5);
        RationalNumber b = new RationalNumber(ad1, bd1);
        System.out.println("ad1=" + ad1 + "  bd1=" + bd1 + "ad/bd=" + b);
        RationalNumber neg = b.negate();
        System.out.println("-b=" + neg);

    }

    @Test
    public void inverse() throws Exception {

        System.out.println("      INVERSE    ");
        BigDecimal ad1 = new BigDecimal(3);
        BigDecimal bd1 = new BigDecimal(5);
        RationalNumber b = new RationalNumber(ad1, bd1);
        System.out.println("ad1=" + ad1 + "  bd1=" + bd1 + "ad/bd=" + b);
        RationalNumber inv = b.inverse();
        System.out.println("inv=1/b=" + inv);
    }
}