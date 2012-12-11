package ie.hunt.sample;

@SuppressWarnings("unused")
public class ScratchSampleDAO {
    public String getName(int id) {
        return "dawg!";
    }

    public String getNameButDelegating(int id) {
        CondRet condRet = SampleSingleton.fetchFromCache("ScratchSampleDAO:getNameButDelegating:id");
        if (condRet.o != null) {
            return (String) condRet.o;
        }
        String ret = "dave";
        SampleSingleton.addToCache(id, ret);
        return ret;
    }
}
