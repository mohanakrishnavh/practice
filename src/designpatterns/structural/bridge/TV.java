package designpatterns.structural.bridge;

/**
 * Abstraction in the Bridge design pattern.
 * This abstract class defines the interface for TV devices and maintains
 * a reference to a Remote (implementor). The bridge allows the TV hierarchy
 * and Remote hierarchy to vary independently.
 *
 * @author Practice Repository
 * @version 1.0
 */
public abstract class TV {
    /** The remote control implementation used by this TV */
    protected Remote remote;

    /**
     * Constructs a TV with the specified remote control.
     *
     * @param remote the remote control implementation to use
     */
    TV(Remote remote) {
        this.remote = remote;
    }

    /**
     * Turns on the TV.
     * Subclasses must implement this method to define specific behavior.
     */
    abstract void on();
    
    /**
     * Turns off the TV.
     * Subclasses must implement this method to define specific behavior.
     */
    abstract void off();
}
