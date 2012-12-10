package ie.hunt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloWorld implements GetMessage {

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

    public Object multiParamCall(int a, String b, Object c, Long d, boolean e, String sc1, String sd1, String se1, String sf1, String sg1, String sh1, String si1, String sj1, String sb1, String sk1, String sl1) {
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