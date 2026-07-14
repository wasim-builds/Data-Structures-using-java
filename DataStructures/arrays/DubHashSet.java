package arrays;
import java.util.*;

public class DubHashSet {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 2, 5, 1, 6, 3};

        // Use HashSet to remove duplicates
        HashSet<Integer> set = new HashSet<>(Arrays.asList(array));

        // Convert back to array
        Integer[] uniqueArray = set.toArray(new Integer[0]);

        // Print the result
        System.out.println("Array after removing duplicates: " + Arrays.toString(uniqueArray));
    }
}