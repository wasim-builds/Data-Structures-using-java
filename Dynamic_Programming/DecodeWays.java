package Dynamic_Programming;

public class DecodeWays {
    public static int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int one = s.charAt(i - 1) - '0';
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (one != 0) dp[i] += dp[i - 1];
            if (two >= 10 && two <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println("Decode Ways: " + numDecodings("226"));
    }
}
