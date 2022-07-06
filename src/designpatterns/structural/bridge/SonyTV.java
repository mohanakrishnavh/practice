package designpatterns.structural.bridge;

public class SonyTV extends TV {
    Remote remoteType;

    public SonyTV(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }

    @Override
    public void on() {
        System.out.println("Sony TV On");
        remoteType.on();
    }

    @Override
    public void off() {
        System.out.println("Sony TV Off");
        remoteType.off();
    }
}
