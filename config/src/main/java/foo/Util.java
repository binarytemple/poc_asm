package foo;
import java.io.BufferedInputStream;

public class Util {

	public static BufferedInputStream readFile(String name) {
		java.io.FileInputStream fis = null;
		java.io.BufferedInputStream buf = null;
		try {
			fis = new java.io.FileInputStream(name);
			buf = new java.io.BufferedInputStream(fis);
			return buf;
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
