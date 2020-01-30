package pns.mathutil.mtc.polynomOperators;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import pns.mathutil.numberOperators.ArraysOperator;
import pns.pingremote.Pingator;

import java.util.List;

public class SimplePolynome {
    PolynomialFunction polynom;

    public SimplePolynome() {
        double[] dd = {0};
        this.polynom = new PolynomialFunction(dd);
    }

    public SimplePolynome(String s) {
        double[] dd = ArraysOperator.convertToDouble(s.getBytes());
        this.polynom = new PolynomialFunction(dd);
    }

    public SimplePolynome(int deg) {
        Pingator pingator = new Pingator(deg);
        List<Long> cf = pingator.pingMany("google.ru");
        List<Number> cff = ArraysOperator.convertToNumbers(cf);
        double[] dd = ArraysOperator.createFromList(cff);
        this.polynom = new PolynomialFunction(dd);
    }

    public PolynomialFunction getPolynom() {
        return polynom;
    }
}
