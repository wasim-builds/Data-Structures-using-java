package DataStructures.Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit (LeetCode 1438)
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray 
 * such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 */
public class LongestContinuousSubarray {
    
    /**
     * Finds the maximum length of a valid subarray.
     * @param nums The input array
     * @param limit The absolute difference limit
     * @return Max length
     */
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);
            
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);
            
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[left]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[left]) minDeque.pollFirst();
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
