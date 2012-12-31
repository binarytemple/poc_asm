package ie.hunt.aop.conf;

import static org.hamcrest.core.StringStartsWith.startsWith;

import java.io.IOException;
import java.io.StringReader;

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
	public void testMatcherNonTerminalGoodPatterns() throws Throwable {
		AspectConfParser parser = new AspectConfParser(new StringReader("nbl.blah.Blah:wee() -> broadcast;"));
//		thrown.expect(ie.hunt.aop.conf.ParseException.class);
//		thrown.expectMessage("duplicate alias id:log");
		parser.saveAlias("broadcast", "fooBroadcast");
		parser.Matcher();
		parser.ReInit(new StringReader("nbl.**.Blah:foo() -> broadcast;"));
		parser.Matcher();
		parser.ReInit(new StringReader("nbl.*.*.Blah:foo() -> broadcast;"));
		parser.Matcher();
		parser.ReInit(new StringReader("nbl.*.*.:*() -> broadcast;"));
		parser.Matcher();
		//Foolish, but legal...
		parser.ReInit(new StringReader("*:*() -> broadcast;"));
		parser.Matcher();
		
//		Node node = parser.jjtree.popNode();
//		System.err.println(node);
	}
	
	@Test
	public void testMatcherNonTerminalBadPattern1() throws Throwable {
		thrown.expect(ie.hunt.aop.conf.ParseException.class);
		thrown.expectMessage("Encountered \" \"(\" \"( \"\" at line 1");
		AspectConfParser parser = new AspectConfParser(new StringReader("() -> broadcast;"));
		parser.saveAlias("broadcast", "fooBroadcast");
		parser.Matcher();
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
