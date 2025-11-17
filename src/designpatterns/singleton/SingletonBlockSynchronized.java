package designpatterns.singleton;

/**
 * Thread-safe Singleton implementation using Double-Checked Locking.
 * This is the most efficient thread-safe singleton implementation,
 * combining lazy initialization with minimal synchronization overhead.
 * 
 * <p>The volatile keyword ensures that changes to the instance variable
 * are immediately visible to all threads, preventing issues with instruction
 * reordering by the JVM.
 * 
 * <p>Double-checked locking reduces synchronization overhead by checking
 * the instance twice: once without locking and once with locking.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class SingletonBlockSynchronized {
    private static volatile SingletonBlockSynchronized instance;

    /**
     * Private constructor to prevent external instantiation.
     */
    private SingletonBlockSynchronized() {
    }

    /**
     * Returns the singleton instance using double-checked locking.
     * 
     * <p>The method first checks if the instance exists without locking.
     * If it doesn't exist, it synchronizes on the class object and checks again
     * before creating the instance. This ensures thread safety while minimizing
     * the performance impact of synchronization.
     *
     * @return the singleton instance of SingletonBlockSynchronized
     */
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
