package designpatterns.singleton;

public class SingletonBlockSynchronized {
    private static volatile SingletonBlockSynchronized instance;

    private SingletonBlockSynchronized() {}

    public static SingletonBlockSynchronized getInstance() {
        if (instance == null) {
            synchronized (SingletonBlockSynchronized.class) {
                if (instance == null) {
                    instance = new SingletonBlockSynchronized();
                }
            }
        }

        return instance;
    }
}
