package pns.BigNumbers;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Set;

public class BigPareOperationsTest {

    @Test
    public void gcd() throws Exception {
        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);

        SuperLageNumber a = new SuperLageNumber(dSet, 5 * 7 + "");
        SuperLageNumber b = new SuperLageNumber(dSet, 9 * 7 + "");

        BigPareOperations bpo = new BigPareOperations();
        SuperLageNumber gc = bpo.gcd(a, b);

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
        SuperLageNumber a = new SuperLageNumber("2");
        BigPareOperations bpo = new BigPareOperations();
        int b = 91;
        SuperLageNumber p = bpo.power(a, b);
        String pp = p + "";
        System.out.println("a=" + a + "  b=" + b + "   power=" + p + " \n" +
                " pp len " + pp.length() + "  long Value " + p.getValue() + "  int Value " + p.getValue());
    }
}