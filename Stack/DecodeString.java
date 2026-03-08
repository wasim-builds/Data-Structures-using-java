package Stack;

import java.util.Stack;

public class DecodeString {
    // Decode an encoded string (k[encoded_string])
    // Time Complexity: O(n), Space Complexity: O(n)
    
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int k = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = "";
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = new StringBuilder(stringStack.pop());
                int repeat = countStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(currentString);
                }
                currentString = decoded.toString();
            } else {
                currentString += ch;
            }
        }
        
        return currentString;
    }
    
    public static void main(String[] args) {
        System.out.println("Test 1: " + decodeString("3[a]2[bc]"));        // "aaabcbc"
        System.out.println("Test 2: " + decodeString("3[a2[c]]"));         // "accaccacc"
        System.out.println("Test 3: " + decodeString("2[abc]3[cd]ef"));    // "abcabccdcdcdef"
    }
}
