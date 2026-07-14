import java.util.*;

/**
 * Kth Largest Element in an Array
 * 
 * Problem: Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * 
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * 
 * Approach: Use a Min Heap of size k. For each element:
 * - If heap size < k, add element to heap
 * - Else if element > heap.peek(), remove min and add element
 * The root of the heap will be the kth largest element.
 * 
 * Time Complexity: O(n log k) where n is array length
 * Space Complexity: O(k)
 */
public class KthLargestElement {
    
    /**
     * Find kth largest element using min heap
     */
    public static int findKthLargest(int[] nums, int k) {
        // Use PriorityQueue as min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            
            // Keep heap size at k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The root is the kth largest
        return minHeap.peek();
    }
    
    /**
     * Alternative approach using max heap
     */
    public static int findKthLargestMaxHeap(int[] nums, int k) {
        // Use max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int num : nums) {
            maxHeap.offer(num);
        }
        
        // Extract k-1 elements
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        
        return maxHeap.peek();
    }
    
    /**
     * Quick Select approach (average O(n))
     */
    public static int findKthLargestQuickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);
        
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }
    
    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }
        
        swap(nums, storeIndex, right);
        return storeIndex;
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Array: " + Arrays.toString(nums1));
        System.out.println("K = " + k1);
        System.out.println("Kth Largest (Min Heap): " + findKthLargest(nums1, k1));
        System.out.println("Kth Largest (Max Heap): " + findKthLargestMaxHeap(nums1, k1));
        System.out.println("Kth Largest (Quick Select): " + findKthLargestQuickSelect(nums1, k1));
        
        System.out.println();
        
        // Test case 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Array: " + Arrays.toString(nums2));
        System.out.println("K = " + k2);
        System.out.println("Kth Largest: " + findKthLargest(nums2, k2));
    }
}
