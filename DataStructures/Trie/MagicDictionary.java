/**
 * Implement Magic Dictionary (LeetCode 676)
 * Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.
 */
public class MagicDictionary {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        root = new TrieNode();
    }

    /**
     * Builds the dictionary.
     * @param dictionary The array of words
     */
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEndOfWord = true;
        }
    }

    /**
     * Returns true if you can change exactly one character in searchWord to match a word in the dictionary.
     * @param searchWord The word to search
     * @return true if it matches exactly one modified character
     */
    public boolean search(String searchWord) {
        return searchHelper(root, searchWord, 0, false);
    }

    private boolean searchHelper(TrieNode node, String word, int index, boolean modified) {
        if (index == word.length()) {
            return modified && node.isEndOfWord;
        }

        char c = word.charAt(index);
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                if (c - 'a' == i) {
                    if (searchHelper(node.children[i], word, index + 1, modified)) {
                        return true;
                    }
                } else if (!modified) {
                    if (searchHelper(node.children[i], word, index + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
