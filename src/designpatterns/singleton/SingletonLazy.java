package designpatterns.singleton;

/**
 * Lazy initialization implementation of the Singleton design pattern.
 * This approach creates the instance only when getInstance() is first called.
 * 
 * <p><b>Note:</b> This implementation is NOT thread-safe. Multiple threads
 * calling getInstance() simultaneously might create multiple instances.
 * Use this only in single-threaded environments.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    /**
     * Private constructor to prevent external instantiation.
     */
    private SingletonLazy() {
    }

    /**
     * Returns the singleton instance, creating it if it doesn't exist.
     * 
     * <p><b>Warning:</b> This method is not thread-safe.
     *
     * @return the singleton instance of SingletonLazy
     */
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
