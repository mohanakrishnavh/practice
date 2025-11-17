package designpatterns.singleton;

/**
 * Eager initialization implementation of the Singleton design pattern.
 * The instance is created at class loading time, ensuring thread safety.
 * 
 * <p>This approach is simple and thread-safe, but the instance is created
 * even if it's never used, which may waste resources.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class SingletonEager {
    private static final SingletonEager instance = new SingletonEager();

    /**
     * Private constructor to prevent external instantiation.
     */
    private SingletonEager() {
    }

    /**
     * Returns the singleton instance.
     * The instance is created when the class is loaded.
     *
     * @return the singleton instance of SingletonEager
     */
    public static SingletonEager getInstance() {
        return instance;
    }

    /**
     * Main method to demonstrate eager singleton usage.
     * Shows that multiple calls to getInstance() return the same instance.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        SingletonEager instance = SingletonEager.getInstance();
        System.out.println(instance);

        SingletonEager instance2 = SingletonEager.getInstance();
        System.out.println(instance2);
    }
}
