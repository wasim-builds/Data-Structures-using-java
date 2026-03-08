import java.util.*;

/**
 * LeetCode #3 - Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(min(m,n)) where m is charset size
 */
public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3 ("abc")
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1 ("b")
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3 ("wke")
    }
}
