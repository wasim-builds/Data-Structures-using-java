package InterviewQuestions.Arrays;

/**
 * LeetCode 42: Trapping Rain Water
 * 
 * Problem: Given n non-negative integers representing an elevation map where
 * the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * Example:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 * Approach 1: Two Pointers (Optimal)
 * - Use two pointers from both ends
 * - Track max height from left and right
 * - Water trapped = min(leftMax, rightMax) - current height
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class TrappingRainWater {

    // Optimal Solution: Two Pointers
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Process left side
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                // Process right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    // Alternative Solution: Using extra space for left and right max arrays
    // Time: O(n), Space: O(n)
    public static int trapWithArrays(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard example
        int[] height1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Test 1 (Two Pointers): " + trap(height1)); // Expected: 6
        System.out.println("Test 1 (Arrays): " + trapWithArrays(height1)); // Expected: 6

        // Test Case 2: Descending heights
        int[] height2 = { 4, 3, 2, 1 };
        System.out.println("Test 2: " + trap(height2)); // Expected: 0

        // Test Case 3: Ascending heights
        int[] height3 = { 1, 2, 3, 4 };
        System.out.println("Test 3: " + trap(height3)); // Expected: 0

        // Test Case 4: Valley shape
        int[] height4 = { 4, 2, 0, 3, 2, 5 };
        System.out.println("Test 4: " + trap(height4)); // Expected: 9

        // Test Case 5: Single peak
        int[] height5 = { 3, 0, 2, 0, 4 };
        System.out.println("Test 5: " + trap(height5)); // Expected: 7
    }
}
