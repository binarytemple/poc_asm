package ie.hunt;

import junit.framework.Assert;
import org.junit.*;
import sun.plugin.navig.motif.OJIPlugin;

import java.lang.reflect.Method;

public class GenerateHelloWorldTest {

    static Class clazz;

    @BeforeClass
    public static void setUp() throws Exception {

        final byte[] b = GenerateHelloWorld.dump();
        clazz = new ClassLoader() {
            Class cc = defineClass("ie.hunt.HelloWorld", b, 0, b.length);
        }.cc;
    }

    @Test
    public void testGetValue() throws Exception {
        GetMessage gm = (GetMessage) clazz.newInstance();
        Assert.assertTrue("must have content", gm.getValue().length() > 1000);
    }

    @Test
    public void testMultiParamCall() throws Exception {
        GetMessage gm = (GetMessage) clazz.newInstance();
        gm.multiParamCall
                (
                        1, "b",
                        new Object(), 1l,
                        false, "sc1",
                        "sd1", "se1",
                        "sf1", "sg1",
                        "sh1", "si1",
                        "sj1", "sb1",
                        "sk1", "sl1"
                );
    }

    @Test
    public void testDump() throws Exception {
        GetMessage gm = (GetMessage) clazz.newInstance();
        Assert.assertEquals("must equal 'hello world'", "hello world", gm.getMessage());
    }

    @Test
    @SuppressWarnings(value = "unchecked")
    public void testDumpWithReflection() throws Exception {
        Object o = clazz.newInstance();
        Method getMessage = clazz.getMethod("getMessage");
        Assert.assertEquals("must equal 'hello world'", "hello world", getMessage.invoke(o));
    }

}
