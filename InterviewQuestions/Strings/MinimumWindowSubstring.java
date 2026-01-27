package InterviewQuestions.Strings;

import java.util.*;

/**
 * LeetCode 76: Minimum Window Substring
 * 
 * Problem: Given two strings s and t, return the minimum window substring of s
 * such that every character in t (including duplicates) is included in the
 * window.
 * 
 * Example:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * 
 * Approach: Sliding Window with HashMap
 * - Expand window until all characters of t are included
 * - Contract window while maintaining validity
 * - Track minimum window
 * 
 * Time Complexity: O(m + n) where m = s.length, n = t.length
 * Space Complexity: O(n) for hashmap
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int required = targetMap.size(); // Number of unique characters in t
        int formed = 0; // Number of unique characters in current window with desired frequency

        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            // Expand window
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // Check if frequency of current character matches target frequency
            if (targetMap.containsKey(c) &&
                    windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            // Contract window while it's valid
            while (left <= right && formed == required) {
                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // Remove leftmost character
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (targetMap.containsKey(leftChar) &&
                        windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        // Test Case 1: Standard case
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Test 1: " + minWindow(s1, t1)); // Expected: "BANC"

        // Test Case 2: Single character
        String s2 = "a";
        String t2 = "a";
        System.out.println("Test 2: " + minWindow(s2, t2)); // Expected: "a"

        // Test Case 3: No valid window
        String s3 = "a";
        String t3 = "aa";
        System.out.println("Test 3: " + minWindow(s3, t3)); // Expected: ""

        // Test Case 4: Entire string is minimum
        String s4 = "abc";
        String t4 = "abc";
        System.out.println("Test 4: " + minWindow(s4, t4)); // Expected: "abc"

        // Test Case 5: Duplicates in t
        String s5 = "aaaaaaaaaaaabbbbbcdd";
        String t5 = "abcdd";
        System.out.println("Test 5: " + minWindow(s5, t5)); // Expected: "abbbbbcdd"
    }
}
