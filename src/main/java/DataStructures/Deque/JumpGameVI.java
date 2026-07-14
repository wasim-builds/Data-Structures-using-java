package DataStructures.Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Jump Game VI (LeetCode 1696)
 * You are given a 0-indexed integer array nums and an integer k.
 * You can jump at most k steps. Return the maximum score you can get.
 */
public class JumpGameVI {
    
    /**
     * Finds maximum score to reach end of array.
     * @param nums Array of scores
     * @param k Max jump length
     * @return Max score
     */
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        Deque<Integer> q = new LinkedList<>();
        q.offer(0);
        
        for (int i = 1; i < n; i++) {
            while (!q.isEmpty() && q.peekFirst() < i - k) {
                q.pollFirst();
            }
            
            dp[i] = nums[i] + dp[q.peekFirst()];
            
            while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) {
                q.pollLast();
            }
            
            q.offerLast(i);
        }
        
        return dp[n - 1];
    }
}
