package designpatterns.factory;

public class VehicleFactory {
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
