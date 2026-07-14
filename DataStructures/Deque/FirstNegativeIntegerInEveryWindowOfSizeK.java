import java.util.Deque;
import java.util.LinkedList;

/**
 * First Negative Integer in Every Window of Size K
 * Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.
 */
public class FirstNegativeIntegerInEveryWindowOfSizeK {
    
    /**
     * Finds the first negative integer in each window of size k.
     * @param arr The input array
     * @param k Window size
     * @return Array containing first negative integers
     */
    public long[] printFirstNegativeInteger(long[] arr, int k) {
        int n = arr.length;
        long[] result = new long[n - k + 1];
        int idx = 0;
        
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            
            if (arr[i] < 0) {
                dq.offer(i);
            }
            
            if (i >= k - 1) {
                if (!dq.isEmpty()) {
                    result[idx++] = arr[dq.peek()];
                } else {
                    result[idx++] = 0;
                }
            }
        }
        return result;
    }
}
