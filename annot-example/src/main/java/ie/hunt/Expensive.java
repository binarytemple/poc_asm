package ie.hunt;

import java.util.Random;

public class Expensive {

    /**
     * Simulate an expensive database operation
     *
     * @param id Unique identifier for this method call.
     * @return the user name
     */
    @Cacheable
    public String slowCalculation(int id) {
        String[] names = {"mark", "bryan", "james", "niels"};
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return names[new Random().nextInt(names.length)];
    }

}
