package pns.BigNumbers;

import org.junit.Test;

import java.util.Set;

public class RationalNumberTest {

    @Test
    public void create() throws Exception {
        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        SuperLageNumber ad = new SuperLageNumber("5");
        SuperLageNumber bd = new SuperLageNumber("15");
        RationalNumber a = new RationalNumber(ad, bd);
        System.out.println("ad=" + ad + "  bd=" + bd + "   a=" + a);
        RationalNumber b = new RationalNumber(bd, ad, true);
        System.out.println("ad=" + ad + "  bd=" + bd + "   b=" + b);
    }

    @Test
    public void add() throws Exception {
        System.out.println("      ADD     ");

        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        SuperLageNumber ad = new SuperLageNumber("2");
        SuperLageNumber bd = new SuperLageNumber("3");
        RationalNumber a = new RationalNumber(ad, bd);
        System.out.println("     a " + a);
        SuperLageNumber ad1 = new SuperLageNumber("3");
        SuperLageNumber bd1 = new SuperLageNumber("7");
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


        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        SuperLageNumber ad = new SuperLageNumber("3");
        SuperLageNumber bd = new SuperLageNumber("4");
        RationalNumber a = new RationalNumber(ad, bd);
        System.out.println("ad=" + ad + "  bd=" + bd + "ad/bd=" + a);

        SuperLageNumber ad1 = new SuperLageNumber("4");
        SuperLageNumber bd1 = new SuperLageNumber("5");
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
        SuperLageNumber ad1 = new SuperLageNumber("3");
        SuperLageNumber bd1 = new SuperLageNumber("5");
        RationalNumber b = new RationalNumber(ad1, bd1);
        System.out.println("ad1=" + ad1 + "  bd1=" + bd1 + "  b=" + b);
        RationalNumber neg = b.negate();
        System.out.println("-b=" + neg);

    }

    @Test
    public void inverse() throws Exception {
        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);

        System.out.println("      INVERSE    ");
        SuperLageNumber ad1 = new SuperLageNumber(dSet, "3");
        SuperLageNumber bd1 = new SuperLageNumber(dSet, "5");
        RationalNumber b = new RationalNumber(ad1, bd1);
        System.out.println("ad1=" + ad1 + "  bd1=" + bd1 + "   b=" + b);
        RationalNumber inv = b.inverse();
        System.out.println("inv=1/b=" + inv);
    }
}