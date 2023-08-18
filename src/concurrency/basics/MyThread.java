package concurrency.basics;

// Thread is a Runnable
// This approach is not recommended
public class MyThread extends Thread {
    public void run() {
        System.out.println("Running MyThread");
    }
}
