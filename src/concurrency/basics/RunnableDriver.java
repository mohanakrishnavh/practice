package concurrency.basics;

public class RunnableDriver {
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
