package ie.hunt.sample;

@SuppressWarnings("unused")
public class SampleSingleton {

    public static CondRet fetchFromCache(Object o) {
        return new CondRet("bryan");
    }

    public static void addToCache(int id, String ret) {
        //No need to implement, just an ilustration.
    }
}
