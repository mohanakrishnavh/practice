package lld.immutable;

/**
 * ImmutableDriver
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ImmutableDriver {
    public static void main(String[] args) {
        Engine engine = new Engine(5);
        ImmutableCar immutableCar = new ImmutableCar(1, "Mazda", engine);

        System.out.println(immutableCar.getName().equals("Mazda"));
        System.out.println(immutableCar.getEngine().getSpeed());

        engine.setSpeed(10);
        System.out.println("Engine: " + engine.getSpeed());
        System.out.println("ImmutableCar: " + immutableCar.getEngine().getSpeed());
    }
}
