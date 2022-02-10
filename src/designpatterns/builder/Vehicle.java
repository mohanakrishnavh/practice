package designpatterns.builder;

public class Vehicle {
    // Required Parameters
    private String engine;
    private int wheel;

    // Optional Parameters
    private int airbags;

    public String getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public int getAirbags() {
        return airbags;
    }

    private Vehicle(VehicleBuilder builder) {
        engine = builder.engine;
        wheel = builder.wheel;
        airbags = builder.airbags;
    }

    public static class VehicleBuilder {
        private String engine;
        private int wheel;
        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder airbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
