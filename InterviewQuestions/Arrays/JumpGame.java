package InterviewQuestions.Arrays;

/**
 * LeetCode 55: Jump Game
 * 
 * Problem: Given an array of non-negative integers where each element
 * represents
 * your maximum jump length at that position, determine if you can reach the
 * last index.
 * 
 * Example:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Approach: Greedy
 * - Track the farthest position we can reach
 * - If at any point current index > farthest, we can't proceed
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // If current position is beyond max reach, we can't get here
            if (i > maxReach) {
                return false;
            }

            // Update max reachable position
            maxReach = Math.max(maxReach, i + nums[i]);

            // Early exit if we can already reach the end
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    // Alternative: Work backwards from the end
    public static boolean canJumpBackwards(int[] nums) {
        int lastGoodIndex = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }

        return lastGoodIndex == 0;
    }

    public static void main(String[] args) {
        // Test Case 1: Can reach end
        int[] nums1 = { 2, 3, 1, 1, 4 };
        System.out.println("Test 1: " + canJump(nums1)); // Expected: true

        // Test Case 2: Cannot reach end
        int[] nums2 = { 3, 2, 1, 0, 4 };
        System.out.println("Test 2: " + canJump(nums2)); // Expected: false

        // Test Case 3: Single element
        int[] nums3 = { 0 };
        System.out.println("Test 3: " + canJump(nums3)); // Expected: true

        // Test Case 4: All zeros except first
        int[] nums4 = { 2, 0, 0 };
        System.out.println("Test 4: " + canJump(nums4)); // Expected: true

        // Test Case 5: Large jumps
        int[] nums5 = { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
        System.out.println("Test 5: " + canJump(nums5)); // Expected: true

        // Test backwards approach
        System.out.println("\nBackwards approach:");
        System.out.println("Test 1: " + canJumpBackwards(nums1)); // Expected: true
        System.out.println("Test 2: " + canJumpBackwards(nums2)); // Expected: false
    }
}
