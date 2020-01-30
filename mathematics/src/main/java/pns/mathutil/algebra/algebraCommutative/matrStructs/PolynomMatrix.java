package pns.mathutil.algebra.algebraCommutative.matrStructs;

import pns.mathutil.numberOperators.ArraysOperator;

public class PolynomMatrix {
    private Polynom[][] matrix;
    private int R = 0;
    private int C = 0;

    public PolynomMatrix() {
    }

    public PolynomMatrix(Polynom[][] matrix) {
        this.matrix = matrix;
    }

    public PolynomMatrix(int r, int c) {
        C = c;
        R = r;
        this.matrix = new Polynom[r][c];
        fillByZero();
    }


    public PolynomMatrix(int r, int c, boolean isRandom) {
        C = c;
        R = r;
        this.matrix = new Polynom[r][c];
        fillByZero();
        if (isRandom) fillByRnd(1);
    }

    public PolynomMatrix(int r, int c, int deg, boolean isRandom) {
        C = c;
        R = r;
        this.matrix = new Polynom[r][c];
        fillByZero();
        System.out.println(R + "   :::   " + C);
        if (isRandom) fillByRnd(deg);
    }

    public void fillUnit() {
        fillByUnit();
    }

    public int getR() {
        return R;
    }

    public int getC() {
        return C;
    }

    public void setMatrix(Polynom[][] matrix) {
        this.matrix = matrix;
    }

    public Polynom[][] getMatrix() {
        return matrix;
    }


    private void fillByRnd(int deg) {
        for (int k = 0; k < R; k++) {
            for (int n = 0; n < C; n++) {
                matrix[k][n] = new Polynom(ArraysOperator.createRandomDouble(deg));
            }
        }
    }

    private void fillByZero() {
        double[] d = {0.0};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = new Polynom(d);
            }
        }
    }

    private void fillByUnit() {
        double[] d = {1.0};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = new Polynom(d);
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer();
        sbf.append("PolynomMatrix[").append(System.lineSeparator());
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
