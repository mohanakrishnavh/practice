package concurrency.memory;

public class SeparateObjectsDriver {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        Runnable runnable1 = new MyRunnable(myObject);
        Runnable runnable2 = new MyRunnable(myObject);

        Thread thread1 = new Thread(runnable1, "thread1");
        Thread thread2 = new Thread(runnable2, "thread2");

        thread1.start();
        thread2.start();
    }
}
