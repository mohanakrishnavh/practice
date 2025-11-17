package designpatterns.factory;

/**
 * Client class demonstrating the Factory design pattern.
 * This class shows how the VehicleFactory can be used to create
 * different types of vehicles without knowing their concrete classes.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class FactoryDriver {
    
    /**
     * Main method to demonstrate factory pattern usage.
     * Creates different vehicle instances using the factory
     * and displays their properties.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a car using the factory
        Vehicle car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);

        // Create a bike using the factory
        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
    }
}
