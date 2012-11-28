package ie.hunt;

/**
 * Run an expensive operation multiple times...
 */
public class App {
    public static void main(String[] args) {
        Expensive expensive = new Expensive();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(expensive.slowCalculation(i));
            }
        }
    }
}
