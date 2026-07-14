import java.util.Map;
import java.util.HashMap;

/**
 * Map Sum Pairs (LeetCode 677)
 * Implement the MapSum class.
 */
public class MapSum {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int value = 0;
    }

    private TrieNode root;
    private Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    /**
     * Inserts a key-value pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
     * @param key The key string
     * @param val The value integer
     */
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode curr = root;
        curr.value += delta;
        for (char c : key.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
            curr.value += delta;
        }
    }

    /**
     * Returns the sum of all the pairs' value whose key starts with the prefix.
     * @param prefix The prefix string
     * @return Sum of values
     */
    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return 0;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.value;
    }
}
