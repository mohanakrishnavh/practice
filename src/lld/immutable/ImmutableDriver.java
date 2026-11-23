package lld.immutable;

/**
 * ImmutableDriver
 * 
 * Demonstrates the immutable-class pattern using {@link ImmutableCar}.
 *
 * <p>An {@code Engine} is passed to the car and then mutated. Because {@code ImmutableCar}
 * deep-copies the engine in its constructor, the car's engine speed is unaffected.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ImmutableDriver {
    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
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
