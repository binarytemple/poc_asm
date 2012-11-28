package profiler;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		File dir = new File(".");
		String[] list = dir.list();
		
		for (String file: list) {
			System.out.println(file);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
            }
		}

	}

}
