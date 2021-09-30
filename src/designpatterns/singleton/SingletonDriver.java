package designpatterns.singleton;

public class SingletonDriver {
    public static void main(String[] args) {
        SingletonBlockSynchronized instance1 = SingletonBlockSynchronized.getInstance();
        System.out.println(instance1);

        SingletonBlockSynchronized instance2 = SingletonBlockSynchronized.getInstance();
        System.out.println(instance2);
    }
}
