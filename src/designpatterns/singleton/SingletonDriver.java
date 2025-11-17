package designpatterns.singleton;

/**
 * Client class demonstrating thread-safe Singleton pattern with concurrent access.
 * This class shows how multiple threads can safely access the singleton instance
 * without creating duplicate objects.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class SingletonDriver {
    
    /**
     * Main method to demonstrate thread-safe singleton behavior.
     * Creates two threads that simultaneously request the singleton instance
     * to verify that only one instance is created.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create first thread to get singleton instance
        Thread t1 = new Thread(() -> {
            SingletonBlockSynchronized instance1 = SingletonBlockSynchronized.getInstance();
            System.out.println("Thread 1: " + instance1);
        });

        // Create second thread to get singleton instance
        Thread t2 = new Thread(() -> {
            SingletonBlockSynchronized instance2 = SingletonBlockSynchronized.getInstance();
            System.out.println("Thread 2: " + instance2);
        });

        // Start both threads
        t1.start();
        t2.start();
    }
}
