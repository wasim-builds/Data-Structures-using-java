package InterviewQuestions.DynamicProgramming;

/**
 * LeetCode 72: Edit Distance
 * 
 * Problem: Given two strings word1 and word2, return the minimum number of
 * operations
 * required to convert word1 to word2. Operations: insert, delete, replace a
 * character.
 * 
 * Example:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: horse -> rorse -> rose -> ros
 * 
 * Approach: 2D Dynamic Programming
 * - dp[i][j] = min operations to convert word1[0...i-1] to word2[0...j-1]
 * - If chars match: dp[i][j] = dp[i-1][j-1]
 * - Else: dp[i][j] = 1 + min(insert, delete, replace)
 * 
 * Time Complexity: O(m × n)
 * Space Complexity: O(m × n), can be optimized to O(n)
 */
public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] = min operations to convert word1[0..i-1] to word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Delete all characters
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Insert all characters
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Take minimum of three operations
                    int insert = dp[i][j - 1]; // Insert char from word2
                    int delete = dp[i - 1][j]; // Delete char from word1
                    int replace = dp[i - 1][j - 1]; // Replace char

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }

    // Space optimized version: O(n) space
    public static int minDistanceOptimized(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Only need current and previous row
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // Initialize first row
        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            curr[0] = i; // First column

            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(curr[j - 1], Math.min(prev[j], prev[j - 1]));
                }
            }

            // Swap arrays
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }

    public static void main(String[] args) {
        // Test Case 1: Standard case
        String word1_1 = "horse";
        String word2_1 = "ros";
        System.out.println("Test 1: " + minDistance(word1_1, word2_1));
        // Expected: 3 (horse -> rorse -> rose -> ros)

        // Test Case 2: One empty string
        String word1_2 = "intention";
        String word2_2 = "execution";
        System.out.println("Test 2: " + minDistance(word1_2, word2_2));
        // Expected: 5

        // Test Case 3: Same strings
        String word1_3 = "abc";
        String word2_3 = "abc";
        System.out.println("Test 3: " + minDistance(word1_3, word2_3));
        // Expected: 0

        // Test Case 4: Completely different
        String word1_4 = "abc";
        String word2_4 = "def";
        System.out.println("Test 4: " + minDistance(word1_4, word2_4));
        // Expected: 3

        // Test optimized version
        System.out.println("\nOptimized version:");
        System.out.println("Test 1: " + minDistanceOptimized(word1_1, word2_1));
        // Expected: 3
    }
}
