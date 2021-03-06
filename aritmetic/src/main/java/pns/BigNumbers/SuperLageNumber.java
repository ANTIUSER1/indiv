package pns.BigNumbers;

import java.util.*;

public class SuperLageNumber extends ISuperNumber implements Comparable<SuperLageNumber> {

    public static final SuperLageNumber ZERO = new SuperLageNumber("0");
    public static final SuperLageNumber UNIT = new SuperLageNumber("1");


    private String value;
    private Boolean isNegative = false;

    public SuperLageNumber() {
        generateDigits();
        char c = (char) (byte) digitsList.get(0);
        value = "" + c;
    }

    public SuperLageNumber(String value) {

        generateDigits();
        value = value.trim();
        if (isCorrectValue(digits, value)) this.value = removeFirstDigitsFrom(value);
    }


    public SuperLageNumber(Set<Byte> extDigits, String value) {
        generateDigits(extDigits);
        if (isCorrectValue(digits, value)) this.value = removeFirstDigitsFrom(value);
        //  System.out.println(digits);

    }

//    public SuperLageNumber(Set<Byte> extDigits, String value) {
//        digits = extDigits;
//        if (isCorrectValue(digits, value)) this.value = removeFirstDigitsFrom(value);
//    }
//
//    public SuperLageNumber(Set<Byte> extDigits, String value, boolean isNeg) {
//        digits = extDigits;
//        isNegative = isNeg;
//        if (isCorrectValue(digits, value)) this.value = removeFirstDigitsFrom(value);
//    }

    public SuperLageNumber(Set<Byte> extDigits1, Set<Byte> extDigits2, String value) {
        generateDigits(extDigits1, extDigits2);
        if (isCorrectValue(digits, value)) this.value = removeFirstDigitsFrom(value);
    }

    public SuperLageNumber(String value, boolean negative) {
        generateDigits();
        value = value.trim();
        if (isCorrectValue(digits, value)) this.value = removeFirstDigitsFrom(value);
        this.isNegative = negative;
    }

    public SuperLageNumber(Set<Byte> extDigits, String value, boolean negative) {
        generateDigits(extDigits);
        if (isCorrectValue(digits, value)) this.value = removeFirstDigitsFrom(value);
        if (value.equals("0")) negative = false;
        this.isNegative = negative;
    }

    public SuperLageNumber(Set<Byte> extDigits1, Set<Byte> extDigits2, String value, boolean negative) {
        generateDigits(extDigits1, extDigits2);
        if (isCorrectValue(digits, value)) this.value = removeFirstDigitsFrom(value);
        this.isNegative = negative;
    }

    public Boolean isNegative() {
        return isNegative;
    }

    public void setNegative(Boolean negative) {
        isNegative = negative;
    }

    private boolean isCorrectValue(Set<Byte> dig, String value) {
        boolean res = true;

        for (int k = 0; k < value.length(); k++) {
            boolean correct = dig.contains((byte) value.charAt(k));
            if (!correct)
                throw new ArithmeticException(" Digit at " + k + " equals to  '" + value.charAt(k) + "' is  incorrect");
        }
        return res;
    }

    public String getValue() {
        return value;
    }

    public SuperLageNumber add(SuperLageNumber a) {
        SuperLageNumber tmpT = this.clone();
        SuperLageNumber tmpA = a.clone();
        tmpA.rebuildDigits();
        tmpT.rebuildDigits();

        if (!tmpT.isNegative && tmpA.isNegative) {
            tmpA.isNegative = false;
            return tmpT.substact(tmpA);
        }
        if (!tmpA.isNegative && tmpT.isNegative) {
            tmpT.isNegative = false;
            return tmpA.substact(tmpT);
        }
        if (tmpA.isNegative && tmpT.isNegative) {
            tmpA.isNegative = false;
            tmpT.isNegative = false;
            tmpA = tmpT.add(tmpA);
            tmpA.isNegative = true;
            return tmpA;
        }

        String tmpSTR1 = tmpT.value;
        String tmpSTR2 = tmpA.value;

        if (tmpSTR2.length() < tmpSTR1.length()) {
            tmpSTR2 = addZerosTo(tmpSTR2, tmpSTR1.length() - tmpSTR2.length());
        } else {
            tmpSTR1 = addZerosTo(tmpSTR1,
                    tmpSTR2.length() - tmpSTR1.length());
        }
        String nc = add(tmpSTR1, tmpSTR2);

        Set<Byte> tmpDig = new HashSet<>(this.digits);
        SuperLageNumber res = new SuperLageNumber(tmpDig, nc);
        return res;

    }

    public SuperLageNumber abs() {
        SuperLageNumber res = clone();
        res.rebuildDigits();
        res.isNegative = false;
        return res;
    }

    public SuperLageNumber negate() {
        SuperLageNumber res = clone();
        res.isNegative = isNegative;
        res.rebuildDigits();
        res.isNegative = !res.isNegative;
        return res;
    }

    public SuperLageNumber substact(SuperLageNumber a) {
        SuperLageNumber tmpA = a.clone();
        SuperLageNumber tmpT = this.clone();

        boolean resIsNeg = tmpT.compareTo(tmpA) < 0;
        //  System.out.println(digitsList);

        if (!tmpT.isNegative && tmpA.isNegative) {
            tmpA.setNegative(false);
            tmpA = tmpA.add(tmpT);
            return tmpA;
        }
        if (tmpT.isNegative && !tmpA.isNegative) {
            tmpA.setNegative(false);
            tmpA = tmpA.add(tmpT);
            tmpA.setNegative(true);
            return tmpA;
        }
        if (tmpT.isNegative && tmpA.isNegative) {
            tmpA.setNegative(false);
            tmpT.setNegative(false);
            tmpA = tmpA.substact(tmpT);
            tmpA.setNegative(resIsNeg);
            return tmpA;
        }

        if (resIsNeg) {
            tmpA = tmpA.substact(tmpT);
            tmpA.setNegative(true);
            return tmpA;
        }
        //       System.out.println(this + "    " + a + "  " + resIsNeg);
        String tmpSTR1 = value;
        String tmpSTR2 = a.value;
        if (tmpSTR2.length() < tmpSTR1.length()) {
            tmpSTR2 = addZerosTo(tmpSTR2, tmpSTR1.length() - tmpSTR2.length());
        } else {
            tmpSTR1 = addZerosTo(tmpSTR1,
                    tmpSTR2.length() - tmpSTR1.length());
        }
        String nc = substact(tmpSTR1, tmpSTR2);
        Set<Byte> tmpDig = new HashSet<>(this.digits);

        //System.out.println(tmpDig.size() + "   -----**  :   ::   :::: " + this.digits.size());
        SuperLageNumber res = new SuperLageNumber(tmpDig, nc, resIsNeg);

        return res;
    }


    public String addZerosTo(String str, int n) {
        StringBuffer sbf = new StringBuffer();
        for (int k = 0; k < n; k++) sbf.append('0');
        return sbf.toString() + str;
    }

    public String removeFirstDigitsFrom(String s) {
        String s1 = s.trim();
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == '0') continue;
            else return s.substring(k, s.length());
        }
        if (s.equals(s1)) return "0";
        return s;
    }

    public SuperLageNumber muliplyByDigit(String digit) {
        char c = digit.charAt(0);
        SuperLageNumber res = this.clone();
        res.rebuildDigits();
        if (!res.digits.contains((byte) c)) throw new ArithmeticException(digit + " is not exists ");
        String ss = multStringOnChar(res.value, c);
        res.value = removeFirstDigitsFrom(ss);

        return res;
    }

    public SuperLageNumber[] divide(SuperLageNumber a) {
        SuperLageNumber tmpT = this.clone();
        SuperLageNumber tmpA = a.clone();

        tmpA.rebuildDigits();
        tmpT.rebuildDigits();
        SuperLageNumber[] res = new SuperLageNumber[2];
        res[0] = tmpT.intDiv(tmpA);

        SuperLageNumber SLN = res[0].multiply(tmpA);
        res[1] = tmpT.substact(res[0].multiply(tmpA));
        return res;
    }

    public SuperLageNumber mod(SuperLageNumber a) {
        SuperLageNumber tmpT = this.clone();
        SuperLageNumber tmpA = a.clone();

        tmpA.rebuildDigits();
        tmpT.rebuildDigits();
        SuperLageNumber res = tmpT.intDiv(tmpA);
        res = tmpT.substact(res.multiply(tmpA));
        return res;
    }

    public SuperLageNumber intDiv(SuperLageNumber a) {
        SuperLageNumber tmpT = this.clone();

        tmpT = tmpT.abs();
        SuperLageNumber tmpA = a.clone();
        tmpA = tmpA.abs();
        tmpA.rebuildDigits();
        tmpT.rebuildDigits();

        SuperLageNumber res = ZERO;
        res.digits = digits;
        SuperLageNumber adder = tmpA.clone();
        while (adder.compareTo(tmpT) <= 0) {
            adder = adder.add(tmpA);
            res = res.add(UNIT);
        }
        return res;
    }

    public SuperLageNumber multiply(SuperLageNumber a) {
        SuperLageNumber tmpT = this.clone();
        SuperLageNumber tmpA = a.clone();


        tmpA.rebuildDigits();
        tmpT.rebuildDigits();
        this.digits = tmpA.digits;
        Set<Byte> stb = new HashSet<>(digits);
        SuperLageNumber res = new SuperLageNumber(stb, "0", false);
        List<SuperLageNumber> superLageNumberList = new ArrayList<>();
        List<String> superLageStrList = new ArrayList<>();
        for (int k = 0; k < tmpA.value.length(); k++) {
            String tmp = multStringOnChar(tmpT.value, tmpA.value.charAt(k));
            //System.out.println(k + "   " + tmp + "   " + tmpT.value + "    " + tmpA.value.charAt(k));
            tmp = shiftToLeft(tmp, tmpA.value.length() - k - 1);
            SuperLageNumber tmpNum = new SuperLageNumber(stb, tmp);
            superLageNumberList.add(tmpNum);
        }
        for (SuperLageNumber large : superLageNumberList) {
            res = res.add(large);
//            System.out.println(large + "   res  " + res);
        }
        res.isNegative = (tmpA.isNegative && !tmpT.isNegative) || (!tmpA.isNegative && tmpT.isNegative);
        //System.out.println(superLageNumberList);
        return res;
    }

    public SuperLageNumber muliplyByDigit(String digit, int digitNumber) {
        SuperLageNumber res = this.clone();
        res = res.muliplyByDigit(digit).shiftToLeft(digitNumber);

        return res;
    }

    public SuperLageNumber shiftToLeft(int N) {
        SuperLageNumber res = this.clone();
        res.value = shiftToLeft(res.value, N);
        Set<Byte> s0 = new HashSet<>(res.digits);
        return new SuperLageNumber(s0, res.value, res.isNegative);
    }

    private String multStringOnChar(String value, char c) {

        //rebuildDigits();
        String ss = addZerosTo("000", value.length());
        value = "000" + value;
        StringBuilder res = new StringBuilder(ss);
        StringBuilder mem = new StringBuilder("0");

        Set<Integer> lockedInt = new HashSet<>();
        byte b = (byte) c;
        int fixN = digitsList.indexOf(b);
        for (int k = value.length() - 1; k >= 0; k--) {

            byte currentByte = (byte) value.charAt(k);
            int currentInt = digitsList.indexOf(currentByte);
            int currentProd = fixN * currentInt;
            int over = currentProd / digits.size();
            byte overByte = digitsList.get(over);
            mem.append((char) overByte);
            byte newByte = digitsList.get(currentProd % digits.size());
            if (!lockedInt.contains(k)) {
                lockedInt.add(k);
                res.setCharAt(k, (char) newByte);
            }
        }
//        System.out.println(mem.toString() + "  +   " + res.toString());
        Set<Byte> btts = new HashSet<>(digits);

        SuperLageNumber tmmMod = new SuperLageNumber(btts, res.toString());
        SuperLageNumber tmmMem = new SuperLageNumber(btts, mem.reverse().toString());
        tmmMem.rebuildDigits();
        tmmMod.rebuildDigits();
        SuperLageNumber tmp = tmmMod.add(tmmMem);
        return tmp.value;

        // return add(res.toString(), mem.toString());
        // return res.toString();
    }


    private String shiftToLeft(String s, int N) {
        StringBuilder res = new StringBuilder(s);
        for (int k = 0; k < N; k++) res.append(0);
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperLageNumber that = (SuperLageNumber) o;
        return this.toString().trim().equals(o.toString().trim());
    }

    @Override
    public int hashCode() {
        return Objects.hash(digits, base, value, isNegative);
    }

    @Override
    public String toString() {
        String res = value;
        if (isNegative) res = '-' + value;
        return res;
    }


    public SuperLageNumber clone() {
        return new SuperLageNumber(digits, value, isNegative);
    }


    @Override
    public int compareTo(SuperLageNumber sln) {
        rebuildDigits();
        sln.rebuildDigits();
        if (this.isNegative && !sln.isNegative) return -1;
        if (!this.isNegative && sln.isNegative) return 1;

        if (this.isNegative.equals(sln.isNegative)) {
            if (this.value.equals(sln.value)) {
                return 0;
            } else {
                return rcomparateByPos(sln.value);
            }
        }
        System.out.println("ELSE?????????????");
        return 0;
    }

    private String add(String s1, String s2) {
        rebuildDigits();
        int N = 3 + s1.length() + s2.length();
        s1 = addZerosTo(s1, N);
        s2 = addZerosTo(s2, N);
        String ss = addZerosTo("", s1.length());

        StringBuilder res = new StringBuilder(ss);
        int over = 0;
        Set<Integer> lockInt = new HashSet<>();
//        System.out.println(s1 + "  + " + s2);
//        System.out.println(s1.length());

        for (int k = ss.length() - 1; k >= 0; k--) {
            byte b1 = (byte) s1.charAt(k);
            byte b2 = (byte) s2.charAt(k);
            int p1 = digitsList.indexOf(b1);
            int p2 = digitsList.indexOf(b2);

            if (p1 + p2 + over >= digits.size()) over = 1;
            //    System.out.println(" digits.size() " + digits.size() + "     " + (p1 + p2 + over) + "   ***  " + (p1 + p2 + over >= digits.size()));
            int p = (p1 + p2) % digits.size();
            byte b = digitsList.get(p);

            if (!lockInt.contains(k)) {
                res.setCharAt(k, (char) b);
                lockInt.add(k);
//                System.out.println(k + "    chr  " + (char) b);
                //  System.out.println(" (p1 + p2 + over)  " + (p1 + p2 + over) + "   chr" + (char) b + "  over " + over + "   k " + k + "res" + res);
            }
            //  System.out.println(k + "   " + lockInt);
            if (over > 0) {
                if (k > 0) {
                    byte prevByte1 = (byte) s1.charAt(k - 1);
                    byte prevByte2 = (byte) s2.charAt(k - 1);
                    int prevInt1 = digitsList.indexOf(prevByte1);
                    int prevInt2 = digitsList.indexOf(prevByte2);
                    int prevIntNew = over + prevInt1 + prevInt2;
                    over = prevIntNew / digits.size();
                    prevIntNew = prevIntNew % digits.size();
                    byte prevByteNew = digitsList.get(prevIntNew);


                    if (!lockInt.contains(k - 1)) {
                        res.setCharAt(k - 1, (char) prevByteNew);
                        lockInt.add(k - 1);

//                        System.out.println("    " + (k - 1) + "   |||   chr  " + (char) prevByteNew);
//                        System.out.println("    ---********       k  " + (k - 1) + "  res  " + res);
//                        System.out.println("||||");
                    }


                }
            }


        }
        return res.toString();
    }

    private String substact(String s1, String s2) {
        //    rebuildDigits();
        int N = 1 + s1.length() + s2.length();
        // System.out.println(s1 + "   ;; :   " + s2);
        s1 = addZerosTo(s1, N);
        s2 = addZerosTo(s2, N);
        String ss = addZerosTo("", s1.length());
        // System.out.println(s1 + "     ---   " + s2);

        boolean mustAddUnit = false;
        StringBuilder res = new StringBuilder(s1);

        for (int k = ss.length() - 1; k >= 0; k--) {
            byte bAdd = 0;
            int pAdd = 0;
            byte b1 = (byte) s1.charAt(k);
            byte b2 = (byte) s2.charAt(k);
            int p1 = digitsList.indexOf(b1);
            int p2 = digitsList.indexOf(b2);
            int p = (p1 - p2);

            mustAddUnit = p < 0;
            if (mustAddUnit) {
                p = digits.size() + p;
                if (k > 0) {
                    bAdd = (byte) s1.charAt(k - 1);
                    pAdd = digitsList.indexOf(bAdd) - 1;
                    if (pAdd < 0) pAdd = digits.size() + pAdd;
                    bAdd = digitsList.get(pAdd);
                    //        System.out.println(bAdd + "   " + pAdd + "    ::  " + "     c      " + s1.charAt(k - 1) + "   " + (char) bAdd);
                    res.setCharAt(k - 1, (char) bAdd);
                }
            }
            byte b = digitsList.get(p);


            res.setCharAt(k, (char) b);
            s1 = res.toString();
        }

        return res.toString();

    }


    private int rcomparateByPos(String sv) {

        if (!this.isNegative && this.value.length() - sv.length() != 0) {
            return this.value.length() - sv.length();
        }
        if (this.isNegative && this.value.length() - sv.length() != 0) {
            return -this.value.length() + sv.length();
        }
        if (this.value.length() == sv.length()) {
            if (!this.isNegative)
                return comparePositive(this.value, sv);
            else return -comparePositive(this.value, sv);
        }
        return 5000;
    }

    private int comparePositive(String value, String sv) {
        for (int k = 0; k < sv.length(); k++) {
            byte b1 = (byte) value.charAt(k);
            int n1 = digitsList.indexOf(b1);
            byte b2 = (byte) sv.charAt(k);
            int n2 = digitsList.indexOf(b2);
            if (n1 == n2) {
                continue;
            } else if (n1 > n2) return 1;
            else return -1;
        }
        return 1000;
    }
}
