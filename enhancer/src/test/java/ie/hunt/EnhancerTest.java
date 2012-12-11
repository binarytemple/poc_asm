package ie.hunt;

import enhancer.EnhancingClassAdapter;
import enhancer.GenericCache;
import enhancer.MethodKey;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.io.IOUtils;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Unit test for simple App.
 */
public class EnhancerTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public EnhancerTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(EnhancerTest.class);
    }

    /**
     * Test we can put and retrive from the cache.
     */
    public void testCache() {
        MethodKey m = new MethodKey("aclass", "amethod", new Object[]{1, "fads", new Object()});
        String mValue = "my fancy value";
        MethodKey m1 = new MethodKey("aclass", "amethod1", new Object[]{1, "fads", new Object()});
        String mValue1 = "my fancy value1";
        MethodKey m2 = new MethodKey("aclass", "amethod2", new Object[]{1, "fads", new Object()});
        String mValue2 = "my fancy value2";

        GenericCache.setValue(m, mValue);
        GenericCache.setValue(m1, mValue1);
        GenericCache.setValue(m2, mValue2);

        assertEquals(GenericCache.getValue(m), mValue);
        assertEquals(GenericCache.getValue(m1), mValue1);
        assertEquals(GenericCache.getValue(m2), mValue2);
    }

    public void testEnhanceHelloWorld() throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //TODO: Load into method reader
        InputStream inputStream = HelloWorld.class.getClassLoader().getResourceAsStream("ie/hunt/HelloWorld.class");
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, ba);
        byte[] bytes = ba.toByteArray();

        ClassReader reader = new ClassReader(bytes);

        /*
          How do I make ASM calculate visitMaxs for me?
          http://asm.ow2.org/doc/faq.html#Q3
         */
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        ClassAdapter adapter = new EnhancingClassAdapter(writer, "ie.hunt.HelloWorld");
        reader.accept(adapter, 0);
        final byte[] result = writer.toByteArray();

        Class cc = new ClassLoader() {
            Class cc = defineClass("ie.hunt.HelloWorld", result, 0, result.length);
        }.cc;

        Object o = cc.newInstance();

        Method getValue = cc.getMethod("getValue");

        getValue.invoke(o);

    }

}
