package pns.BigNumbers;

import java.io.Serializable;

public class RationalNumber<F extends SuperLageNumber, S extends SuperLageNumber> extends BigPare<F, S> implements Serializable {


    public RationalNumber(F first, S second) throws Exception {
        super(first, second);
        if (!super.first.getDigits().equals(super.second.getDigits()))
            throw new ArithmeticException("Can not create such rational Number");
        makeRational();

    }

    public RationalNumber(BigPare source) throws Exception {
        super();
        super.first = (F) source.first;
        super.second = (S) source.second;
        if (!super.first.getDigits().equals(super.second.getDigits()))
            throw new ArithmeticException("Can not create such rational Number  " + super.toString() + "  " +
                    "\n\r Dec 1 " + super.first.getDigits() +

                    "\n\r Dec 2 " + super.second.getDigits());
        makeRational();
    }

    public RationalNumber add(RationalNumber a) throws Exception {
        SuperLageNumber dividor1 = new SuperLageNumber("" + (first.multiply(a.second)));
        SuperLageNumber dividor2 = new SuperLageNumber("" + (second.multiply(a.first)));

        SuperLageNumber dividor = new SuperLageNumber("" + dividor1.add(dividor2));
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
        SuperLageNumber z = new SuperLageNumber();
        if (second.equals(z)) throw new ArithmeticException("dividing by 0");
        BigPareOperations bpo = new BigPareOperations();
        SuperLageNumber common = bpo.gcd(first, second);

        SuperLageNumber[] restsF = first.divide(common);
        SuperLageNumber[] restsS = second.divide(common);
        first = (F) restsF[0];
        second = (S) restsS[0];
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
