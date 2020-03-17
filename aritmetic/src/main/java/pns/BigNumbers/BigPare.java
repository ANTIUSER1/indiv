package pns.BigNumbers;

import java.util.HashSet;
import java.util.Set;

public class BigPare<F extends SuperLageNumber, S extends SuperLageNumber> implements ISuperPare {

    protected Set<Byte> digits = new HashSet<>();

    protected F first;
    protected S second;

    public BigPare(F first, S second) {
        this.first = first;
        this.first.rebuildDigits();
        this.second = second;
        this.second.rebuildDigits();
        if (!first.digits.equals(second.digits)) throw new ArithmeticException("Digits set are not equals");
        digits = first.digits;
    }

    public BigPare() {
        first = (F) new SuperLageNumber("0");
        second = (S) new SuperLageNumber("0");
    }

    public BigPare(BigPare source) {
        first = (F) source.first;
        second = (S) source.second;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "BigPare{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
