package Stack;

import java.util.Stack;

public class ValidParentheses {
    // Check if a string of parentheses is valid
    // Time Complexity: O(n), Space Complexity: O(n)
    
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println("Test 1: " + isValid("()"));        // true
        System.out.println("Test 2: " + isValid("()[]{}"));    // true
        System.out.println("Test 3: " + isValid("(]"));        // false
        System.out.println("Test 4: " + isValid("([)]"));      // false
        System.out.println("Test 5: " + isValid("{[]}"));      // true
    }
}
