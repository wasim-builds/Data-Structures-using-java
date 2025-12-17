package Stack;

import java.util.Stack;

public class BasicCalculator {
    // Implement a basic calculator to evaluate simple expression string
    // Time Complexity: O(n), Space Complexity: O(n)
    
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int number = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // sign
                result += stack.pop(); // result
            }
        }
        
        if (number != 0) {
            result += sign * number;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("Test 1: " + calculate("1 + 1"));           // 2
        System.out.println("Test 2: " + calculate(" 2-1 + 2 "));       // 3
        System.out.println("Test 3: " + calculate("(1+(4+5+2)-3)+(6+8)")); // 23
    }
}
