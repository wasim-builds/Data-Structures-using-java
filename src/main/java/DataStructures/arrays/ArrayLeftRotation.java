package arrays;
import java.util.Arrays;

public class ArrayLeftRotation {
    public static int[] leftRotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
        return nums;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6};
        int k = 2;

        System.out.println(Arrays.toString(leftRotate(nums, k)));
    }
}
