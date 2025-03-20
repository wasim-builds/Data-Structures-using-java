package arrays;

//Count Distinct Subsequences


import java.util.*;

public class DistinctSubsequences {
    public static int countDistinctSubsequences(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        Map<Character, Integer> lastOccurrence = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];

            char ch = s.charAt(i - 1);
            if (lastOccurrence.containsKey(ch)) {
                dp[i] -= dp[lastOccurrence.get(ch) - 1];
            }
            lastOccurrence.put(ch, i);
        }
        return dp[n] - 1;
    }

    public static void main(String[] args) {
        String s = "gfg";
        System.out.println(countDistinctSubsequences(s)); // Output: 7
    }
}
