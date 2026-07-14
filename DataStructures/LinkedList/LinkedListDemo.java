package LinkedList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


public class LinkedListDemo {
    public static void main(String[] args) {
        // Create a LinkedList of Integers
        LinkedList<Integer> numbers = new LinkedList<>();

        // add(E e): Adds to the end
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        // addFirst(E e): Adds to the beginning
        numbers.addFirst(5);

        // addLast(E e): Adds to the end
        numbers.addLast(35);

        // Remove elements
        numbers.remove();            // Removes first element (5)
        numbers.removeFirst();       // Removes first element (10)
        numbers.removeLast();        // Removes last element (35)

        // Retrieve elements
        int first = numbers.getFirst();  // 20
        int last = numbers.getLast();    // 30
        int second = numbers.get(0);     // 20

        // Traverse the list
        System.out.println("Using iterator:");
        Iterator<Integer> itr = numbers.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " "); // Outputs each element
        }

        System.out.println("\nUsing listIterator:");
        ListIterator<Integer> listItr = numbers.listIterator();
        while (listItr.hasNext()) {
            System.out.print(listItr.next() + " "); // Outputs each element
        }
    }
}
