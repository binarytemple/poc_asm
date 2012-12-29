import java.io.IOException;

import farf.EG2;
import farf.SimpleNode;

public class AspectParserMain {

	public static void main(String args[]) throws IOException {
		java.io.InputStream is = null;
		try {
			is = foo.Util.readFile("sample/aspects.conf");
			EG2 parser = new EG2(is);
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
