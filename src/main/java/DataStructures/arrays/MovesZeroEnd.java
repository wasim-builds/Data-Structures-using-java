package arrays;
import java.util.Arrays;


public class MovesZeroEnd {
    public static void moveToEnd(int[] arr, int target) {
        int index = 0; // Pointer for non-target elements
        
        // Move non-target elements to the front
        for (int num : arr) {
            if (num != target) {
                arr[index++] = num;
            }
        }
        
        // Fill the remaining spaces with the target value
        while (index < arr.length) {
            arr[index++] = target;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0}; 
        moveToEnd(arr, 0); // Move all 0s to the end
        System.out.println(Arrays.toString(arr)); // Output: [1, 2, 4, 3, 5, 0, 0, 0]
    }
}

        // Arrays.sort(arr);
        // List<Integer> list= new ArrayList<>();
        // List<Integer> list2= new ArrayList<>();

        // for(int i=0;i<arr.length;i++){
        //     if(arr[i] != 0){
        //         list.add(arr[i]);
        //     }
        //     else{
        //         list2.add(arr[i]);

        //     }

        // }

        // System.out.println(list);

        // System.out.println(list2);
        // // add list1 and list2
        



