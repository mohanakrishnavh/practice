# Singleton Design Pattern

## Overview
The Singleton pattern is a **creational design pattern** that ensures a class has only one instance and provides a global point of access to that instance. It's one of the most commonly used (and sometimes misused) design patterns.

## Intent
- Ensure a class has only one instance
- Provide global access to that instance
- Lazy initialization (create instance only when needed)
- Thread-safe instance creation
- Prevent multiple instances through controlled instantiation

## Problem It Solves
Some classes should have exactly one instance:
1. **Resource Managers**: Database connections, file managers, thread pools
2. **Configuration Objects**: Application settings, preferences
3. **Caches**: Shared cache across application
4. **Logging**: Single logger instance
5. **Device Drivers**: Printer spooler, graphics driver

Multiple instances of these classes can cause:
- Resource waste
- Inconsistent state
- Conflicts and race conditions

## Implementation Approaches

This repository demonstrates **four different Singleton implementations**, each with different characteristics:

### 1. Eager Initialization (SingletonEager)
```java
public class SingletonEager {
    private static final SingletonEager instance = new SingletonEager();
    
    private SingletonEager() {}
    
    public static SingletonEager getInstance() {
        return instance;
    }
}
```

**Characteristics:**
- ✅ Thread-safe (created at class loading)
- ✅ Simple and easy to understand
- ❌ Instance created even if never used
- ❌ No lazy initialization
- ❌ Can't handle exceptions during creation

**Use When:**
- Instance will definitely be used
- Instance creation is not expensive
- Instance creation won't fail

### 2. Lazy Initialization (SingletonLazy)
```java
public class SingletonLazy {
    private static SingletonLazy instance;
    
    private SingletonLazy() {}
    
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
```

**Characteristics:**
- ✅ Lazy initialization (created when first needed)
- ✅ Simple implementation
- ❌ **NOT thread-safe** (multiple instances possible)
- ❌ Only suitable for single-threaded applications

**Use When:**
- Single-threaded environment only
- Simplicity is more important than thread safety

### 3. Synchronized Method (SingletonSynchronized)
```java
public class SingletonSynchronized {
    private static SingletonSynchronized instance;
    
    private SingletonSynchronized() {}
    
    public static synchronized SingletonSynchronized getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronized();
        }
        return instance;
    }
}
```

**Characteristics:**
- ✅ Thread-safe
- ✅ Lazy initialization
- ❌ **Performance overhead** (synchronization on every call)
- ❌ Slower than other approaches

**Use When:**
- Thread safety is required
- getInstance() is not called frequently
- Performance is not critical

### 4. Double-Checked Locking ✓ (SingletonBlockSynchronized) **RECOMMENDED**
```java
public class SingletonBlockSynchronized {
    private static volatile SingletonBlockSynchronized instance;
    
    private SingletonBlockSynchronized() {}
    
    public static SingletonBlockSynchronized getInstance() {
        if (instance == null) {
            synchronized (SingletonBlockSynchronized.class) {
                if (instance == null) {
                    instance = new SingletonBlockSynchronized();
                }
            }
        }
        return instance;
    }
}
```

**Characteristics:**
- ✅ Thread-safe
- ✅ Lazy initialization
- ✅ **Minimal synchronization overhead**
- ✅ Best performance among thread-safe approaches
- ⚠️ Requires `volatile` keyword (Java 5+)

**Use When:**
- Thread safety is required
- getInstance() is called frequently
- Need both lazy initialization and good performance

## UML Structure
```
Singleton
├── - instance: Singleton [static]
├── - Singleton() [private constructor]
└── + getInstance(): Singleton [static]
```

## Key Components

### 1. Private Constructor
```java
private SingletonBlockSynchronized() {
    // Prevents external instantiation
}
```
Prevents clients from creating instances using `new`.

### 2. Static Instance Variable
```java
private static volatile SingletonBlockSynchronized instance;
```
- `static`: Shared across all potential instances
- `volatile`: Ensures visibility across threads (prevents instruction reordering)

### 3. Public Static Access Method
```java
public static SingletonBlockSynchronized getInstance()
```
Global access point to get the singleton instance.

## Double-Checked Locking Explained

### Why Two Checks?

**First Check (Outside Synchronized Block):**
```java
if (instance == null) { // First check - No synchronization
    synchronized (SingletonBlockSynchronized.class) {
        ...
    }
}
```
- Avoids synchronization overhead after instance is created
- 99% of calls bypass synchronization after first creation

**Second Check (Inside Synchronized Block):**
```java
synchronized (SingletonBlockSynchronized.class) {
    if (instance == null) { // Second check - With synchronization
        instance = new SingletonBlockSynchronized();
    }
}
```
- Prevents multiple instances if multiple threads passed first check
- Ensures only one thread creates the instance

### Why `volatile` Keyword?

Without `volatile`, the JVM might reorder instructions:
```java
instance = new SingletonBlockSynchronized();
```

This seemingly atomic operation actually involves:
1. Allocate memory
2. Initialize object
3. Assign reference to `instance`

Without `volatile`, steps 2 and 3 could be reordered, causing other threads to see a partially constructed object.

## Advantages

1. **Controlled Access**: Single point of access to the instance
2. **Lazy Initialization**: Create instance only when needed (lazy approaches)
3. **Global Access**: Accessible from anywhere in application
4. **Memory Efficiency**: Only one instance exists
5. **Namespace Pollution**: Reduces global namespace usage

## Disadvantages

1. **Global State**: Can make code harder to test and maintain
2. **Hidden Dependencies**: Implicit dependencies are harder to track
3. **Tight Coupling**: Classes become coupled to the Singleton
4. **Difficult Testing**: Hard to mock for unit tests
5. **Violation of SRP**: Class manages both its business logic and instance control
6. **Multithreading Complexity**: Requires careful thread-safety implementation

## When to Use

✅ **Use Singleton Pattern When:**
- Exactly one instance is required
- Instance needs global access
- Lazy initialization is beneficial
- Resource is expensive to create
- Need to coordinate actions across system

✅ **Examples:**
- Database connection pools
- Configuration managers
- Logger instances
- Cache managers
- Thread pools
- File system managers

❌ **Avoid Singleton Pattern When:**
- Multiple instances might be needed later
- Testing flexibility is important
- Dependency injection is available
- State needs to be isolated
- Pattern is used just for "convenience"

## Modern Alternatives

### 1. Enum Singleton (Best Practice in Java)
```java
public enum SingletonEnum {
    INSTANCE;
    
    public void doSomething() {
        // Implementation
    }
}

// Usage
SingletonEnum.INSTANCE.doSomething();
```

**Advantages:**
- ✅ Simplest implementation
- ✅ Thread-safe automatically
- ✅ Serialization-safe
- ✅ Reflection-proof

### 2. Bill Pugh Singleton (Initialization-on-demand)
```java
public class Singleton {
    private Singleton() {}
    
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```

**Advantages:**
- ✅ Thread-safe without synchronization
- ✅ Lazy initialization
- ✅ No performance overhead

### 3. Dependency Injection (Recommended Modern Approach)
```java
// Don't use Singleton pattern at all
// Let DI container manage instance lifecycle

@Component
@Scope("singleton") // Spring manages single instance
public class ConfigurationManager {
    // Implementation
}
```

## Breaking Singleton Pattern

### 1. Reflection Attack
```java
Constructor<SingletonBlockSynchronized> constructor = 
    SingletonBlockSynchronized.class.getDeclaredConstructor();
constructor.setAccessible(true);
SingletonBlockSynchronized instance = constructor.newInstance();
```

**Prevention:**
```java
private SingletonBlockSynchronized() {
    if (instance != null) {
        throw new IllegalStateException("Instance already created!");
    }
}
```

### 2. Serialization Attack
```java
// If Singleton implements Serializable
ObjectInputStream in = new ObjectInputStream(...);
SingletonBlockSynchronized instance = (SingletonBlockSynchronized) in.readObject();
```

**Prevention:**
```java
protected Object readResolve() {
    return getInstance();
}
```

### 3. Cloning Attack
**Prevention:**
```java
@Override
protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
}
```

## Testing Singleton

### Challenge
Singletons maintain state across tests, making unit testing difficult.

### Solutions

**1. Use Dependency Injection:**
```java
public class MyClass {
    private Singleton singleton;
    
    public MyClass(Singleton singleton) {
        this.singleton = singleton;
    }
}

// In tests
MyClass myClass = new MyClass(mockSingleton);
```

**2. Reset Method (Use Carefully):**
```java
public static void resetInstance() {
    instance = null; // Only for testing!
}
```

**3. Use Interfaces:**
```java
public interface Logger {
    void log(String message);
}

public class SingletonLogger implements Logger {
    // Singleton implementation
}

// Easy to mock the interface in tests
```

## Code Example Usage

```java
// Using Double-Checked Locking Singleton
public class SingletonDriver {
    public static void main(String[] args) {
        // Create threads to test thread safety
        Thread t1 = new Thread(() -> {
            SingletonBlockSynchronized instance1 = 
                SingletonBlockSynchronized.getInstance();
            System.out.println("Thread 1: " + instance1);
        });

        Thread t2 = new Thread(() -> {
            SingletonBlockSynchronized instance2 = 
                SingletonBlockSynchronized.getInstance();
            System.out.println("Thread 2: " + instance2);
        });

        t1.start();
        t2.start();
        
        // Both threads will print the same instance reference
    }
}
```

## Best Practices

1. **Use Enum if Possible**: Simplest and safest
2. **Prefer Dependency Injection**: Better testability
3. **Document Thread Safety**: Clearly state thread-safety guarantees
4. **Consider Bill Pugh**: For non-enum implementations
5. **Avoid Global State**: Minimize singleton usage
6. **Make Thread-Safe**: Always consider multithreading
7. **Protect Against Reflection**: Add checks in constructor
8. **Handle Serialization**: Implement readResolve()

## Common Pitfalls

1. **Not Thread-Safe**: Using lazy initialization without synchronization
2. **Over-Synchronization**: Synchronizing entire getInstance() method
3. **Missing volatile**: Forgetting volatile in double-checked locking
4. **Too Many Singletons**: Using singleton for everything
5. **Tight Coupling**: Making code dependent on singleton

## Related Patterns

- **Factory Method**: Often implemented as Singleton
- **Abstract Factory**: Can be implemented as Singleton
- **Builder**: Builder itself might be Singleton
- **Prototype**: Alternative to Singleton for object creation
- **Facade**: Often implemented as Singleton

## References
- Gang of Four Design Patterns
- Effective Java by Joshua Bloch (Item 3: Enforce the singleton property with a private constructor or an enum type)
- Java Concurrency in Practice
