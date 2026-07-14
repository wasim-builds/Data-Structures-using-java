import java.util.Deque;
import java.util.LinkedList;

/**
 * Max Value of Equation (LeetCode 1499)
 * Given an array points containing the coordinates of points on a 2D plane, sorted by the x-values,
 * return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.
 */
public class MaxValueOfEquation {
    
    /**
     * Finds the maximum value of the equation yi + yj + xj - xi.
     * @param points Array of [x, y] points
     * @param k Max difference in x
     * @return Maximum equation value
     */
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> dq = new LinkedList<>();
        int maxVal = Integer.MIN_VALUE;
        
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            
            while (!dq.isEmpty() && x - dq.peekFirst()[1] > k) {
                dq.pollFirst();
            }
            
            if (!dq.isEmpty()) {
                maxVal = Math.max(maxVal, dq.peekFirst()[0] + y + x);
            }
            
            int currentVal = y - x;
            while (!dq.isEmpty() && dq.peekLast()[0] <= currentVal) {
                dq.pollLast();
            }
            
            dq.offerLast(new int[]{currentVal, x});
        }
        
        return maxVal;
    }
}
