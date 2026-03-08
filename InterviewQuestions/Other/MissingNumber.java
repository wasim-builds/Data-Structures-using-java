/**
 * LeetCode #268 - Missing Number
 * Time: O(n), Space: O(1)
 */
public class MissingNumber {
    // XOR approach
    public static int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }

    // Math approach
    public static int missingNumberMath(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] { 3, 0, 1 })); // 2
        System.out.println(missingNumber(new int[] { 0, 1 })); // 2
        System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 })); // 8
    }
}
