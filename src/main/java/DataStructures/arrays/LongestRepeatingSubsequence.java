package arrays;

//Longest repeating sequence 

public class LongestRepeatingSubsequence {
    public static int longestRepeatingSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // Characters match and indices are not same
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        String str = "aabebcdd";
        System.out.println(longestRepeatingSubsequence(str)); // Output: 3
    }
}
