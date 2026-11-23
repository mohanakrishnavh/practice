package lld.immutable;

/**
 * Engine
 * 
 * A simple mutable engine holding a speed value.
 *
 * <p>It is deliberately mutable so that {@link ImmutableCar} can show why it must
 * defensively copy mutable collaborators.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Engine {
    private int speed;

    /**
     * Creates an engine with the given speed.
     *
     * @param speed the initial speed
     */
    public Engine(int speed) {
        this.speed = speed;
    }

    /**
     * Returns the current speed.
     *
     * @return the engine speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Updates the engine speed.
     *
     * @param speed the new speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
