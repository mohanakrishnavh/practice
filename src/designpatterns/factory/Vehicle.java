package designpatterns.factory;

public abstract class Vehicle {
    public abstract int getNumberOfWheels();

    public String toString() {
        return "Number of wheels: " + this.getNumberOfWheels();
    }
}
