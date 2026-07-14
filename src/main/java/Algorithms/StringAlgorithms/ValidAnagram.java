package Algorithms.StringAlgorithms;

import java.util.Arrays;

/**
 * Valid Anagram (LeetCode 242)
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}
