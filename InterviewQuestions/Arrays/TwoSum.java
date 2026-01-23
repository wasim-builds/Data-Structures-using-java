import java.util.*;

/**
 * LeetCode #1 - Two Sum
 * Difficulty: Easy
 * 
 * Problem: Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * 
 * Optimal Solution: HashMap
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TwoSum {

    // Optimal Solution - Single Pass HashMap
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {}; // No solution found
    }

    // Brute Force (for comparison) - O(n^2)
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        System.out.println("Input: " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(twoSum(nums1, target1)));
        // Expected: [0, 1]

        // Test Case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        System.out.println("\nInput: " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(twoSum(nums2, target2)));
        // Expected: [1, 2]

        // Test Case 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        System.out.println("\nInput: " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(twoSum(nums3, target3)));
        // Expected: [0, 1]
    }
}
