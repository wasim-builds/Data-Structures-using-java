/**
 * Radix Sort Algorithm
 * Time Complexity: O(d * (n + k)) where d is number of digits
 * Space Complexity: O(n + k)
 * 
 * Sorts by processing digits from least to most significant
 */
public class RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        // Find maximum to know number of digits
        int max = getMax(arr);

        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Count occurrences
        for (int num : arr) {
            count[(num / exp) % 10]++;
        }

        // Cumulative count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy to original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };

        System.out.println("Original array:");
        System.out.println(java.util.Arrays.toString(arr));

        radixSort(arr);

        System.out.println("\nSorted array:");
        System.out.println(java.util.Arrays.toString(arr));
    }
}
