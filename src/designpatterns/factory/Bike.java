package designpatterns.factory;

/**
 * Concrete implementation of Vehicle representing a Bike.
 * This class is created by the VehicleFactory when a bike type is requested.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class Bike extends Vehicle {
    private int numberOfWheels;

    /**
     * Constructs a Bike with the specified number of wheels.
     *
     * @param numberOfWheels the number of wheels for this bike
     */
    Bike(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    /**
     * Gets the number of wheels for this bike.
     *
     * @return the number of wheels on this bike
     */
    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}
