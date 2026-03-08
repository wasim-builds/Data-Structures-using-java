package Stack;

import java.util.Stack;

public class ScoreOfParentheses {
    // Calculate score of balanced parentheses
    // () = 1, (A) = 2*A, AB = A+B
    // Time Complexity: O(n), Space Complexity: O(n)
    
    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Initial score
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int val = stack.pop();
                int top = stack.pop();
                stack.push(top + Math.max(2 * val, 1));
            }
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        System.out.println("Test 1: " + scoreOfParentheses("()"));          // 1
        System.out.println("Test 2: " + scoreOfParentheses("(())"));        // 2
        System.out.println("Test 3: " + scoreOfParentheses("()()"));        // 2
        System.out.println("Test 4: " + scoreOfParentheses("(()(()))"));    // 6
    }
}
