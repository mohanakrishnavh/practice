package concurrency.basics;

/**
 * Demonstrates creating a thread task by implementing the Runnable interface.
 * 
 * <p>The Runnable interface is implemented by any class whose instances
 * are intended to be executed by a thread. This is the recommended approach
 * for creating threads because:
 * <ul>
 *   <li>Allows the class to extend another class if needed</li>
 *   <li>Separates task definition from thread management</li>
 *   <li>More flexible and follows composition over inheritance</li>
 *   <li>Can be used with ExecutorService and thread pools</li>
 * </ul>
 * 
 * <p><b>Usage:</b>
 * <pre>
 * Runnable task = new MyRunnable();
 * Thread thread = new Thread(task);
 * thread.start();
 * </pre>
 * 
 * @author Practice Repository
 * @version 1.0
 * @see Runnable
 * @see Thread
 */
public class MyRunnable implements Runnable {

    /**
     * The code to be executed when the thread runs.
     * This method is called when the thread is started.
     */
    @Override
    public void run() {
        System.out.println("I am running");
    }
}
