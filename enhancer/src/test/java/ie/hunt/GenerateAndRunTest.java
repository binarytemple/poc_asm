package ie.hunt;


import junit.framework.Assert;

public class GenerateAndRunTest {

    public static void main(String[] args) throws Exception {
        final byte[] b = GenerateHelloWorld.dump();

        GetMessage gm = (GetMessage) new ClassLoader() {
            Class cc = defineClass("ie.hunt.HelloWorld", b, 0, b.length);
        }.cc.newInstance();

        Assert.assertEquals("must equal 'hello world'", "hello world", gm.getMessage());
    }
}
