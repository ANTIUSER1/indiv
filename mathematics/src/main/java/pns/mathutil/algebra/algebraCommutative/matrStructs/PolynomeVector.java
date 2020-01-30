package pns.mathutil.algebra.algebraCommutative.matrStructs;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import pns.mathutil.numberOperators.ArraysOperator;

public class PolynomeVector {
    private PolynomialFunction[] vector;
    private int R = 0;
    private double[] Z = {0};
    private PolynomialFunction zero = new PolynomialFunction(Z);
    private double[] U = {1};
    private PolynomialFunction unit = new PolynomialFunction(U);
    private PolynomialFunction diagonal;

    public PolynomeVector(int r, PolynomialFunction diagonal) {
        R = r;
        this.diagonal = diagonal;
        vector = new PolynomialFunction[R];
        for (int i = 0; i < R; i++) {
            vector[i] = diagonal;
        }
    }

    public PolynomeVector(PolynomialFunction[] vector) {
        this.vector = vector;
        R = vector.length;
    }

    public PolynomeVector() {
        vector = new PolynomialFunction[2];
        R = 2;
        fillByZero(R);
    }

    public PolynomeVector(int R) {
        vector = new PolynomialFunction[R];
        fillByZero(R);
    }

    public PolynomeVector(int R, boolean isRand) {
        vector = new PolynomialFunction[R];
        fillByZero(R);
        if (isRand) fillByRnd(R, 1);
    }

    public PolynomeVector(int R, int deg, boolean isRand) {
        vector = new PolynomialFunction[R];
        fillByZero(R);
        if (isRand) fillByRnd(R, deg);
    }


    public PolynomialFunction[] getVector() {
        return vector;
    }

    public int getR() {
        return R;
    }

    public PolynomialFunction getDiagonal() {
        return diagonal;
    }

    public PolynomialFunction getZero() {
        return zero;
    }

    public PolynomialFunction getUnit() {
        return unit;
    }

    public void setVectorComponent(PolynomialFunction p, int k) {
        this.vector[k] = p;
    }


    private void fillByZero(int r) {
        for (int k = 0; k < r; k++) {
            vector[k] = zero;
        }
    }

    private void fillByRnd(int r, int deg) {
        for (int k = 0; k < r; k++) {
            vector[k] = new PolynomialFunction(ArraysOperator.createRandomDouble(deg));
        }
    }


    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer();
        sbf.append("Vector[ ").append(System.lineSeparator());
        for (int i = 0; i < vector.length; i++) {
            sbf.append(vector[i]).append(System.lineSeparator());
        }
        sbf.append("]");
        return sbf.toString();
    }
}


