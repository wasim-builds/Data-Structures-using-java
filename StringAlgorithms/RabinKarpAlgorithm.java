/**
 * Rabin-Karp String Matching Algorithm
 * Time Complexity: O(n + m) average case, O(n*m) worst case
 * Space Complexity: O(1)
 * 
 * Uses rolling hash for efficient pattern matching
 * 
 * Applications:
 * - Multiple pattern search
 * - Plagiarism detection
 * - Finding duplicate files
 */
public class RabinKarpAlgorithm {

    private static final int PRIME = 101; // Prime number for hash calculation
    private static final int BASE = 256; // Number of characters in alphabet

    // Calculate hash value for a string
    private static long calculateHash(String str, int length) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * BASE + str.charAt(i)) % PRIME;
        }
        return hash;
    }

    // Recalculate hash using rolling hash technique
    private static long recalculateHash(String str, int oldIndex, int newIndex,
            long oldHash, int patternLength) {
        long newHash = oldHash - str.charAt(oldIndex) *
                (long) Math.pow(BASE, patternLength - 1);
        newHash = (newHash * BASE + str.charAt(newIndex)) % PRIME;

        // Handle negative hash
        if (newHash < 0) {
            newHash += PRIME;
        }

        return newHash;
    }

    // Check if pattern matches text at given index
    private static boolean checkEqual(String text, int start, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(start + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Search for pattern in text - find first occurrence
    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m > n)
            return -1;

        long patternHash = calculateHash(pattern, m);
        long textHash = calculateHash(text, m);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                // Hash matches, verify actual string
                if (checkEqual(text, i, pattern)) {
                    return i;
                }
            }

            // Calculate hash for next window
            if (i < n - m) {
                textHash = recalculateHash(text, i, i + m, textHash, m);
            }
        }

        return -1;
    }

    // Find all occurrences of pattern in text
    public static java.util.List<Integer> searchAll(String text, String pattern) {
        java.util.List<Integer> occurrences = new java.util.ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        if (m > n)
            return occurrences;

        long patternHash = calculateHash(pattern, m);
        long textHash = calculateHash(text, m);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                if (checkEqual(text, i, pattern)) {
                    occurrences.add(i);
                }
            }

            if (i < n - m) {
                textHash = recalculateHash(text, i, i + m, textHash, m);
            }
        }

        return occurrences;
    }

    // Search for multiple patterns in text
    public static java.util.Map<String, java.util.List<Integer>> searchMultiplePatterns(String text,
            String[] patterns) {
        java.util.Map<String, java.util.List<Integer>> results = new java.util.HashMap<>();

        for (String pattern : patterns) {
            results.put(pattern, searchAll(text, pattern));
        }

        return results;
    }

    public static void main(String[] args) {
        String text = "GEEKS FOR GEEKS";
        String pattern = "GEEKS";

        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);

        // Find first occurrence
        int index = search(text, pattern);
        if (index != -1) {
            System.out.println("\nPattern found at index: " + index);
        } else {
            System.out.println("\nPattern not found");
        }

        // Find all occurrences
        java.util.List<Integer> occurrences = searchAll(text, pattern);
        System.out.println("All occurrences at indices: " + occurrences);

        // Multiple pattern search
        System.out.println("\n--- Multiple Pattern Search ---");
        String text2 = "AABAACAADAABAABA";
        String[] patterns = { "AABA", "AA", "CAD" };

        System.out.println("Text: " + text2);
        System.out.println("Patterns: " + java.util.Arrays.toString(patterns));

        java.util.Map<String, java.util.List<Integer>> results = searchMultiplePatterns(text2, patterns);

        System.out.println("\nResults:");
        for (java.util.Map.Entry<String, java.util.List<Integer>> entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
