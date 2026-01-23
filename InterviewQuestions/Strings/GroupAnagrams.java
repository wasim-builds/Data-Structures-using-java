import java.util.*;

/**
 * LeetCode #49 - Group Anagrams
 * Time: O(n*k) where k is max length, Space: O(n*k)
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] count = new char[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = String.valueOf(count);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
    }
}
