package designpatterns.structural.bridge;

/**
 * Concrete implementation of Remote representing a new-generation remote control.
 * This class provides a specific implementation of the Remote interface
 * with modern features.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class NewRemote implements Remote {
    
    /**
     * Turns on the device using the new remote.
     */
    @Override
    public void on() {
        System.out.println("On with NewRemote");
    }

    /**
     * Turns off the device using the new remote.
     */
    @Override
    public void off() {
        System.out.println("Off with NewRemote");
    }
}
