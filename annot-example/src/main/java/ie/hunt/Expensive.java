package ie.hunt;

import java.util.Random;

public class Expensive {

    @Cacheable
    public int slowCalculation(){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return new Random().nextInt(Integer.MAX_VALUE);
    }

}
