package foo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class Util {

	/**
	 * Given a path, try to read a files contents to a
	 * {@link BufferedInputStream} . If the file does not exist, try to read it
	 * from the classpath instead.
	 * 
	 * @param name
	 * @return
	 */
	public static BufferedInputStream readFile(String name) {
		java.io.BufferedInputStream buf = null;
		if (new File(name).exists()) {
			java.io.FileInputStream fis = null;
			try {
				fis = new java.io.FileInputStream(name);
				buf = new java.io.BufferedInputStream(fis);
				return buf;
			} catch (Throwable t) {
				throw new RuntimeException(t);
			}
		} else {
			URL resource = Util.class.getClassLoader().getResource(name);
			try {
				InputStream openStream = resource.openStream();

				buf = new java.io.BufferedInputStream(openStream);
				return buf;
			} catch (Throwable t) {
				throw new RuntimeException(t);
			}
		}
	}
}
