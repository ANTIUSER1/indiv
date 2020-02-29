package pns.BigNumbers;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SuperLageNumberTest {


    @Test
    public void create() {

        SuperLageNumber slNumber = new SuperLageNumber("123");
        System.out.println(slNumber + "   base " + slNumber.getBase() + "   digits  " + slNumber.getDigits());

        slNumber = new SuperLageNumber("3322");
        System.out.println(slNumber + "   base " + slNumber.getBase() + "   digits  " + slNumber.getDigits());

        Set<Byte> dSet = generateDigitSet(65, 90);
        Set<Byte> dSet1 = generateDigitSet(97, 122);
        slNumber = new SuperLageNumber(dSet, "332ASD2222558");
        System.out.println(slNumber + "   base " + slNumber.getBase() + "   digits  " + slNumber.getDigits());

        slNumber = new SuperLageNumber(dSet, dSet1, "332ASD2222558");
        System.out.println(slNumber + "   base " + slNumber.getBase() + "   digits  " + slNumber.getDigits());


    }

    private Set<Byte> generateDigitSet(int from, int to) {
        Set<Byte> res = new HashSet<>();
        for (byte k = (byte) from; k <= to; k++) res.add(k);
        return res;
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
        int e = 0;
        int d = 0;
        int i = 0;
        for (int u = 101; u < 10000; u++) {
            for (int v = 100; v < u; v++) {
                i++;
                SuperLageNumber N1 = new SuperLageNumber("" + u);
                SuperLageNumber N2 = new SuperLageNumber("" + v);
                SuperLageNumber N0 = new SuperLageNumber("" + (u * v));
                SuperLageNumber N = N1.muliply(N2);

                if (!N0.equals(N)) {
                    e++;
                    System.out.println("ERRROR :   u*v= " + N0 + "  N1.mult(N2)=" + N + "   u=" + u + "   v=" + v);
                } else {
                    d++;
                    //        System.out.println(" done :   u*v= " + N0 + "  N1.mult(N2)=" + N + "   u=" + u + "   v=" + v);
                }
            }
        }
        System.out.println(
                "  i " + i + "       d " + d + "   e " + e
        );
    }

    @Test
    public void add() {
        Set<Byte> dSet = generateDigitSet(65, 90);
        SuperLageNumber slNumber1 = new SuperLageNumber("4670");
        // System.out.println("slNumber1 " + slNumber1 + "   base " + slNumber1.getBase() + "   digits  " + slNumber1.getDigits());
        SuperLageNumber slNumber2 = new SuperLageNumber("532");
        //   System.out.println("slNumber2 " + slNumber2 + "   base " + slNumber2.getBase() + "   digits  " + slNumber2.getDigits());
        SuperLageNumber slNum = slNumber1.add(slNumber2);
        System.out.println("slNumber1  " + slNumber1);
        System.out.println("slNumber2 " + slNumber2);
        System.out.println("slNumber1+slNumber2 " + slNum);
    }

    @Test
    public void multiplyByDigit() {

        Set<Byte> dSet = generateDigitSet(65, 90);
        SuperLageNumber slN1 = new SuperLageNumber("578");
        SuperLageNumber slN3 = slN1.muliplyByDigit("9");
        System.out.println("    SLN1   " + slN1);

        System.out.println("    SLN3   " + slN3);

    }


    @Test
    public void multiply() {

        Set<Byte> dSet = generateDigitSet(65, 90);
        Set<Byte> dSet1 = generateDigitSet(58, 122);
        dSet.addAll(dSet1);
        SuperLageNumber slN1 = new SuperLageNumber("2120");
        SuperLageNumber slN2 = new SuperLageNumber("9");
        SuperLageNumber slN3 = slN1.muliply(slN2);
        System.out.println(slN1);
        System.out.println(slN2);
        System.out.println("--------------   ");
        System.out.println(slN3);
        //112 89

    }

    @Test
    public void substuct() {

        Set<Byte> dSet = generateDigitSet(65, 90);
        SuperLageNumber slNumber1 = new SuperLageNumber("0", false);
        //System.out.println("slNumber1 " + slNumber1 + "   base " + slNumber1.getBase() + "   digits  " + slNumber1.getDigits());
        SuperLageNumber slNumber2 = new SuperLageNumber("35", true);
        // System.out.println("slNumber2 " + slNumber2 + "   base " + slNumber2.getBase() + "   digits  " + slNumber2.getDigits());
        SuperLageNumber slNum = slNumber1.substuct(slNumber2);
        System.out.println("slNumber1  " + slNumber1);
        System.out.println("slNumber2 " + slNumber2);
        System.out.println("slNum=slNumber1-slNumber2 " + slNum);
        SuperLageNumber slN = new SuperLageNumber(slNum.getValue());

        slNum = slN.add(slNumber2);
        System.out.println("slNum+slNumber2 " + slNum);

    }

    @Test
    public void addZerosTo() {

        Set<Byte> dSet = generateDigitSet(65, 90);
        SuperLageNumber slNumber1 = new SuperLageNumber(dSet, "12005533");
        System.out.println("slNumber1 " + slNumber1 + "   base " + slNumber1.getBase() + "   digits  " + slNumber1.getDigits());
        String tmp = slNumber1.addZerosTo(slNumber1.getValue(), 35);
        System.out.println("add zeros  tmp  " + tmp);

        tmp = slNumber1.removeFirstDigitsFrom(tmp);
        System.out.println("tmp  " + tmp);

    }

    @Test
    public void compareTo() {

        Set<Byte> dSet = generateDigitSet(65, 90);
        SuperLageNumber slNumber1 = new SuperLageNumber("285354");
        SuperLageNumber slNumber2 = new SuperLageNumber("285254");
        System.out.println("N1   " + slNumber1);
        System.out.println("N2   " + slNumber2);

        int compare = slNumber1.compareTo(slNumber2);
        System.out.println(" comp  " + compare);
    }
}