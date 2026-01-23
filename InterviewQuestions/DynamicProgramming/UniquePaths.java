/**
 * LeetCode #62 - Unique Paths
 * Difficulty: Medium
 * Time: O(m*n), Space: O(n)
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // 28
        System.out.println(uniquePaths(3, 2)); // 3
    }
}
