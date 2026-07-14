/**
 * Longest Word in Dictionary (LeetCode 720)
 * Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.
 */
public class LongestWord {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private TrieNode root = new TrieNode();
    private String ans = "";

    private void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }

    private void dfs(TrieNode node) {
        if (node == null) return;
        if (node.word != null) {
            if (node.word.length() > ans.length() || (node.word.length() == ans.length() && node.word.compareTo(ans) < 0)) {
                ans = node.word;
            }
        }
        for (TrieNode child : node.children) {
            if (child != null && child.word != null) {
                dfs(child);
            }
        }
    }

    /**
     * Finds the longest word that can be built one character at a time.
     * @param words The array of words
     * @return The longest word
     */
    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }
        root.word = ""; // Dummy word for root
        dfs(root);
        return ans;
    }
}
