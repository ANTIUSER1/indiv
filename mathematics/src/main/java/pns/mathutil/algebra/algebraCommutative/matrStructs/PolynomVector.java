package pns.mathutil.algebra.algebraCommutative.matrStructs;

import pns.mathutil.numberOperators.ArraysOperator;

public class PolynomVector {
    private Polynom[] vector;
    private int R = 0;

    private double[] z = {0};
    private Polynom zero = new Polynom(z);

    public PolynomVector(int r, Polynom diagonal) {
        R = r;
        vector = new Polynom[R];
        for (int i = 0; i < R; i++) {
            vector[i] = diagonal;
        }
    }

    public PolynomVector(Polynom[] vector) {
        this.vector = vector;
        R = vector.length;
    }

    public PolynomVector() {
        vector = new Polynom[2];
        R = 2;
        fillByZero(R);
    }

    public PolynomVector(int R) {
        vector = new Polynom[R];
        fillByZero(R);
    }

    public PolynomVector(int R, boolean isRand) {
        vector = new Polynom[R];
        fillByZero(R);
        if (isRand) fillByRnd(R, 1);
    }

    public PolynomVector(int R, int deg, boolean isRand) {
        vector = new Polynom[R];
        fillByZero(R);
        if (isRand) fillByRnd(R, deg);
    }


    public Polynom[] getVector() {
        return vector;
    }

    public int getR() {
        return R;
    }

    public void setVectorComponent(Polynom p, int k) {
        this.vector[k] = p;
    }

    public Polynom getZero() {
        return zero;
    }

    private void fillByZero(int r) {
        for (int k = 0; k < r; k++) {
            vector[k] = zero;
        }
    }

    private void fillByRnd(int r, int deg) {
        for (int k = 0; k < r; k++) {
            vector[k] = new Polynom(ArraysOperator.createRandomDouble(deg));
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


