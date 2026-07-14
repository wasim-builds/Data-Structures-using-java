package DataStructures.Trie;

/**
 * Prefix and Suffix Search (LeetCode 745)
 * Design a special dictionary that searches the words in it by a prefix and a suffix.
 */
public class WordFilter {
    static class TrieNode {
        TrieNode[] children = new TrieNode[27]; // 'a' to 'z' and '{'
        int weight = 0;
    }

    private TrieNode root;

    /**
     * Initializes the object with the words in the dictionary.
     * @param words The array of words
     */
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int weight = 0; weight < words.length; weight++) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); i++) {
                TrieNode curr = root;
                curr.weight = weight;
                // Add suffix + '{' + word to Trie
                for (int j = i; j < 2 * word.length() - 1; j++) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (curr.children[k] == null) {
                        curr.children[k] = new TrieNode();
                    }
                    curr = curr.children[k];
                    curr.weight = weight;
                }
            }
        }
    }

    /**
     * Returns the index of the word in the dictionary, which has the prefix pref and the suffix suff.
     * @param pref The prefix string
     * @param suff The suffix string
     * @return The index of the word
     */
    public int f(String pref, String suff) {
        TrieNode curr = root;
        String searchWord = suff + "{" + pref;
        for (char c : searchWord.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return -1;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.weight;
    }
}
