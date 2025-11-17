package designpatterns.decorator;

/**
 * Component interface in the Decorator pattern.
 * Defines the contract that all dress objects (both concrete components
 * and decorators) must implement.
 *
 * @author Practice Repository
 * @version 1.0
 */
public interface Dress {
    
    /**
     * Assembles the dress with its features.
     * Concrete implementations and decorators will provide
     * specific behaviors for this method.
     */
    void assemble();
}
