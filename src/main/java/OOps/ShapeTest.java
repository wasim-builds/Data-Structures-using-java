package OOps;


abstract class Shape {
    abstract double area();
    abstract double perimeter();
}


class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle class
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    double perimeter() {
        return 2 * (width + height);
    }
}

// Triangle class
class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double area() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's formula
    }

    @Override
    double perimeter() {
        return a + b + c;
    }
}


public class ShapeTest {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 4, 5)
        };

        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() +
                ": Area = " + shape.area() +
                ", Perimeter = " + shape.perimeter());
        }
    }
}
