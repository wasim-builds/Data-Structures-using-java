package Stack;

import java.util.Stack;

public class RemoveKDigits {
    // Remove k digits to get the smallest possible number
    // Time Complexity: O(n), Space Complexity: O(n)
    
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        // Remove remaining k digits from end
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // Build result
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();
        
        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.length() == 0 ? "0" : result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("Test 1: " + removeKdigits("1432219", 3));  // "1219"
        System.out.println("Test 2: " + removeKdigits("10200", 1));    // "200"
        System.out.println("Test 3: " + removeKdigits("10", 2));       // "0"
    }
}
