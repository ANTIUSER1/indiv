package pns.mathutil.start;

import pns.mathutil.algebra.algebraCommutative.matrStructs.Polynom;
import pns.mathutil.numberOperators.ArraysOperator;
import pns.mathutil.numberOperators.ReducerArrays;

public class Main {
    public static void main(String[] args) throws Exception {
        //   modSimple();

        //arrayOperatorTest();

        polynomArithmeticTest();

//        SimplePolynome sp = new SimplePolynome(5);
//        System.out.println(sp.getPolynom());
//        System.out.println();
//
//        if (args.length == 1) {
//            sp = new SimplePolynome(args[0]);
//            System.out.println(sp.getPolynom());
//        }
//              System.out.println();
//
//        PolynomeMatrix pm = new PolynomeMatrix();
//        pm.createMatr2X2fromOnePolynome(sp.getPolynom());
//        System.out.println(pm);
//
//        PolynomeMatrix vect = new PolynomeMatrix(3, 1, 2, true);
//        PolynomeMatrix p0 = new PolynomeMatrix(3, 3, 2, true);
//        PolynomeMatrix veRotate = MatrixPolynomeUtils.matrMult(p0, vect);
//
//        System.out.println("  vector:::  " + vect);
//        System.out.println("     " + p0);
//        System.out.println("   rotate  " + veRotate);


        // PolynomeVector vv = PolynomeUtils.matrMult(pm, vect);
        //System.out.println("vv  " + vv);

//        PolynomeMatrix p0 = new PolynomeMatrix(2, 3, 1, true);
//        PolynomeMatrix p1 = new PolynomeMatrix(8, 8, 3, true);
//        System.out.println(p1);
//        PolynomialFunction pf = PolynomeUtils.determinant(p1);
//        System.out.println(pf);


//        MatrixBuilder mb = new MatrixBuilder();
//        PolynomeMatrix m0 = new PolynomeMatrix(3, 5, 2, true);
//        PolynomeMatrix m1 = new PolynomeMatrix(3, 4, 5, true);
//        PolynomeMatrix m2 = new PolynomeMatrix(3, 3, 4, true);
//        PolynomeMatrix[] pma = new PolynomeMatrix[3];
//        pma[0] = m0;
//        pma[1] = m1;
//        pma[2] = m2;
//        for (int k = 0; k < pma.length; k++) {
//            System.out.println(k + " :   " + pma[k]);
//        }
//        PolynomeMatrix m = mb.buildHorizontalFromBlocks(pma);
//        System.out.println(m);


//        double[] d = {1, 1, 1};
//        PolynomialFunction pp0 = new PolynomialFunction(d);
//        System.out.println(pp0);
//        System.out.println("     mult  ->> " + pp0.multiply(pp0));
//
//        PolynomeBuilder pb = new PolynomeBuilder();
//        pp0 = pb.buildResultPower(pp0, 2);
//        // pp0 = pb.buildResultAsPowerSum(pp0, 2);
//        System.out.println("    pp0-->> " + pp0);

//        d[0] = 1;
//        d[1] = -1;
//        PolynomialFunction pp = new PolynomialFunction(d);
//        System.out.println(pp + "     " + pp.multiply(pp0));
//
//        MatrixBuilder mb = new MatrixBuilder();
//        double[] d0 = {103, -98, 97, -100, 112, -110, 105, -109, 75, -86};
//        PolynomialFunction pptr = new PolynomialFunction(d0);
//        PolynomeMatrix m = mb.createMatr2X2Special1OnePolynome(pptr, 2);
//        System.out.println(m);
////
//        PolynomialFunction pf = MatrixPolynomeUtils.determinant(m);
//        System.out.println("     DET:  " + pf);
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
