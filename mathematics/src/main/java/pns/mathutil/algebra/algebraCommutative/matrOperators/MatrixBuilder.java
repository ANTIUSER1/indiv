package pns.mathutil.algebra.algebraCommutative.matrOperators;

import pns.mathutil.algebra.algebraCommutative.matrStructs.Polynom;
import pns.mathutil.algebra.algebraCommutative.matrStructs.PolynomMatrix;
import pns.mathutil.algebra.algebraCommutative.polynomOperators.PolynomeBuilder;


public class MatrixBuilder {

    public PolynomMatrix createVectorMatr(int R) {
        PolynomMatrix res = new PolynomMatrix(R, 1);
        Polynom[][] matr = MatrixPolynomeUtils.initPF(R, 1);
        res.setMatrix(matr);
        return res;
    }

    public PolynomMatrix createVectorMatr(int R, int deg, boolean isRandom) {
        PolynomMatrix res = new PolynomMatrix(R, 1, deg, isRandom);
        return res;
    }

    public PolynomMatrix createMatr(String[][] ss) {
        PolynomeBuilder pb = new PolynomeBuilder();
        Polynom[][] content = pb.polynomeArray(ss);
        PolynomMatrix res = new PolynomMatrix(ss.length, ss[0].length);
        res.setMatrix(content);
        return res;
    }

    public PolynomMatrix createMatr(String[][] ss, double coef) {
        PolynomeBuilder pb = new PolynomeBuilder();
        Polynom[][] content = pb.polynomeArray(ss, coef);
        PolynomMatrix res = new PolynomMatrix(ss.length, ss[0].length);
        res.setMatrix(content);
        return res;
    }

    public PolynomMatrix createVectorMatr(int R, int deg, double m, boolean isRandom) {
        PolynomMatrix res = new PolynomMatrix(R, 1, deg, m, isRandom);
        return res;
    }

    public PolynomMatrix createVectorMatr(int R, int deg, double m, boolean isRandom, boolean mustRound) {
        PolynomMatrix res = new PolynomMatrix(R, 1, deg, m, isRandom);
        if (mustRound) res = res.round(10);
        return res;
    }

    public PolynomMatrix createVectorMatr(int R, int deg, boolean isRandom, boolean mustRound) {
        PolynomMatrix res = new PolynomMatrix(R, 1, deg, isRandom);
        if (mustRound) res = res.round(10);
        return res;
    }

    public PolynomMatrix createVectorMatr(Polynom[][] p) {
        PolynomMatrix res = new PolynomMatrix(p);
        return res;
    }

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

    public PolynomMatrix createInverseMatr2X2Special1(Polynom pf, int degMain) {
        double[] u = {3 * Double.MAX_VALUE / 4 - 1};
        Polynom U = new Polynom(u);

        PolynomeBuilder pb = new PolynomeBuilder();
        Polynom pf11 = pb.buildResultPower(pf, degMain);
        Polynom pf01 = pb.buildResultAsPowerSum(pf, 2 * degMain - 1);
        Polynom pf10 = U.add(pf);

        Polynom[][] matrix = MatrixPolynomeUtils.initPF(2, 2);
        matrix[0][0] = pf11;
        matrix[0][1] = pf01.negate();
        matrix[1][0] = pf10.negate();
        matrix[1][1] = pf11;

        PolynomMatrix res = new PolynomMatrix(2, 2);
        res.setMatrix(matrix);
        return res;
    }

    public PolynomMatrix createInverseMatr2X2Special1(Polynom pf, int degMain, double m) {
        double[] u = {Integer.MAX_VALUE - 1};
        Polynom U = new Polynom(u);

        PolynomeBuilder pb = new PolynomeBuilder();
        Polynom pf11 = pb.buildResultPower(pf, degMain, m);
        Polynom pf01 = pb.buildResultAsPowerSum(pf, 2 * degMain - 1, m);
        Polynom pf10 = U.add(pf, m);

        Polynom[][] matrix = MatrixPolynomeUtils.initPF(2, 2);
        matrix[0][0] = pf11;
        matrix[0][1] = pf01.negate(m);
        matrix[1][0] = pf10.negate(m);
        matrix[1][1] = pf11;

        PolynomMatrix res = new PolynomMatrix(2, 2);
        res.setMatrix(matrix);
        return res;
    }


    public PolynomMatrix createMatr2X2Special1(Polynom pf, int degMain) {
        double[] u = {Integer.MAX_VALUE - 1};

        //   double[] d = {1};
        Polynom U = new Polynom(u);
        PolynomeBuilder pb = new PolynomeBuilder();
        Polynom pf00 = pb.buildResultPower(pf, degMain);
        Polynom pf01 = pb.buildResultAsPowerSum(pf, 2 * degMain - 1);
        Polynom pf10 = U.add(pf);

        System.out.println("    *****   " + pf);
        System.out.println("    *****   " + pf10);
        System.out.println("    *****   " + U);

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


    public PolynomMatrix createMatr2X2DegeneratePolynome(int R, int C) {


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
