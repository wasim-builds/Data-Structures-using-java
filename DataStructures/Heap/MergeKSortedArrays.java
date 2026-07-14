import java.util.*;

/**
 * Merge K Sorted Arrays
 * 
 * Problem: Given K sorted arrays, merge them into one sorted array.
 * 
 * Example:
 * Input: arrays = [[1, 3, 5, 7], [2, 4, 6, 8], [0, 9, 10, 11]]
 * Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 * 
 * Approach: Use a Min Heap to efficiently merge K arrays.
 * - Create a min heap of size K containing the first element from each array
 * - Extract min, add to result, and insert next element from same array
 * - Continue until all elements are processed
 * 
 * Time Complexity: O(N log K) where N is total elements and K is number of arrays
 * Space Complexity: O(K) for heap + O(N) for result
 */
public class MergeKSortedArrays {
    
    /**
     * Element wrapper to track array index and element index
     */
    static class Element implements Comparable<Element> {
        int value;
        int arrayIndex;
        int elementIndex;
        
        public Element(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
        
        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.value, other.value);
        }
    }
    
    /**
     * Merge K sorted arrays using min heap
     */
    public static List<Integer> mergeKSortedArrays(int[][] arrays) {
        List<Integer> result = new ArrayList<>();
        
        if (arrays == null || arrays.length == 0) {
            return result;
        }
        
        // Min heap to store elements
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        
        // Add first element from each array to heap
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new Element(arrays[i][0], i, 0));
            }
        }
        
        // Extract min and add next element from same array
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result.add(current.value);
            
            // If current array has more elements, add next one
            int nextIndex = current.elementIndex + 1;
            if (nextIndex < arrays[current.arrayIndex].length) {
                minHeap.offer(new Element(
                    arrays[current.arrayIndex][nextIndex],
                    current.arrayIndex,
                    nextIndex
                ));
            }
        }
        
        return result;
    }
    
    /**
     * Alternative: Merge arrays into int array
     */
    public static int[] mergeKSortedArraysToArray(int[][] arrays) {
        // Calculate total size
        int totalSize = 0;
        for (int[] array : arrays) {
            totalSize += array.length;
        }
        
        int[] result = new int[totalSize];
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        
        // Add first element from each array
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new Element(arrays[i][0], i, 0));
            }
        }
        
        int index = 0;
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result[index++] = current.value;
            
            int nextIndex = current.elementIndex + 1;
            if (nextIndex < arrays[current.arrayIndex].length) {
                minHeap.offer(new Element(
                    arrays[current.arrayIndex][nextIndex],
                    current.arrayIndex,
                    nextIndex
                ));
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[][] arrays1 = {
            {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}
        };
        
        System.out.println("Input arrays:");
        for (int[] arr : arrays1) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("\nMerged array: " + mergeKSortedArrays(arrays1));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 2
        int[][] arrays2 = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
        
        System.out.println("Input arrays:");
        for (int[] arr : arrays2) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("\nMerged array: " + Arrays.toString(mergeKSortedArraysToArray(arrays2)));
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 3: Different sized arrays
        int[][] arrays3 = {
            {1, 10, 20},
            {2},
            {3, 5, 7, 9, 11, 13}
        };
        
        System.out.println("Input arrays:");
        for (int[] arr : arrays3) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("\nMerged array: " + mergeKSortedArrays(arrays3));
    }
}
