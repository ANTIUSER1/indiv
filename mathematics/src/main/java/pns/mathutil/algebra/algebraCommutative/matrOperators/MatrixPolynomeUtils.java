package pns.mathutil.algebra.algebraCommutative.matrOperators;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import pns.mathutil.algebra.algebraCommutative.matrStructs.PolynomeMatrix;
import pns.mathutil.algebra.algebraCommutative.matrStructs.PolynomeVector;

import java.util.ArrayList;
import java.util.List;

public class MatrixPolynomeUtils {
    public static PolynomialFunction initPF() {
        double[] d = {0};
        return new PolynomialFunction(d);
    }

    public static PolynomialFunction[] initPF(int dim) {
        PolynomialFunction[] res = new PolynomialFunction[dim];
        for (int k = 0; k < res.length; k++) {
            res[k] = initPF();
        }
        return res;
    }

    public static PolynomialFunction[][] initPF(int R, int C) {
        PolynomialFunction[][] res = new PolynomialFunction[R][C];
        for (int k = 0; k < R; k++) {
            for (int n = 0; n < C; n++) {
                res[k][n] = initPF();
            }
        }
        return res;
    }

    public static PolynomeVector matrMult(
            PolynomeMatrix A, PolynomeVector X
    ) {
        PolynomeVector res = new PolynomeVector(X.getR());
        PolynomialFunction[] resVal = res.getVector();
        for (int i = 0; i < A.getR(); i++) {
            PolynomialFunction elem = res.getZero();
            for (int j = 0; j < A.getC(); j++) {
                elem = elem.add(A.getMatrix()[i][j].multiply(X.getVector()[i]));
                PolynomialFunction tmp = resVal[j];
                tmp.add(elem);
            }
            res.setVectorComponent(elem, i);
        }
        return res;
    }

    public static PolynomeMatrix matrMult(
            PolynomeMatrix A, PolynomeMatrix B
    ) throws Exception {
        PolynomialFunction[][] mat = initPF(A.getR(), B.getC());
        for (int i = 0; i < A.getR(); i++) {
            for (int j = 0; j < B.getC(); j++) {
                PolynomialFunction[] a = extractRow(A, i);

                PolynomialFunction[] b = extractCol(B, j);
                mat[i][j] = scalarProduct(a, b);
            }
        }
        PolynomeMatrix res = new PolynomeMatrix(A.getR(), B.getC());
        res.setMatrix(mat);
        return res;
    }

    public static PolynomeMatrix extractMinor(PolynomeMatrix M, int r, int c) {
        PolynomeMatrix res = new PolynomeMatrix(M.getR() - 1, M.getC() - 1);
        PolynomialFunction[][] resPM = res.getMatrix();
        PolynomialFunction[][] pm = M.getMatrix();
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

    public static PolynomialFunction determinant(PolynomeMatrix M) {
        if (M.getC() == M.getR()) {
            PolynomialFunction res = initPF();
            PolynomialFunction[][] pm = M.getMatrix();
            if (M.getC() == 1) return pm[0][0];
            for (int k = 0; k < M.getC(); k++) {
                double[] unit = {1};
                if (k % 2 == 1) {
                    unit[0] = -1;
                }
                PolynomialFunction U = new PolynomialFunction(unit);
                PolynomialFunction coef = pm[0][k].multiply(U);
                PolynomeMatrix AlgDop = extractMinor(M, 0, k);
                res = res.add(coef.multiply(determinant(AlgDop)));

            }
            return res;
        }
        return null;
    }

    public static PolynomialFunction det2X2(PolynomeMatrix M) {
        if (M.getC() == 2 && M.getR() == 2) {
            PolynomialFunction[][] pm = M.getMatrix();
            PolynomialFunction mainD = pm[0][0].multiply(pm[1][1]);
            PolynomialFunction slaveD = pm[0][1].multiply(pm[1][0]).negate();
            return mainD.add(slaveD);
        }
        return null;
    }

    public static PolynomialFunction[] extractRow(
            PolynomeMatrix A, int k
    ) {
        return A.getMatrix()[k];
    }

    public static PolynomialFunction[] extractCol(
            PolynomeMatrix A, int c
    ) {

        PolynomialFunction[] res = initPF(A.getR());
        for (int k = 0; k < A.getR(); k++) {
            try {
                res[k] = A.getMatrix()[k][c];
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        return res;
    }

    public static PolynomialFunction scalarProduct(PolynomialFunction[] v1, PolynomialFunction[] v2) throws Exception {
        if (v1.length != v2.length || v1.length * v2.length == 0) {
            throw new Exception();
        }
        double[] d = {0};
        PolynomialFunction res = new PolynomialFunction(d);
        List<PolynomialFunction> pfList = new ArrayList<>();
        for (int k = 0; k < v1.length; k++) {
            PolynomialFunction tmp = v1[k].multiply(v2[k]);
            res = res.add(v1[k].multiply(v2[k]));
        }
        return res;
    }


}
