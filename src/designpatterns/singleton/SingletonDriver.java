package designpatterns.singleton;

public class SingletonDriver {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            SingletonBlockSynchronized instance1 = SingletonBlockSynchronized.getInstance();
            System.out.println(instance1);
        });

        Thread t2 = new Thread(() -> {
            SingletonBlockSynchronized instance2 = SingletonBlockSynchronized.getInstance();
            System.out.println(instance2);
        });

        t1.start();
        t2.start();
    }
}
