package DataStructures.Trie;

import java.util.List;
import java.util.ArrayList;

/**
 * Camelcase Matching (LeetCode 1023)
 * Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.
 */
public class CamelcaseMatching {
    
    /**
     * Checks if queries match the given pattern.
     * @param queries The array of query strings
     * @param pattern The pattern string
     * @return List of booleans indicating match
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            res.add(isMatch(q, pattern));
        }
        return res;
    }

    private boolean isMatch(String query, String pattern) {
        int i = 0;
        for (char c : query.toCharArray()) {
            if (i < pattern.length() && c == pattern.charAt(i)) {
                i++;
            } else if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return i == pattern.length();
    }
}
