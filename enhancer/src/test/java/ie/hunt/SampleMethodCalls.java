package ie.hunt;

import enhancer.GenericCache;
import enhancer.MethodKey;

@SuppressWarnings("unused")
public class SampleMethodCalls {

    public int getSomeValue(String in) {
        MethodKey m = new MethodKey("SampleMethodCalls", "getSomeValue", new Object[]{in});
        Object ret = GenericCache.getValue(m);
        if (ret != null) {
            return (Integer) ret;
        } else {
            int retval = 10;
            GenericCache.setValue(m, retval);
            return retval;
        }
    }

}
