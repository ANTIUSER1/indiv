package pns.BigNumbers;

import java.math.BigDecimal;

public class BigPare<F extends BigDecimal, S extends BigDecimal> {

    protected F first;
    protected S second;

    public BigPare(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public BigPare() {
        first = (F) new BigDecimal(0);
        second = (S) new BigDecimal(0);
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
