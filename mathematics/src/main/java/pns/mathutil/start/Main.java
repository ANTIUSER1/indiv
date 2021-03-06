package pns.mathutil.start;

import pns.mathutil.algebra.algebraCommutative.matrOperators.MatrixBuilder;
import pns.mathutil.algebra.algebraCommutative.matrOperators.MatrixPolynomeUtils;
import pns.mathutil.algebra.algebraCommutative.matrStructs.Polynom;
import pns.mathutil.algebra.algebraCommutative.matrStructs.PolynomMatrix;
import pns.mathutil.algebra.algebraCommutative.polynomOperators.PolynomeBuilder;
import pns.mathutil.numberOperators.ArraysOperator;
import pns.mathutil.numberOperators.Reducer;
import pns.mathutil.numberOperators.ReducerArrays;
import pns.mathutil.stringOperators.StrDataOperator;

public class Main {
    public static void main(String[] args) throws Exception {
        //   modSimple();

        //arrayOperatorTest();

        //  polynomArithmeticTest();

//        determinantTest();

        //matrMultiplyTest();

//        matrixBuilderSpecial();

//        matrixInverseBuilderSpecial();

        //   vectCreateTest();

        //vectMatrInvTest();

        //   PolynomArrayTest();

        //matrFromStrTest();

        make2x2MatrInvFromStr();

        double dd = 1.2278944112558;
        System.out.println(Reducer.roundAccuracy(dd));
    }

    private static void make2x2MatrInvFromStr() throws Exception {
        String sa = StrDataOperator.rndString(42, 126, 3);
        Polynom polynom = new Polynom(sa);
        System.out.println("     polynom  " + polynom);

        MatrixBuilder builder = new MatrixBuilder();
        String[][] strVect = StrDataOperator.rndStringDoubleArray(10, 100, 2, 2, 2);
        PolynomMatrix polynomMatrixVect = builder.createMatr(strVect);

        System.out.println("  VECT  " + polynomMatrixVect);

        PolynomMatrix polynomMatrix = builder.createMatr2X2Special1(polynom, 2);
        System.out.println("  2x2 spec " + polynomMatrix);

        PolynomMatrix polynomMatrixInv = builder.createInverseMatr2X2Special1(polynom, 2);
        System.out.println("spec inv " + polynomMatrixInv);

        PolynomMatrix p = MatrixPolynomeUtils.matrMult(polynomMatrix, polynomMatrixVect);
        System.out.println(" p " + p);
        System.out.println("  VECT  " + polynomMatrixVect);
        PolynomMatrix p0 = MatrixPolynomeUtils.matrMult(polynomMatrixInv, p);
        System.out.println(" p0 " + p0);

        PolynomMatrix ep0 = MatrixPolynomeUtils.matrMult(polynomMatrixInv, polynomMatrix);
        System.out.println(" ep0 " + ep0);

    }

    private static void matrFromStrTest() throws Exception {
        String[][] s1 = StrDataOperator.rndStringDoubleArray(-255, 255, 2, 2, 2);
        String[][] s2 = StrDataOperator.rndStringDoubleArray(-255, 255, 2, 2, 3);
        MatrixBuilder mb = new MatrixBuilder();
        PolynomMatrix pm1 = mb.createMatr(s1, 0.02);
        System.out.println(pm1);
        PolynomMatrix pm2 = mb.createMatr(s2, .02);
        System.out.println(pm2);
        PolynomMatrix pr = MatrixPolynomeUtils.matrMult(pm1, pm2);
        System.out.println(pr);

    }

    /**
     * далее надо сделать матрицу из строк
     */
    private static void PolynomArrayTest() {
        String[] sa1 = StrDataOperator.rndStringArray(42, 122, 5, 3);
        String[] sa2 = StrDataOperator.rndStringArray(42, 122, 5, 3);
        Polynom[] p1 = new Polynom[sa1.length];
        Polynom[] p2 = new Polynom[sa1.length];
        for (int k = 0; k < sa1.length; k++) {
            p1[k] = new Polynom(sa1[k]);
            p2[k] = new Polynom(sa2[k]);
            System.out.println(p1[k] + "      " + p2[k]);
        }
        PolynomeBuilder pb = new PolynomeBuilder();
        Polynom rr = pb.linCombination(p1, p2);
        System.out.println(rr);
    }


    private static void vectMatrInvTest() throws Exception {

        MatrixBuilder builder = new MatrixBuilder();
        PolynomMatrix polynomMatrixVect = builder.createVectorMatr(2, 3, 7, true, true);
        System.out.println("  VECT  " + polynomMatrixVect);

        double[] cft = {5, 2, -3};
        Polynom polynom = new Polynom(cft, 7);
        System.out.println(" polynom " + polynom);
        PolynomMatrix polynomMatrix = builder.createMatr2X2Special1(polynom, 1, 7);
        System.out.println("  2x2 spec " + polynomMatrix);

        PolynomMatrix polynomMatrixInv = builder.createInverseMatr2X2Special1(polynom, 1, 7);
        System.out.println("spec inv " + polynomMatrixInv);

        PolynomMatrix p = MatrixPolynomeUtils.matrMult(polynomMatrix, polynomMatrixVect, 7);
        System.out.println(" p " + p);
        System.out.println("  VECT  " + polynomMatrixVect);
        PolynomMatrix p0 = MatrixPolynomeUtils.matrMult(polynomMatrixInv, p, 7);
        System.out.println(" p0 " + p0);

    }

    private static void vectCreateTest() {
        MatrixBuilder builder = new MatrixBuilder();
        PolynomMatrix polynomMatrix = builder.createVectorMatr(2, 1, true, true);
        System.out.println(polynomMatrix);
    }

    private static void matrixInverseBuilderSpecial() throws Exception {
        MatrixBuilder builder = new MatrixBuilder();
        double[] cft = {102, 195, 11, 92, 80, 102, 980, 91};
        Polynom polynom = new Polynom(cft);

        System.out.println(polynom);
        PolynomMatrix polynomMatrix = builder.createMatr2X2Special1(polynom, 31, 7);
        System.out.println(polynomMatrix);

        PolynomMatrix polynomMatrixInv = builder.createInverseMatr2X2Special1(polynom, 31, 7);
        System.out.println(polynomMatrix);

        PolynomMatrix p = MatrixPolynomeUtils.matrMult(polynomMatrix, polynomMatrixInv, 7);
        System.out.println(" p " + p);
    }


    private static void polynomSpecialTest() {
        PolynomMatrix p1 = new PolynomMatrix(4, 4, 1, 30, true);
        PolynomeBuilder pb = new PolynomeBuilder();

    }

    private static void matrMultiplyTest() throws Exception {
        PolynomMatrix p1 = new PolynomMatrix(4, 4, 1, 30, true);
        PolynomMatrix p2 = new PolynomMatrix(4, 4, 1, 30, true);
        p1 = p1.round(10);
        p2 = p2.round(10);
        System.out.println(" p1  " + p1);
        System.out.println(" p2 " + p2);

        PolynomMatrix p = MatrixPolynomeUtils.matrMult(p1, p2, 10);

        System.out.println(" p " + p);
    }

    public static void determinantTest() {
        PolynomMatrix p1 = new PolynomMatrix(3, 3, 100, 30, true);
        p1 = p1.round(10);
        System.out.println(p1);
        Polynom pf = MatrixPolynomeUtils.determinant(p1, 65537);
        System.out.println(pf);

    }

    public static void matrixBuilderSpecial() {
        MatrixBuilder builder = new MatrixBuilder();
        double[] cft = {0, 1, 1};
        Polynom polynom = new Polynom(cft);

        System.out.println(polynom);
        PolynomMatrix polynomMatrix = builder.createMatr2X2Special1(polynom, 1);
        System.out.println(polynomMatrix);
        Polynom pf = MatrixPolynomeUtils.determinant(polynomMatrix);
        System.out.println(pf);
    }

    public static void polynomArithmeticTest() {

        byte[] doubles0 = {5, 51};
        byte[] doubles1 = {11, 6};
        doubles0 = "ASxxsdd".getBytes();
        doubles1 = "Annsdd".getBytes();
        Polynom polynom = new Polynom(doubles0, 7);
        Polynom polynom1 = new Polynom(doubles1, 7);

        System.out.println(polynom);
        System.out.println(polynom1);
        System.out.println(polynom.add(polynom1));
        System.out.println(polynom.multiply(polynom1));
    }

    public static void arrayOperatorTest() {
        long[] db = ArraysOperator.createRandomLong(3);
        for (Long dd : db) {
            System.out.println(dd);
        }
    }

    public static void modSimple() {
        int[] ddd = {12, -4};
//        System.out.println(ddd + "     " + Reducer.reduceMod(ddd, 5));
        for (Integer d : ReducerArrays.reduceMod(ddd, 5)) {
            System.out.println(d);
        }
    }


}
