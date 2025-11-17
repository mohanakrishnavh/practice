# Bridge Design Pattern

## Overview
The Bridge pattern is a **structural design pattern** that decouples an abstraction from its implementation so that the two can vary independently. It uses composition over inheritance to connect two class hierarchies with a "bridge."

## Intent
- Decouple abstraction from implementation
- Allow both abstraction and implementation to vary independently
- Avoid permanent binding between abstraction and implementation
- Reduce the number of subclasses in inheritance hierarchies
- Hide implementation details from clients

## Problem It Solves
When you have two dimensions of variation (e.g., TV types and Remote types), traditional inheritance creates an explosion of classes:

**Without Bridge Pattern:**
```
TVs × Remotes = Many Classes
- SonyTVWithOldRemote
- SonyTVWithNewRemote
- PhillipsTVWithOldRemote
- PhillipsTVWithNewRemote
- SamsungTVWithOldRemote
- SamsungTVWithNewRemote
... (combinatorial explosion)
```

**With Bridge Pattern:**
```
TVs + Remotes = Fewer Classes
TVs: Sony, Phillips
Remotes: Old, New
Total: 4 classes instead of 6+ (and scales better)
```

## UML Structure
```
TV (Abstraction)                    Remote (Implementor)
├── # remote: Remote                ├── + on(): void
├── + TV(Remote)                    └── + off(): void
├── + on(): void [abstract]              │
└── + off(): void [abstract]             ├── OldRemote
     │                                    │   ├── + on(): void
     ├── SonyTV                           │   └── + off(): void
     │   ├── - remoteType: Remote        │
     │   ├── + on(): void                └── NewRemote
     │   └── + off(): void                   ├── + on(): void
     │                                       └── + off(): void
     └── PhillipsTV
         ├── - remoteType: Remote
         ├── + on(): void
         └── + off(): void
```

## Components

### 1. Abstraction (TV)
- Defines the abstraction's interface
- Maintains reference to Implementor (Remote)
- Delegates implementation-specific work to Implementor
- Provides high-level control logic

### 2. Refined Abstractions (SonyTV, PhillipsTV)
- Extend the Abstraction
- Provide variant implementations
- Add TV-specific behaviors
- Work with any Remote implementation

### 3. Implementor (Remote)
- Defines interface for implementation classes
- Doesn't need to match Abstraction interface exactly
- Provides primitive operations
- Independent hierarchy from Abstraction

### 4. Concrete Implementors (OldRemote, NewRemote)
- Implement the Implementor interface
- Provide concrete implementations
- Can be swapped without affecting Abstraction

## Implementation Details

### Two Independent Hierarchies

**Abstraction Hierarchy (TVs):**
```
TV
├── SonyTV
└── PhillipsTV
```

**Implementation Hierarchy (Remotes):**
```
Remote
├── OldRemote
└── NewRemote
```

### Bridge Connection
```java
public abstract class TV {
    protected Remote remote; // The bridge!
    
    TV(Remote remote) {
        this.remote = remote;
    }
    
    abstract void on();
    abstract void off();
}
```

### Flexibility
Any TV can work with any Remote:
```java
TV sonyWithOldRemote = new SonyTV(new OldRemote());
TV sonyWithNewRemote = new SonyTV(new NewRemote());
TV phillipsWithOldRemote = new PhillipsTV(new OldRemote());
TV phillipsWithNewRemote = new PhillipsTV(new NewRemote());
```

## Advantages

1. **Decoupling**: Separates interface from implementation
2. **Extensibility**: Add new abstractions and implementations independently
3. **Flexibility**: Switch implementations at runtime
4. **Scalability**: Avoid class explosion with multiple dimensions
5. **Single Responsibility**: Each class has one reason to change
6. **Open/Closed**: Open for extension, closed for modification
7. **Implementation Hiding**: Hide implementation details from clients

## Disadvantages

1. **Complexity**: More classes and indirection
2. **Harder to Understand**: Requires understanding of both hierarchies
3. **Initial Design Overhead**: Needs upfront planning
4. **Performance**: Extra indirection may have slight overhead

## When to Use

✅ **Use Bridge Pattern When:**
- Have multiple dimensions that vary independently
- Want to avoid compile-time binding between abstraction and implementation
- Need to share implementation among multiple objects (using reference counting)
- Changes in implementation shouldn't affect clients
- Have class explosion from multiple variations
- Want to switch implementations at runtime

✅ **Specific Scenarios:**
- GUI frameworks (windows with different rendering engines)
- Database drivers (multiple databases with same operations)
- Device drivers (devices with different communication protocols)
- Cross-platform applications

❌ **Avoid Bridge Pattern When:**
- Only one dimension of variation exists
- Abstraction and implementation are unlikely to change
- Simple inheritance suffices
- Adding complexity isn't justified

## Real-World Examples

### 1. JDBC API
```java
// Abstraction
Connection connection = DriverManager.getConnection(url);
Statement statement = connection.createStatement();

// Different implementations (Oracle, MySQL, PostgreSQL)
// but same abstraction interface
```

### 2. Graphics APIs
```java
// Abstraction: Shape
// Implementation: Rendering engine (OpenGL, DirectX, Vulkan)
abstract class Shape {
    protected Renderer renderer;
    
    Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        renderer.renderCircle();
    }
}
```

### 3. Messaging Systems
```java
// Abstraction: Message
// Implementation: Sender (Email, SMS, Push)
abstract class Message {
    protected MessageSender sender;
    
    Message(MessageSender sender) {
        this.sender = sender;
    }
    
    abstract void send();
}
```

### 4. Collections Framework
```java
// AbstractList is abstraction
// ArrayList and LinkedList are refined abstractions
// Different underlying implementations (array vs linked nodes)
```

### 5. Logging Frameworks
```java
// Abstraction: Logger
// Implementation: LogHandler (Console, File, Database)
class Logger {
    private LogHandler handler;
    
    void log(String message) {
        handler.write(message);
    }
}
```

## Code Example Usage

```java
public class BridgeDriver {
    public static void main(String[] args) {
        // Sony TV with Old Remote
        SonyTV sonyTVWithOldRemote = new SonyTV(new OldRemote());
        sonyTVWithOldRemote.on();   // Sony TV On + On with Old Remote
        sonyTVWithOldRemote.off();  // Sony TV Off + Off with Old Remote
        
        // Sony TV with New Remote
        SonyTV sonyTVWithNewRemote = new SonyTV(new NewRemote());
        sonyTVWithNewRemote.on();   // Sony TV On + On with NewRemote
        sonyTVWithNewRemote.off();  // Sony TV Off + Off with NewRemote
        
        // Phillips TV with Old Remote
        PhillipsTV phillipsWithOld = new PhillipsTV(new OldRemote());
        phillipsWithOld.on();       // Phillips TV On + On with Old Remote
        phillipsWithOld.off();      // Phillips TV Off + Off with Old Remote
        
        // Phillips TV with New Remote
        PhillipsTV phillipsWithNew = new PhillipsTV(new NewRemote());
        phillipsWithNew.on();       // Phillips TV On + On with NewRemote
        phillipsWithNew.off();      // Phillips TV Off + Off with NewRemote
    }
}
```

## Best Practices

1. **Identify Orthogonal Concerns**: Find truly independent dimensions
2. **Composition Over Inheritance**: Use has-a relationship
3. **Keep Hierarchies Shallow**: Avoid deep abstraction hierarchies
4. **Interface Stability**: Keep implementor interface stable
5. **Document Relationships**: Clearly document bridge connections
6. **Consider Factory**: Use Factory pattern to create combinations
7. **Runtime Flexibility**: Allow changing implementation at runtime

## Design Decisions

### How Many Hierarchies?
**Typically Two:**
- Abstraction hierarchy
- Implementation hierarchy

**Can Have More:**
- Multiple implementation dimensions
- Requires multiple bridge references

### When to Bridge?
**Bridge Early** if:
- Multiple variations expected
- Platform independence needed
- Runtime switching required

**Bridge Later** if:
- Only one variation currently exists
- Future variations uncertain
- YAGNI (You Aren't Gonna Need It)

## Bridge vs Other Patterns

### Bridge vs Adapter
| Aspect | Bridge | Adapter |
|--------|--------|---------|
| **Intent** | Decouple abstraction from implementation | Make incompatible interfaces work |
| **When** | Designed upfront | Applied to existing code |
| **Hierarchies** | Two independent hierarchies | Wraps existing interface |
| **Flexibility** | Both sides can vary | Makes fixed interface compatible |

### Bridge vs Strategy
| Aspect | Bridge | Strategy |
|--------|--------|----------|
| **Intent** | Structural separation | Behavioral variation |
| **Focus** | Separates what from how | Encapsulates algorithms |
| **Scope** | Class level | Object level |
| **Hierarchies** | Two hierarchies | One interface, multiple implementations |

### Bridge vs State
| Aspect | Bridge | State |
|--------|--------|-------|
| **Intent** | Separate dimensions | Alter behavior based on state |
| **Switching** | Arbitrary switching | State-driven transitions |
| **Purpose** | Structural flexibility | Behavioral change |

## Variations

### Multiple Implementors
```java
abstract class EnhancedTV {
    protected Remote remote;
    protected Display display;
    
    EnhancedTV(Remote remote, Display display) {
        this.remote = remote;
        this.display = display;
    }
}
```

### Runtime Switching
```java
public class TV {
    private Remote remote;
    
    public void setRemote(Remote remote) {
        this.remote = remote; // Switch at runtime
    }
}
```

## Advanced Example: Shape-Renderer

```java
// Implementor
interface Renderer {
    void renderCircle(float radius);
    void renderSquare(float side);
}

// Concrete Implementors
class VectorRenderer implements Renderer {
    public void renderCircle(float radius) {
        System.out.println("Drawing circle (vector) with radius " + radius);
    }
    
    public void renderSquare(float side) {
        System.out.println("Drawing square (vector) with side " + side);
    }
}

class RasterRenderer implements Renderer {
    public void renderCircle(float radius) {
        System.out.println("Drawing circle (raster) with radius " + radius);
    }
    
    public void renderSquare(float side) {
        System.out.println("Drawing square (raster) with side " + side);
    }
}

// Abstraction
abstract class Shape {
    protected Renderer renderer;
    
    Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    
    abstract void draw();
    abstract void resize(float factor);
}

// Refined Abstractions
class Circle extends Shape {
    private float radius;
    
    Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }
    
    void draw() {
        renderer.renderCircle(radius);
    }
    
    void resize(float factor) {
        radius *= factor;
    }
}

// Usage
Shape vectorCircle = new Circle(new VectorRenderer(), 5);
Shape rasterCircle = new Circle(new RasterRenderer(), 5);
vectorCircle.draw(); // Vector rendering
rasterCircle.draw(); // Raster rendering
```

## Testing Considerations

```java
@Test
public void testBridgeWithMockImplementor() {
    // Arrange
    Remote mockRemote = mock(Remote.class);
    TV tv = new SonyTV(mockRemote);
    
    // Act
    tv.on();
    
    // Assert
    verify(mockRemote).on();
}

@Test
public void testRuntimeImplementorSwitch() {
    Remote oldRemote = new OldRemote();
    Remote newRemote = new NewRemote();
    
    TV tv = new SonyTV(oldRemote);
    // Use oldRemote...
    
    tv = new SonyTV(newRemote);
    // Now using newRemote...
}
```

## Common Pitfalls

1. **Overengineering**: Using Bridge when simple inheritance suffices
2. **Tight Coupling**: Not keeping hierarchies truly independent
3. **God Abstraction**: Abstraction knowing too much about implementation
4. **Forgetting Flexibility**: Not allowing runtime switching when beneficial
5. **Wrong Pattern**: Using Bridge when Adapter is more appropriate

## Related Patterns

- **Abstract Factory**: Can create Bridge components
- **Adapter**: Bridge designed upfront; Adapter retrofitted
- **Strategy**: Similar structure but different intent
- **State**: Can use Bridge to separate state from context

## Extension Points

### Adding New TVs
```java
// Just add new refined abstraction
public class SamsungTV extends TV {
    public SamsungTV(Remote remote) {
        super(remote);
    }
    
    @Override
    void on() {
        System.out.println("Samsung TV On");
        remote.on();
    }
    
    @Override
    void off() {
        System.out.println("Samsung TV Off");
        remote.off();
    }
}
```

### Adding New Remotes
```java
// Just add new implementor
public class SmartRemote implements Remote {
    @Override
    public void on() {
        System.out.println("On with Smart Remote (voice activated)");
    }
    
    @Override
    public void off() {
        System.out.println("Off with Smart Remote (gesture control)");
    }
}
```

Both can be combined without modifying existing code!

## References
- Gang of Four Design Patterns
- Head First Design Patterns
- Design Patterns Explained by Alan Shalloway
