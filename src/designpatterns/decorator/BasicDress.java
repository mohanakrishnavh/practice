package designpatterns.decorator;

/**
 * Concrete implementation of the Dress interface representing a basic dress.
 * This class serves as the base component in the Decorator pattern,
 * providing the core functionality that can be enhanced with decorators.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class BasicDress implements Dress {
    
    /**
     * Assembles the basic dress with its fundamental features.
     * This method prints the basic dress features to the console.
     */
    @Override
    public void assemble() {
        System.out.println("Basic Dress Features");
    }
}
