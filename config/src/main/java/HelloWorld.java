import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.nio.file.*;

public class HelloWorld {

	ConcurrentMap<String, Object> m = new ConcurrentHashMap<String, Object>();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		 
		java.io.FileInputStream fis = null ;
		java.io.BufferedInputStream buf = null;
		try {
			fis = new java.io.FileInputStream("./test/aspects.conf");
			buf = new java.io.BufferedInputStream(fis);	
		}finally {
			buf.close();
		}
		
		new java.io.ByteArrayInputStream("dsadsadsa".getBytes());
		int i = 100;
		HelloWorld h = new HelloWorld();
		System.err.println(h.runOp(i));
		h.runconc();

		PrintStream p = System.out;

		p.append("asddsadsadsa\n", 0, 5);
		// p.close();
		p.println("wee");

		Path path = Paths.get("/tmp/tests");

		//
		//
//		FileChannel open = FileChannel.open(path, StandardOpenOption.WRITE,
//				StandardOpenOption.APPEND, StandardOpenOption.CREATE);

		// FileOutputStream fs = new FileOutputStream(new
		// File("/dev/stdout"));// path.toFile());
		FileOutputStream fs = new FileOutputStream(path.toFile());

		fs.write("eeeeeeeeeeeeeeeeeeeee".getBytes());
		fs.flush();

		PrintStream nps = new PrintStream(new BufferedOutputStream(fs), true);

		System.setOut(nps);
		p.close();

		System.out.println("**********");

	}

	private Object runconc() {
		return m.putIfAbsent("dave", 1);
	}

	private int runOp(int i) {
		if (Cache.hasValue(i)) {
			return (Integer) Cache.getValue(i);
		} else {
			int val = 1;
			val = val++;
			Cache.setValue(i, val);
			return (int) val;
		}
	}
}
