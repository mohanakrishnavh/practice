# Composite Design Pattern

## Overview
The Composite pattern is a **structural design pattern** that allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.

## Intent
- Compose objects into tree structures to represent part-whole hierarchies
- Allow clients to treat individual objects and compositions uniformly
- Represent hierarchical structures with recursive composition
- Simplify client code by treating leaf and composite nodes the same way

## Problem It Solves
When working with tree structures, clients often need different code to handle:
1. **Leaf Objects**: Individual objects without children
2. **Composite Objects**: Objects that contain other objects
3. **Hierarchical Operations**: Operations that need to traverse the entire structure

The Composite pattern unifies the interface so clients can work with both types identically.

## UML Structure
```
Account (Component)
├── + getBalance(): float
│
├── DepositAccount (Leaf)
│   ├── - accountNo: String
│   ├── - accountBalance: float
│   └── + getBalance(): float
│
├── SavingAccount (Leaf)
│   ├── - accountNo: String
│   ├── - accountBalance: float
│   └── + getBalance(): float
│
└── CompositeAccount (Composite)
    ├── - accounts: List<Account>
    ├── + getBalance(): float
    ├── + addAccount(Account): void
    └── + removeAccount(Account): void
```

## Components

### 1. Component (Account)
- Abstract base class defining the common interface
- Declares operations that are common to both leaf and composite objects
- Defines the contract: `getBalance()`

### 2. Leaf (DepositAccount, SavingAccount)
- Represents leaf objects with no children
- Implements the component interface
- Performs actual work (returns its own balance)

### 3. Composite (CompositeAccount)
- Contains child components (leaves or other composites)
- Implements component interface by delegating to children
- Provides methods to manage children: `addAccount()`, `removeAccount()`
- Aggregates results from all children

## Implementation Details

### Tree Structure
```
CompositeAccount (Total: 2250)
├── DepositAccount (DA001: 100)
├── DepositAccount (DA002: 150)
└── SavingAccount (SA001: 2000)
```

### Recursive Composition
CompositeAccount can contain other CompositeAccounts:
```
RootComposite
├── CompositeAccount1
│   ├── DepositAccount
│   └── SavingAccount
└── CompositeAccount2
    ├── DepositAccount
    └── SavingAccount
```

## Advantages

1. **Uniform Treatment**: Treat individual and composite objects the same way
2. **Easy to Add New Components**: New leaf or composite types are easy to add
3. **Simplified Client Code**: Clients don't need to distinguish between types
4. **Natural Tree Structures**: Perfect for hierarchical data
5. **Open/Closed Principle**: Open for extension, closed for modification

## Disadvantages

1. **Overly General**: Can make design too general
2. **Type Safety**: Hard to restrict composite to certain types
3. **Complexity**: May be overkill for simple structures
4. **Performance**: Recursive operations can be slow for deep hierarchies

## When to Use

✅ **Use Composite Pattern When:**
- Need to represent part-whole hierarchies
- Want clients to ignore differences between leaf and composite objects
- Working with tree structures (file systems, organizational charts, etc.)
- Need to perform operations uniformly across structure
- Structure can be recursive

❌ **Avoid Composite Pattern When:**
- Structure is not hierarchical
- Distinction between leaf and composite is important
- Operations differ significantly between leaf and composite

## Real-World Examples

1. **File System**
   ```
   Directory (Composite)
   ├── File (Leaf)
   ├── File (Leaf)
   └── Directory (Composite)
       ├── File (Leaf)
       └── File (Leaf)
   ```

2. **GUI Components**
   ```
   Panel (Composite)
   ├── Button (Leaf)
   ├── TextField (Leaf)
   └── Panel (Composite)
       ├── Label (Leaf)
       └── Checkbox (Leaf)
   ```

3. **Organization Structure**
   ```
   Department (Composite)
   ├── Employee (Leaf)
   ├── Employee (Leaf)
   └── Department (Composite)
       ├── Employee (Leaf)
       └── Employee (Leaf)
   ```

4. **Graphics/Drawing Applications**
   ```
   Group (Composite)
   ├── Circle (Leaf)
   ├── Rectangle (Leaf)
   └── Group (Composite)
       ├── Line (Leaf)
       └── Text (Leaf)
   ```

## Code Example Usage

```java
// Create a composite account structure
CompositeAccount portfolio = new CompositeAccount();

// Add individual accounts
portfolio.addAccount(new DepositAccount("DA001", 100.00f));
portfolio.addAccount(new DepositAccount("DA002", 150.00f));
portfolio.addAccount(new SavingAccount("SA001", 2000.00f));

// Get total balance (same interface as individual accounts)
float totalBalance = portfolio.getBalance(); // Returns 2250.00
```

## Best Practices

1. **Consistent Interface**: Keep component interface simple and uniform
2. **Child Management**: Decide where to declare child management operations
3. **Parent Reference**: Consider adding parent reference for traversal
4. **Ordering**: Maintain child order if needed
5. **Caching**: Cache aggregate results for performance
6. **Null Checks**: Handle null children gracefully

## Design Decisions

### Where to Declare Child Management?
**Option 1: In Component (Base Class)**
- Pro: Uniform interface
- Con: Leaf classes have unused methods

**Option 2: In Composite Only** ✓ (Used in this implementation)
- Pro: Type safety
- Con: Clients must know composite type

### Should Component Know Its Parent?
**Option 1: Yes**
- Pro: Easy to navigate up the tree
- Con: More coupling, harder to share components

**Option 2: No** ✓ (Used in this implementation)
- Pro: Simpler, easier to share
- Con: Can't navigate upward

## Variations

### 1. Transparent Composite
Child management methods in Component interface

### 2. Safe Composite
Child management methods only in Composite class (this implementation)

### 3. Cached Composite
Caches results for better performance

## Related Patterns

- **Decorator**: Similar structure but different intent
- **Flyweight**: Often used with Composite for sharing leaf objects
- **Iterator**: Used to traverse composite structures
- **Visitor**: Perform operations on composite structures

## Testing Considerations

```java
@Test
public void testCompositeBalance() {
    CompositeAccount composite = new CompositeAccount();
    composite.addAccount(new DepositAccount("DA001", 100.00f));
    composite.addAccount(new SavingAccount("SA001", 200.00f));
    
    assertEquals(300.00f, composite.getBalance(), 0.01);
}

@Test
public void testNestedComposite() {
    CompositeAccount root = new CompositeAccount();
    CompositeAccount child = new CompositeAccount();
    
    child.addAccount(new DepositAccount("DA001", 100.00f));
    root.addAccount(child);
    root.addAccount(new SavingAccount("SA001", 200.00f));
    
    assertEquals(300.00f, root.getBalance(), 0.01);
}
```

## References
- Gang of Four Design Patterns
- Head First Design Patterns
