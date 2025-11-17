package designpatterns.decorator;

/**
 * Client class demonstrating the Decorator design pattern.
 * This class shows how decorators can be stacked to add
 * multiple features to a basic dress object dynamically.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class Client {
    
    /**
     * Main method to demonstrate decorator pattern usage.
     * Creates different combinations of decorated dresses to show
     * how features can be added dynamically at runtime.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Creating a sporty version of a basic dress
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        
        System.out.println();

        // Creating a sporty and fancy version of a basic dress
        // Demonstrates stacking multiple decorators
        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble();
    }
}
