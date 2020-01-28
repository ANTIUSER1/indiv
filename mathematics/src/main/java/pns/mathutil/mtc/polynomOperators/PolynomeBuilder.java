package pns.mathutil.mtc.polynomOperators;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

import java.util.ArrayList;
import java.util.List;

public class PolynomeBuilder {
    public PolynomialFunction buildResult(List<Double> d) {
        if (d.isEmpty()) return null;
        double[] dd = new double[d.size()];
        for (int k = 0; k < dd.length; k++) dd[k] = d.get(k);
        PolynomialFunction res = new PolynomialFunction(dd);
        return res;
    }

    public PolynomialFunction buildResultPower(PolynomialFunction p, int power) {
        System.out.println("PPPWW    "+power);
        if(power==0){
            double[] d={1};
            return new PolynomialFunction(d);
        }
        PolynomialFunction res=p;
        for (int k = 1; k < power; k++)
        {   res = res.multiply(p);
            System.out.println(k+"   power  "+res);
        }
        return res;
    }

    public PolynomialFunction buildResultAsPowerSum(PolynomialFunction p, int power) {
        double[] z = {0};
        double[] u = {1};
        PolynomialFunction q = p;
        List<PolynomialFunction> pfl = new ArrayList<>();
        PolynomialFunction zz = new PolynomialFunction(z);
        PolynomialFunction rr = new PolynomialFunction(u);

        for (int k = 1; k <= power; k++) {
            q = buildResultPower(p, k);
            System.out.println(k+"  <<----------- power "+q+  "  "+p);
            pfl.add(q);
        }
        PolynomialFunction  fz=zz;
        for (int k = 0; k < pfl.size(); k++) {
            fz = fz.add(pfl.get(k));
//            System.out.println(pfl.size()+"     "+k+"  |||  "+zz+"     "+fz.add(rr));
        }
        return fz.add(rr) ;
    }

}
