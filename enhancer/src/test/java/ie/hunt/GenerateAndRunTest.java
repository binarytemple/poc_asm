package ie.hunt;


import junit.framework.Assert;

import java.lang.reflect.*;

public class GenerateAndRunTest {

    public static void main(String[] args) throws Exception {
        final byte[] b = GenerateHelloWorld.dump();
        Class c = new ClassLoader() {
            Class cc = defineClass("ie.hunt.HelloWorld", b, 0, b.length);
        }.cc;
        GetMessage gm = (GetMessage) c.newInstance();
        Assert.assertEquals("must equal 'hello world'", "hello world", gm.getMessage());
        Method getMessage = c.getMethod("getMessage");
        Assert.assertEquals("must equal 'hello world'", "hello world", getMessage.invoke(gm));


    }
}
