package pns.mathutil.algebra.algebraCommutative.matrOperators;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import pns.mathutil.algebra.algebraCommutative.matrStructs.Polynom;
import pns.mathutil.algebra.algebraCommutative.matrStructs.PolynomMatrix;
import pns.mathutil.algebra.algebraCommutative.polynomOperators.PolynomeBuilder;


public class MatrixBuilder {

    public PolynomMatrix buildVeticalFromBlocks(PolynomMatrix[] blocks) {
        if (blocsAreVerticalValid(blocks)) {
            int C = blocks[0].getC();
            int R = countNewRows(blocks);
            Polynom[][] matr = MatrixPolynomeUtils.initPF(R, C);
            int N = 0;
            for (PolynomMatrix pm : blocks) {
                Polynom[][] matrData = pm.getMatrix();
                for (int i = 0; i < pm.getR(); i++) {
                    for (int j = 0; j < pm.getC(); j++) {
                        matr[i + N][j] = matrData[i][j];
                    }
                }
                N += pm.getR();
            }
            PolynomMatrix res = new PolynomMatrix(R, C);
            res.setMatrix(matr);
            return res;
        }
        return null;
    }

    public PolynomMatrix buildHorizontalFromBlocks(PolynomMatrix[] blocks) {
        if (blocsAreHorizontalValid(blocks)) {
            int R = blocks[0].getR();
            int C = countNewCols(blocks);
            Polynom[][] matr = MatrixPolynomeUtils.initPF(R, C);
            int N = 0;
            for (PolynomMatrix pm : blocks) {
                Polynom[][] matrData = pm.getMatrix();
                for (int i = 0; i < pm.getR(); i++) {
                    for (int j = 0; j < pm.getC(); j++) {
                        matr[i][j + N] = matrData[i][j];
                    }
                }
                System.out.println("N " + N);
                N += pm.getC();
            }
            PolynomMatrix res = new PolynomMatrix(R, C);
            res.setMatrix(matr);
            return res;
        }
        return null;
    }

    public PolynomMatrix createMatr2X2Special1(Polynom pf, int degMain) {
        double[] d = {1};
        Polynom U = new Polynom(d);
        PolynomeBuilder pb = new PolynomeBuilder();
        Polynom pf00 = pb.buildResultPower(pf, degMain);
        Polynom pf01 = pb.buildResultAsPowerSum(pf, 2 * degMain - 1);
        Polynom pf10 = U.negate().add(pf);

        Polynom[][] matrix = MatrixPolynomeUtils.initPF(2, 2);
        matrix[0][0] = pf00;
        matrix[0][1] = pf01;
        matrix[1][0] = pf10;
        matrix[1][1] = pf00;

        PolynomMatrix res = new PolynomMatrix(2, 2);
        res.setMatrix(matrix);
        return res;
    }


    public PolynomMatrix createMatr2X2Special1(Polynom pf, int degMain, double m) {
        double[] d = {1};
        Polynom U = new Polynom(d);
        PolynomeBuilder pb = new PolynomeBuilder();
        Polynom pf00 = pb.buildResultPower(pf, degMain, m);
        Polynom pf01 = pb.buildResultAsPowerSum(pf, 2 * degMain - 1, m);
        Polynom pf10 = U.negate().add(pf, m);

        Polynom[][] matrix = MatrixPolynomeUtils.initPF(2, 2);
        matrix[0][0] = pf00;
        matrix[0][1] = pf01;
        matrix[1][0] = pf10;
        matrix[1][1] = pf00;

        PolynomMatrix res = new PolynomMatrix(2, 2);
        res.setMatrix(matrix);
        return res;
    }


    public PolynomMatrix createMatr2X2DegeneratePolynome(PolynomialFunction pf, int dim) {


        return null;
    }

    private int countNewCols(PolynomMatrix[] blocks) {
        int res = 0;
        for (PolynomMatrix p : blocks) res += p.getC();
        return res;
    }

    private int countNewRows(PolynomMatrix[] blocks) {
        int res = 0;
        for (PolynomMatrix p : blocks) res += p.getR();
        return res;
    }

    private boolean blocsAreVerticalValid(PolynomMatrix[] blocks) {
        boolean res = blocks.length > 0;
        if (res) {
            int C = blocks[0].getC();
            for (int k = 1; k < blocks.length; k++) {
                if (blocks[k].getC() != C) return false;
            }
        }
        return res;
    }

    private boolean blocsAreHorizontalValid(PolynomMatrix[] blocks) {
        boolean res = blocks.length > 0;
        if (res) {
            int R = blocks[0].getR();
            for (int k = 1; k < blocks.length; k++) {
                if (blocks[k].getR() != R) return false;
            }
        }
        return res;
    }

}
