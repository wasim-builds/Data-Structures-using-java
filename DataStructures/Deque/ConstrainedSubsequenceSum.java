import java.util.Deque;
import java.util.LinkedList;

/**
 * Constrained Subsequence Sum (LeetCode 1425)
 * Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array 
 * such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.
 */
public class ConstrainedSubsequenceSum {
    
    /**
     * Returns the maximum sum of a constrained subsequence.
     * @param nums Array of integers
     * @param k Maximum difference between indices
     * @return Max sum
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (!q.isEmpty()) {
                dp[i] = Math.max(dp[i], nums[i] + dp[q.peek()]);
            }
            
            maxSum = Math.max(maxSum, dp[i]);
            
            while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) {
                q.pollLast();
            }
            
            if (dp[i] > 0) {
                q.offer(i);
            }
            
            if (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }
        }
        
        return maxSum;
    }
}
