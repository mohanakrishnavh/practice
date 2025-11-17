# Design Patterns Reference Guide

## Overview
This directory contains comprehensive implementations and documentation of fundamental design patterns in Java. Each pattern includes fully documented code following industry standards and detailed README files explaining theory, use cases, and best practices.

## What Are Design Patterns?
Design patterns are reusable solutions to common problems in software design. They represent best practices evolved over time by experienced software developers. Design patterns:
- Provide tested, proven development paradigms
- Speed up the development process
- Improve code readability and maintainability
- Facilitate communication among developers
- Prevent subtle issues that can cause major problems

## Pattern Categories

### Creational Patterns
Focus on object creation mechanisms, creating objects in a manner suitable for the situation.

- **[Builder](builder/)** - Construct complex objects step by step
- **[Factory](factory/)** - Create objects without specifying exact classes
- **[Singleton](singleton/)** - Ensure a class has only one instance

### Structural Patterns
Deal with object composition, creating relationships between objects to form larger structures.

- **[Adapter](structural/adaptor/)** - Make incompatible interfaces work together
- **[Bridge](structural/bridge/)** - Separate abstraction from implementation
- **[Composite](composite/)** - Compose objects into tree structures
- **[Decorator](decorator/)** - Add responsibilities to objects dynamically

## Quick Pattern Selection Guide

### When to Use Which Pattern?

#### Object Creation Problems
- **Complex object construction** → Builder
- **Unknown object types at runtime** → Factory
- **Need exactly one instance** → Singleton

#### Interface Compatibility
- **Incompatible interfaces** → Adapter
- **Multiple independent variations** → Bridge

#### Object Composition
- **Part-whole hierarchies** → Composite
- **Dynamic feature addition** → Decorator

## Patterns Overview

### 1. Builder Pattern
**Type:** Creational  
**Purpose:** Separate construction from representation  
**Use When:** Objects have many optional parameters

```java
Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4)
    .airbags(4)
    .build();
```

**Key Benefits:**
- ✅ Readable code
- ✅ Immutable objects
- ✅ Flexible construction

**[Learn More →](builder/README.md)**

---

### 2. Factory Pattern
**Type:** Creational  
**Purpose:** Encapsulate object creation  
**Use When:** Object types vary at runtime

```java
Vehicle car = VehicleFactory.getInstance("car", 4);
Vehicle bike = VehicleFactory.getInstance("bike", 2);
```

**Key Benefits:**
- ✅ Loose coupling
- ✅ Centralized creation
- ✅ Easy to extend

**[Learn More →](factory/README.md)**

---

### 3. Singleton Pattern
**Type:** Creational  
**Purpose:** Ensure single instance  
**Use When:** Exactly one instance needed globally

```java
// Thread-safe double-checked locking
SingletonBlockSynchronized instance = 
    SingletonBlockSynchronized.getInstance();
```

**Implementations:**
- **Eager**: Thread-safe, no lazy loading
- **Lazy**: Lazy loading, not thread-safe
- **Synchronized**: Thread-safe, performance overhead
- **Double-Checked Locking**: ✓ Best approach

**Key Benefits:**
- ✅ Controlled access
- ✅ Reduced namespace pollution
- ✅ Permits refinement

**[Learn More →](singleton/README.md)**

---

### 4. Composite Pattern
**Type:** Structural  
**Purpose:** Treat individual and composite objects uniformly  
**Use When:** Building tree structures

```java
CompositeAccount portfolio = new CompositeAccount();
portfolio.addAccount(new DepositAccount("DA001", 100.00f));
portfolio.addAccount(new SavingAccount("SA001", 200.00f));
float total = portfolio.getBalance(); // 300.00
```

**Key Benefits:**
- ✅ Uniform treatment
- ✅ Easy to add components
- ✅ Natural hierarchies

**[Learn More →](composite/README.md)**

---

### 5. Decorator Pattern
**Type:** Structural  
**Purpose:** Add responsibilities dynamically  
**Use When:** Need flexible feature additions

```java
Dress dress = new SportyDress(
    new FancyDress(
        new BasicDress()
    )
);
dress.assemble(); // Stacked features
```

**Key Benefits:**
- ✅ Runtime flexibility
- ✅ Alternative to subclassing
- ✅ Single Responsibility Principle

**[Learn More →](decorator/README.md)**

---

### 6. Adapter Pattern
**Type:** Structural  
**Purpose:** Convert interface to another  
**Use When:** Incompatible interfaces need to work together

```java
IEDriver ieDriver = new IEDriver();
WebDriver adapter = new WebDriverAdaptor(ieDriver);
adapter.getElement(); // Adapted to ieDriver.findElement()
```

**Key Benefits:**
- ✅ Reuse existing code
- ✅ Integrate third-party libraries
- ✅ Support legacy systems

**[Learn More →](structural/adaptor/README.md)**

---

### 7. Bridge Pattern
**Type:** Structural  
**Purpose:** Decouple abstraction from implementation  
**Use When:** Multiple independent dimensions of variation

```java
TV sonyWithOldRemote = new SonyTV(new OldRemote());
TV phillipsWithNewRemote = new PhillipsTV(new NewRemote());
// Any TV with any Remote
```

**Key Benefits:**
- ✅ Independent variation
- ✅ Avoid class explosion
- ✅ Runtime flexibility

**[Learn More →](structural/bridge/README.md)**

## Code Quality Standards

All implementations in this repository follow:

### JavaDoc Documentation
- ✅ Class-level documentation with purpose and usage
- ✅ Method-level documentation with parameters and return values
- ✅ Field documentation for important attributes
- ✅ Author and version tags

### Code Formatting
- ✅ Consistent indentation (4 spaces)
- ✅ Proper spacing and line breaks
- ✅ Meaningful variable names
- ✅ Clear method names following conventions

### Best Practices
- ✅ SOLID principles
- ✅ Clean Code principles
- ✅ Proper encapsulation
- ✅ Interface-based programming

## How to Use This Repository

### 1. Learning
Each pattern folder contains:
- **README.md** - Comprehensive theory and explanation
- **Java files** - Fully documented implementation
- **Driver/Client classes** - Usage examples

### 2. Running Examples
```bash
# Navigate to pattern directory
cd src/designpatterns/builder

# Compile and run
javac BuilderDriver.java
java designpatterns.builder.BuilderDriver
```

### 3. Studying Patterns
Recommended learning order:
1. **Factory** - Simplest creational pattern
2. **Singleton** - Common pattern with variations
3. **Builder** - More complex creational pattern
4. **Adapter** - Straightforward structural pattern
5. **Decorator** - Flexible structural pattern
6. **Composite** - Hierarchical structural pattern
7. **Bridge** - Advanced structural pattern

## Pattern Relationships

### Complementary Patterns
- **Factory + Singleton**: Factory often implemented as Singleton
- **Builder + Factory**: Factory can create builders
- **Composite + Decorator**: Often used together
- **Adapter + Bridge**: Bridge is design-time; Adapter is fix-time

### Alternative Patterns
- **Factory vs Builder**: Factory for simple objects; Builder for complex
- **Adapter vs Bridge**: Adapter fixes; Bridge prevents
- **Decorator vs Composite**: Decorator adds features; Composite adds structure

## Common Anti-Patterns to Avoid

### 1. Singleton Overuse
❌ Don't use Singleton for everything  
✅ Use dependency injection when possible

### 2. God Factory
❌ One factory creating all object types  
✅ Multiple specialized factories

### 3. Decorator Explosion
❌ Too many decorator classes  
✅ Limited, well-defined decorators

### 4. Deep Composites
❌ Excessively deep tree structures  
✅ Reasonable hierarchy depth

## Design Principles Applied

### SOLID Principles
- **S**ingle Responsibility: Each class has one job
- **O**pen/Closed: Open for extension, closed for modification
- **L**iskov Substitution: Subtypes are substitutable
- **I**nterface Segregation: Small, focused interfaces
- **D**ependency Inversion: Depend on abstractions

### Other Principles
- **DRY** (Don't Repeat Yourself)
- **KISS** (Keep It Simple, Stupid)
- **YAGNI** (You Aren't Gonna Need It)
- **Composition over Inheritance**

## Testing Patterns

Each pattern can be unit tested:

```java
@Test
public void testPatternBehavior() {
    // Arrange
    Pattern pattern = new ConcretePattern();
    
    // Act
    Result result = pattern.doSomething();
    
    // Assert
    assertEquals(expected, result);
}
```

## Real-World Applications

### Enterprise Applications
- **Spring Framework**: Extensive use of Factory, Singleton, Proxy patterns
- **Hibernate**: Uses Proxy, Factory patterns
- **Java Collections**: Decorator, Composite patterns

### Android Development
- **View Hierarchy**: Composite pattern
- **Context**: Singleton-like behavior
- **Adapters**: Adapter pattern for RecyclerView

### Web Development
- **Servlet Filters**: Decorator pattern
- **Connection Pools**: Singleton pattern
- **Request Handlers**: Factory pattern

## Further Resources

### Books
- **Design Patterns: Elements of Reusable Object-Oriented Software** (Gang of Four)
- **Head First Design Patterns** by Eric Freeman
- **Effective Java** by Joshua Bloch

### Online Resources
- [Refactoring.Guru](https://refactoring.guru/design-patterns)
- [SourceMaking](https://sourcemaking.com/design_patterns)
- [Java Design Patterns (GitHub)](https://github.com/iluwatar/java-design-patterns)

## Contributing Guidelines

When adding new patterns:
1. Follow existing code structure
2. Add comprehensive JavaDoc comments
3. Create detailed README.md
4. Include real-world examples
5. Provide usage demonstrations
6. Follow formatting standards

## License

This code is intended for educational purposes.

---

## Quick Reference Table

| Pattern | Type | Problem Solved | Key Benefit | Complexity |
|---------|------|----------------|-------------|------------|
| Builder | Creational | Complex object construction | Readable code | Medium |
| Factory | Creational | Object creation flexibility | Loose coupling | Low |
| Singleton | Creational | Single instance | Controlled access | Low |
| Composite | Structural | Tree structures | Uniform treatment | Medium |
| Decorator | Structural | Dynamic features | Runtime flexibility | Medium |
| Adapter | Structural | Interface mismatch | Integration | Low |
| Bridge | Structural | Multiple variations | Independent variation | High |

---

**Happy Learning! 🎓**

For questions or suggestions, please refer to individual pattern READMEs or create an issue.
