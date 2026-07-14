package OOps;


// Interface Animal with method sound()
interface Animal {
    void sound();
}

// Interface Pet extends Animal and adds method play()
interface Pet extends Animal {
    void play();
}

// Dog class implements Pet (which includes Animal)
class Dog implements Pet {
    // Implement sound() from Animal
    public void sound() {
        System.out.println("The dog barks: Woof! Woof!");
    }

    // Implement play() from Pet
    public void play() {
        System.out.println("The dog is playing fetch.");
    }
}

// Main class to run the program
public class Main1 {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.sound();
        myDog.play();
    }
}
