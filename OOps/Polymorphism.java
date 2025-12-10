package OOps;


class Vehicle {
    void drive() {
        System.out.println("Driving a vehicle...");
    }
}

class Car extends Vehicle {
    void drive() {
        System.out.println("Driving a car...");
    }
}

class Bike extends Vehicle {
    void drive() {
        System.out.println("Riding a bike...");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();
        
        v1.drive();  // Output: Driving a car...
        v2.drive();  // Output: Riding 


// Regardless of the type, the driver uses the same "Drive" action, but the behavior changes based on the vehicle.