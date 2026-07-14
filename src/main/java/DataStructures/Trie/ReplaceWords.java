package DataStructures.Trie;

import java.util.List;
import java.util.ArrayList;

/**
 * Replace Words (LeetCode 648)
 * In English, we have a concept called root, which can be followed by some other word to form another longer word.
 * This class provides a method to replace all successors in a sentence with their roots.
 */
public class ReplaceWords {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    /**
     * Replaces words in the sentence with the roots from the dictionary.
     * @param dictionary List of roots
     * @param sentence Space-separated words
     * @return The sentence with replaced words
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }

        StringBuilder ans = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            if (ans.length() > 0) {
                ans.append(" ");
            }
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null || cur.word != null) {
                    break;
                }
                cur = cur.children[c - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }
}
