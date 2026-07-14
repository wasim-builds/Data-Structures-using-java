import java.util.*;

/**
 * Median in a Stream of Integers (Median Finder)
 * 
 * Problem: Design a data structure that supports adding numbers and finding the median.
 * 
 * Implement the MedianFinder class:
 * - MedianFinder() initializes the MedianFinder object
 * - void addNum(int num) adds the integer num to the data structure
 * - double findMedian() returns the median of all elements so far
 * 
 * Example:
 * MedianFinder mf = new MedianFinder();
 * mf.addNum(1);
 * mf.addNum(2);
 * mf.findMedian(); // returns 1.5
 * mf.addNum(3);
 * mf.findMedian(); // returns 2.0
 * 
 * Approach: Use two heaps
 * - Max heap for smaller half of numbers
 * - Min heap for larger half of numbers
 * - Balance heaps so their sizes differ by at most 1
 * - Median is either root of larger heap or average of both roots
 * 
 * Time Complexity: O(log n) for addNum, O(1) for findMedian
 * Space Complexity: O(n)
 */
public class MedianFinder {
    
    // Max heap for smaller half (left side)
    private PriorityQueue<Integer> maxHeap;
    
    // Min heap for larger half (right side)
    private PriorityQueue<Integer> minHeap;
    
    /**
     * Initialize the MedianFinder
     */
    public MedianFinder() {
        // Max heap: larger values have higher priority
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Min heap: smaller values have higher priority
        minHeap = new PriorityQueue<>();
    }
    
    /**
     * Add a number to the data structure
     * 
     * Strategy:
     * 1. Add to max heap first
     * 2. Move max from max heap to min heap to balance
     * 3. If min heap becomes larger, move its min to max heap
     */
    public void addNum(int num) {
        // Add to max heap (smaller half)
        maxHeap.offer(num);
        
        // Balance: move max from max heap to min heap
        minHeap.offer(maxHeap.poll());
        
        // If min heap is larger, rebalance
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    /**
     * Find the median
     * 
     * If maxHeap has more elements (odd total), median is its root
     * If both have same size (even total), median is average of both roots
     */
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
    
    /**
     * Get size of the data structure
     */
    public int size() {
        return maxHeap.size() + minHeap.size();
    }
    
    /**
     * Clear all data
     */
    public void clear() {
        maxHeap.clear();
        minHeap.clear();
    }
    
    /**
     * Alternative implementation with explicit size tracking
     */
    static class MedianFinderOptimized {
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;
        
        public MedianFinderOptimized() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }
        
        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            
            // Balance heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
        
        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            return maxHeap.peek();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== MedianFinder Test ===\n");
        
        MedianFinder mf = new MedianFinder();
        
        // Test case 1: Adding numbers one by one
        int[] numbers = {5, 15, 1, 3, 8, 7, 9, 10, 20, 12};
        
        System.out.println("Adding numbers and finding median:");
        for (int num : numbers) {
            mf.addNum(num);
            System.out.println("Added " + num + ", Median: " + mf.findMedian());
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 2: Sequential numbers
        MedianFinder mf2 = new MedianFinder();
        System.out.println("Adding sequential numbers:");
        for (int i = 1; i <= 5; i++) {
            mf2.addNum(i);
            System.out.println("Added " + i + ", Median: " + mf2.findMedian());
        }
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 3: Using optimized version
        MedianFinderOptimized mfOpt = new MedianFinderOptimized();
        System.out.println("Testing optimized version:");
        int[] nums = {1, 2, 3, 4, 5};
        for (int num : nums) {
            mfOpt.addNum(num);
            System.out.println("Added " + num + ", Median: " + mfOpt.findMedian());
        }
    }
}
