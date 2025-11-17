# Decorator Design Pattern

## Overview
The Decorator pattern is a **structural design pattern** that allows you to attach new behaviors to objects dynamically by placing them inside special wrapper objects called decorators. It provides a flexible alternative to subclassing for extending functionality.

## Intent
- Add responsibilities to objects dynamically and transparently
- Provide a flexible alternative to subclassing for extending functionality
- Wrap objects to add new behavior without modifying existing code
- Follow the Open/Closed Principle (open for extension, closed for modification)

## Problem It Solves
When you need to add features to objects, traditional inheritance has limitations:
1. **Static Nature**: Inheritance is static and applies to entire classes
2. **Explosion of Subclasses**: Need many subclasses for different combinations
3. **Inflexibility**: Can't add/remove responsibilities at runtime
4. **Tight Coupling**: Subclasses are tightly coupled to parent classes

The Decorator pattern solves this by allowing dynamic composition of behaviors.

## UML Structure
```
Dress (Component Interface)
├── + assemble(): void
│
├── BasicDress (Concrete Component)
│   └── + assemble(): void
│
└── DressDecorator (Base Decorator)
    ├── # dress: Dress
    ├── + DressDecorator(Dress)
    ├── + assemble(): void
    │
    ├── CasualDress (Concrete Decorator)
    │   └── + assemble(): void
    │
    ├── FancyDress (Concrete Decorator)
    │   └── + assemble(): void
    │
    └── SportyDress (Concrete Decorator)
        └── + assemble(): void
```

## Components

### 1. Component (Dress)
- Defines the interface for objects that can have responsibilities added
- Common interface for both concrete components and decorators

### 2. Concrete Component (BasicDress)
- The base object to which additional responsibilities can be attached
- Provides the core functionality

### 3. Base Decorator (DressDecorator)
- Maintains a reference to a Component object
- Defines an interface conforming to Component's interface
- Delegates operations to the wrapped component

### 4. Concrete Decorators (CasualDress, FancyDress, SportyDress)
- Add specific responsibilities to the component
- Can add behavior before and/or after delegating to the wrapped component

## Implementation Details

### Wrapping Mechanism
```java
// Basic dress
Dress dress = new BasicDress();

// Add sporty features
Dress sportyDress = new SportyDress(dress);

// Add fancy AND sporty features (stacking decorators)
Dress fancySportyDress = new SportyDress(new FancyDress(new BasicDress()));
```

### Decorator Stacking
Decorators can be stacked in any order:
```
SportyDress wraps
    └── FancyDress wraps
        └── BasicDress
```

### Call Flow
```
sportyFancyDress.assemble()
    → SportyDress.assemble()
        → super.assemble() // calls FancyDress.assemble()
            → super.assemble() // calls BasicDress.assemble()
                → Print "Basic Dress Features"
            → Print "Fancy Dress Features"
        → Print "Sporty Dress Features"
```

## Advantages

1. **Runtime Flexibility**: Add/remove responsibilities at runtime
2. **Avoids Class Explosion**: Don't need subclasses for every combination
3. **Single Responsibility**: Each decorator adds one specific behavior
4. **Open/Closed Principle**: Extend behavior without modifying existing code
5. **Composability**: Mix and match decorators freely
6. **Transparent Wrapping**: Decorators are transparent to clients

## Disadvantages

1. **Complexity**: Many small objects can be confusing
2. **Debugging Difficulty**: Stack of decorators can be hard to debug
3. **Order Dependency**: Order of decorators may matter
4. **Identity Issues**: Decorated object ≠ original object
5. **Configuration Overhead**: Setting up decorators can be verbose

## When to Use

✅ **Use Decorator Pattern When:**
- Need to add responsibilities to objects dynamically
- Responsibilities can be withdrawn
- Extension by subclassing is impractical (too many combinations)
- Want to add features without changing existing code
- Need to combine multiple optional features

❌ **Avoid Decorator Pattern When:**
- Need to change core behavior (use Strategy instead)
- Object's interface needs to change
- Simple inheritance suffices
- Performance is critical (wrapping adds overhead)

## Real-World Examples

### 1. Java I/O Streams
```java
// Stacking decorators for file reading
BufferedReader reader = new BufferedReader(
    new InputStreamReader(
        new FileInputStream("file.txt")
    )
);
```

### 2. Coffee Shop Example
```java
Coffee coffee = new SimpleCoffee();           // $2
coffee = new MilkDecorator(coffee);           // +$0.50
coffee = new SugarDecorator(coffee);          // +$0.25
coffee = new WhipCreamDecorator(coffee);      // +$0.75
// Total: $3.50
```

### 3. UI Components
```java
Window window = new SimpleWindow();
window = new ScrollableWindow(window);
window = new BorderedWindow(window);
```

### 4. Text Formatting
```java
Text text = new PlainText("Hello");
text = new BoldDecorator(text);
text = new ItalicDecorator(text);
text = new UnderlineDecorator(text);
```

## Code Example Usage

```java
// Basic dress
Dress basicDress = new BasicDress();
basicDress.assemble();
// Output: Basic Dress Features

// Sporty dress
Dress sportyDress = new SportyDress(new BasicDress());
sportyDress.assemble();
// Output:
// Basic Dress Features
// Sporty Dress Features

// Combining multiple decorators
Dress fancySportyDress = new SportyDress(new FancyDress(new BasicDress()));
fancySportyDress.assemble();
// Output:
// Basic Dress Features
// Fancy Dress Features
// Sporty Dress Features
```

## Best Practices

1. **Keep Decorators Lightweight**: Each decorator should add one feature
2. **Maintain Component Interface**: Decorators must match component interface
3. **Order Matters**: Document if decorator order is significant
4. **Use Composition**: Favor composition over inheritance
5. **Consider Factory**: Use Factory pattern to simplify decorator creation
6. **Document Dependencies**: Note any dependencies between decorators

## Design Decisions

### Should Decorator Pass Through All Methods?
**Yes** - Decorator should implement all Component interface methods to maintain transparency.

### Should Decorator Be Abstract or Concrete?
**Abstract** ✓ (Used in this implementation)
- Forces common structure
- Ensures proper delegation

**Concrete**
- More flexible but less structure

### How to Handle Decorator-Specific Methods?
**Option 1**: Add to decorator only (type-specific behavior)
**Option 2**: Add to component interface (if needed by all)

## Variations

### 1. Transparent Decorator
Client doesn't know about decoration

### 2. Semi-Transparent Decorator
Client can access decorator-specific features

### 3. Multi-Component Decorator
Decorator wraps multiple components

## Related Patterns

- **Adapter**: Changes interface; Decorator enhances responsibility
- **Composite**: Decorator has only one child; Composite has many
- **Strategy**: Changes algorithm; Decorator adds features
- **Proxy**: Controls access; Decorator adds functionality
- **Chain of Responsibility**: Similar chaining but different intent

## Implementation Considerations

### Thread Safety
```java
public class ThreadSafeDecorator extends DressDecorator {
    public ThreadSafeDecorator(Dress dress) {
        super(dress);
    }
    
    @Override
    public synchronized void assemble() {
        super.assemble();
        // Additional behavior
    }
}
```

### Decorator Factory
```java
public class DressFactory {
    public static Dress createSportyFancyDress() {
        return new SportyDress(
            new FancyDress(
                new BasicDress()
            )
        );
    }
}
```

## Testing Considerations

```java
@Test
public void testBasicDress() {
    Dress dress = new BasicDress();
    // Assert basic functionality
}

@Test
public void testDecoratedDress() {
    Dress dress = new SportyDress(new BasicDress());
    // Assert decorated functionality
}

@Test
public void testMultipleDecorators() {
    Dress dress = new SportyDress(
        new FancyDress(
            new BasicDress()
        )
    );
    // Assert combined functionality
}

@Test
public void testDecoratorOrder() {
    // Test that order matters (or doesn't)
    Dress dress1 = new SportyDress(new FancyDress(new BasicDress()));
    Dress dress2 = new FancyDress(new SportyDress(new BasicDress()));
    // Assert expected behavior
}
```

## Common Pitfalls

1. **Too Many Decorators**: Can lead to complex object graphs
2. **Forgetting to Delegate**: Decorator must call super.method()
3. **Type Checking**: Can't use instanceof reliably
4. **State Management**: Be careful with stateful decorators
5. **Performance**: Multiple layers add overhead

## References
- Gang of Four Design Patterns
- Head First Design Patterns
- Effective Java by Joshua Bloch
