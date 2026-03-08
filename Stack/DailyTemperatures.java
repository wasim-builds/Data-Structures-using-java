package Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    // Find how many days until a warmer temperature
    // Time Complexity: O(n), Space Complexity: O(n)
    
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] temps1 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Temperatures: " + Arrays.toString(temps1));
        System.out.println("Days to wait: " + Arrays.toString(dailyTemperatures(temps1)));
        // [1, 1, 4, 2, 1, 1, 0, 0]
        
        int[] temps2 = {30, 40, 50, 60};
        System.out.println("\nTemperatures: " + Arrays.toString(temps2));
        System.out.println("Days to wait: " + Arrays.toString(dailyTemperatures(temps2)));
        // [1, 1, 1, 0]
    }
}
