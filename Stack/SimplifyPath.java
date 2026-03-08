package Stack;

import java.util.Stack;

public class SimplifyPath {
    // Simplify Unix-style file path
    // Time Complexity: O(n), Space Complexity: O(n)
    
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        
        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.equals(".") && !component.isEmpty()) {
                stack.push(component);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        return result.length() > 0 ? result.toString() : "/";
    }
    
    public static void main(String[] args) {
        System.out.println("Test 1: " + simplifyPath("/home/"));                    // "/home"
        System.out.println("Test 2: " + simplifyPath("/../"));                      // "/"
        System.out.println("Test 3: " + simplifyPath("/home//foo/"));               // "/home/foo"
        System.out.println("Test 4: " + simplifyPath("/a/./b/../../c/"));           // "/c"
        System.out.println("Test 5: " + simplifyPath("/a/../../b/../c//.//"));      // "/c"
    }
}
