package Algorithms.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition Labels (LeetCode 763)
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 * Return a list of integers representing the size of these parts.
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
