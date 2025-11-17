package designpatterns.builder;

/**
 * Represents a Vehicle with required and optional parameters.
 * Demonstrates the Builder design pattern.
 */
public class Vehicle {
    // Required Parameters
    private final String engine;
    private final int wheel;

    // Optional Parameters
    private final int airbags;

    /**
     * Private constructor to enforce object creation via the builder.
     * @param builder VehicleBuilder instance
     */
    private Vehicle(VehicleBuilder builder) {
        engine = builder.engine;
        wheel = builder.wheel;
        airbags = builder.airbags;
    }

    /**
     * Gets the engine type of the vehicle.
     * @return engine type
     */
    public String getEngine() {
        return engine;
    }

    /**
     * Gets the number of wheels of the vehicle.
     * @return number of wheels
     */
    public int getWheel() {
        return wheel;
    }

    /**
     * Gets the number of airbags in the vehicle.
     * @return number of airbags
     */
    public int getAirbags() {
        return airbags;
    }

    /**
     * Builder class for Vehicle.
     */
    public static class VehicleBuilder {
        private final String engine;
        private final int wheel;
        private int airbags;

        /**
         * Constructor for VehicleBuilder with required parameters.
         * @param engine engine type
         * @param wheel number of wheels
         */
        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        /**
         * Sets the number of airbags.
         * @param airbags number of airbags
         * @return VehicleBuilder instance
         */
        public VehicleBuilder airbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        /**
         * Builds and returns a Vehicle instance.
         * @return Vehicle instance
         */
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
