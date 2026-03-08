package InterviewQuestions.Graphs;

import java.util.*;

/**
 * LeetCode 261: Graph Valid Tree
 * 
 * Problem: Given n nodes labeled from 0 to n-1 and a list of undirected edges,
 * check whether these edges make up a valid tree.
 * 
 * A valid tree must satisfy:
 * 1. Connected (all nodes reachable)
 * 2. No cycles
 * 3. Exactly n-1 edges
 * 
 * Approach: Union-Find (Disjoint Set Union)
 * - Use DSU to detect cycles
 * - Check if all nodes are connected
 * 
 * Time Complexity: O(E × α(n)) ≈ O(E) where α is inverse Ackermann
 * Space Complexity: O(n)
 */
public class GraphValidTree {

    static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int components;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false; // Cycle detected
            }

            // Union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            components--;
            return true;
        }

        public int getComponents() {
            return components;
        }
    }

    public static boolean validTree(int n, int[][] edges) {
        // A tree with n nodes must have exactly n-1 edges
        if (edges.length != n - 1) {
            return false;
        }

        UnionFind uf = new UnionFind(n);

        // Try to union all edges
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return false; // Cycle detected
            }
        }

        // Check if all nodes are connected (should be 1 component)
        return uf.getComponents() == 1;
    }

    // Alternative: DFS approach
    public static boolean validTreeDFS(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // DFS to check connectivity
        boolean[] visited = new boolean[n];
        dfs(graph, visited, 0);

        // Check if all nodes visited
        for (boolean v : visited) {
            if (!v)
                return false;
        }

        return true;
    }

    private static void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Valid tree
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        System.out.println("Test 1: " + validTree(5, edges1)); // Expected: true

        // Test Case 2: Has cycle
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
        System.out.println("Test 2: " + validTree(5, edges2)); // Expected: false

        // Test Case 3: Not connected
        int[][] edges3 = { { 0, 1 }, { 2, 3 } };
        System.out.println("Test 3: " + validTree(4, edges3)); // Expected: false

        // Test Case 4: Single node
        int[][] edges4 = {};
        System.out.println("Test 4: " + validTree(1, edges4)); // Expected: true

        // Test DFS approach
        System.out.println("\nDFS Approach:");
        System.out.println("Test 1: " + validTreeDFS(5, edges1)); // Expected: true
    }
}
