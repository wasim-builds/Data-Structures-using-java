package OOps;

// Parent Class (Base Class)
class Animal {
    String name;

    void eat() {
        System.out.println(name + "is eating");
    }
}

// Child Class (Derived Class)
class Dog extends Animal {
    void bark() {
        System.out.println(name + "is barking");
    }

}
class Cat extends Animal{
    void sound(){
        System.out.println("meow meow");
    }
}
// one to one relationship

public class Inheritance {
    public static void main(String[] args) {
        Dog work = new Dog();
        work.name = "Chimtu ";  // Inherited property
        work.eat();           // Inherited method
        work.bark();          // Unique method
        work.sound();
    }
}



































// Real-Life Example: Family (Parent-Child Relationship)
// Imagine a family where a child inherits features from their parents.
// For example:

// A father has a last name, eye color, and height.

// His child inherits these traits but can also have unique characteristics like voice or hobbies.

// Parent Class → Common Properties
// Child Class → Inherits Parent’s Properties + Adds New Ones

