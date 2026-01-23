import java.util.*;

/**
 * LeetCode #238 - Product of Array Except Self
 * Difficulty: Medium
 * 
 * Problem: Return array where output[i] is product of all elements except
 * nums[i]
 * Must solve without division and in O(n) time.
 * 
 * Optimal Solution: Left and Right products
 * Time Complexity: O(n)
 * Space Complexity: O(1) - output array doesn't count
 */
public class ProductExceptSelf {

    // Optimal Solution - Two passes with constant space
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Calculate right products and multiply
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    // Alternative with extra space (easier to understand)
    public static int[] productExceptSelfWithSpace(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        // Left products
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Right products
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Combine
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = { 1, 2, 3, 4 };
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums1)));
        // Expected: [24, 12, 8, 6]

        // Test Case 2
        int[] nums2 = { -1, 1, 0, -3, 3 };
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums2)));
        // Expected: [0, 0, 9, 0, 0]
    }
}
