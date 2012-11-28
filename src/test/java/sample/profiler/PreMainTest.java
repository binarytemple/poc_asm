package sample.profiler;

import ie.hunt.AppTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
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
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPremain()
    {
        assertTrue( true );
    }
}