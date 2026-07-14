package DataStructures.DisjointSet;

/**
 * Redundant Connection (LeetCode 684)
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes.
 */
public class RedundantConnection {
    static class UnionFind {
        int[] parent;
        
        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }
        
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        
        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return false;
            parent[rootP] = rootQ;
            return true;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }
}
