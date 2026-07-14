package Stack;

import java.util.Stack;

public class LargestRectangleHistogram {
    // Find the largest rectangle area in a histogram
    // Time Complexity: O(n), Space Complexity: O(n)
    
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Test 1: " + largestRectangleArea(heights1));  // 10
        
        int[] heights2 = {2, 4};
        System.out.println("Test 2: " + largestRectangleArea(heights2));  // 4
        
        int[] heights3 = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Test 3: " + largestRectangleArea(heights3));  // 12
    }
}
