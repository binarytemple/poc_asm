package ie.hunt;

import enhancer.GenericCache;
import enhancer.MethodKey;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
}
