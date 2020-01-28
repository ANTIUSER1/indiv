package pns.start;

import pns.pingremote.Pingator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 1) {
            Pingator pp = new Pingator(3);
            List<Long> llo = pp.pingMany(args[0]);

            long avg = pp.avgDelayMoments(args[0]);
            System.out.println(avg);
        }
    }

}
