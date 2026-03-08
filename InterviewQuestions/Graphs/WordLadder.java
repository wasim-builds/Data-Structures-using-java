package InterviewQuestions.Graphs;

import java.util.*;

/**
 * LeetCode 127: Word Ladder
 * 
 * Problem: Given two words (beginWord and endWord), and a dictionary's word
 * list,
 * find the length of shortest transformation sequence from beginWord to
 * endWord.
 * Each transformed word must exist in the word list. Only one letter can be
 * changed at a time.
 * 
 * Example:
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * 
 * Approach: BFS (shortest path in unweighted graph)
 * - Treat each word as a node
 * - Edge exists if words differ by one letter
 * - BFS to find shortest path
 * 
 * Time Complexity: O(n × m²) where n = wordList size, m = word length
 * Space Complexity: O(n × m²)
 */
public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        // If endWord not in list, no solution
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Try changing each character
                char[] chars = currentWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];

                    // Try all 26 letters
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar)
                            continue;

                        chars[j] = c;
                        String newWord = new String(chars);

                        // Found the target
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If valid transformation, add to queue
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // Mark as visited
                        }
                    }

                    chars[j] = originalChar; // Restore
                }
            }

            level++;
        }

        return 0; // No transformation sequence found
    }

    public static void main(String[] args) {
        // Test Case 1: Standard case
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Test 1: " + ladderLength("hit", "cog", wordList1));
        // Expected: 5 (hit -> hot -> dot -> dog -> cog)

        // Test Case 2: No solution
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println("Test 2: " + ladderLength("hit", "cog", wordList2));
        // Expected: 0 (cog not in wordList)

        // Test Case 3: Direct transformation
        List<String> wordList3 = Arrays.asList("hot", "dot", "dog");
        System.out.println("Test 3: " + ladderLength("hot", "dot", wordList3));
        // Expected: 2 (hot -> dot)

        // Test Case 4: Longer sequence
        List<String> wordList4 = Arrays.asList("a", "b", "c");
        System.out.println("Test 4: " + ladderLength("a", "c", wordList4));
        // Expected: 2 (a -> c)
    }
}
