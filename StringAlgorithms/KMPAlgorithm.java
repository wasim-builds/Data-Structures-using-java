/**
 * KMP (Knuth-Morris-Pratt) String Matching Algorithm
 * Time Complexity: O(n + m) where n = text length, m = pattern length
 * Space Complexity: O(m) for LPS array
 * 
 * More efficient than naive pattern matching O(n*m)
 * 
 * Applications:
 * - Text search
 * - DNA sequence matching
 * - Plagiarism detection
 */
public class KMPAlgorithm {

    // Build Longest Proper Prefix which is also Suffix (LPS) array
    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // Length of previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // lps[0] is always 0

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // KMP search - find first occurrence
    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m == 0)
            return 0;
        if (n < m)
            return -1;

        int[] lps = computeLPSArray(pattern);

        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                return i - j; // Pattern found at index i-j
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1; // Pattern not found
    }

    // Find all occurrences of pattern in text
    public static java.util.List<Integer> searchAll(String text, String pattern) {
        java.util.List<Integer> occurrences = new java.util.ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        if (m == 0 || n < m)
            return occurrences;

        int[] lps = computeLPSArray(pattern);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                occurrences.add(i - j);
                j = lps[j - 1];
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return occurrences;
    }

    // Count occurrences of pattern in text
    public static int countOccurrences(String text, String pattern) {
        return searchAll(text, pattern).size();
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

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
        String text2 = "AABAACAADAABAABA";
        String pattern2 = "AABA";

        System.out.println("\n--- Find All Occurrences ---");
        System.out.println("Text: " + text2);
        System.out.println("Pattern: " + pattern2);

        java.util.List<Integer> occurrences = searchAll(text2, pattern2);
        System.out.println("Pattern found at indices: " + occurrences);
        System.out.println("Total occurrences: " + occurrences.size());

        // LPS array example
        System.out.println("\n--- LPS Array Example ---");
        String pat = "ABABCABAB";
        int[] lps = computeLPSArray(pat);
        System.out.println("Pattern: " + pat);
        System.out.print("LPS Array: ");
        for (int val : lps) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
