package designpatterns.structural.bridge;

/**
 * Implementor interface in the Bridge design pattern.
 * Defines the interface for implementation classes (remote controls).
 * This interface is independent of the abstraction (TV) hierarchy.
 *
 * @author Practice Repository
 * @version 1.0
 */
public interface Remote {
    
    /**
     * Turns on the device.
     */
    void on();
    
    /**
     * Turns off the device.
     */
    void off();
}
