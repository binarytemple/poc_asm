import ie.hunt.aop.conf.AspectConfParser;
import ie.hunt.aop.conf.SimpleNode;

import java.io.IOException;

public class DumpConfMain {

	public static void main(String args[]) throws IOException {
		java.io.InputStream is = null;
		try {
			is = foo.Util.readFile("sample/valid-aspects1.conf");
			AspectConfParser parser = new AspectConfParser(is);
			try {
				SimpleNode n = parser.Start();
				System.out.println("Dumping parse tree");
				n.dump("");
			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.exit(1);
			}
		} finally {
			is.close();
		}
	}
}
