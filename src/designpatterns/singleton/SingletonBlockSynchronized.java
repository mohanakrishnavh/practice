package designpatterns.singleton;

public class SingletonBlockSynchronized {
    private static volatile SingletonBlockSynchronized instance;

    private SingletonBlockSynchronized() {
    }

    public static SingletonBlockSynchronized getInstance() {
        if (instance == null) {
            // Double-Checked Locking
            synchronized (SingletonBlockSynchronized.class) {
                if (instance == null) {
                    instance = new SingletonBlockSynchronized();
                }
            }
        }

        return instance;
    }
}
