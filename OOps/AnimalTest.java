package OOps;
//21mis7125
interface Flyable {
    void fly();
}
interface Swimmable {
    void swim();
}


class Bird implements Flyable {
    public void fly() {
        System.out.println("The bird is flying.");
    }
}
class Fish implements Swimmable {
    public void swim() {
        System.out.println("The fish is swimming.");
    }
}
public class AnimalTest {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();

        Fish fish = new Fish();
        fish.swim();
    }
}
