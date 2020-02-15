package pns.BigNumbers;

import org.junit.Test;

import java.math.BigDecimal;

public class BigPareOperationsTest {

    @org.junit.Test
    public void gcd() throws Exception {

        BigDecimal a = new BigDecimal(5 * 451 * 997 * 90 * 9);
        BigDecimal b = new BigDecimal(9 * 101 * 7 * 40 * 997);

        BigPareOperations bpo = new BigPareOperations();
        BigDecimal gc = bpo.gcd(a, b);

        System.out.println("a=" + a + "  b=" + b + " gcd(a, b)=" + gc);
    }

    @Test
    public void lcm() throws Exception {
        BigDecimal a = new BigDecimal(63 * 55 * 451 * 451 + 578 * 997);
        BigDecimal b = new BigDecimal(385 * 997);

        BigPareOperations bpo = new BigPareOperations();
        BigDecimal gc = bpo.lcm(a, b);

        System.out.println("a=" + a + "  b=" + b + " lcm(a, b)=" + gc);
    }

    @Test
    public void power() {
        BigDecimal a = new BigDecimal(2);
        BigPareOperations bpo = new BigPareOperations();
        int b = 91;
        BigDecimal p = bpo.power(a, b);
        String pp = p + "";
        System.out.println("a=" + a + "  b=" + b + "   power=" + p + " \n" +
                " pp len " + pp.length() + "  long Value " + p.longValue() + "  int Value " + p.intValue());
    }
}