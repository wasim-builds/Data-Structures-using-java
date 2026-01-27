package InterviewQuestions.Strings;

import java.util.*;

/**
 * LeetCode 131: Palindrome Partitioning
 * 
 * Problem: Given a string s, partition s such that every substring of the
 * partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * 
 * Approach: Backtracking
 * - Try all possible partitions
 * - Check if each partition is a palindrome
 * - Backtrack if not valid
 * 
 * Time Complexity: O(n × 2^n) - n for palindrome check, 2^n partitions
 * Space Complexity: O(n) for recursion stack
 */
public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        // Base case: reached end of string
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try all possible partitions starting from 'start'
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);

            // Only proceed if current substring is a palindrome
            if (isPalindrome(substring)) {
                current.add(substring);
                backtrack(s, end, current, result);
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test Case 1: Multiple palindrome partitions
        String s1 = "aab";
        System.out.println("Test 1: " + partition(s1));
        // Expected: [["a","a","b"],["aa","b"]]

        // Test Case 2: All same characters
        String s2 = "aaa";
        System.out.println("Test 2: " + partition(s2));
        // Expected: [["a","a","a"],["a","aa"],["aa","a"],["aaa"]]

        // Test Case 3: Single character
        String s3 = "a";
        System.out.println("Test 3: " + partition(s3));
        // Expected: [["a"]]

        // Test Case 4: No palindrome substring > 1
        String s4 = "abc";
        System.out.println("Test 4: " + partition(s4));
        // Expected: [["a","b","c"]]

        // Test Case 5: Entire string is palindrome
        String s5 = "aba";
        System.out.println("Test 5: " + partition(s5));
        // Expected: [["a","b","a"],["aba"]]
    }
}
