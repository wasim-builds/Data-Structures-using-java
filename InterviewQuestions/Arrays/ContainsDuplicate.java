import java.util.*;

/**
 * LeetCode #217 - Contains Duplicate
 * Difficulty: Easy
 * 
 * Problem: Return true if any value appears at least twice in the array.
 * 
 * Optimal Solution: HashSet
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ContainsDuplicate {

    // Optimal Solution - HashSet
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return true; // Duplicate found
            }
        }

        return false;
    }

    // Alternative - Sorting approach O(n log n) time, O(1) space
    public static boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = { 1, 2, 3, 1 };
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Contains Duplicate: " + containsDuplicate(nums1));
        // Expected: true

        // Test Case 2
        int[] nums2 = { 1, 2, 3, 4 };
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Contains Duplicate: " + containsDuplicate(nums2));
        // Expected: false

        // Test Case 3
        int[] nums3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Contains Duplicate: " + containsDuplicate(nums3));
        // Expected: true
    }
}
