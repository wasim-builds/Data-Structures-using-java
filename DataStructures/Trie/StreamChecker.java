/**
 * Stream of Characters (LeetCode 1032)
 * Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of a given array of strings words.
 */
public class StreamChecker {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;
    private StringBuilder stream;

    /**
     * Initializes the object with the strings array words.
     * @param words The array of words
     */
    public StreamChecker(String[] words) {
        root = new TrieNode();
        stream = new StringBuilder();
        for (String word : words) {
            TrieNode curr = root;
            // Insert reversed word
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEndOfWord = true;
        }
    }

    /**
     * Accepts a character and returns true if a suffix of the stream is in the dictionary.
     * @param letter The character added to the stream
     * @return true if a suffix exists in dictionary
     */
    public boolean query(char letter) {
        stream.append(letter);
        TrieNode curr = root;
        for (int i = stream.length() - 1; i >= 0; i--) {
            char c = stream.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
            if (curr.isEndOfWord) {
                return true;
            }
        }
        return false;
    }
}
