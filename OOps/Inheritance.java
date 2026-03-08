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
        
        Cat cat = new Cat();
        cat.name = "Kitty ";
        cat.sound();
    }
}




































