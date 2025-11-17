package designpatterns.factory;

/**
 * Abstract base class representing a Vehicle in the Factory pattern.
 * This class defines the common interface for all vehicle types
 * that can be created by the VehicleFactory.
 *
 * @author Practice Repository
 * @version 1.0
 */
public abstract class Vehicle {
    
    /**
     * Gets the number of wheels for this vehicle.
     * Subclasses must implement this method to provide specific wheel counts.
     *
     * @return the number of wheels on this vehicle
     */
    public abstract int getNumberOfWheels();

    /**
     * Returns a string representation of the vehicle.
     *
     * @return a string describing the number of wheels on this vehicle
     */
    @Override
    public String toString() {
        return "Number of wheels: " + this.getNumberOfWheels();
    }
}
