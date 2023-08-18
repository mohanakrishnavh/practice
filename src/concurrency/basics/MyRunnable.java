package concurrency.basics;

// The Runnable interface is implemented by any class that is
// intended to be executed by a thread
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("I am running");
    }
}
