package concurrency.basics;

/**
 * RunnableDriver
 * 
 * Demonstrates the different ways of creating and starting a thread from a {@link Runnable}.
 *
 * <p>Covers a named class ({@link MyRunnable}), an anonymous inner class, a lambda, and
 * starting a thread directly from a lambda. Implementing {@code Runnable} is preferred over
 * extending {@code Thread}.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class RunnableDriver {
    /**
     * Starts threads using each Runnable syntax.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        // Defining a class that implements Runnable
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        // Syntax alternatives
        // Defining an inline class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running");
            }
        };

        // Using lambdas
        Runnable r = () -> System.out.println("Running");

        // Directly start the thread using lambda
        new Thread(() -> System.out.println("Running"))
                .start();
    }
}
