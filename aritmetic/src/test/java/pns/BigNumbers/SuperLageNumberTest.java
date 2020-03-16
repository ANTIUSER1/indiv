package pns.BigNumbers;

import org.junit.Test;

import java.util.Date;
import java.util.Set;

public class SuperLageNumberTest {


    @Test
    public void create() {

        SuperLageNumber slNumber = new SuperLageNumber("123");
        System.out.println(slNumber + "   base " + slNumber.getBase() + "   digits  " + slNumber.getDigits());

        slNumber = new SuperLageNumber("3322");
        System.out.println(slNumber + "   base " + slNumber.getBase() + "   digits  " + slNumber.getDigits());


        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        Set<Byte> dSet1 = BigPareOperations.generateDigitSet(97, 122);
        slNumber = new SuperLageNumber(dSet, "332ASD2222558");
        System.out.println(slNumber + "   base " + slNumber.getBase() + "   digits  " + slNumber.getDigits());

        slNumber = new SuperLageNumber(dSet, dSet1, "332ASD2222558");
        System.out.println(slNumber + "   base " + slNumber.getBase() + "   digits  " + slNumber.getDigits());


    }


    @Test
    public void addMultiTest() {
        for (int u = 1000; u < 3000; u++) {
            for (int v = 1000; v < 3000; v++) {
                SuperLageNumber N1 = new SuperLageNumber("" + u);
                SuperLageNumber N2 = new SuperLageNumber("" + v);
                SuperLageNumber N0 = new SuperLageNumber("" + (u + v));
                SuperLageNumber N = N1.add(N2);

                if (!N0.equals(N)) {
                    System.out.println("ERRROR :   u+v= " + N0 + "  N1.add(N2)=" + N + "   u=" + u + "   v=" + v);
                }
            }
        }
    }

    @Test
    public void multiplyMultiTest() {
        long ts = System.currentTimeMillis();
        long e = 0;
        long d = 0;
        long i = 0;

        long maxLim = 500;
        long minLim = 80000;

        for (long u = minLim; u < minLim + maxLim; u++) {
            for (long v = minLim; v < minLim + maxLim; v++) {
                i++;
                SuperLageNumber N1 = new SuperLageNumber("" + u);
                SuperLageNumber N2 = new SuperLageNumber("" + v);
                SuperLageNumber N0 = new SuperLageNumber("" + (u * v));
                SuperLageNumber N = N1.multiply(N2);
                if (!N0.equals(N)) {
                    e++;
                    System.out.println("ERRROR :   u*v= " + N0 + "  N1.mult(N2)=" + N + "   u=" + u + "   v=" + v);
                } else {
                    d++;
                    //        System.out.println(" done :   u*v= " + N0 + "  N1.mult(N2)=" + N + "   u=" + u + "   v=" + v);
                }
            }
        }
        System.out.println(new Date() +
                "       i " + i + "       d " + d + "   e " + e + "    " + new Date(System.currentTimeMillis() - ts)
        );
    }

    @Test
    public void add() {
        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        SuperLageNumber slNumber1 = new SuperLageNumber(dSet, "4016000");
        // System.out.println("slNumber1 " + slNumber1 + "   base " + slNumber1.getBase() + "   digits  " + slNumber1.getDigits());
        SuperLageNumber slNumber2 = new SuperLageNumber(dSet, "8032");
        //   System.out.println("slNumber2 " + slNumber2 + "   base " + slNumber2.getBase() + "   digits  " + slNumber2.getDigits());
        SuperLageNumber slNum = slNumber1.add(slNumber2);
        System.out.println("slNumber1  " + slNumber1);
        System.out.println("slNumber2 " + slNumber2);
        System.out.println("slNumber1+slNumber2 " + slNum);
    }

    @Test
    public void multiplyByDigit() {

        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        SuperLageNumber slN1 = new SuperLageNumber("578");
        SuperLageNumber slN3 = slN1.muliplyByDigit("9");
        System.out.println("    SLN1   " + slN1);

        System.out.println("    SLN3   " + slN3);

    }


    @Test
    public void multiply() {

        Set<Byte> dSet = BigPareOperations.generateDigitSet(70, 90);
        Set<Byte> dSet1 = BigPareOperations.generateDigitSet(70, 250);

        dSet.addAll(dSet1);
        SuperLageNumber slN1 = new SuperLageNumber(dSet, "2008");
        SuperLageNumber slN2 = new SuperLageNumber(dSet, "2004");
        SuperLageNumber slN3 = slN1.multiply(slN2);
        System.out.println(slN1);
        System.out.println(slN2);
        System.out.println("--------------   " + slN3.getValue().length());
        System.out.println(slN3);
        //112 89

    }

    @Test
    public void substuct() {
        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        SuperLageNumber slNumber1 = new SuperLageNumber(dSet, "XZ585858XXXSSWZ", false);
        SuperLageNumber slNumber2 = new SuperLageNumber(dSet, "ZZZAZZZZDD2121FF14", false);
//
        SuperLageNumber slNum = slNumber1.substact(slNumber2);
        System.out.println("slNumber1  " + slNumber1);
        System.out.println("slNumber2 " + slNumber2);
        System.out.println("slNum=slNumber1-slNumber2 " + slNum);
        System.out.println("slNumber1.compareTo(slNum )  " + slNumber1.compareTo(slNum));
        SuperLageNumber sad = slNum.add(slNumber2);
        System.out.println("sad  " + sad);
    }

    @Test
    public void addZerosTo() {


        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        SuperLageNumber slNumber1 = new SuperLageNumber(dSet, "12005533");
        System.out.println("slNumber1 " + slNumber1 + "   base " + slNumber1.getBase() + "   digits  " + slNumber1.getDigits());
        String tmp = slNumber1.addZerosTo(slNumber1.getValue(), 35);
        System.out.println("add zeros  tmp  " + tmp);

        tmp = slNumber1.removeFirstDigitsFrom(tmp);
        System.out.println("tmp  " + tmp);

    }

    @Test
    public void compareTo() {

        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        SuperLageNumber slNumber1 = new SuperLageNumber(dSet, "73");
        SuperLageNumber slNumber2 = new SuperLageNumber(dSet, "2");
        System.out.println("N1   " + slNumber1);
        System.out.println("N2   " + slNumber2);

        int compare = slNumber1.compareTo(slNumber2);
        System.out.println(" comp  " + compare);
    }

    @Test
    public void intDiv() {

        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        SuperLageNumber N1 = new SuperLageNumber("30");
        SuperLageNumber N2 = new SuperLageNumber("7");
        SuperLageNumber N3 = N1.intDiv(N2);
        System.out.println("N3=" + N3);

    }

    @Test
    public void divide() {

        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        SuperLageNumber N1 = new SuperLageNumber("30");
        SuperLageNumber N2 = new SuperLageNumber("7");
        SuperLageNumber[] N3 = N1.divide(N2);
        System.out.println("N =  " + N3[0] + "  ; " + N3[1]);
    }

    @Test
    public void mod() {

        Set<Byte> dSet = BigPareOperations.generateDigitSet(65, 90);
        SuperLageNumber N1 = new SuperLageNumber("29");
        SuperLageNumber N2 = new SuperLageNumber("7");
        SuperLageNumber N3 = N1.mod(N2);
        System.out.println("N = " + N3);
    }
}