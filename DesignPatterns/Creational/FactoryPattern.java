package DesignPatterns.Creational;

/**
 * Factory Design Pattern
 * 
 * Purpose: Creates objects without specifying the exact class to create.
 * 
 * Use Cases:
 * - When exact type of object isn't known until runtime
 * - When object creation logic is complex
 * - When you want to centralize object creation
 * 
 * Interview Points:
 * - Promotes loose coupling
 * - Single Responsibility Principle
 * - Open/Closed Principle
 */

// Product interface
interface Shape {
    void draw();
}

// Concrete Products
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}

// Factory class
class ShapeFactory {
    // Factory method
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        switch (shapeType.toUpperCase()) {
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            case "TRIANGLE":
                return new Triangle();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}

// Real-world example: Notification Factory
interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

class NotificationFactory {
    public static Notification createNotification(String channel) {
        switch (channel.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification channel: " + channel);
        }
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        // Shape Factory Example
        System.out.println("=== Shape Factory ===");
        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();

        Shape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        Shape triangle = ShapeFactory.getShape("TRIANGLE");
        triangle.draw();

        // Notification Factory Example (Real-world)
        System.out.println("\n=== Notification Factory ===");
        Notification email = NotificationFactory.createNotification("EMAIL");
        email.send("Welcome to our platform!");

        Notification sms = NotificationFactory.createNotification("SMS");
        sms.send("Your OTP is 123456");

        Notification push = NotificationFactory.createNotification("PUSH");
        push.send("You have a new message");

        // Demonstrate error handling
        try {
            Shape unknown = ShapeFactory.getShape("HEXAGON");
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}
