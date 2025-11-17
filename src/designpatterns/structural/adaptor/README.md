# Adapter Design Pattern

## Overview
The Adapter pattern is a **structural design pattern** that allows objects with incompatible interfaces to collaborate. It acts as a bridge between two incompatible interfaces by wrapping an existing class with a new interface.

## Intent
- Convert the interface of a class into another interface clients expect
- Allow classes with incompatible interfaces to work together
- Wrap an existing class with a new interface
- Make existing code work with new code without modifying either
- Enable reuse of existing functionality

## Problem It Solves
You often encounter situations where:
1. **Legacy Code Integration**: Need to use old code with new interfaces
2. **Third-Party Libraries**: External libraries don't match your interface requirements
3. **Interface Mismatch**: Two systems need to communicate but have different interfaces
4. **Reusability**: Want to reuse existing class but it doesn't have the right interface

Direct modification is problematic because:
- You don't have access to source code
- Modification would break existing clients
- The class is part of a larger system

## UML Structure
```
WebDriver (Target Interface)
├── + getElement(): void
└── + selectElement(): void

ChromeDriver (Concrete Target)
├── + getElement(): void
└── + selectElement(): void

IEDriver (Adaptee)
├── + findElement(): void
└── + clickElement(): void

WebDriverAdaptor (Adapter)
├── - ieDriver: IEDriver
├── + WebDriverAdaptor(IEDriver)
├── + getElement(): void [adapts to findElement()]
└── + selectElement(): void [adapts to clickElement()]
```

## Components

### 1. Target (WebDriver)
- The interface that the client expects to work with
- Defines domain-specific interface used by client code
- Client code is written against this interface

### 2. Adaptee (IEDriver)
- The existing class with incompatible interface
- Contains useful functionality but wrong interface
- Cannot be modified (third-party, legacy, or in-use)

### 3. Adapter (WebDriverAdaptor)
- Implements the Target interface
- Wraps the Adaptee object
- Translates calls from Target interface to Adaptee interface
- Makes Adaptee compatible with Target

### 4. Client (AdapterDesignPatterDriver)
- Works with objects through Target interface
- Unaware of the adaptation happening
- Can work with both native Target implementations and adapted objects

## Implementation Details

### Object Adapter (Composition) ✓ This Implementation
```java
public class WebDriverAdaptor implements WebDriver {
    private IEDriver ieDriver; // Composition
    
    public WebDriverAdaptor(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }
    
    @Override
    public void getElement() {
        ieDriver.findElement(); // Adaptation
    }
    
    @Override
    public void selectElement() {
        ieDriver.clickElement(); // Adaptation
    }
}
```

**Characteristics:**
- ✅ Uses composition (has-a relationship)
- ✅ More flexible (can adapt any IEDriver subclass)
- ✅ Can override Adaptee behavior
- ❌ Requires Adaptee instance

### Class Adapter (Inheritance)
```java
public class WebDriverAdaptor extends IEDriver implements WebDriver {
    @Override
    public void getElement() {
        findElement(); // Direct inheritance call
    }
    
    @Override
    public void selectElement() {
        clickElement(); // Direct inheritance call
    }
}
```

**Characteristics:**
- ✅ Simpler (no delegation needed)
- ✅ Can override Adaptee methods
- ❌ Less flexible (single inheritance in Java)
- ❌ Adapts only specific class, not subclasses

## Advantages

1. **Single Responsibility Principle**: Separates interface conversion from business logic
2. **Open/Closed Principle**: Can introduce new adapters without modifying existing code
3. **Reusability**: Reuse existing functionality with different interfaces
4. **Decoupling**: Client code doesn't depend on concrete classes
5. **Integration**: Easy integration of third-party libraries
6. **Legacy Support**: Work with legacy code without modification

## Disadvantages

1. **Complexity**: Increases overall code complexity
2. **Indirection**: Additional layer of abstraction
3. **Performance**: Slight overhead from delegation
4. **Maintenance**: More classes to maintain

## When to Use

✅ **Use Adapter Pattern When:**
- Need to use existing class with incompatible interface
- Want to create reusable class that works with unrelated classes
- Need to integrate third-party library with different interface
- Have legacy code that needs to work with new systems
- Want to use several existing subclasses but it's impractical to adapt their interface by subclassing

❌ **Avoid Adapter Pattern When:**
- Can modify the source code directly
- Interface difference is minimal
- Creating new class is simpler than adapting
- Performance overhead is critical

## Real-World Examples

### 1. Java I/O Adapters
```java
// Adapting byte stream to character stream
Reader reader = new InputStreamReader(new FileInputStream("file.txt"));

// BufferedReader adapts Reader interface
BufferedReader bufferedReader = new BufferedReader(reader);
```

### 2. Collections Framework
```java
// Arrays.asList() adapts array to List interface
String[] array = {"a", "b", "c"};
List<String> list = Arrays.asList(array);

// Collections.enumeration() adapts Iterator to Enumeration
Enumeration<String> enumeration = Collections.enumeration(list);
```

### 3. JDBC-ODBC Bridge
```java
// Adapts ODBC drivers to JDBC interface
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection conn = DriverManager.getConnection("jdbc:odbc:DataSource");
```

### 4. XML Adapters
```java
// JAXB uses adapters for custom type conversion
@XmlJavaTypeAdapter(DateAdapter.class)
private Date date;
```

### 5. Spring MVC
```java
// HandlerAdapter adapts different controller types
public interface HandlerAdapter {
    boolean supports(Object handler);
    ModelAndView handle(HttpServletRequest request, 
                       HttpServletResponse response, 
                       Object handler);
}
```

## Code Example Usage

```java
public class AdapterDesignPatterDriver {
    public static void main(String[] args) {
        // ChromeDriver already implements WebDriver interface
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();      // Direct call
        chromeDriver.selectElement();   // Direct call
        
        // IEDriver has incompatible interface
        IEDriver ieDriver = new IEDriver();
        ieDriver.findElement();         // Different method names
        ieDriver.clickElement();        // Different method names
        
        // Adapter makes IEDriver compatible with WebDriver interface
        WebDriverAdaptor adaptor = new WebDriverAdaptor(ieDriver);
        adaptor.getElement();           // Adapted to findElement()
        adaptor.selectElement();        // Adapted to clickElement()
        
        // Client can work with both through WebDriver interface
        performAutomation(chromeDriver); // Works directly
        performAutomation(adaptor);      // Works through adapter
    }
    
    // Client method works with Target interface
    public static void performAutomation(WebDriver driver) {
        driver.getElement();
        driver.selectElement();
    }
}
```

## Adapter vs Other Patterns

### Adapter vs Bridge
| Aspect | Adapter | Bridge |
|--------|---------|--------|
| **Intent** | Make incompatible interfaces work together | Separate abstraction from implementation |
| **When** | After classes are designed | During design phase |
| **Focus** | Compatibility | Flexibility |
| **Structure** | Wraps existing interface | Two independent hierarchies |

### Adapter vs Decorator
| Aspect | Adapter | Decorator |
|--------|---------|-----------|
| **Intent** | Change interface | Add responsibilities |
| **Interface** | Changes interface | Keeps same interface |
| **Purpose** | Compatibility | Enhancement |
| **Number** | Usually one adapter | Can stack multiple |

### Adapter vs Facade
| Aspect | Adapter | Facade |
|--------|---------|--------|
| **Intent** | Match interface | Simplify interface |
| **Adaptee** | Usually one class | Multiple classes/subsystem |
| **Interface** | Same capabilities, different interface | Simpler interface |
| **Bidirectional** | Can be bidirectional | Usually unidirectional |

## Best Practices

1. **Prefer Composition**: Use object adapter over class adapter in Java
2. **Single Responsibility**: Each adapter should adapt one interface
3. **Naming Convention**: Use "Adapter" or "Adaptor" suffix
4. **Document Mapping**: Clearly document which methods map to which
5. **Handle Exceptions**: Properly translate exceptions between interfaces
6. **Consider Two-Way Adapters**: Allow adaptation in both directions if needed
7. **Use Interfaces**: Both target and adaptee should be interfaces when possible

## Two-Way Adapter Example
```java
public class TwoWayAdapter implements WebDriver, IEDriverInterface {
    private IEDriver ieDriver;
    
    // WebDriver → IEDriver adaptation
    @Override
    public void getElement() {
        ieDriver.findElement();
    }
    
    // IEDriver → WebDriver adaptation
    @Override
    public void findElement() {
        getElement();
    }
}
```

## Advanced Scenarios

### Adapting Multiple Classes
```java
public class UniversalDriverAdapter implements WebDriver {
    private Object driver;
    
    public UniversalDriverAdapter(Object driver) {
        this.driver = driver;
    }
    
    @Override
    public void getElement() {
        if (driver instanceof IEDriver) {
            ((IEDriver) driver).findElement();
        } else if (driver instanceof FirefoxDriver) {
            ((FirefoxDriver) driver).locateElement();
        }
        // ... more adaptations
    }
}
```

### Pluggable Adapters
```java
public interface DriverAdapter {
    void getElement();
    void selectElement();
}

public class AdapterFactory {
    public static DriverAdapter getAdapter(String driverType) {
        switch (driverType) {
            case "IE":
                return new IEDriverAdapter();
            case "Firefox":
                return new FirefoxDriverAdapter();
            default:
                throw new IllegalArgumentException("Unknown driver");
        }
    }
}
```

## Testing Considerations

```java
@Test
public void testAdapterDelegation() {
    // Arrange
    IEDriver ieDriver = mock(IEDriver.class);
    WebDriverAdaptor adapter = new WebDriverAdaptor(ieDriver);
    
    // Act
    adapter.getElement();
    
    // Assert
    verify(ieDriver).findElement();
}

@Test
public void testAdapterInterface() {
    IEDriver ieDriver = new IEDriver();
    WebDriver adapter = new WebDriverAdaptor(ieDriver);
    
    // Verify adapter implements target interface
    assertTrue(adapter instanceof WebDriver);
}
```

## Common Pitfalls

1. **Over-Adaptation**: Creating adapters when direct modification is better
2. **Leaky Abstraction**: Exposing adaptee details through adapter
3. **Incomplete Adaptation**: Not implementing all target interface methods
4. **Wrong Pattern**: Using adapter when bridge or facade is more appropriate
5. **Multiple Responsibilities**: Adapter doing more than interface conversion

## Related Patterns

- **Bridge**: Separates abstraction from implementation (design-time)
- **Decorator**: Adds responsibilities while keeping interface
- **Proxy**: Provides same interface with access control
- **Facade**: Simplifies interface to subsystem

## Extension Points

### Adding New Browser Drivers
```java
// 1. Create new incompatible driver
public class SafariDriver {
    public void searchElement() { }
    public void chooseElement() { }
}

// 2. Create adapter
public class SafariDriverAdapter implements WebDriver {
    private SafariDriver safariDriver;
    
    public SafariDriverAdapter(SafariDriver driver) {
        this.safariDriver = driver;
    }
    
    @Override
    public void getElement() {
        safariDriver.searchElement();
    }
    
    @Override
    public void selectElement() {
        safariDriver.chooseElement();
    }
}
```

## References
- Gang of Four Design Patterns
- Head First Design Patterns
- Martin Fowler's Design Patterns
