package pns.mathutil.mtc.matrOperators;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import pns.mathutil.mtc.polynomOperators.PolynomeBuilder;

import java.util.ArrayList;
import java.util.List;

public class MatrixBuilder {

    public PolynomeMatrix buildVeticalFromBlocks(PolynomeMatrix[] blocks) {
        if (blocsAreVerticalValid(blocks)) {
            int C = blocks[0].getC();
            int R = countNewRows(blocks);
            PolynomialFunction[][] matr = MatrixPolynomeUtils.initPF(R, C);
            int N = 0;
            for (PolynomeMatrix pm : blocks) {
                PolynomialFunction[][] matrData = pm.getMatrix();
                for (int i = 0; i < pm.getR(); i++) {
                    for (int j = 0; j < pm.getC(); j++) {
                        matr[i + N][j] = matrData[i][j];
                    }
                }
                System.out.println("N " + N);
                N += pm.getR();
            }
            PolynomeMatrix res = new PolynomeMatrix(R, C);
            res.setMatrix(matr);
            return res;
        }
        return null;
    }

    public PolynomeMatrix buildHorizontalFromBlocks(PolynomeMatrix[] blocks) {
        if (blocsAreHorizontalValid(blocks)) {
            int R = blocks[0].getR();
            int C = countNewCols(blocks);
            PolynomialFunction[][] matr = MatrixPolynomeUtils.initPF(R, C);
            int N = 0;
            for (PolynomeMatrix pm : blocks) {
                PolynomialFunction[][] matrData = pm.getMatrix();
                for (int i = 0; i < pm.getR(); i++) {
                    for (int j = 0; j < pm.getC(); j++) {
                        matr[i][j + N] = matrData[i][j];
                    }
                }
                System.out.println("N " + N);
                N += pm.getC();
            }
            PolynomeMatrix res = new PolynomeMatrix(R, C);
            res.setMatrix(matr);
            return res;
        }
        return null;
    }

    public PolynomeMatrix createMatr2X2Special1OnePolynome(PolynomialFunction pf, int degMain, int degSlave) {
         double [] d={1}  ;PolynomialFunction U=new PolynomialFunction(d);

        PolynomeBuilder pb = new PolynomeBuilder();
        System.out.println("    pf "+pf);
        PolynomialFunction       pf10=pf;
        pf = pb.buildResultPower(pf, degMain);
        System.out.println("   //***** pf "+pf);

        PolynomialFunction pp0 = pb.buildResultAsPowerSum(pf, degSlave);
        PolynomialFunction pp1 = pf.add(U.negate());
        PolynomialFunction[][] matrix = MatrixPolynomeUtils.initPF(2, 2);
        matrix[0][0] = pf;
        matrix[0][1] = pp0;
        matrix[1][0] = pp1;
        matrix[1][1] = pf;

        PolynomeMatrix res = new PolynomeMatrix(2, 2);
        res.setMatrix(matrix);
        return res;
    }

    @Deprecated
    public PolynomeMatrix createMatr2X2fromOnePolynome0(PolynomialFunction pf) {
        PolynomialFunction[][] matrix = MatrixPolynomeUtils.initPF(2, 2);
        double[] U = {1};
        PolynomialFunction unit = new PolynomialFunction(U);

        matrix[0][0] = pf;
        matrix[1][1] = pf;
        matrix[0][1] = pf.add(unit);
        matrix[1][0] = pf.add(unit.negate());
        PolynomeMatrix res = new PolynomeMatrix(2, 2);
        res.setMatrix(matrix);
        return res;
    }

    private int countNewCols(PolynomeMatrix[] blocks) {
        int res = 0;
        for (PolynomeMatrix p : blocks) res += p.getC();
        return res;
    }

    private int countNewRows(PolynomeMatrix[] blocks) {
        int res = 0;
        for (PolynomeMatrix p : blocks) res += p.getR();
        return res;
    }

    private boolean blocsAreVerticalValid(PolynomeMatrix[] blocks) {
        boolean res = blocks.length > 0;
        if (res) {
            int C = blocks[0].getC();
            for (int k = 1; k < blocks.length; k++) {
                if (blocks[k].getC() != C) return false;
            }
        }
        return res;
    }

    private boolean blocsAreHorizontalValid(PolynomeMatrix[] blocks) {
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
