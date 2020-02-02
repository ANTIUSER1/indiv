package pns.mathutil.algebra.algebraCommutative.matrOperators;

import pns.mathutil.algebra.algebraCommutative.matrStructs.Polynom;
import pns.mathutil.algebra.algebraCommutative.matrStructs.PolynomMatrix;
import pns.mathutil.algebra.algebraCommutative.matrStructs.PolynomVector;

public class MatrixPolynomeUtils {
    public static Polynom initPF() {
        double[] d = {0};
        return new Polynom(d);
    }

    public static Polynom[] initPF(int dim) {
        Polynom[] res = new Polynom[dim];
        for (int k = 0; k < res.length; k++) {
            res[k] = initPF();
        }
        return res;
    }

    public static Polynom[][] initPF(int R, int C) {
        Polynom[][] res = new Polynom[R][C];
        for (int k = 0; k < R; k++) {
            for (int n = 0; n < C; n++) {
                res[k][n] = initPF();
            }
        }
        return res;
    }

    public static PolynomVector matrMult(
            PolynomMatrix A, PolynomVector X
    ) {
        PolynomVector res = new PolynomVector(X.getR());
        Polynom[] resVal = res.getVector();
        for (int i = 0; i < A.getR(); i++) {
            Polynom elem = res.getZero();
            for (int j = 0; j < A.getC(); j++) {
                elem = elem.add(A.getMatrix()[i][j].multiply(X.getVector()[i]));
                Polynom tmp = resVal[j];
                tmp.add(elem);
            }
            res.setVectorComponent(elem, i);
        }
        return res;
    }

    public static PolynomMatrix matrMult(
            PolynomMatrix A, PolynomMatrix B
    ) throws Exception {
        Polynom[][] mat = initPF(A.getR(), B.getC());
        for (int i = 0; i < A.getR(); i++) {
            for (int j = 0; j < B.getC(); j++) {
                Polynom[] a = extractRow(A, i);

                Polynom[] b = extractCol(B, j);
                mat[i][j] = scalarProduct(a, b);
            }
        }
        PolynomMatrix res = new PolynomMatrix(A.getR(), B.getC());
        res.setMatrix(mat);
        return res;
    }


    public static PolynomMatrix matrMult(
            PolynomMatrix A, PolynomMatrix B, double m
    ) throws Exception {
        Polynom[][] mat = initPF(A.getR(), B.getC());
        for (int i = 0; i < A.getR(); i++) {
            for (int j = 0; j < B.getC(); j++) {
                Polynom[] a = extractRow(A, i);

                Polynom[] b = extractCol(B, j);
                mat[i][j] = scalarProduct(a, b, m);
            }
        }
        PolynomMatrix res = new PolynomMatrix(A.getR(), B.getC());
        res.setMatrix(mat);
        return res;
    }

    public static PolynomMatrix extractMinor(PolynomMatrix M, int r, int c) {
        PolynomMatrix res = new PolynomMatrix(M.getR() - 1, M.getC() - 1);
        Polynom[][] resPM = res.getMatrix();
        Polynom[][] pm = M.getMatrix();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.println(i + "     " + j);
                resPM[i][j] = pm[i][j];
            }
            for (int j = c + 1; j < M.getC(); j++) {
                System.out.println(i + "     " + j);
                resPM[i][j - 1] = pm[i][j];
            }
        }
        for (int i = r + 1; i < M.getR(); i++) {
            for (int j = 0; j < c; j++) {
                resPM[i - 1][j] = pm[i][j];
            }
            for (int j = c + 1; j < M.getC(); j++) {
                resPM[i - 1][j - 1] = pm[i][j];
            }
        }
        res.setMatrix(resPM);
        return res;
    }

    public static Polynom determinant(PolynomMatrix M) {
        if (M.getC() == M.getR()) {
            Polynom res = initPF();

            Polynom[][] pm = M.getMatrix();
            if (M.getC() == 1) return pm[0][0];
            for (int k = 0; k < M.getC(); k++) {
                double[] unit = {1};
                if (k % 2 == 1) {
                    unit[0] = -1;
                }
                Polynom U = new Polynom(unit);
                Polynom coef = U.multiply(pm[0][k]);
                PolynomMatrix AlgDop = extractMinor(M, 0, k);
                res = res.add(coef.multiply(determinant(AlgDop)));
            }
            return res;
        }
        return null;
    }


    public static Polynom determinant(PolynomMatrix M, double m) {
        if (M.getC() == M.getR()) {
            double[] unit = {1};
            Polynom res = initPF();
            Polynom[][] pm = M.getMatrix();
            if (M.getC() == 1) return pm[0][0];
            for (int k = 0; k < M.getC(); k++) {
                if (k % 2 == 1) {
                    unit[0] = -1;
                }
                Polynom U = new Polynom(unit);
                Polynom coef = U.multiply(pm[0][k], m);
                PolynomMatrix AlgDop = extractMinor(M, 0, k);
                Polynom tmp = determinant(AlgDop, m);
                //      System.out.println(m + "   " + k + "   " + tmp + "    " + coef + "      " + coef.multiply(tmp) + "      " + coef.multiply(tmp, m));
                tmp = coef.multiply(tmp, m);
                res = res.add(tmp, m);
            }
            return res;
        }
        return null;
    }


    public static Polynom det2X2(PolynomMatrix M) {
        if (M.getC() == 2 && M.getR() == 2) {
            Polynom[][] pm = M.getMatrix();
            Polynom mainD = pm[0][0].multiply(pm[1][1]);
            Polynom slaveD = pm[0][1].multiply(pm[1][0]).negate();

            System.out.println(mainD + "  <<----m   s---> " + slaveD);
            return mainD.add(slaveD);
        }
        return null;
    }

    public static Polynom[] extractRow(
            PolynomMatrix A, int k
    ) {
        return A.getMatrix()[k];
    }

    public static Polynom[] extractCol(
            PolynomMatrix A, int c
    ) {

        Polynom[] res = initPF(A.getR());
        for (int k = 0; k < A.getR(); k++) {
            try {
                res[k] = A.getMatrix()[k][c];
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        return res;
    }

    public static Polynom scalarProduct(Polynom[] v1, Polynom[] v2) throws Exception {
        if (v1.length != v2.length || v1.length * v2.length == 0) {
            throw new Exception();
        }
        double[] d = {0};
        Polynom res = new Polynom(d);
        for (int k = 0; k < v1.length; k++) {
            res = res.add(v1[k].multiply(v2[k]));
        }
        return res;
    }


    public static Polynom scalarProduct(Polynom[] v1, Polynom[] v2, double m) throws Exception {
        if (v1.length != v2.length || v1.length * v2.length == 0) {
            throw new Exception();
        }
        double[] d = {0};
        Polynom res = new Polynom(d);
        for (int k = 0; k < v1.length; k++) {
            res = res.add(v1[k].multiply(v2[k], m), m);
        }
        return res;
    }


}
