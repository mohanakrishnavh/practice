package designpatterns.structural.bridge;

/**
 * Client class demonstrating the Bridge design pattern.
 * This class shows how the TV abstraction and Remote implementation
 * hierarchies can vary independently. Any TV can work with any Remote.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class BridgeDriver {

    /**
     * Main method to demonstrate bridge pattern usage.
     * Creates various combinations of TVs and Remotes to show
     * the flexibility provided by the Bridge pattern.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Sony TV with Old Remote
        SonyTV sonyTVWithOldRemote = new SonyTV(new OldRemote());
        sonyTVWithOldRemote.on();
        sonyTVWithOldRemote.off();
        System.out.println();

        // Sony TV with New Remote
        SonyTV sonyTVWithNewRemote = new SonyTV(new NewRemote());
        sonyTVWithNewRemote.on();
        sonyTVWithNewRemote.off();
        System.out.println();

        // Phillips TV with Old Remote
        PhillipsTV phillipsTVWithOldRemote = new PhillipsTV(new OldRemote());
        phillipsTVWithOldRemote.on();
        phillipsTVWithOldRemote.off();
        System.out.println();

        // Phillips TV with New Remote
        PhillipsTV phillipsTVWithNewRemote = new PhillipsTV(new NewRemote());
        phillipsTVWithNewRemote.on();
        phillipsTVWithNewRemote.off();
        System.out.println();
    }
}
