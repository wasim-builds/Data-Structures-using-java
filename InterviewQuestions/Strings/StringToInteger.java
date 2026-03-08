/**
 * LeetCode #8 - String to Integer (atoi)
 * Difficulty: Medium
 * Time: O(n), Space: O(1)
 */
public class StringToInteger {
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int i = 0, n = s.length();

        // Skip whitespace
        while (i < n && s.charAt(i) == ' ')
            i++;

        if (i == n)
            return 0;

        // Check sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        // Convert digits
        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            // Check overflow
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42")); // 42
        System.out.println(myAtoi("   -42")); // -42
        System.out.println(myAtoi("4193 with words")); // 4193
        System.out.println(myAtoi("words and 987")); // 0
    }
}
