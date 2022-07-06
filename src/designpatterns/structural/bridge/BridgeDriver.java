package designpatterns.structural.bridge;

public class BridgeDriver {

    public static void main(String[] args) {
        SonyTV sonyTVWithOldRemote = new SonyTV(new OldRemote());
        sonyTVWithOldRemote.on();
        sonyTVWithOldRemote.off();
        System.out.println();

        SonyTV sonyTVWithNewRemote = new SonyTV(new NewRemote());
        sonyTVWithNewRemote.on();
        sonyTVWithNewRemote.off();
        System.out.println();

        PhillipsTV phillipsTVWithOldRemote = new PhillipsTV(new OldRemote());
        phillipsTVWithOldRemote.on();
        phillipsTVWithOldRemote.off();
        System.out.println();

        PhillipsTV phillipsTVWithNewRemote = new PhillipsTV(new NewRemote());
        phillipsTVWithNewRemote.on();
        phillipsTVWithNewRemote.off();
        System.out.println();
    }

}
