package InterviewQuestions.DynamicProgramming;

/**
 * LeetCode 416: Partition Equal Subset Sum
 * 
 * Problem: Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of
 * elements
 * in both subsets is equal.
 * 
 * Example:
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: [1, 5, 5] and [11]
 * 
 * Approach: 0/1 Knapsack DP
 * - If total sum is odd, return false
 * - Find if subset with sum = total/2 exists
 * - dp[i] = can we make sum i using elements
 * 
 * Time Complexity: O(n × sum)
 * Space Complexity: O(sum)
 */
public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, can't partition equally
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        // dp[i] = can we make sum i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Can always make sum 0 (empty subset)

        // For each number
        for (int num : nums) {
            // Traverse backwards to avoid using same element twice
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        return dp[target];
    }

    // Alternative: 2D DP (easier to understand)
    public static boolean canPartition2D(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int n = nums.length;

        // dp[i][j] = can we make sum j using first i elements
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: can always make sum 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {
                // Don't take current element
                dp[i][sum] = dp[i - 1][sum];

                // Take current element (if possible)
                if (sum >= nums[i - 1]) {
                    dp[i][sum] = dp[i][sum] || dp[i - 1][sum - nums[i - 1]];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        // Test Case 1: Can partition
        int[] nums1 = { 1, 5, 11, 5 };
        System.out.println("Test 1: " + canPartition(nums1));
        // Expected: true ([1,5,5] and [11])

        // Test Case 2: Cannot partition
        int[] nums2 = { 1, 2, 3, 5 };
        System.out.println("Test 2: " + canPartition(nums2));
        // Expected: false

        // Test Case 3: Single element
        int[] nums3 = { 1 };
        System.out.println("Test 3: " + canPartition(nums3));
        // Expected: false

        // Test Case 4: Two equal elements
        int[] nums4 = { 1, 1 };
        System.out.println("Test 4: " + canPartition(nums4));
        // Expected: true

        // Test Case 5: Larger array
        int[] nums5 = { 1, 2, 5 };
        System.out.println("Test 5: " + canPartition(nums5));
        // Expected: false

        // Test 2D approach
        System.out.println("\n2D DP approach:");
        System.out.println("Test 1: " + canPartition2D(nums1));
        // Expected: true
    }
}
