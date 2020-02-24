package pns.BigNumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SuperLageNumber implements Comparable<SuperLageNumber> {

    private List<Byte> digits = new ArrayList<>();
    private int base;
    private String value;
    private Boolean isNegative = false;

    public SuperLageNumber() {
        generateDigits();
        value = "0";
    }

    public SuperLageNumber(String value) {
        generateDigits();
        value = value.trim();
        if (isCorrectValue(value)) this.value = removeFirstDigitsFrom(value);
    }

    public SuperLageNumber(Set<Byte> extDigits, String value) {
        generateDigits(extDigits);
        if (isCorrectValue(value)) this.value = removeFirstDigitsFrom(value);
    }

    public SuperLageNumber(Set<Byte> extDigits1, Set<Byte> extDigits2, String value) {
        generateDigits(extDigits1, extDigits2);
        if (isCorrectValue(value)) this.value = removeFirstDigitsFrom(value);
    }

    public SuperLageNumber(String value, boolean negative) {
        generateDigits();
        value = value.trim();
        if (isCorrectValue(value)) this.value = removeFirstDigitsFrom(value);
        this.isNegative = negative;
    }

    public SuperLageNumber(Set<Byte> extDigits, String value, boolean negative) {
        generateDigits(extDigits);
        if (isCorrectValue(value)) this.value = removeFirstDigitsFrom(value);
        if (value.equals("0")) negative = false;
        this.isNegative = negative;
    }

    public SuperLageNumber(Set<Byte> extDigits1, Set<Byte> extDigits2, String value, boolean negative) {
        generateDigits(extDigits1, extDigits2);
        if (isCorrectValue(value)) this.value = removeFirstDigitsFrom(value);
        this.isNegative = negative;
    }

    public Boolean isNegative() {
        return isNegative;
    }

    public void setNegative(Boolean negative) {
        isNegative = negative;
    }

    private boolean isCorrectValue(String value) {
        boolean res = true;
        for (int k = 0; k < value.length(); k++) {
            boolean correct = digits.contains((byte) value.charAt(k));
            if (!correct)
                throw new ArithmeticException(" Digit at " + k + " equals to  '" + value.charAt(k) + "' is  incorrect");
        }
        return res;
    }

    private void generateDigits() {
        for (byte k = 48; k < 58; k++) digits.add(k);

        base = digits.size();
    }

    private void generateDigits(Set<Byte> extDigits) {

        generateDigits();

        this.digits.addAll(this.digits.size(), extDigits);
        base = this.digits.size();
    }

    private void generateDigits(Set<Byte> extDigits1, Set<Byte> extDigits2) {

        generateDigits();
        this.digits.addAll(this.digits.size(), extDigits1);
        this.digits.addAll(this.digits.size(), extDigits2);
        base = this.digits.size();
    }

    public List<Byte> getDigits() {
        return digits;
    }

    public int getBase() {
        return base;
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
            return tmpT.substuct(tmpA);
        }
        if (!tmpA.isNegative && tmpT.isNegative) {
            tmpT.isNegative = false;
            return tmpA.substuct(tmpT);
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
        String nc = genCrarSq(tmpSTR1, tmpSTR2);

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
        SuperLageNumber z = new SuperLageNumber("0");

        SuperLageNumber res = clone();
        res.rebuildDigits();
        return z.substuct(res);
    }

    public SuperLageNumber substuct(SuperLageNumber a) {
        a.rebuildDigits();
        this.rebuildDigits();
        SuperLageNumber tmpA = a.clone();
        SuperLageNumber tmpT = this.clone();
        boolean resIsNeg = tmpT.compareTo(tmpA) < 0;

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
            tmpA = tmpA.substuct(tmpT);
            tmpA.setNegative(resIsNeg);
            return tmpA;
        }

        if (resIsNeg) {
            tmpA = tmpA.substuct(tmpT);
            tmpA.setNegative(true);
            return tmpA;
        }
//        System.out.println(this + "    " + a + "  " + resIsNeg);
        String tmpSTR1 = value;
        String tmpSTR2 = a.value;
        if (tmpSTR2.length() < tmpSTR1.length()) {
            tmpSTR2 = addZerosTo(tmpSTR2, tmpSTR1.length() - tmpSTR2.length());
        } else {
            tmpSTR1 = addZerosTo(tmpSTR1,
                    tmpSTR2.length() - tmpSTR1.length());
        }
        String nc = substuct(tmpSTR1, tmpSTR2);
        Set<Byte> tmpDig = new HashSet<>(this.digits);
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

    public SuperLageNumber muliply(SuperLageNumber a) {
        SuperLageNumber tmpT = this.clone();
        SuperLageNumber tmpA = a.clone();
        tmpA.rebuildDigits();
        tmpT.rebuildDigits();
        Set<Byte> stb = new HashSet<>(digits);
        SuperLageNumber res = new SuperLageNumber(stb, "0", false);
        List<SuperLageNumber> superLageNumberList = new ArrayList<>();
        List<String> superLageStrList = new ArrayList<>();
        for (int k = 0; k < tmpA.value.length(); k++) {
            String tmp = multStringOnChar(tmpT.value, tmpA.value.charAt(k));
            tmp = shiftToLeft(tmp, tmpA.value.length() - k - 1);
            SuperLageNumber tmpNum = new SuperLageNumber(stb, tmp);
            superLageNumberList.add(tmpNum);
        }
        for (SuperLageNumber large : superLageNumberList) {
            res = res.add(large);
            //     System.out.println(large + "   res  " + res);
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
        StringBuilder res = new StringBuilder("00000" + value);
        value = res.toString();
        Set<Integer> lockedInt = new HashSet<>();
        byte b = (byte) c;
        int over = 0;
        int fixN = digits.indexOf(b);
        //     System.out.println("   LEN  " + value.length());
        for (int k = value.length() - 1; k >= 0; k--) {

            byte cb = (byte) value.charAt(k);
            int n = digits.indexOf(cb);
            int p = fixN * n;

            //boolean mustToAdd = p >= digits.size();
            int rn = p % digits.size();

            byte cbn = digits.get(rn);
            char ccn = (char) cbn;
            //   System.out.println("   " + ccn);
            if (!lockedInt.contains(k)) res.setCharAt(k, ccn);
            lockedInt.add(k);
            over = p / digits.size();
//            System.out.println(n + " * " + fixN);
//            System.out.println(k + "   res  " + res + "   " + lockedInt);

            if (over > 0) {
                if (k > 0) {
                    //  System.out.println("     k-1  " + (k - 1));
                    byte prevByte = (byte) value.charAt(k - 1);
                    int prevInt = digits.indexOf(prevByte);
                    int prevIntNew = over + prevInt * fixN;
                    byte prevByteNew = digits.get(prevIntNew % digits.size());
                    if (!lockedInt.contains(k - 1)) res.setCharAt(k - 1, (char) prevByteNew);
                    lockedInt.add(k - 1);
//                    System.out.println("      " + over + " + " + prevInt + " * " + fixN);
//                    System.out.println("      " + k + "   res  " + res + "   " + lockedInt);


                    over = prevIntNew / digits.size();
                    if (over > 0) {
                        //      System.out.println("#######====>>>");
                        if (k > 2) {
//                            System.out.println("    " + (k - 2));

                            byte prevByte1 = (byte) value.charAt(k - 2);
                            int prevInt1 = digits.indexOf(prevByte1);
                            int prevIntNew1 = over + prevInt1 * fixN;
                            byte prevByteNew1 = digits.get(prevIntNew1 % digits.size());

                            if (!lockedInt.contains(k - 2)) res.setCharAt(k - 2, (char) prevByteNew1);
                            lockedInt.add(k - 2);
//                            System.out.println("               " + over + " + " + prevInt1 + " * " + fixN);
//                            System.out.println("               " + k + "   res  " + res + "   " + lockedInt);


                        }
                    }
                }
            }


        }
        //    System.out.println(over + "  res  " + res.toString());

        return res.toString();
    }

    private String shiftToLeft(String s, int N) {
        StringBuilder res = new StringBuilder(s);
        for (int k = 0; k < N; k++) res.append(0);
        return res.toString();
    }


    @Override
    public String toString() {
        String res = value;
        if (isNegative) res = '-' + value;
        return res;
    }


    public SuperLageNumber clone() {
        Set<Byte> ss = new HashSet<>(digits);
        return new SuperLageNumber(ss, value, isNegative);
    }


    @Override
    public int compareTo(SuperLageNumber sln) {

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

    private String genCrarSq(String s1, String s2) {
        s1 = addZerosTo(s1, 2);
        s2 = addZerosTo(s2, 2);
        String ss = addZerosTo("", s1.length());

        StringBuilder res = new StringBuilder(ss);
        int over = 0;
        Set<Integer> lockInt = new HashSet<>();
//        System.out.println(s1 + "  + " + s2);
//        System.out.println(s1.length());

        for (int k = s1.length() - 1; k >= 0; k--) {
            byte b1 = (byte) s1.charAt(k);
            byte b2 = (byte) s2.charAt(k);
            int p1 = digits.indexOf(b1);
            int p2 = digits.indexOf(b2);

            over = (p1 + p2 + over) / digits.size();
            int p = (p1 + p2) % digits.size();
            byte b = digits.get(p);

            if (!lockInt.contains(k)) {
                res.setCharAt(k, (char) b);
                lockInt.add(k);
//
//                System.out.println(k + "    chr  " + (char) b);
//                System.out.println(k + "  over " + over + "  @@@----  ----k " + k + "  res  " + res);
            }

            if (over > 0) {
                if (k > 0) {
                    byte prevByte1 = (byte) s1.charAt(k - 1);
                    byte prevByte2 = (byte) s2.charAt(k - 1);
                    int prevInt1 = digits.indexOf(prevByte1);
                    int prevInt2 = digits.indexOf(prevByte2);
                    int prevIntNew = over + prevInt1 + prevInt2;
                    over = prevIntNew / digits.size();
                    prevIntNew = prevIntNew % digits.size();
                    byte prevByteNew = digits.get(prevIntNew);

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


    private String substuct(String s1, String s2) {
        int N = 1 + s1.length() + s2.length();
        // System.out.println(s1 + "   ;; :   " + s2);
        s1 = addZerosTo("0", N) + s1;
        s2 = addZerosTo("0", N) + s2;
        // System.out.println(s1 + "     ---   " + s2);

        boolean mustAddUnit = false;
        StringBuilder res = new StringBuilder(s1);
        for (int k = s1.length() - 1; k >= 0; k--) {
            //   System.out.println(k + "    s1 " + s1.substring(0, k + 1) + "    s2 " + s2.substring(0, k + 1));
            byte bAdd = 0;
            int pAdd = 0;
            byte b1 = (byte) s1.charAt(k);
            byte b2 = (byte) s2.charAt(k);
            int p1 = digits.indexOf(b1);
            int p2 = digits.indexOf(b2);
            int p = (p1 - p2);
//            System.out.println(k + "  " + p1 + "   " + p2 + "   1   " + s1.charAt(k) + "   2   " + s2.charAt(k) + "   " + p);
            mustAddUnit = p < 0;
            if (mustAddUnit) {
                p = digits.size() + p;
                if (k > 0) {
                    bAdd = (byte) s1.charAt(k - 1);
                    pAdd = digits.indexOf(bAdd) - 1;
                    if (pAdd < 0) pAdd = digits.size() + pAdd;
                    bAdd = digits.get(pAdd);
                    //               System.out.println(bAdd + "   " + pAdd + "    ::  " + "     c      " + s1.charAt(k - 1) + "   " + (char) bAdd);
                    res.setCharAt(k - 1, (char) bAdd);
                }
            }
            byte b = digits.get(p);

            res.setCharAt(k, (char) b);
            s1 = res.toString();
            //       System.out.println("          k  " + k + "             res " + res);
        }

        return res.toString();
    }

    private void rebuildDigits() {
        Set<Byte> ss = new HashSet<>(digits);
        digits.clear();
        digits.addAll(ss);
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
        System.out.println(value + ";   " + sv);
        for (int k = 0; k < sv.length(); k++) {
            byte b1 = (byte) value.charAt(k);
            int n1 = digits.indexOf(b1);
            byte b2 = (byte) sv.charAt(k);
            int n2 = digits.indexOf(b2);
            if (n1 == n2) {
                continue;
            } else if (n1 > n2) return 1;
            else return -1;
        }
        return 1000;
    }
}
