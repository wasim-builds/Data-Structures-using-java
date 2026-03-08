import java.util.*;

/**
 * Connect Ropes to Minimize Cost
 * 
 * Problem: Given n ropes of different lengths, connect them into one rope. 
 * The cost to connect two ropes is equal to the sum of their lengths.
 * Find the minimum cost to connect all ropes.
 * 
 * Example 1:
 * Input: ropes = [4, 3, 2, 6]
 * Output: 29
 * Explanation:
 * - Connect 2 and 3, cost = 5, ropes = [4, 5, 6]
 * - Connect 4 and 5, cost = 9, ropes = [6, 9]
 * - Connect 6 and 9, cost = 15, ropes = []
 * Total cost = 5 + 9 + 15 = 29
 * 
 * Example 2:
 * Input: ropes = [1, 2, 5, 10, 35, 89]
 * Output: 224
 * 
 * Approach: Use Min Heap (Greedy)
 * - Always connect the two smallest ropes first
 * - Add all ropes to min heap
 * - While heap has more than 1 rope:
 *   - Extract two smallest ropes
 *   - Connect them (cost = sum)
 *   - Add result back to heap
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class ConnectRopesMinCost {
    
    /**
     * Find minimum cost to connect all ropes
     */
    public static int minCostToConnectRopes(int[] ropes) {
        if (ropes == null || ropes.length <= 1) {
            return 0;
        }
        
        // Min heap to store rope lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add all ropes to heap
        for (int rope : ropes) {
            minHeap.offer(rope);
        }
        
        int totalCost = 0;
        
        // Connect ropes until one remains
        while (minHeap.size() > 1) {
            // Extract two smallest ropes
            int first = minHeap.poll();
            int second = minHeap.poll();
            
            // Cost to connect them
            int cost = first + second;
            totalCost += cost;
            
            // Add connected rope back to heap
            minHeap.offer(cost);
        }
        
        return totalCost;
    }
    
    /**
     * Alternative implementation with detailed steps
     */
    public static int minCostWithSteps(int[] ropes) {
        if (ropes == null || ropes.length <= 1) {
            return 0;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        System.out.println("Initial ropes: " + Arrays.toString(ropes));
        System.out.println("\nConnection steps:");
        
        for (int rope : ropes) {
            minHeap.offer(rope);
        }
        
        int totalCost = 0;
        int step = 1;
        
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int cost = first + second;
            
            System.out.printf("Step %d: Connect %d + %d = %d (cost = %d)%n", 
                step++, first, second, cost, cost);
            
            totalCost += cost;
            minHeap.offer(cost);
        }
        
        System.out.println("\nTotal cost: " + totalCost);
        return totalCost;
    }
    
    /**
     * Using Long for large numbers
     */
    public static long minCostToConnectRopesLong(long[] ropes) {
        if (ropes == null || ropes.length <= 1) {
            return 0;
        }
        
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        for (long rope : ropes) {
            minHeap.offer(rope);
        }
        
        long totalCost = 0;
        
        while (minHeap.size() > 1) {
            long first = minHeap.poll();
            long second = minHeap.poll();
            long cost = first + second;
            totalCost += cost;
            minHeap.offer(cost);
        }
        
        return totalCost;
    }
    
    /**
     * Brute force approach for comparison (O(n^2))
     */
    public static int minCostBruteForce(int[] ropes) {
        if (ropes == null || ropes.length <= 1) {
            return 0;
        }
        
        List<Integer> ropeList = new ArrayList<>();
        for (int rope : ropes) {
            ropeList.add(rope);
        }
        
        int totalCost = 0;
        
        while (ropeList.size() > 1) {
            Collections.sort(ropeList);
            
            int first = ropeList.remove(0);
            int second = ropeList.remove(0);
            int cost = first + second;
            
            totalCost += cost;
            ropeList.add(cost);
        }
        
        return totalCost;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] ropes1 = {4, 3, 2, 6};
        System.out.println("=== Test Case 1 ===");
        System.out.println("Ropes: " + Arrays.toString(ropes1));
        System.out.println("Minimum cost: " + minCostToConnectRopes(ropes1));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 2 with steps
        int[] ropes2 = {1, 2, 5, 10, 35, 89};
        System.out.println("=== Test Case 2 ===");
        minCostWithSteps(ropes2);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 3
        int[] ropes3 = {20, 4, 8, 2};
        System.out.println("=== Test Case 3 ===");
        System.out.println("Ropes: " + Arrays.toString(ropes3));
        System.out.println("Minimum cost: " + minCostToConnectRopes(ropes3));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 4: Edge case
        int[] ropes4 = {5};
        System.out.println("=== Test Case 4 (Edge Case) ===");
        System.out.println("Ropes: " + Arrays.toString(ropes4));
        System.out.println("Minimum cost: " + minCostToConnectRopes(ropes4));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 5: Comparison with brute force
        int[] ropes5 = {4, 2, 7, 6, 9};
        System.out.println("=== Test Case 5 (Comparison) ===");
        System.out.println("Ropes: " + Arrays.toString(ropes5));
        System.out.println("Heap approach: " + minCostToConnectRopes(ropes5));
        System.out.println("Brute force: " + minCostBruteForce(ropes5));
    }
}
