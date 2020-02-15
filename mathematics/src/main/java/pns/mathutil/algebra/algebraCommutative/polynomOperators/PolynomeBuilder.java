package pns.mathutil.algebra.algebraCommutative.polynomOperators;

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
            }
        }
        return res;
    }


    public Polynom buildResultPower(Polynom p, int power, double m) {

        double[] d = {1};
        Polynom U = new Polynom(d);
        ;
        if (power == 0) {
            return U;
        }

        Polynom res = p.multiply(U, m);
        for (int k = 1; k <= power; k++) {
            if (k == 1) res = p;
            else {
                res = res.multiply(p, m);
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

    public Polynom[] polynomeArray(String[] ss) {
        Polynom[] res = new Polynom[ss.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = new Polynom(ss[i]);
        }
        return res;
    }

    public Polynom[][] polynomeArray(String[][] ss) {
        Polynom[][] res = new Polynom[ss.length][ss[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = new Polynom(ss[i][j]);
            }
        }
        return res;
    }

    public Polynom[][] polynomeArray(String[][] ss, double coeff) {
        Polynom[][] res = new Polynom[ss.length][ss[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = new Polynom(ss[i][j], coeff);
            }
        }
        return res;
    }

    public Polynom linCombination(Polynom[] p, Polynom[] pCoefs) {
        double[] z = {0};
        Polynom res = new Polynom(z);
        if (p.length <= pCoefs.length) {

            for (int k = 0; k < p.length; k++) {
                Polynom t = p[k].multiply(pCoefs[k]);
                res = res.add(t);
            }
            return res;
        } else {
            for (int k = 0; k < pCoefs.length; k++) {
                Polynom t = p[k].multiply(pCoefs[k]);
                res = res.add(t);
            }

            return res;
        }
    }

    public Polynom buildResultAsPowerSum(Polynom p, int power, double m) {
        double[] z = {0};
        double[] u = {1};
        Polynom res = new Polynom(u);
        Polynom q = p;
        if (power == 0) return res;

        res = new Polynom(z);
        List<Polynom> pfl = new ArrayList<>();

        for (int k = 0; k <= power; k++) {
            q = buildResultPower(p, k, m);
            pfl.add(q);
        }

        for (Polynom ppf : pfl) {
            res = res.add(ppf, m);
        }

        return res;
    }

}
