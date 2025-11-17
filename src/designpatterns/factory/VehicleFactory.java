package designpatterns.factory;

/**
 * Factory class for creating Vehicle objects.
 * This class implements the Factory design pattern by providing
 * a centralized method for creating different types of vehicles
 * without exposing the instantiation logic to the client.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class VehicleFactory {
    
    /**
     * Creates and returns a Vehicle instance based on the specified type.
     * This method encapsulates the object creation logic and returns
     * the appropriate vehicle subclass based on the type parameter.
     *
     * @param type           the type of vehicle to create ("car" or "bike")
     * @param numberOfWheels the number of wheels for the vehicle
     * @return a Vehicle instance of the specified type, or null if type is invalid
     */
    public static Vehicle getInstance(String type, int numberOfWheels) {
        switch (type) {
            case "car":
                return new Car(numberOfWheels);
            case "bike":
                return new Bike(numberOfWheels);
            default:
                return null;
        }
    }
}
