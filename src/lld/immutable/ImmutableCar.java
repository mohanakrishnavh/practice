package lld.immutable;

// Make the class as final
// Make variables as private
// Make variable as final
// No setter methods
// Make deep copy of the object
public final class ImmutableCar {
    private final int id;
    private final String name;
    private final Engine engine;

    public ImmutableCar(int id, String name, Engine engine) {
        this.id = id;
        this.name = name;

        // Make deep copy of the object before assigning
        Engine newEngine = new Engine(engine.getSpeed());
        this.engine = newEngine;
        // this.engine = engine
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Engine getEngine() {
        return engine;
    }
}
