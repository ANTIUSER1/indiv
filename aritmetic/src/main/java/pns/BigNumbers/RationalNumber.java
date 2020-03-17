package pns.BigNumbers;

import java.io.Serializable;

public class RationalNumber<F extends SuperLageNumber, S extends SuperLageNumber> extends BigPare<F, S> implements Serializable {

    private boolean isNegative = false;

    public RationalNumber(F first, S second) throws Exception {
        super(first, second);
        isNegative = !first.isNegative().equals(second.isNegative());
        if (!super.first.getDigits().equals(super.second.getDigits()))
            throw new ArithmeticException("Can not create such rational Number");
        makeRational();

    }

    public RationalNumber(F first, S second, boolean negative) throws Exception {
        super(first, second);
        isNegative = !first.isNegative().equals(second.isNegative()) || negative;
        if (!super.first.getDigits().equals(super.second.getDigits()))
            throw new ArithmeticException("Can not create such rational Number  " + super.toString() + "  " +
                    "\n\r Dec 1 " + super.first.getDigits() +

                    "\n\r Dec 2 " + super.second.getDigits());
        makeRational();
    }

    public RationalNumber add(RationalNumber a) throws Exception {
        SuperLageNumber bt = second.multiply(a.second);
        SuperLageNumber up1 = first.multiply(a.second);
        SuperLageNumber up2 = second.multiply(a.first);
        SuperLageNumber up = up1.add(up2);

        return new RationalNumber(up, bt);
    }

    public RationalNumber multiply(RationalNumber a) throws Exception {
        SuperLageNumber bt = second.multiply(a.second);
        SuperLageNumber up1 = first.multiply(a.first);

        return new RationalNumber(up1, bt);
    }


    public RationalNumber negate() throws Exception {
        SuperLageNumber bt = second;
        SuperLageNumber up1 = first.negate();
        return new RationalNumber(up1, bt);
    }

    public RationalNumber inverse() throws Exception {
        return new RationalNumber(second, first);
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
        return this.toString().equals(other.toString());
    }

    @Override
    public String toString() {
        if (isNegative) return " -(" + first + "/" + second + ") ";
        return " (" + first + "/" + second + ") ";
    }
}
