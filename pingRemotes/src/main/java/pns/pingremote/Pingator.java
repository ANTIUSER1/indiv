package pns.pingremote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Pingator {
    private int timeout = 3;
    private long timeofPing = 0L;
    private int attemptsNumber;
    private SecureRandom sr = new SecureRandom();

    public Pingator() {
        attemptsNumber = 10;
    }

    public Pingator(int attemptsNumber) {
        this.attemptsNumber = attemptsNumber;
    }

    public long avgDelayMoments(String host) {
        List<Long> tmp = pingMany(host);
        return Math.round(
                tmp.stream().mapToLong(v -> v).average().getAsDouble());
    }

    public List<Long> pingMany(String host) {
        List<Long> res = new ArrayList<>();
        for (int k = 0; k < attemptsNumber; k++) {
            try {
                if (host.startsWith("http".toLowerCase())) {
                    res.add(ping(host));
                } else {
                    res.add(sendPingRequest(host));
                }
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }
        System.out.println(res);
        return res;
    }

    private long ping(String host) throws Exception {
        long ts = System.nanoTime();
        long res = Math.abs(sr.nextLong());
        URL url = new URL(host);

        URLConnection uc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                uc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            res += inputLine.trim().length();

        in.close();
        res += System.nanoTime() - ts;
        System.out.println(res);
        return res;

    }

    public long sendPingRequest(String ipAddress)
            throws UnknownHostException, IOException {
        long ts = System.nanoTime();
        InetAddress addr = InetAddress.getByName(ipAddress);
        //   System.out.println("Sending Ping Request to " + ipAddress);
        addr.isReachable(5000);
        long res = (System.nanoTime() - ts + Math.abs(sr.nextLong()));
        return res;
    }

}