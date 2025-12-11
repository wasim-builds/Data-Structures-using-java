package Dynamic_Programming;

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (Math.abs(target) > sum || ((sum + target) & 1) == 1) return 0;
        int w = (sum + target) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[w];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println("Target Sum ways: " + findTargetSumWays(nums, 3));
    }
}
