package pns.BigNumbers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ISuperNumber implements Serializable {

    protected Set<Byte> digits = new HashSet<>();
    protected int base;
    protected List<Byte> digitsList = new ArrayList<>();

    public Set<Byte> getDigits() {
        return digits;
    }

    public int getBase() {
        return base;
    }


    protected void generateDigits() {
        digitsList.clear();
        for (byte k = 48; k < 58; k++) digits.add(k);
        digitsList.addAll(digits);
        base = digits.size();
    }

    protected void generateDigits(Set<Byte> extDigits) {
        generateDigits();
        this.digitsList.addAll(this.digits.size(), extDigits);
        base = this.digits.size();
    }

    protected void generateDigits(Set<Byte> extDigits1, Set<Byte> extDigits2) {
        generateDigits();
//        this.digits.addAll(this.digits.size(), extDigits1);
//        this.digits.addAll(this.digits.size(), extDigits2);
        base = this.digits.size();
    }

    protected void rebuildDigits() {
//        generateDigits();
//        System.out.println("   DIG   " + digits);
//        List<Byte> ss = new ArrayList<>();
//        for (int k = 0; k < digits.size(); k++) {
//            // System.out.println(k + "   " + digits.get(k));
//            ss.add(digits.get(k));
//        }
////        System.out.println("  -- SS   " + ss);
//        digits.clear();
//        digits.addAll(ss);
    }

}
