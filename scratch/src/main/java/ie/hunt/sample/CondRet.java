package ie.hunt.sample;

public class CondRet {
    public final Object o;

    public CondRet(Object o) {
        this.o = o;
    }

    public boolean hasResult() {
        return o != null;
    }
}
