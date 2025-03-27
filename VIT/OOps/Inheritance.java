package OOps;

// Parent Class (Base Class)
class Animal {
    String name;

    void eat() {
        System.out.println(name + " is eating.");
    }
}

// Child Class (Derived Class)
class Dog extends Animal {
    void bark() {
        System.out.println(name + " is barking.");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.name = "Buddy";  // Inherited property
        myDog.eat();           // Inherited method
        myDog.bark();          // Unique method
    }
}


// Real-Life Example: Family (Parent-Child Relationship)
// Imagine a family where a child inherits features from their parents.
// For example:

// A father has a last name, eye color, and height.

// His child inherits these traits but can also have unique characteristics like voice or hobbies.

// Parent Class → Common Properties
// Child Class → Inherits Parent’s Properties + Adds New Ones

