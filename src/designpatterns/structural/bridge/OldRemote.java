package designpatterns.structural.bridge;

/**
 * Concrete implementation of Remote representing an old-style remote control.
 * This class provides a specific implementation of the Remote interface.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class OldRemote implements Remote {
    
    /**
     * Turns on the device using the old remote.
     */
    @Override
    public void on() {
        System.out.println("On with Old Remote");
    }

    /**
     * Turns off the device using the old remote.
     */
    @Override
    public void off() {
        System.out.println("Off with Old Remote");
    }
}
