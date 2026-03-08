package Stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    // Simulate asteroid collisions
    // Time Complexity: O(n), Space Complexity: O(n)
    
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean alive = true;
            
            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                }
                alive = false;
            }
            
            if (alive) {
                stack.push(asteroid);
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] asteroids1 = {5, 10, -5};
        System.out.println("Test 1: " + Arrays.toString(asteroidCollision(asteroids1)));
        // [5, 10]
        
        int[] asteroids2 = {8, -8};
        System.out.println("Test 2: " + Arrays.toString(asteroidCollision(asteroids2)));
        // []
        
        int[] asteroids3 = {10, 2, -5};
        System.out.println("Test 3: " + Arrays.toString(asteroidCollision(asteroids3)));
        // [10]
    }
}
