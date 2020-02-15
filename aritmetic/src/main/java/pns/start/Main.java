package pns.start;

import pns.BigNumbers.BigPare;
import pns.BigNumbers.BigPareOperations;
import pns.BigNumbers.RationalNumber;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws Exception {

        BigDecimal a = new BigDecimal("55");

        BigDecimal b = new BigDecimal(30);
        BigPare bp = new BigPare(a, b);
        System.out.println(bp);

        BigPareOperations bpo = new BigPareOperations();
        BigDecimal gc = bpo.gcd(a, b);
        System.out.println(gc);
        RationalNumber rn = new RationalNumber(a, b);
        System.out.println(rn);

    }
}
