import java.util.*;

/**
 * Sort an Almost Sorted Array (K-Sorted Array)
 * 
 * Problem: Given an array of n elements, where each element is at most k positions away 
 * from its target position in sorted order, sort the array efficiently.
 * 
 * Example:
 * Input: arr = [6, 5, 3, 2, 8, 10, 9], k = 3
 * Output: [2, 3, 5, 6, 8, 9, 10]
 * Explanation: Each element is at most 3 positions away from its correct position
 * 
 * Approach: Use Min Heap of size k+1
 * - First k+1 elements go into heap
 * - Extract min and add next element
 * - Continue until all elements are processed
 * This works because element at index i can only be in positions [i-k, i+k]
 * 
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */
public class SortAlmostSortedArray {
    
    /**
     * Sort almost sorted array using min heap
     */
    public static int[] sortKSortedArray(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        
        int[] result = new int[arr.length];
        int resultIndex = 0;
        
        // Min heap of size k+1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add first k+1 elements to heap
        int i = 0;
        while (i < arr.length && i <= k) {
            minHeap.offer(arr[i]);
            i++;
        }
        
        // Extract min and add next element
        while (!minHeap.isEmpty()) {
            result[resultIndex++] = minHeap.poll();
            
            if (i < arr.length) {
                minHeap.offer(arr[i]);
                i++;
            }
        }
        
        return result;
    }
    
    /**
     * In-place sorting (modifies original array)
     */
    public static void sortKSortedArrayInPlace(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add first k+1 elements
        int i = 0;
        while (i < arr.length && i <= k) {
            minHeap.offer(arr[i]);
            i++;
        }
        
        // Extract and place at correct position
        int index = 0;
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
            
            if (i < arr.length) {
                minHeap.offer(arr[i]);
                i++;
            }
        }
    }
    
    /**
     * Using TreeSet (alternative approach)
     */
    public static int[] sortKSortedArrayTreeSet(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        
        int[] result = new int[arr.length];
        int resultIndex = 0;
        
        // TreeSet maintains sorted order
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        // Add first k+1 elements
        for (int i = 0; i <= k && i < arr.length; i++) {
            treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
        }
        
        // Process remaining elements
        for (int i = k + 1; i < arr.length; i++) {
            // Get minimum
            int min = treeMap.firstKey();
            result[resultIndex++] = min;
            
            // Remove from map
            if (treeMap.get(min) == 1) {
                treeMap.remove(min);
            } else {
                treeMap.put(min, treeMap.get(min) - 1);
            }
            
            // Add next element
            treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
        }
        
        // Empty remaining elements
        while (!treeMap.isEmpty()) {
            int min = treeMap.firstKey();
            int count = treeMap.get(min);
            for (int i = 0; i < count; i++) {
                result[resultIndex++] = min;
            }
            treeMap.remove(min);
        }
        
        return result;
    }
    
    /**
     * Verify if array is k-sorted
     */
    public static boolean isKSorted(int[] arr, int k) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        for (int i = 0; i < arr.length; i++) {
            // Find position of arr[i] in sorted array
            int sortedIndex = Arrays.binarySearch(sorted, arr[i]);
            if (Math.abs(sortedIndex - i) > k) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {6, 5, 3, 2, 8, 10, 9};
        int k1 = 3;
        System.out.println("Original array: " + Arrays.toString(arr1));
        System.out.println("K = " + k1);
        System.out.println("Sorted array: " + Arrays.toString(sortKSortedArray(arr1, k1)));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 2: In-place sorting
        int[] arr2 = {3, 2, 1, 5, 6, 4};
        int k2 = 2;
        System.out.println("Original array: " + Arrays.toString(arr2));
        System.out.println("K = " + k2);
        sortKSortedArrayInPlace(arr2, k2);
        System.out.println("Sorted array (in-place): " + Arrays.toString(arr2));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 3: Already sorted
        int[] arr3 = {1, 2, 3, 4, 5};
        int k3 = 0;
        System.out.println("Original array: " + Arrays.toString(arr3));
        System.out.println("K = " + k3);
        System.out.println("Sorted array: " + Arrays.toString(sortKSortedArray(arr3, k3)));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 4: With duplicates
        int[] arr4 = {2, 1, 3, 2, 4, 3, 5};
        int k4 = 2;
        System.out.println("Original array: " + Arrays.toString(arr4));
        System.out.println("K = " + k4);
        System.out.println("Sorted array: " + Arrays.toString(sortKSortedArray(arr4, k4)));
    }
}
