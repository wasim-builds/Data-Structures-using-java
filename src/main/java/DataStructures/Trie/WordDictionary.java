package DataStructures.Trie;

/**
 * Design Add and Search Words Data Structure (LeetCode 211)
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 */
public class WordDictionary {
    private WordDictionary[] children;
    private boolean isEndOfWord;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        children = new WordDictionary[26];
        isEndOfWord = false;
    }

    /**
     * Adds a word into the data structure.
     * @param word The word to add
     */
    public void addWord(String word) {
        WordDictionary curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new WordDictionary();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    /**
     * Returns true if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     * @param word The word to search
     * @return true if word is found, false otherwise
     */
    public boolean search(String word) {
        return searchHelper(word, 0, this);
    }

    private boolean searchHelper(String word, int index, WordDictionary curr) {
        if (index == word.length()) {
            return curr.isEndOfWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (WordDictionary child : curr.children) {
                if (child != null && searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            return searchHelper(word, index + 1, curr.children[c - 'a']);
        }
    }
}
