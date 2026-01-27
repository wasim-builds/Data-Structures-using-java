# Design Patterns in Java

This directory contains implementations of common design patterns frequently asked in technical interviews and used in production code.

## 📚 Pattern Categories

### Creational Patterns
Patterns that deal with object creation mechanisms.

- **Singleton Pattern** - Ensures a class has only one instance
- **Factory Pattern** - Creates objects without specifying exact class
- **Builder Pattern** - Constructs complex objects step by step

### Structural Patterns
Patterns that deal with object composition and relationships.

- **Decorator Pattern** - Adds functionality to objects dynamically
- **Facade Pattern** - Provides simplified interface to complex subsystem

### Behavioral Patterns
Patterns that deal with object collaboration and responsibilities.

- **Strategy Pattern** - Defines family of interchangeable algorithms
- **Template Method Pattern** - Defines algorithm skeleton in base class
- **Iterator Pattern** - Provides way to access elements sequentially

## 🎯 When to Use Each Pattern

| Pattern | Use Case | Example |
|---------|----------|---------|
| Singleton | Global access to single instance | Database connection, Logger |
| Factory | Create objects based on input | Shape factory, Document creator |
| Builder | Complex object construction | HTTP request builder, SQL query builder |
| Decorator | Add responsibilities dynamically | I/O streams, UI components |
| Facade | Simplify complex system | Library API, Framework wrapper |
| Strategy | Runtime algorithm selection | Sorting strategies, Payment methods |
| Template Method | Common algorithm structure | Data processing pipeline |
| Iterator | Sequential access | Collection traversal |

## 💡 Interview Tips

1. **Know the problem each pattern solves**
2. **Understand trade-offs** (complexity vs flexibility)
3. **Provide real-world examples**
4. **Be able to code at least 3-4 patterns from scratch**
5. **Discuss when NOT to use a pattern**

## 🔗 Resources

- Each pattern includes detailed comments and examples
- Multiple implementation approaches where applicable
- Test cases demonstrating usage
