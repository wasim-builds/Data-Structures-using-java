import java.util.*;

/**
 * Top K Frequent Elements
 * 
 * Problem: Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * Approach:
 * 1. Count frequency of each element using HashMap
 * 2. Use Min Heap of size k based on frequency
 * 3. For each element, if heap size < k or frequency > min frequency in heap, update heap
 * 4. Return elements in heap
 * 
 * Time Complexity: O(n log k) where n is array length
 * Space Complexity: O(n) for frequency map + O(k) for heap
 */
public class TopKFrequentElements {
    
    /**
     * Find top K frequent elements using heap
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Min heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        // Add elements to heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            
            // Keep heap size at k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Build result array
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }
        
        return result;
    }
    
    /**
     * Alternative using bucket sort (O(n) time)
     */
    public static List<Integer> topKFrequentBucket(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Create buckets: index = frequency, value = list of numbers with that frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            buckets[frequency].add(entry.getKey());
        }
        
        // Collect top k elements from highest frequency buckets
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (!buckets[i].isEmpty()) {
                result.addAll(buckets[i]);
            }
        }
        
        return result.subList(0, Math.min(k, result.size()));
    }
    
    /**
     * Using max heap (simpler but O(n log n))
     */
    public static int[] topKFrequentMaxHeap(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Max heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        maxHeap.addAll(frequencyMap.entrySet());
        
        // Extract top k
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getKey();
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Array: " + Arrays.toString(nums1));
        System.out.println("K = " + k1);
        System.out.println("Top K Frequent (Min Heap): " + Arrays.toString(topKFrequent(nums1, k1)));
        System.out.println("Top K Frequent (Max Heap): " + Arrays.toString(topKFrequentMaxHeap(nums1, k1)));
        System.out.println("Top K Frequent (Bucket): " + topKFrequentBucket(nums1, k1));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 2
        int[] nums2 = {4, 1, -1, 2, -1, 2, 3};
        int k2 = 2;
        System.out.println("Array: " + Arrays.toString(nums2));
        System.out.println("K = " + k2);
        System.out.println("Top K Frequent: " + Arrays.toString(topKFrequent(nums2, k2)));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 3
        int[] nums3 = {1};
        int k3 = 1;
        System.out.println("Array: " + Arrays.toString(nums3));
        System.out.println("K = " + k3);
        System.out.println("Top K Frequent: " + Arrays.toString(topKFrequent(nums3, k3)));
    }
}
