package CompetitiveProgramming;

import java.util.*;

/**
 * Common Utilities Template for Competitive Programming
 * 
 * Contains frequently used utility functions:
 * - Array operations (sorting, searching, manipulation)
 * - String utilities
 * - Bit manipulation tricks
 * - Math utilities
 * - Collection helpers
 */
public class CommonUtilities {

    // ==================== Array Utilities ====================

    // Reverse array
    public static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Rotate array right by k positions
    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k %= n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Find max and min in array
    public static int[] findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return new int[] { min, max };
    }

    // Count frequency of elements
    public static Map<Integer, Integer> countFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return freq;
    }

    // Binary search (returns index or -1)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // Lower bound: first element >= target
    public static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    // Upper bound: first element > target
    public static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    // ==================== String Utilities ====================

    // Check if string is palindrome
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Count character frequency
    public static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }

    // Generate all permutations of string
    public static List<String> permutations(String s) {
        List<String> result = new ArrayList<>();
        permuteHelper(s.toCharArray(), 0, result);
        return result;
    }

    private static void permuteHelper(char[] arr, int index, List<String> result) {
        if (index == arr.length - 1) {
            result.add(new String(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permuteHelper(arr, index + 1, result);
            swap(arr, index, i); // backtrack
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ==================== Bit Manipulation ====================

    // Check if kth bit is set
    public static boolean isBitSet(int n, int k) {
        return (n & (1 << k)) != 0;
    }

    // Set kth bit
    public static int setBit(int n, int k) {
        return n | (1 << k);
    }

    // Clear kth bit
    public static int clearBit(int n, int k) {
        return n & ~(1 << k);
    }

    // Toggle kth bit
    public static int toggleBit(int n, int k) {
        return n ^ (1 << k);
    }

    // Count set bits (Brian Kernighan's algorithm)
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    // Check if power of 2
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Get rightmost set bit
    public static int rightmostSetBit(int n) {
        return n & -n;
    }

    // ==================== Math Utilities ====================

    // Fast power: a^b
    public static long power(long a, long b) {
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                result *= a;
            }
            a *= a;
            b /= 2;
        }
        return result;
    }

    // Factorial
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // nCr (combinations)
    public static long nCr(int n, int r) {
        if (r > n - r)
            r = n - r; // Optimization
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    // Check if number is perfect square
    public static boolean isPerfectSquare(long n) {
        if (n < 0)
            return false;
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    // Sum of digits
    public static int digitSum(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // ==================== Collection Helpers ====================

    // Sort array in descending order
    public static void sortDescending(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    // Get kth smallest element (Quick Select)
    public static int kthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right)
            return arr[left];

        int pivotIndex = partition(arr, left, right);

        if (k == pivotIndex)
            return arr[k];
        else if (k < pivotIndex)
            return quickSelect(arr, left, pivotIndex - 1, k);
        else
            return quickSelect(arr, pivotIndex + 1, right, k);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }

    // ==================== Coordinate Compression ====================

    public static int[] compress(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        int[] compressed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            compressed[i] = map.get(arr[i]);
        }
        return compressed;
    }

    // ==================== Demo ====================

    public static void main(String[] args) {
        System.out.println("=== Array Utilities ===");
        int[] arr = { 1, 2, 3, 4, 5 };
        rotateRight(arr, 2);
        System.out.println("Rotated: " + Arrays.toString(arr));

        System.out.println("\n=== Bit Manipulation ===");
        System.out.println("Count set bits in 15: " + countSetBits(15));
        System.out.println("Is 16 power of 2? " + isPowerOfTwo(16));

        System.out.println("\n=== Math Utilities ===");
        System.out.println("5C2 = " + nCr(5, 2));
        System.out.println("2^10 = " + power(2, 10));

        System.out.println("\n=== String Utilities ===");
        System.out.println("Is 'racecar' palindrome? " + isPalindrome("racecar"));
    }
}
