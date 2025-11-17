# Factory Design Pattern

## Overview
The Factory pattern is a **creational design pattern** that provides an interface for creating objects without specifying their exact classes. It encapsulates object creation logic in a separate method or class, promoting loose coupling and adherence to the Open/Closed Principle.

## Intent
- Define an interface for creating objects
- Let subclasses or factory methods decide which class to instantiate
- Encapsulate object creation logic
- Decouple client code from concrete classes
- Provide a centralized place for object creation

## Problem It Solves
Direct object instantiation (`new ClassName()`) causes several issues:
1. **Tight Coupling**: Client code depends on concrete classes
2. **Code Duplication**: Object creation logic scattered throughout code
3. **Difficult Maintenance**: Changes to object creation require multiple code updates
4. **Limited Flexibility**: Hard to change object creation strategy
5. **Violated SRP**: Clients handle both logic and object creation

## UML Structure
```
Vehicle (Abstract Product)
├── + getNumberOfWheels(): int
├── + toString(): String
│
├── Car (Concrete Product)
│   ├── - numberOfWheels: int
│   └── + getNumberOfWheels(): int
│
└── Bike (Concrete Product)
    ├── - numberOfWheels: int
    └── + getNumberOfWheels(): int

VehicleFactory (Factory)
└── + getInstance(String, int): Vehicle [static]
```

## Components

### 1. Product (Vehicle)
- Abstract base class or interface defining product interface
- Common interface for all objects the factory creates
- Declares methods that all concrete products must implement

### 2. Concrete Products (Car, Bike)
- Specific implementations of the Product interface
- Different variants that the factory can create
- Contain actual implementation logic

### 3. Factory (VehicleFactory)
- Contains factory method that returns Product objects
- Encapsulates object creation logic
- Decides which concrete product to instantiate based on parameters

## Implementation Details

### Simple Factory Method
```java
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
```

### Type-Based Creation
The factory uses a string parameter to determine which type to create. This could also use enums for type safety:

```java
public enum VehicleType {
    CAR, BIKE
}

public static Vehicle getInstance(VehicleType type, int numberOfWheels) {
    switch (type) {
        case CAR:
            return new Car(numberOfWheels);
        case BIKE:
            return new Bike(numberOfWheels);
    }
}
```

## Advantages

1. **Encapsulation**: Object creation logic is centralized
2. **Loose Coupling**: Client code doesn't depend on concrete classes
3. **Single Responsibility**: Separates object creation from business logic
4. **Open/Closed Principle**: Easy to add new product types
5. **Code Reusability**: Creation logic is reused across application
6. **Easy Testing**: Can mock factory for unit tests

## Disadvantages

1. **Additional Complexity**: Extra classes and indirection
2. **Limited Parameters**: Factory method signature constraints all products
3. **God Class Risk**: Factory can become too large
4. **Null Returns**: May return null for invalid types (use Optional instead)

## When to Use

✅ **Use Factory Pattern When:**
- Don't know exact types of objects needed at compile time
- Want to provide a library of products to users
- Need to centralize object creation logic
- Object creation is complex or requires configuration
- Want to decouple client code from concrete classes
- Need to enforce creation constraints

❌ **Avoid Factory Pattern When:**
- Object creation is simple and straightforward
- Only one product type exists
- Adding extra layer provides no benefit
- Direct instantiation is clearer

## Factory Pattern Types

### 1. Simple Factory (This Implementation) ✓
- Static factory method
- Not a true Gang of Four pattern
- Most commonly used in practice

```java
Vehicle vehicle = VehicleFactory.getInstance("car", 4);
```

### 2. Factory Method Pattern
- Abstract creator with abstract factory method
- Subclasses override factory method
- More flexible but more complex

```java
abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    Vehicle createVehicle() {
        return new Car();
    }
}
```

### 3. Abstract Factory Pattern
- Factory of factories
- Creates families of related objects
- Most complex but most powerful

```java
interface VehicleFactory {
    Vehicle createVehicle();
    Engine createEngine();
}
```

## Real-World Examples

### 1. JDBC DriverManager
```java
Connection conn = DriverManager.getConnection(url, user, password);
// Returns appropriate driver implementation
```

### 2. Calendar
```java
Calendar calendar = Calendar.getInstance();
// Returns appropriate calendar for locale
```

### 3. NumberFormat
```java
NumberFormat format = NumberFormat.getInstance(Locale.US);
// Returns appropriate formatter
```

### 4. Frameworks
```java
// Spring Framework
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
Object bean = context.getBean("myBean");
```

### 5. Logger Factories
```java
Logger logger = LoggerFactory.getLogger(MyClass.class);
```

## Code Example Usage

```java
// Create a car using the factory
Vehicle car = VehicleFactory.getInstance("car", 4);
System.out.println(car); // Output: Number of wheels: 4

// Create a bike using the factory
Vehicle bike = VehicleFactory.getInstance("bike", 2);
System.out.println(bike); // Output: Number of wheels: 2

// Client code doesn't know about Car or Bike classes
// It only works with the Vehicle interface
```

## Best Practices

1. **Use Static Factory Methods**: Simple and clean for basic cases
2. **Return Interfaces**: Return abstract types, not concrete classes
3. **Meaningful Names**: Use descriptive method names (e.g., `createVehicle()`, `getInstance()`)
4. **Handle Invalid Input**: Use Optional or throw exceptions instead of returning null
5. **Consider Enum Types**: Use enums for type parameters instead of strings
6. **Document Factory**: Clearly document which types are supported
7. **Thread Safety**: Make factory methods thread-safe if needed

## Improved Implementation Examples

### Using Optional
```java
public static Optional<Vehicle> getInstance(String type, int wheels) {
    switch (type) {
        case "car":
            return Optional.of(new Car(wheels));
        case "bike":
            return Optional.of(new Bike(wheels));
        default:
            return Optional.empty();
    }
}
```

### Using Enum
```java
public enum VehicleType {
    CAR("car"),
    BIKE("bike");
    
    private final String type;
    
    VehicleType(String type) {
        this.type = type;
    }
}

public static Vehicle getInstance(VehicleType type, int wheels) {
    // More type-safe implementation
}
```

### With Validation
```java
public static Vehicle getInstance(String type, int numberOfWheels) {
    if (numberOfWheels <= 0) {
        throw new IllegalArgumentException("Wheels must be positive");
    }
    
    switch (type.toLowerCase()) {
        case "car":
            return new Car(numberOfWheels);
        case "bike":
            return new Bike(numberOfWheels);
        default:
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
    }
}
```

## Related Patterns

- **Abstract Factory**: Factory Method creates one product; Abstract Factory creates families
- **Prototype**: Alternative for object creation using cloning
- **Singleton**: Factory is often implemented as a Singleton
- **Builder**: More complex object construction with many parameters
- **Template Method**: Factory Method is a specialization

## Testing Considerations

```java
@Test
public void testCarCreation() {
    Vehicle car = VehicleFactory.getInstance("car", 4);
    assertNotNull(car);
    assertTrue(car instanceof Car);
    assertEquals(4, car.getNumberOfWheels());
}

@Test
public void testBikeCreation() {
    Vehicle bike = VehicleFactory.getInstance("bike", 2);
    assertNotNull(bike);
    assertTrue(bike instanceof Bike);
    assertEquals(2, bike.getNumberOfWheels());
}

@Test
public void testInvalidType() {
    Vehicle vehicle = VehicleFactory.getInstance("invalid", 4);
    assertNull(vehicle);
    // Or with improved version:
    // assertThrows(IllegalArgumentException.class, 
    //     () -> VehicleFactory.getInstance("invalid", 4));
}
```

## Common Pitfalls

1. **Returning Null**: Use Optional or throw exceptions
2. **Factory Too Large**: Split into multiple factories if needed
3. **Not Using Interfaces**: Always return abstract types
4. **String-Based Types**: Use enums for type safety
5. **Constructor Exposure**: Make constructors package-private or private

## Extension Points

### Adding New Vehicle Types
```java
// 1. Create new product class
public class Truck extends Vehicle {
    // Implementation
}

// 2. Update factory method
public static Vehicle getInstance(String type, int numberOfWheels) {
    switch (type) {
        case "car":
            return new Car(numberOfWheels);
        case "bike":
            return new Bike(numberOfWheels);
        case "truck": // New type
            return new Truck(numberOfWheels);
        default:
            return null;
    }
}
```

## References
- Gang of Four Design Patterns
- Effective Java by Joshua Bloch (Item 1: Consider static factory methods instead of constructors)
- Head First Design Patterns
