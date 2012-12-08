package ie.hunt;

import java.io.File;

/**
 * Hello world!
 *
 */
public class AppMain
{

    public static void main(String[] args) {
        AppMain am = new AppMain();
        File dir = new File(".");
        String[] list = am.getFileNames(dir);
        for (String file: list) {
            System.out.println(file);
        }
    }


    private String[] getFileNames(File dir) {
        String[] list = dir.list();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
