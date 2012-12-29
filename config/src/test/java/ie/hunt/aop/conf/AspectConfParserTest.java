package ie.hunt.aop.conf;

import static org.hamcrest.core.StringStartsWith.startsWith;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AspectConfParserTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParseWithMissingAlias() throws Throwable {
		thrown.expect(ie.hunt.aop.conf.ParseException.class);
		thrown.expectMessage("'madeup'");
		thrown.expectMessage(startsWith("Missing alias"));
		parseFile("sample/bad-aspects1.conf");
	}

	@Test
	public void testParseWithDuplicateAlias() throws Throwable {
		thrown.expect(ie.hunt.aop.conf.ParseException.class);
		thrown.expectMessage("duplicate alias id:log");
		// thrown.expectMessage(startsWith("Missing alias"));
		parseFile("sample/bad-aspects2.conf");
	}

	private void parseFile(String name) throws Exception, IOException {
		java.io.InputStream is = null;
		try {
			is = foo.Util.readFile(name);
			AspectConfParser parser = new AspectConfParser(is);
			try {
				SimpleNode n = parser.Start();
				n.dump("");
			} catch (Exception e) {
				throw e;
			}
		} finally {
			is.close();
		}
	}

}
