package ie.hunt;

import enhancer.Returner;

public class StaticDecider {


    public static Returner decide(String clazz,String method, Object [] args) {

        if(args.length > 1 && args[0] instanceof Integer) {
            return new Returner(false,"world");
        }
        else {
            return new Returner(true,null);
        }

    }
}
