package pns.mathutil.mtc.matrOperators;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import pns.mathutil.algebra.algebraCommutative.matrOperators.MatrixPolynomeUtils;
import pns.mathutil.mtc.numberOperators.ArraysOperator;

public class PolynomeMatrix {
    private PolynomialFunction[][] matrix;
    private int R = 0;
    private int C = 0;
    private double[] Z = {0};
    private PolynomialFunction zero = new PolynomialFunction(Z);
    private double[] U = {1};
    private PolynomialFunction unit = new PolynomialFunction(U);

    public PolynomeMatrix() {
    }

    public PolynomeMatrix(PolynomialFunction[][] matrix) {
        this.matrix = matrix;
        R = MatrixPolynomeUtils.extractRow(this, 0).length;
        System.out.println("RRR  " + R);

        C = matrix[0].length;
        System.out.println("CCC " + C);
        //PolynomeUtils.extractCol(this, 0).length;

    }

    public PolynomeMatrix(int r, int c) {
        C = c;
        R = r;
        this.matrix = new PolynomialFunction[r][c];
        fillByZero(R, C);
    }

    public PolynomeMatrix(int r, int c, boolean isRandom) {
        C = c;
        R = r;
        this.matrix = new PolynomialFunction[r][c];
        fillByZero(R, C);
        if (isRandom) fillByRnd(R, C, 1);
    }

    public PolynomeMatrix(int r, int c, int deg, boolean isRandom) {
        C = c;
        R = r;
        this.matrix = new PolynomialFunction[r][c];
        fillByZero(R, C);
        System.out.println(R + "   :::   " + C);
        if (isRandom) fillByRnd(R, C, deg);
    }


    public PolynomialFunction getZero() {
        return zero;
    }

    public int getR() {
        return R;
    }

    public int getC() {
        return C;
    }

    public PolynomialFunction getUnit() {
        return unit;
    }

    public void setMatrix(PolynomialFunction[][] matrix) {
        this.matrix = matrix;
    }

    public PolynomialFunction[][] getMatrix() {
        return matrix;
    }

    private void fillByZero(int r, int c) {
        for (int k = 0; k < r; k++) {
            for (int n = 0; n < c; n++) {
                matrix[k][n] = zero;
            }
        }
    }

    private void fillByRnd(int r, int c, int deg) {
        for (int k = 0; k < r; k++) {
            for (int n = 0; n < c; n++) {
                matrix[k][n] = new PolynomialFunction(ArraysOperator.rand(deg));
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer();
        sbf.append("matrix[").append(System.lineSeparator());
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sbf.append(matrix[i][j]).append(" ; ");
            }
            sbf.append(System.lineSeparator());
        }
        sbf.append("]");
        return sbf.toString();
    }
}
