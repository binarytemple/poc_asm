package ie.hunt;

import java.io.File;

/**
 * Hello world!
 *
 */
public class AppMain
{

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
