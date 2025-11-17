package concurrency.basics;

/**
 * Demonstrates creating a thread by extending the Thread class.
 * 
 * <p><b>Note:</b> This approach is NOT recommended because:
 * <ul>
 *   <li>Java doesn't support multiple inheritance</li>
 *   <li>Tight coupling between task and thread management</li>
 *   <li>Less flexible than implementing Runnable</li>
 * </ul>
 * 
 * <p><b>Preferred Approach:</b> Implement Runnable interface instead.
 * 
 * @author Practice Repository
 * @version 1.0
 * @see MyRunnable
 * @see Runnable
 */
public class MyThread extends Thread {
    
    /**
     * The code to be executed when the thread runs.
     * Override this method to define the thread's task.
     */
    @Override
    public void run() {
        System.out.println("Running MyThread");
    }
}
