package InterviewQuestions.Strings;

/**
 * LeetCode 91: Decode Ways
 * 
 * Problem: A message containing letters from A-Z can be encoded into numbers
 * using the mapping:
 * 'A' -> "1", 'B' -> "2", ..., 'Z' -> "26"
 * Given a string s containing only digits, return the number of ways to decode
 * it.
 * 
 * Example:
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2
 * 2 6).
 * 
 * Approach: Dynamic Programming
 * - dp[i] = number of ways to decode s[0...i-1]
 * - Single digit: if valid (1-9), add dp[i-1]
 * - Two digits: if valid (10-26), add dp[i-2]
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) with space optimization
 */
public class DecodeWays {

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();

        // Space optimized: only need last two values
        int prev2 = 1; // dp[i-2]
        int prev1 = 1; // dp[i-1]

        for (int i = 1; i < n; i++) {
            int current = 0;

            // Single digit decode
            int oneDigit = s.charAt(i) - '0';
            if (oneDigit >= 1 && oneDigit <= 9) {
                current += prev1;
            }

            // Two digit decode
            int twoDigits = (s.charAt(i - 1) - '0') * 10 + oneDigit;
            if (twoDigits >= 10 && twoDigits <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    // Alternative: DP with array (easier to understand)
    public static int numDecodingsDP(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty string
        dp[1] = 1; // First character (already validated)

        for (int i = 2; i <= n; i++) {
            // Single digit
            int oneDigit = s.charAt(i - 1) - '0';
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Two digits
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + oneDigit;
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // Test Case 1: Multiple ways
        String s1 = "226";
        System.out.println("Test 1: " + numDecodings(s1)); // Expected: 3

        // Test Case 2: Single way
        String s2 = "12";
        System.out.println("Test 2: " + numDecodings(s2)); // Expected: 2

        // Test Case 3: Contains zero
        String s3 = "06";
        System.out.println("Test 3: " + numDecodings(s3)); // Expected: 0

        // Test Case 4: Valid zero
        String s4 = "10";
        System.out.println("Test 4: " + numDecodings(s4)); // Expected: 1

        // Test Case 5: Complex case
        String s5 = "2101";
        System.out.println("Test 5: " + numDecodings(s5)); // Expected: 1

        // Test Case 6: All single digits
        String s6 = "111111";
        System.out.println("Test 6: " + numDecodings(s6)); // Expected: 13

        // Compare with DP array approach
        System.out.println("\nDP Array approach:");
        System.out.println("Test 1: " + numDecodingsDP(s1)); // Expected: 3
    }
}
