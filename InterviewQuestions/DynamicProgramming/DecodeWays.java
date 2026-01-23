/**
 * LeetCode #91 - Decode Ways
 * Difficulty: Medium
 * Time: O(n), Space: O(1)
 */
public class DecodeWays {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int prev2 = 1, prev1 = 1;

        for (int i = 1; i < s.length(); i++) {
            int current = 0;

            // Single digit
            if (s.charAt(i) != '0') {
                current += prev1;
            }

            // Two digits
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12")); // 2
        System.out.println(numDecodings("226")); // 3
        System.out.println(numDecodings("06")); // 0
    }
}
