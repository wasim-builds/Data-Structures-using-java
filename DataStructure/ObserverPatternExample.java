
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

class ConcreteObserver implements Observer {
    public void update() {
        System.out.println("ConcreteObserver has been notified!");
    }
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    void registerObserver(Observer observer) {
        observers.add(observer);
    }

    void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer = new ConcreteObserver();
        subject.registerObserver(observer);
        subject.notifyObservers();
    }
}