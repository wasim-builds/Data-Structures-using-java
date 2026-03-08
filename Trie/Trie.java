/**
 * Trie (Prefix Tree) Data Structure
 * Time Complexity:
 * - Insert: O(m) where m is length of word
 * - Search: O(m)
 * - StartsWith: O(m)
 * - Delete: O(m)
 * Space Complexity: O(ALPHABET_SIZE * m * n) where n is number of words
 * 
 * Applications:
 * - Autocomplete
 * - Spell checker
 * - IP routing
 * - Dictionary implementation
 */
public class Trie {

    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // For lowercase a-z
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    // Check if any word starts with the given prefix
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    // Helper method to search for a node
    private TrieNode searchNode(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }

    // Delete a word from the trie
    public boolean delete(String word) {
        return deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false; // Word not found
            }

            current.isEndOfWord = false;

            // If current has no children, it can be deleted
            return isEmpty(current);
        }

        char ch = word.charAt(index);
        int charIndex = ch - 'a';
        TrieNode node = current.children[charIndex];

        if (node == null) {
            return false; // Word not found
        }

        boolean shouldDeleteCurrentNode = deleteHelper(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.children[charIndex] = null;

            // Return true if current node can be deleted
            return !current.isEndOfWord && isEmpty(current);
        }

        return false;
    }

    // Check if node has any children
    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    // Get all words with given prefix (autocomplete)
    public java.util.List<String> autocomplete(String prefix) {
        java.util.List<String> results = new java.util.ArrayList<>();
        TrieNode node = searchNode(prefix);

        if (node != null) {
            collectWords(node, prefix, results);
        }

        return results;
    }

    private void collectWords(TrieNode node, String prefix, java.util.List<String> results) {
        if (node.isEndOfWord) {
            results.add(prefix);
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char ch = (char) ('a' + i);
                collectWords(node.children[i], prefix + ch, results);
            }
        }
    }

    // Count total words in trie
    public int countWords() {
        return countWordsHelper(root);
    }

    private int countWordsHelper(TrieNode node) {
        if (node == null) {
            return 0;
        }

        int count = node.isEndOfWord ? 1 : 0;

        for (TrieNode child : node.children) {
            count += countWordsHelper(child);
        }

        return count;
    }

    // Find longest common prefix
    public String longestCommonPrefix() {
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;

        while (current != null && !current.isEndOfWord && countChildren(current) == 1) {
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    prefix.append((char) ('a' + i));
                    current = current.children[i];
                    break;
                }
            }
        }

        return prefix.toString();
    }

    private int countChildren(TrieNode node) {
        int count = 0;
        for (TrieNode child : node.children) {
            if (child != null) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words
        String[] words = { "apple", "app", "apricot", "banana", "band", "bandana" };
        System.out.println("Inserting words:");
        for (String word : words) {
            trie.insert(word);
            System.out.println("  " + word);
        }

        // Search
        System.out.println("\nSearch Results:");
        System.out.println("Search 'apple': " + trie.search("apple"));
        System.out.println("Search 'app': " + trie.search("app"));
        System.out.println("Search 'appl': " + trie.search("appl"));

        // Prefix search
        System.out.println("\nPrefix Search:");
        System.out.println("StartsWith 'app': " + trie.startsWith("app"));
        System.out.println("StartsWith 'ban': " + trie.startsWith("ban"));
        System.out.println("StartsWith 'cat': " + trie.startsWith("cat"));

        // Autocomplete
        System.out.println("\nAutocomplete 'app': " + trie.autocomplete("app"));
        System.out.println("Autocomplete 'ban': " + trie.autocomplete("ban"));

        // Count words
        System.out.println("\nTotal words in trie: " + trie.countWords());

        // Delete
        System.out.println("\nDeleting 'app'...");
        trie.delete("app");
        System.out.println("Search 'app' after deletion: " + trie.search("app"));
        System.out.println("Search 'apple' after deletion: " + trie.search("apple"));
        System.out.println("Total words after deletion: " + trie.countWords());
    }
}
