package designpatterns.builder;

public class BuilderDriver {
    public static void main(String[] args) {
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).airbags(4).build();
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

        System.out.println("Car :");
        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        System.out.println("\n");

        System.out.println("Bike :");
        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
    }
}
