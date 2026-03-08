import java.util.*;

/**
 * LeetCode #139 - Word Break
 * Time: O(n^2), Space: O(n)
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode",
                Arrays.asList("leet", "code"))); // true
        System.out.println(wordBreak("applepenapple",
                Arrays.asList("apple", "pen"))); // true
        System.out.println(wordBreak("catsandog",
                Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
    }
}
