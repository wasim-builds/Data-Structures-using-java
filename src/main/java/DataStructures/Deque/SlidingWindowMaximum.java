package DataStructures.Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Sliding Window Maximum (LeetCode 239)
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 */
public class SlidingWindowMaximum {
    
    /**
     * Finds the maximum in each sliding window of size k.
     * @param nums The array of integers
     * @param k The size of the sliding window
     * @return Array of maximums for each window
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;
        
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            
            q.offer(i);
            
            if (i >= k - 1) {
                result[ri++] = nums[q.peek()];
            }
        }
        return result;
    }
}
