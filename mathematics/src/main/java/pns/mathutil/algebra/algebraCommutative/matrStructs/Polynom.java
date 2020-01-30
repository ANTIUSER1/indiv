package pns.mathutil.algebra.algebraCommutative.matrStructs;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import pns.mathutil.numberOperators.Reducer;

public class Polynom extends PolynomialFunction {

    private double mod = 1;

    public Polynom(double[] c) throws NullArgumentException, NoDataException {
        super(c);
    }

    public Polynom(double[] c, int modul) throws NullArgumentException, NoDataException {
        super(Reducer.reduceMod(c, modul));
        mod = modul;
    }

    public Polynom(double[] c, double modul) throws NullArgumentException, NoDataException {
        super(Reducer.reduceMod(c, modul));
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
        return reduce(this.multiply(reduce(p)));
    }

    public Polynom add(Polynom p) {
        return reduce(this.add(reduce(p)));
    }
}
