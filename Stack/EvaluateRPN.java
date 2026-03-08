package Stack;

import java.util.Stack;

public class EvaluateRPN {
    // Evaluate Reverse Polish Notation expression
    // Time Complexity: O(n), Space Complexity: O(n)
    
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Test 1: " + evalRPN(tokens1));  // 9
        
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Test 2: " + evalRPN(tokens2));  // 6
        
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Test 3: " + evalRPN(tokens3));  // 22
    }
}
