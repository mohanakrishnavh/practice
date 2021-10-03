package concurrency.memory;

public class MyRunnable implements Runnable{

    private int count = 0;
    private MyObject myObject = null;

    MyRunnable(MyObject myObject) {
        this.myObject = myObject;
    }

    public void run() {
        System.out.println(myObject);
        synchronized (this) {
            for (int i = 0; i < 1000000; i++) {
                this.count++;
            }
        }

        System.out.println(Thread.currentThread().getName() + ": " + this.count);
    }

    /*@Override
    public void run() {
        System.out.println(myObject);

        for (int i=0; i<1000000; i++) {
            this.count++;
        }

        System.out.println(Thread.currentThread().getName() + ": " + this.count);
    }*/
}
