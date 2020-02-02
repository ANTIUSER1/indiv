package pns.mathutil.mtc.polynomOperators;

import pns.mathutil.algebra.algebraCommutative.matrStructs.Polynom;

import java.util.ArrayList;
import java.util.List;

public class PolynomeBuilder {


    public Polynom buildResultPower(Polynom p, int power) {
        if (power == 0) {
            double[] d = {1};
            return new Polynom(d);
        }
        Polynom res = p;
        for (int k = 1; k <= power; k++) {
            if (k == 1) res = p;
            else {
                res = res.multiply(p);
                System.out.println(p + "  <<--- p    res  --->>   " + res + "     k " + k);
            }
        }
        return res;
    }

    public Polynom buildResultAsPowerSum(Polynom p, int power) {
        double[] z = {0};
        double[] u = {1};
        Polynom res = new Polynom(u);
        Polynom q = p;
        if (power == 0) return res;

        res = new Polynom(z);
        List<Polynom> pfl = new ArrayList<>();

        for (int k = 0; k <= power; k++) {
            q = buildResultPower(p, k);
            pfl.add(q);
        }

        for (Polynom ppf : pfl) {
            res = res.add(ppf);
        }

        return res;
    }

}
