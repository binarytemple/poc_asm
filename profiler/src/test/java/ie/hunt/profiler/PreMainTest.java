package sample.profiler;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for PreMain
 */
public class PreMainTest
        extends TestCase
{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PreMainTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PreMainTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPremain()
    {
        Assert.assertTrue(true);
    }
}