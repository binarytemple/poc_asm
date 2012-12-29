import ie.hunt.aop.conf.AspectConfParser;
import ie.hunt.aop.conf.SimpleNode;

import java.io.IOException;

public class AspectParserMain {

	public static void main(String args[]) throws IOException {
		java.io.InputStream is = null;
		try {
			is = foo.Util.readFile("sample/bad-aspects1.conf");
			AspectConfParser parser = new AspectConfParser(is);
			try {
				SimpleNode n = parser.Start();
				n.dump("");
				System.out.println("Thank you.");
			} catch (Exception e) {
				System.out.println("Oops.");
				System.out.println(e.getMessage());
			}
		} finally {
			is.close();
		}
	}
}
