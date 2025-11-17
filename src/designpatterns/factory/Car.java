package designpatterns.factory;

/**
 * Concrete implementation of Vehicle representing a Car.
 * This class is created by the VehicleFactory when a car type is requested.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class Car extends Vehicle {
    private int numberOfWheels;

    /**
     * Constructs a Car with the specified number of wheels.
     *
     * @param numberOfWheels the number of wheels for this car
     */
    Car(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    /**
     * Gets the number of wheels for this car.
     *
     * @return the number of wheels on this car
     */
    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}
