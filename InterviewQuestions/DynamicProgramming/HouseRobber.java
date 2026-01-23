import java.util.*;

/**
 * LeetCode #198 - House Robber
 * Difficulty: Medium
 * Time: O(n), Space: O(1)
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int prev2 = 0, prev1 = 0;

        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] { 1, 2, 3, 1 })); // 4
        System.out.println(rob(new int[] { 2, 7, 9, 3, 1 })); // 12
    }
}
