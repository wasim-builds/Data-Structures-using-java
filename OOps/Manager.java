package OOps;


interface Person {
    String name = "Alice";
    int age = 35;

    void details(); 

    default void hobbies() {
        System.out.println("Hobbies: Reading, Travelling");
    }
}


interface Employees {
    int eid = 101;
    String designation = "Manager";

    void show(); 
}

public class Manager implements Person, Employees {

    @Override
    public void details() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    @Override
    public void show() {
        System.out.println("Employee ID: " + eid);
        System.out.println("Designation: " + designation);
    }
//21MIS7125
    public static void main(String[] args) {
        Manager m = new Manager();
        m.details();      
        m.hobbies();      
        m.show();         
    }
}

