import java.util.*;

/**
 * Find All K-Distant Indices in an Array
 * 
 * Problem: You are given a 0-indexed integer array nums and two integers key and k.
 * A k-distant index is an index i of nums for which there exists at least one index j
 * such that |i - j| <= k and nums[j] == key.
 * 
 * Return a list of all k-distant indices sorted in increasing order.
 * 
 * Example 1:
 * Input: nums = [3,4,9,1,3,9,5], key = 9, k = 1
 * Output: [1,2,3,4,5,6]
 * Explanation: Indices with key (9) are at positions 2 and 5.
 * For index 2: positions 1,2,3 are within distance 1
 * For index 5: positions 4,5,6 are within distance 1
 * Combined: [1,2,3,4,5,6]
 * 
 * Example 2:
 * Input: nums = [2,2,2,2,2], key = 2, k = 2
 * Output: [0,1,2,3,4]
 * 
 * Approach 1: Brute Force
 * - Find all indices where nums[i] == key
 * - For each such index, mark all indices within distance k
 * - Return sorted unique indices
 * 
 * Approach 2: Using Set/TreeSet
 * - Use TreeSet to maintain sorted unique indices
 * 
 * Time Complexity: O(n * k) or O(n log n) depending on approach
 * Space Complexity: O(n)
 */
public class KDistantIndices {
    
    /**
     * Find all k-distant indices using brute force
     */
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> result = new TreeSet<>();
        
        // Find all indices with key value
        List<Integer> keyIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIndices.add(i);
            }
        }
        
        // For each key index, add all indices within distance k
        for (int keyIdx : keyIndices) {
            int start = Math.max(0, keyIdx - k);
            int end = Math.min(nums.length - 1, keyIdx + k);
            
            for (int i = start; i <= end; i++) {
                result.add(i);
            }
        }
        
        return new ArrayList<>(result);
    }
    
    /**
     * Optimized approach using boolean array
     */
    public static List<Integer> findKDistantIndicesOptimized(int[] nums, int key, int k) {
        boolean[] isKDistant = new boolean[nums.length];
        
        // Mark all k-distant indices
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int start = Math.max(0, i - k);
                int end = Math.min(nums.length - 1, i + k);
                
                for (int j = start; j <= end; j++) {
                    isKDistant[j] = true;
                }
            }
        }
        
        // Collect marked indices
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (isKDistant[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    /**
     * Using range merging for efficiency
     */
    public static List<Integer> findKDistantIndicesRanges(int[] nums, int key, int k) {
        List<int[]> ranges = new ArrayList<>();
        
        // Create ranges for each key occurrence
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int start = Math.max(0, i - k);
                int end = Math.min(nums.length - 1, i + k);
                ranges.add(new int[]{start, end});
            }
        }
        
        if (ranges.isEmpty()) {
            return new ArrayList<>();
        }
        
        // Merge overlapping ranges
        ranges.sort((a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(ranges.get(0));
        
        for (int i = 1; i < ranges.size(); i++) {
            int[] current = ranges.get(i);
            int[] last = merged.get(merged.size() - 1);
            
            if (current[0] <= last[1] + 1) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(current);
            }
        }
        
        // Convert merged ranges to list of indices
        List<Integer> result = new ArrayList<>();
        for (int[] range : merged) {
            for (int i = range[0]; i <= range[1]; i++) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    /**
     * Using min heap (over-engineered for this problem but demonstrates heap usage)
     */
    public static List<Integer> findKDistantIndicesHeap(int[] nums, int key, int k) {
        // Min heap to maintain sorted order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> seen = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int start = Math.max(0, i - k);
                int end = Math.min(nums.length - 1, i + k);
                
                for (int j = start; j <= end; j++) {
                    if (!seen.contains(j)) {
                        minHeap.offer(j);
                        seen.add(j);
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        
        return result;
    }
    
    /**
     * With detailed output
     */
    public static List<Integer> findKDistantIndicesWithDetails(int[] nums, int key, int k) {
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Key: " + key + ", K: " + k);
        
        // Find key positions
        List<Integer> keyPositions = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyPositions.add(i);
            }
        }
        System.out.println("Key found at indices: " + keyPositions);
        
        List<Integer> result = findKDistantIndices(nums, key, k);
        System.out.println("K-distant indices: " + result);
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {3, 4, 9, 1, 3, 9, 5};
        int key1 = 9, k1 = 1;
        System.out.println("=== Test Case 1 ===");
        System.out.println("Array: " + Arrays.toString(nums1));
        System.out.println("Key: " + key1 + ", K: " + k1);
        System.out.println("Result: " + findKDistantIndices(nums1, key1, k1));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int key2 = 2, k2 = 2;
        System.out.println("=== Test Case 2 ===");
        System.out.println("Array: " + Arrays.toString(nums2));
        System.out.println("Key: " + key2 + ", K: " + k2);
        System.out.println("Result: " + findKDistantIndices(nums2, key2, k2));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 3 with details
        int[] nums3 = {1, 3, 5, 3, 7, 3, 9};
        int key3 = 3, k3 = 2;
        System.out.println("=== Test Case 3 (Detailed) ===");
        findKDistantIndicesWithDetails(nums3, key3, k3);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 4: No key found
        int[] nums4 = {1, 2, 3, 4, 5};
        int key4 = 9, k4 = 1;
        System.out.println("=== Test Case 4 (No Key) ===");
        System.out.println("Array: " + Arrays.toString(nums4));
        System.out.println("Key: " + key4 + ", K: " + k4);
        System.out.println("Result: " + findKDistantIndices(nums4, key4, k4));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 5: Compare approaches
        int[] nums5 = {1, 5, 2, 5, 3, 5, 4};
        int key5 = 5, k5 = 1;
        System.out.println("=== Test Case 5 (Compare Approaches) ===");
        System.out.println("Array: " + Arrays.toString(nums5));
        System.out.println("Key: " + key5 + ", K: " + k5);
        System.out.println("Basic: " + findKDistantIndices(nums5, key5, k5));
        System.out.println("Optimized: " + findKDistantIndicesOptimized(nums5, key5, k5));
        System.out.println("Ranges: " + findKDistantIndicesRanges(nums5, key5, k5));
    }
}
