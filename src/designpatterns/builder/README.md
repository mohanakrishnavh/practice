# Builder Design Pattern

## Overview
The Builder pattern is a **creational design pattern** that provides a flexible solution for constructing complex objects. It separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

## Intent
- Separate the construction of a complex object from its representation
- Allow step-by-step construction of complex objects
- Provide control over the construction process
- Enable the same construction code to create different representations

## Problem It Solves
When creating objects with many optional parameters, traditional approaches lead to:
1. **Telescoping Constructor Anti-pattern**: Multiple constructors with increasing parameters
2. **JavaBeans Pattern Issues**: Inconsistent state during construction
3. **Complex Parameter Lists**: Hard to read and maintain
4. **Immutability Challenges**: Difficult to create immutable objects with many optional fields

## UML Structure
```
Vehicle
├── - engine: String
├── - wheel: int
├── - airbags: int
└── + VehicleBuilder (static inner class)
    ├── + VehicleBuilder(String, int)
    ├── + airbags(int): VehicleBuilder
    └── + build(): Vehicle
```

## Components

### 1. Product (Vehicle)
- The complex object being built
- Contains both required and optional parameters
- Uses a private constructor to enforce creation through the builder

### 2. Builder (VehicleBuilder)
- Static inner class that constructs the Product
- Contains the same fields as the Product
- Provides methods to set optional parameters (fluent interface)
- Has a `build()` method that creates and returns the final Product

## Implementation Details

### Required Parameters
```java
private final String engine;
private final int wheel;
```
These are passed to the Builder's constructor and must be provided.

### Optional Parameters
```java
private int airbags;
```
These can be set using builder methods and have default values.

### Fluent Interface
The builder methods return `this`, enabling method chaining:
```java
Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4)
    .airbags(4)
    .build();
```

## Advantages

1. **Readable Code**: Clear and self-documenting object creation
2. **Flexible Construction**: Easy to add or remove optional parameters
3. **Immutability**: Product objects can be made immutable
4. **Parameter Validation**: Can validate parameters before object creation
5. **Step-by-Step Construction**: Build complex objects incrementally

## Disadvantages

1. **Increased Complexity**: More code to write and maintain
2. **Memory Overhead**: Creates additional builder objects
3. **Not Suitable for Simple Objects**: Overkill for objects with few parameters

## When to Use

✅ **Use Builder Pattern When:**
- Object has many parameters (4 or more)
- Many parameters are optional
- Need to create immutable objects
- Want to improve code readability
- Object creation requires multiple steps

❌ **Avoid Builder Pattern When:**
- Object is simple with few parameters
- All parameters are required
- Object construction is straightforward

## Real-World Examples

1. **StringBuilder** in Java
   ```java
   StringBuilder sb = new StringBuilder()
       .append("Hello")
       .append(" ")
       .append("World");
   ```

2. **HTTP Request Builders**
   ```java
   HttpRequest request = HttpRequest.newBuilder()
       .uri(URI.create("https://example.com"))
       .header("Content-Type", "application/json")
       .POST(body)
       .build();
   ```

3. **Calendar/Date Builders**
   ```java
   LocalDateTime date = LocalDateTime.now()
       .withYear(2024)
       .withMonth(12)
       .withDayOfMonth(25);
   ```

## Code Example Usage

```java
// Building a car with optional airbags
Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4)
    .airbags(4)
    .build();

// Building a bike without optional parameters
Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2)
    .build();
```

## Best Practices

1. **Make Builder Static Inner Class**: Keeps related code together
2. **Return Builder from Setters**: Enables method chaining
3. **Make Product Immutable**: Use final fields in the product
4. **Validate in Build Method**: Check for invalid combinations
5. **Use Descriptive Names**: Make builder methods self-explanatory

## Variations

### 1. Telescoping Builder
Multiple builder methods for different combinations

### 2. Generic Builder
Reusable builder for multiple product types

### 3. Director
Separate class that defines construction order

## Related Patterns

- **Abstract Factory**: Builder focuses on constructing complex objects step-by-step
- **Composite**: Builder can build composite structures
- **Prototype**: Alternative way to construct complex objects

## Testing Considerations

```java
@Test
public void testVehicleBuilder() {
    Vehicle vehicle = new Vehicle.VehicleBuilder("1500cc", 4)
        .airbags(4)
        .build();
    
    assertEquals("1500cc", vehicle.getEngine());
    assertEquals(4, vehicle.getWheel());
    assertEquals(4, vehicle.getAirbags());
}
```

## References
- Gang of Four Design Patterns
- Effective Java by Joshua Bloch (Item 2: Consider a builder when faced with many constructor parameters)
