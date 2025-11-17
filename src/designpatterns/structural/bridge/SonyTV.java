package designpatterns.structural.bridge;

/**
 * Refined abstraction representing a Sony TV.
 * This class extends TV and provides Sony-specific implementation
 * while delegating remote control operations to the Remote implementor.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class SonyTV extends TV {
    private Remote remoteType;

    /**
     * Constructs a SonyTV with the specified remote control.
     *
     * @param remote the remote control implementation to use
     */
    public SonyTV(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }

    /**
     * Turns on the Sony TV and delegates to the remote control.
     */
    @Override
    public void on() {
        System.out.println("Sony TV On");
        remoteType.on();
    }

    /**
     * Turns off the Sony TV and delegates to the remote control.
     */
    @Override
    public void off() {
        System.out.println("Sony TV Off");
        remoteType.off();
    }
}
