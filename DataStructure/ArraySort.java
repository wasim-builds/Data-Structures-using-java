
import java.util.Arrays;
public class ArraySort {
    public static void main(String[] args) {
//Time Complexity: O(N log N)
//Auxiliary Space: O(1)
        int arr[] = {8,4,6,-7,-3,1234,-12};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
