package pns.mathutil.algebra.algebraCommutative.matrStructs;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import pns.mathutil.numberOperators.ArraysOperator;
import pns.mathutil.numberOperators.ReducerArrays;

public class Polynom extends PolynomialFunction {

    private double mod = 1;

    public Polynom(byte[] c) throws NullArgumentException, NoDataException {
        super(ArraysOperator.convertToDouble(c));
    }

    public Polynom(byte[] c, int modul) throws NullArgumentException, NoDataException {
        super(ArraysOperator.convertToDouble(c));
        mod = modul;
    }

    public Polynom(int[] c, int modul) throws NullArgumentException, NoDataException {
        super(ReducerArrays.reduceMod(ArraysOperator.convertToDouble(c), modul));
        mod = modul;
    }

    public Polynom(long[] c, double modul) throws NullArgumentException, NoDataException {
        super(ReducerArrays.reduceMod(ArraysOperator.convertToDouble(c), modul));
        mod = modul;
    }

    public Polynom(double[] c) throws NullArgumentException, NoDataException {
        super(c);
    }

    public Polynom(double[] c, int modul) throws NullArgumentException, NoDataException {
        super(ReducerArrays.reduceMod(c, modul));
        mod = modul;
    }

    public Polynom(double[] c, double modul) throws NullArgumentException, NoDataException {
        super(ReducerArrays.reduceMod(c, modul));
        mod = modul;
    }

    public Polynom reduce(Polynom p) {
        return new Polynom(this.getCoefficients(), mod);
    }

    public Polynom reduce(int modul) {
        return new Polynom(this.getCoefficients(), modul);
    }

    public Polynom reduce(double modul) {
        return new Polynom(this.getCoefficients(), modul);
    }

    public Polynom multiply(Polynom p) {
        PolynomialFunction prod = getProductPolynomialFunction(p);

        return new Polynom(prod.getCoefficients(), mod);
    }

    public Polynom negate() {
        PolynomialFunction neg = getNegate();

        return new Polynom(neg.getCoefficients(), mod);
    }

    private PolynomialFunction getNegate() {
        double[] thc = ReducerArrays.reduceMod(getCoefficients(), this.mod);
        PolynomialFunction th = new PolynomialFunction(thc);
        return th.negate();
    }

    public PolynomialFunction getProductPolynomialFunction(Polynom p) {
        double[] thc = ReducerArrays.reduceMod(getCoefficients(), this.mod);
        double[] pc = ReducerArrays.reduceMod(p.getCoefficients(), p.mod);
        PolynomialFunction th = new PolynomialFunction(thc);
        PolynomialFunction ph = new PolynomialFunction(pc);

        return th.multiply(ph);
    }

    public PolynomialFunction getSummPolynomialFunction(Polynom p) {
        double[] thc = ReducerArrays.reduceMod(getCoefficients(), this.mod);
        double[] pc = ReducerArrays.reduceMod(p.getCoefficients(), p.mod);
        PolynomialFunction th = new PolynomialFunction(thc);
        PolynomialFunction ph = new PolynomialFunction(pc);

        return th.add(ph);
    }

    public Polynom add(Polynom p) {
        PolynomialFunction prod = getSummPolynomialFunction(p);

        return new Polynom(prod.getCoefficients(), mod);
    }
}
