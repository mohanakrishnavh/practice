package designpatterns.builder;

public class Vehicle {
  // Required Parameters
  private final String engine;
  private final int wheel;

  // Optional Parameters
  private final int airbags;

  private Vehicle(VehicleBuilder builder) {
    engine = builder.engine;
    wheel = builder.wheel;
    airbags = builder.airbags;
  }

  public String getEngine() {
    return engine;
  }

  public int getWheel() {
    return wheel;
  }

  public int getAirbags() {
    return airbags;
  }

  public static class VehicleBuilder {
    private final String engine;
    private final int wheel;
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
