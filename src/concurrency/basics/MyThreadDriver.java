package concurrency.basics;

/**
 * MyThreadDriver
 * 
 * Starts a thread defined by extending {@link Thread} (see {@link MyThread}).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MyThreadDriver {
    /**
     * Creates and starts a {@code MyThread}.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args){
        new MyThread().start();
    }
}
