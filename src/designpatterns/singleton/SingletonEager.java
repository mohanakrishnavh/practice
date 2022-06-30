package designpatterns.singleton;

public class SingletonEager {
    private static final SingletonEager instance = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonEager instance = SingletonEager.getInstance();
        System.out.println(instance);

        SingletonEager instance2 = SingletonEager.getInstance();
        System.out.println(instance2);
    }
}
