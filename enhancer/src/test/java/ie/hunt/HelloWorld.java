package ie.hunt;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class HelloWorld implements GetMessage {

    public String getValue() {
        InputStream inputStream = null;
        try {
            URL url = new URL("http://binarytemple.co.uk");
            StringBuilder buffer = new StringBuilder();
            inputStream = url.openStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            char[] input = new char[1024 * 1024];
            int res;
            while ((res = isr.read(input)) != -1) {
                buffer.append(input, 0, res);
            }
            return buffer.toString();
        } catch (Throwable t) {
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getMessage() {
        return "hello world";
    }

    public String getRandomMessage() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return random.nextInt() + "hello world";
        } else {
            return "goodbye world";
        }
    }

    public Object multiParamCall(int a, String b,
                                 Object c, Long d,
                                 boolean e, String sc1,
                                 String sd1, String se1,
                                 String sf1, String sg1,
                                 String sh1, String si1,
                                 String sj1, String sb1,
                                 String sk1, String sl1) {
        ArrayList l = new ArrayList();
        l.add(a);
        l.add(b);
        l.add(c);
        l.add(d);
        l.add(e);
        l.add(sc1);
        l.add(sd1);
        l.add(se1);
        l.add(sf1);
        l.add(sg1);
        l.add(sh1);
        l.add(si1);
        l.add(sj1);
        l.add(sb1);
        l.add(sk1);
        l.add(sl1);
        System.out.println(new Object[]{"HelloWorld", "multiParamCall", l});
        return new Object();
    }
}