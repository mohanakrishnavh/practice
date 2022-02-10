package designpatterns.factory;

public class Car extends Vehicle {
    int numberOfWheels;

    Car(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}
