package designpatterns.structural.bridge;

public class PhillipsTV extends TV {
    Remote remoteType;

    public PhillipsTV(Remote remote) {
        super(remote);
        this.remoteType = remote;
    }

    @Override
    void on() {
        System.out.println("Phillips TV On");
        remoteType.on();
    }

    @Override
    void off() {
        System.out.println("Phillips TV Off");
        remoteType.off();
    }
}
