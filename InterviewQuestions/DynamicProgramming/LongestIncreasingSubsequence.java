import java.util.*;

/**
 * LeetCode #300 - Longest Increasing Subsequence
 * Time: O(n log n), Space: O(n)
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();

        for (int num : nums) {
            int pos = Collections.binarySearch(dp, num);

            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos == dp.size()) {
                dp.add(num);
            } else {
                dp.set(pos, num);
            }
        }

        return dp.size();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })); // 4
        System.out.println(lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 })); // 4
    }
}
