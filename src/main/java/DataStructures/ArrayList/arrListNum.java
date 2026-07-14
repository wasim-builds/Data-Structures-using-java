package ArrayList;
import java.util.ArrayList;

public class arrListNum {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        System.out.println(numbers);
        System.out.println(numbers.size());
        numbers.add(50);
        numbers.add(100);
        numbers.add(174);
        System.out.println(numbers);

        // add an element at specific index
        numbers.add(0,12);
        System.out.println(numbers);
        // remove an element at specific index
        numbers.remove(2);
    }
    
}
