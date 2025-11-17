package designpatterns.structural.bridge;

/**
 * Refined abstraction representing a Phillips TV.
 * This class extends TV and provides Phillips-specific implementation
 * while delegating remote control operations to the Remote implementor.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class PhillipsTV extends TV {
    private Remote remoteType;

    /**
     * Constructs a PhillipsTV with the specified remote control.
     *
     * @param remote the remote control implementation to use
     */
    public PhillipsTV(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }

    /**
     * Turns on the Phillips TV and delegates to the remote control.
     */
    @Override
    void on() {
        System.out.println("Phillips TV On");
        remoteType.on();
    }

    /**
     * Turns off the Phillips TV and delegates to the remote control.
     */
    @Override
    void off() {
        System.out.println("Phillips TV Off");
        remoteType.off();
    }
}
