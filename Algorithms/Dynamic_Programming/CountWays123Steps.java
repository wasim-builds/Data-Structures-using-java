package Dynamic_Programming;

public class CountWays123Steps {
    public static int countWays(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] += dp[i - 1];
            if (i >= 2) dp[i] += dp[i - 2];
            if (i >= 3) dp[i] += dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("Count ways for 4 steps: " + countWays(4));
    }
}
