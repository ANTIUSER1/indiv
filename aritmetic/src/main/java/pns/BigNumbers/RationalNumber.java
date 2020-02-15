package pns.BigNumbers;

import java.math.BigDecimal;

public class RationalNumber<F extends BigDecimal, S extends BigDecimal> extends BigPare<F, S> {
    public RationalNumber(F first, S second) throws Exception {
        super(first, second);
        makeRational();
    }

    public RationalNumber(BigPare source) throws Exception {
        super();
        super.first = (F) source.first;
        super.second = (S) source.second;
        makeRational();
    }

    public RationalNumber add(RationalNumber a) throws Exception {
        BigDecimal dividor1 = new BigDecimal("" + (first.multiply(a.second)));
        BigDecimal dividor2 = new BigDecimal("" + (second.multiply(a.first)));

        BigDecimal dividor = new BigDecimal("" + dividor1.add(dividor2));
        BigPare bp = new BigPare(dividor, a.second.multiply(second));
        return new RationalNumber(bp);
    }

    public RationalNumber multiply(RationalNumber a) throws Exception {
        BigPare bp = new BigPare(a.first.multiply(first), a.second.multiply(second));
        return new RationalNumber(bp);
    }


    public RationalNumber negate() throws Exception {
        BigPare bp = new BigPare(first.negate(), second);
        return new RationalNumber(bp);
    }

    public RationalNumber inverse() throws Exception {
        BigPare bp = new BigPare(second, first);
        return new RationalNumber(bp);
    }

    private void makeRational() throws Exception {
        BigDecimal z = new BigDecimal(0);
        if (second.equals(z)) throw new ArithmeticException("dividing by 0");
        BigPareOperations bpo = new BigPareOperations();
        BigDecimal common = bpo.gcd(first, second);
        first = (F) first.divide(common);
        second = (S) second.divide(common);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj.getClass().equals(RationalNumber.class))) return false;
        RationalNumber other = (RationalNumber) obj;
        return first.multiply(other.second).equals(other.first.multiply(second));
    }

    @Override
    public String toString() {
        return "(" + first + "/" + second + ") ";
    }
}
