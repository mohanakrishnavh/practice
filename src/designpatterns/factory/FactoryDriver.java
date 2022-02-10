package designpatterns.factory;

public class FactoryDriver {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);

        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
    }
}
