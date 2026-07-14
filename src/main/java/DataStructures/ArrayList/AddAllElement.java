package ArrayList;



// Java program to demonstrate adding 
// elements at a specific index
import java.util.ArrayList;

public class AddAllElement {
  
    public static void main(String[] args) {
      
        ArrayList<String> l1 = new ArrayList<>();
        l1.add("Java");
        l1.add("C++");
        l1.add("Python");

        ArrayList<String> l2 = new ArrayList<>();
        l2.add("C");
        l2.add("AI");

        // Adding elements of 
        // l2 at index 2
        l1.addAll(2, l2);

        System.out.println("" + l1);
    }
}