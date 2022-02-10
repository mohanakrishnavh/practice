package designpatterns.factory;

public class Bike extends Vehicle {
    int numberOfWheels;

    Bike(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}
