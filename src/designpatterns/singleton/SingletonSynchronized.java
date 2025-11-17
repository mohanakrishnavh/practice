package designpatterns.singleton;

/**
 * Thread-safe Singleton implementation using synchronized method.
 * This approach ensures thread safety by synchronizing the entire getInstance() method.
 * 
 * <p><b>Note:</b> While thread-safe, this approach has performance overhead
 * because synchronization is required on every call to getInstance(),
 * even after the instance has been created.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class SingletonSynchronized {
    private static SingletonSynchronized instance;

    /**
     * Private constructor to prevent external instantiation.
     */
    private SingletonSynchronized() {
    }

    /**
     * Returns the singleton instance in a thread-safe manner.
     * The entire method is synchronized, ensuring only one thread
     * can execute it at a time.
     *
     * @return the singleton instance of SingletonSynchronized
     */
    public static synchronized SingletonSynchronized getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronized();
        }
        return instance;
    }
}
