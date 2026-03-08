import java.util.*;

/**
 * Smallest Range Covering Elements from K Lists
 * 
 * Problem: You have k lists of sorted integers. Find the smallest range that includes
 * at least one number from each of the k lists.
 * 
 * Example:
 * Input: lists = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 * Explanation: 
 * Range [20,24] includes 24 from list 1, 20 from list 2, and 22 from list 3.
 * 
 * Approach: Use Min Heap with tracking
 * - Add first element from each list to min heap
 * - Track current max element
 * - Range is [min, max] where min is heap top
 * - Extract min, add next from same list, update max
 * - Track smallest range seen
 * 
 * Time Complexity: O(n log k) where n is total elements, k is number of lists
 * Space Complexity: O(k)
 */
public class SmallestRangeCoveringKLists {
    
    /**
     * Element wrapper with list and index information
     */
    static class Element implements Comparable<Element> {
        int value;
        int listIndex;
        int elementIndex;
        
        public Element(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
        
        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.value, other.value);
        }
    }
    
    /**
     * Find smallest range covering elements from all lists
     */
    public static int[] smallestRange(List<List<Integer>> lists) {
        if (lists == null || lists.isEmpty()) {
            return new int[]{0, 0};
        }
        
        // Min heap to track smallest element from each list
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        int currentMax = Integer.MIN_VALUE;
        
        // Add first element from each list
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                int value = lists.get(i).get(0);
                minHeap.offer(new Element(value, i, 0));
                currentMax = Math.max(currentMax, value);
            }
        }
        
        // Initialize result range
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        
        // Process elements
        while (minHeap.size() == lists.size()) {
            Element minElement = minHeap.poll();
            int currentMin = minElement.value;
            
            // Update range if current is smaller
            if (currentMax - currentMin < rangeEnd - rangeStart) {
                rangeStart = currentMin;
                rangeEnd = currentMax;
            }
            
            // Add next element from same list
            int nextIndex = minElement.elementIndex + 1;
            if (nextIndex < lists.get(minElement.listIndex).size()) {
                int nextValue = lists.get(minElement.listIndex).get(nextIndex);
                minHeap.offer(new Element(nextValue, minElement.listIndex, nextIndex));
                currentMax = Math.max(currentMax, nextValue);
            } else {
                // One list exhausted, stop
                break;
            }
        }
        
        return new int[]{rangeStart, rangeEnd};
    }
    
    /**
     * Alternative with 2D array input
     */
    public static int[] smallestRangeArray(int[][] lists) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        for (int[] list : lists) {
            List<Integer> temp = new ArrayList<>();
            for (int num : list) {
                temp.add(num);
            }
            listOfLists.add(temp);
        }
        return smallestRange(listOfLists);
    }
    
    /**
     * With detailed output
     */
    public static int[] smallestRangeWithDetails(List<List<Integer>> lists) {
        if (lists == null || lists.isEmpty()) {
            return new int[]{0, 0};
        }
        
        System.out.println("Input lists:");
        for (int i = 0; i < lists.size(); i++) {
            System.out.println("List " + i + ": " + lists.get(i));
        }
        System.out.println();
        
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        int currentMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                int value = lists.get(i).get(0);
                minHeap.offer(new Element(value, i, 0));
                currentMax = Math.max(currentMax, value);
            }
        }
        
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        
        while (minHeap.size() == lists.size()) {
            Element minElement = minHeap.poll();
            int currentMin = minElement.value;
            
            System.out.printf("Current range: [%d, %d], size: %d%n", 
                currentMin, currentMax, currentMax - currentMin);
            
            if (currentMax - currentMin < rangeEnd - rangeStart) {
                rangeStart = currentMin;
                rangeEnd = currentMax;
            }
            
            int nextIndex = minElement.elementIndex + 1;
            if (nextIndex < lists.get(minElement.listIndex).size()) {
                int nextValue = lists.get(minElement.listIndex).get(nextIndex);
                minHeap.offer(new Element(nextValue, minElement.listIndex, nextIndex));
                currentMax = Math.max(currentMax, nextValue);
            } else {
                break;
            }
        }
        
        System.out.println("\nSmallest range: [" + rangeStart + ", " + rangeEnd + "]");
        return new int[]{rangeStart, rangeEnd};
    }
    
    public static void main(String[] args) {
        // Test case 1
        List<List<Integer>> lists1 = new ArrayList<>();
        lists1.add(Arrays.asList(4, 10, 15, 24, 26));
        lists1.add(Arrays.asList(0, 9, 12, 20));
        lists1.add(Arrays.asList(5, 18, 22, 30));
        
        System.out.println("=== Test Case 1 ===");
        int[] result1 = smallestRange(lists1);
        System.out.println("Lists: " + lists1);
        System.out.println("Smallest range: [" + result1[0] + ", " + result1[1] + "]");
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 2 with details
        List<List<Integer>> lists2 = new ArrayList<>();
        lists2.add(Arrays.asList(1, 2, 3));
        lists2.add(Arrays.asList(1, 2, 3));
        lists2.add(Arrays.asList(1, 2, 3));
        
        System.out.println("=== Test Case 2 ===");
        smallestRangeWithDetails(lists2);
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test case 3
        int[][] arrays3 = {
            {1, 3, 5, 7, 9},
            {2, 4, 6, 8, 10},
            {1, 5, 9, 13}
        };
        
        System.out.println("=== Test Case 3 ===");
        System.out.println("Arrays:");
        for (int[] arr : arrays3) {
            System.out.println(Arrays.toString(arr));
        }
        int[] result3 = smallestRangeArray(arrays3);
        System.out.println("Smallest range: [" + result3[0] + ", " + result3[1] + "]");
    }
}
