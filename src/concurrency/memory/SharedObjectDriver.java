package concurrency.memory;

public class SharedObjectDriver {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        Runnable runnable = new MyRunnable(myObject);

        Thread thread1 = new Thread(runnable, "thread1");
        Thread thread2 = new Thread(runnable, "thread2");

        thread1.start();
        thread2.start();
    }
}
