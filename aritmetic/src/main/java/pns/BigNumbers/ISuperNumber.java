package pns.BigNumbers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ISuperNumber implements Serializable {

    protected List<Byte> digits = new ArrayList<>();
    protected int base;

    public List<Byte> getDigits() {
        return digits;
    }

    public int getBase() {
        return base;
    }


    protected void generateDigits() {
        for (byte k = 48; k < 58; k++) digits.add(k);
        base = digits.size();
    }

    protected void generateDigits(Set<Byte> extDigits) {
        generateDigits();
        this.digits.addAll(this.digits.size(), extDigits);
        base = this.digits.size();
    }

    protected void generateDigits(Set<Byte> extDigits1, Set<Byte> extDigits2) {
        generateDigits();
        this.digits.addAll(this.digits.size(), extDigits1);
        this.digits.addAll(this.digits.size(), extDigits2);
        base = this.digits.size();
    }

    protected void rebuildDigits() {
        //System.out.println("   DIG   " + digits);
        Set<Byte> ss = new HashSet<>(digits);
        //System.out.println("  -- SS   " + ss);
        digits.clear();
        digits.addAll(ss);
    }

}
