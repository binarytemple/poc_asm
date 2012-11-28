package ie.hunt;

import ie.hunt.sample.ScratchSampleDAO;

/**
 * Hello world!
 */
public class ScratchApp {
    public static void main(String[] args) {
        ScratchSampleDAO d = new ScratchSampleDAO();
        System.out.println(d.getNameButDelegating(10));
    }
}
