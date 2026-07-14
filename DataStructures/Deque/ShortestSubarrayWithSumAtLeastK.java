import java.util.Deque;
import java.util.LinkedList;

/**
 * Shortest Subarray with Sum at Least K (LeetCode 862)
 * Return the length of the shortest, non-empty, contiguous subarray of nums with a sum of at least k. If there is no such subarray, return -1.
 */
public class ShortestSubarrayWithSumAtLeastK {
    
    /**
     * Finds the shortest subarray with sum >= k.
     * @param nums The integer array
     * @param k The target sum
     * @return Minimum length of such subarray
     */
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int minLen = n + 1;
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - dq.pollFirst());
            }
            
            while (!dq.isEmpty() && prefixSum[i] <= prefixSum[dq.peekLast()]) {
                dq.pollLast();
            }
            
            dq.offerLast(i);
        }
        
        return minLen <= n ? minLen : -1;
    }
}
