package DataStructures.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Smallest String With Swaps (LeetCode 1202)
 * You are given a string s, and an array of pairs of indices in the string pairs.
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 */
public class SmallestStringWithSwaps {
    static class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int p) {
            if (p == parent[p]) return p;
            return parent[p] = find(parent[p]);
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        
        Map<Integer, List<Character>> rootToChars = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            rootToChars.putIfAbsent(root, new ArrayList<>());
            rootToChars.get(root).add(s.charAt(i));
        }
        
        for (List<Character> list : rootToChars.values()) {
            Collections.sort(list, Collections.reverseOrder());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            List<Character> list = rootToChars.get(root);
            sb.append(list.remove(list.size() - 1));
        }
        
        return sb.toString();
    }
}
