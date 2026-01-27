package InterviewQuestions.Arrays;

/**
 * LeetCode 33: Search in Rotated Sorted Array
 * 
 * Problem: Given a rotated sorted array and a target value, return the index if
 * found, else -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * Approach: Modified Binary Search
 * - At least one half of the array is always sorted
 * - Determine which half is sorted and if target lies in that range
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Found target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    // Target is in the sorted left half
                    right = mid - 1;
                } else {
                    // Target is in the right half
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // Target is in the sorted right half
                    left = mid + 1;
                } else {
                    // Target is in the left half
                    right = mid - 1;
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Test Case 1: Target exists in rotated array
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        int target1 = 0;
        System.out.println("Test 1: " + search(nums1, target1)); // Expected: 4

        // Test Case 2: Target doesn't exist
        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        int target2 = 3;
        System.out.println("Test 2: " + search(nums2, target2)); // Expected: -1

        // Test Case 3: Single element array
        int[] nums3 = { 1 };
        int target3 = 1;
        System.out.println("Test 3: " + search(nums3, target3)); // Expected: 0

        // Test Case 4: No rotation
        int[] nums4 = { 1, 2, 3, 4, 5 };
        int target4 = 3;
        System.out.println("Test 4: " + search(nums4, target4)); // Expected: 2

        // Test Case 5: Target at rotation point
        int[] nums5 = { 3, 1 };
        int target5 = 1;
        System.out.println("Test 5: " + search(nums5, target5)); // Expected: 1
    }
}
