package pns.mathutil.algebra.algebraCommutative.matrStructs;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import pns.mathutil.numberOperators.ArraysOperator;
import pns.mathutil.numberOperators.Reducer;
import pns.mathutil.numberOperators.ReducerArrays;

public class Polynom extends PolynomialFunction {

    private double mod = 0.5;

    public Polynom(String c) throws NullArgumentException, NoDataException {
        super(ArraysOperator.convertToDouble(c));
    }

    public Polynom(String c, double coeff) throws NullArgumentException, NoDataException {
        super(ArraysOperator.convertToDouble(c, coeff));
    }

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

    public Polynom rround() {
        double[] cf = ArraysOperator.round(getCoefficients());
        return new Polynom(cf, mod);
    }

    public Polynom rround(double m) {
        double[] cf = ArraysOperator.round(getCoefficients());
        return new Polynom(cf, m);
    }

    public Polynom reduce() {
        return new Polynom(this.getCoefficients(), mod);
    }

    public Polynom reduce(int modul) {
        return new Polynom(this.getCoefficients(), modul);
    }

    public Polynom reduce(double modul) {
        return new Polynom(this.getCoefficients(), modul);
    }

    public Polynom multiply(Polynom p) {
        PolynomialFunction prod = getProductPolynomialFunction(p, Integer.MAX_VALUE);

        return new Polynom(prod.getCoefficients());
    }

    public Polynom makeAcuracy() {
        double[] dd = getCoefficients();
        for (int k = 0; k < dd.length; k++) {
            dd[k] = Reducer.roundAccuracy(getCoefficients()[k]);

        }
        return new Polynom(dd);
    }

    public Polynom multiply(Polynom p, double m) {
        PolynomialFunction prod = getProductPolynomialFunction(p);

        return new Polynom(prod.getCoefficients(), m);
    }

    public Polynom negate() {
        PolynomialFunction neg = getNegate(Integer.MAX_VALUE);

        return new Polynom(neg.getCoefficients()).makeAcuracy();
    }

    public Polynom negate(double m) {
        PolynomialFunction neg = getNegate(m);

        return new Polynom(neg.getCoefficients());
    }

    private PolynomialFunction getNegate() {
        double[] thc = getCoefficients();
        PolynomialFunction th = new PolynomialFunction(thc);
        return th.negate();
    }

    private PolynomialFunction getNegate(double m) {
        double[] thc = ReducerArrays.reduceMod(getCoefficients(), m);
        PolynomialFunction th = new PolynomialFunction(thc);
        return th.negate();
    }

    public PolynomialFunction getProductPolynomialFunction(Polynom p) {
        PolynomialFunction th = new PolynomialFunction(getCoefficients());
        PolynomialFunction ph = new PolynomialFunction(p.getCoefficients());

        return th.multiply(ph);
    }

    public PolynomialFunction getSummPolynomialFunction(Polynom p) {
        PolynomialFunction th = new PolynomialFunction(getCoefficients());
        PolynomialFunction ph = new PolynomialFunction(p.getCoefficients());

        return th.add(ph);
    }

    public Polynom add(Polynom p) {
        PolynomialFunction prod = getSummPolynomialFunction(p, Integer.MAX_VALUE);

        return new Polynom(prod.getCoefficients());
    }


    public PolynomialFunction getProductPolynomialFunction(Polynom p, double m) {
        double[] thc = ReducerArrays.reduceMod(getCoefficients(), m);
        double[] pc = ReducerArrays.reduceMod(p.getCoefficients(), m);
        PolynomialFunction th = new PolynomialFunction(thc);
        PolynomialFunction ph = new PolynomialFunction(pc);

        return th.multiply(ph);
    }

    public PolynomialFunction getSummPolynomialFunction(Polynom p, double m) {
        double[] thc = ReducerArrays.reduceMod(getCoefficients(), m);
        double[] pc = ReducerArrays.reduceMod(p.getCoefficients(), m);
        PolynomialFunction th = new PolynomialFunction(thc);
        PolynomialFunction ph = new PolynomialFunction(pc);

        return th.add(ph);
    }

    public Polynom add(Polynom p, double mod) {
        PolynomialFunction prod = getSummPolynomialFunction(p, mod);

        return new Polynom(prod.getCoefficients(), mod);
    }
}
