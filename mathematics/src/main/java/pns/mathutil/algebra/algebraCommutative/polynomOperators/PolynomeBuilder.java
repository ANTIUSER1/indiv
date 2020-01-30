package pns.mathutil.mtc.polynomOperators;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

import java.util.ArrayList;
import java.util.List;

public class PolynomeBuilder {


    public PolynomialFunction buildResultPower(PolynomialFunction p, int power) {
        if (power == 0) {
            double[] d = {1};
            return new PolynomialFunction(d);
        }
        PolynomialFunction res = p;
        for (int k = 1; k <= power; k++) {
            if (k == 1) res = p;
            else {
                res = res.multiply(p);
            }
        }
        return res;
    }

    public PolynomialFunction buildResultAsPowerSum(PolynomialFunction p, int power) {
        double[] z = {0};
        double[] u = {1};
        PolynomialFunction res = new PolynomialFunction(u);
        PolynomialFunction q = p;
        if (power == 0) return res;

        res = new PolynomialFunction(z);
        List<PolynomialFunction> pfl = new ArrayList<>();

        for (int k = 0; k <= power; k++) {
            q = buildResultPower(p, k);
            pfl.add(q);
        }

        for (PolynomialFunction ppf : pfl) {
            res = res.add(ppf);
        }

        return res;
    }

}
