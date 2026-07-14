package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    // Find the next greater element for each element in the array
    // Time Complexity: O(n), Space Complexity: O(n)
    
    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Initialize result with -1
        Arrays.fill(result, -1);
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements smaller than current
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            // If stack is not empty, top is the next greater element
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            
            // Push current element
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        int[] result = nextGreaterElements(arr);
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Next Greater Elements: " + Arrays.toString(result));
        
        int[] arr2 = {13, 7, 6, 12};
        int[] result2 = nextGreaterElements(arr2);
        System.out.println("\nArray: " + Arrays.toString(arr2));
        System.out.println("Next Greater Elements: " + Arrays.toString(result2));
    }
}
