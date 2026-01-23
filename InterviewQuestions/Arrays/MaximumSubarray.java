import java.util.*;

/**
 * LeetCode #53 - Maximum Subarray (Kadane's Algorithm)
 * Difficulty: Medium
 * 
 * Problem: Find contiguous subarray with largest sum.
 * 
 * Optimal Solution: Kadane's Algorithm
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaximumSubarray {

    // Optimal Solution - Kadane's Algorithm
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend current subarray or start new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // Return the actual subarray (not just sum)
    public static int[] maxSubArrayWithIndices(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum = currentSum + nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return Arrays.copyOfRange(nums, start, end + 1);
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Max Sum: " + maxSubArray(nums1));
        System.out.println("Max Subarray: " + Arrays.toString(maxSubArrayWithIndices(nums1)));
        // Expected: 6 ([4, -1, 2, 1])

        // Test Case 2
        int[] nums2 = { 1 };
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Max Sum: " + maxSubArray(nums2));
        // Expected: 1

        // Test Case 3
        int[] nums3 = { 5, 4, -1, 7, 8 };
        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Max Sum: " + maxSubArray(nums3));
        System.out.println("Max Subarray: " + Arrays.toString(maxSubArrayWithIndices(nums3)));
        // Expected: 23
    }
}
