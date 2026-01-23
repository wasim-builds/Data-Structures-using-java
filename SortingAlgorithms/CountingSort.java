/**
 * Counting Sort Algorithm
 * Time Complexity: O(n + k) where k is range of input
 * Space Complexity: O(k)
 * 
 * Efficient for small range of integers
 * Not comparison-based sorting
 */
public class CountingSort {

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        // Find range
        int max = arr[0], min = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Count occurrences
        for (int num : arr) {
            count[num - min]++;
        }

        // Cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 8, 3, 3, 1 };

        System.out.println("Original array:");
        System.out.println(java.util.Arrays.toString(arr));

        countingSort(arr);

        System.out.println("\nSorted array:");
        System.out.println(java.util.Arrays.toString(arr));
    }
}
