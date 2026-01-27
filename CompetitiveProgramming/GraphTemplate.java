package CompetitiveProgramming;

import java.util.*;

/**
 * Graph Algorithms Template for Competitive Programming
 * 
 * Contains commonly used graph algorithms:
 * - BFS and DFS
 * - Shortest paths (Dijkstra, Bellman-Ford)
 * - Topological Sort
 * - Cycle Detection
 * - Connected Components
 * - Minimum Spanning Tree (Kruskal, Prim)
 */
public class GraphTemplate {

    // ==================== Graph Representation ====================

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // ==================== BFS ====================

    public static void bfs(List<List<Integer>> graph, int start) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }

    // BFS for shortest path (unweighted)
    public static int[] bfsShortestPath(List<List<Integer>> graph, int start) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return dist;
    }

    // ==================== DFS ====================

    public static void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    // ==================== Dijkstra's Algorithm ====================

    public static long[] dijkstra(List<List<Edge>> graph, int start) {
        int n = graph.size();
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[] { start, 0 });

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long d = curr[1];

            if (d > dist[node])
                continue;

            for (Edge edge : graph.get(node)) {
                long newDist = dist[node] + edge.weight;
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    pq.offer(new long[] { edge.to, newDist });
                }
            }
        }

        return dist;
    }

    // ==================== Bellman-Ford Algorithm ====================

    public static long[] bellmanFord(int n, List<int[]> edges, int start) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        // Relax edges n-1 times
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != Long.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check for negative cycles
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dist[u] != Long.MAX_VALUE && dist[u] + w < dist[v]) {
                return null; // Negative cycle detected
            }
        }

        return dist;
    }

    // ==================== Topological Sort ====================

    public static List<Integer> topologicalSort(List<List<Integer>> graph) {
        int n = graph.size();
        int[] indegree = new int[n];

        // Calculate indegrees
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result.size() == n ? result : null; // null if cycle exists
    }

    // ==================== Cycle Detection ====================

    // Detect cycle in undirected graph using DFS
    public static boolean hasCycleUndirected(List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfsUndirectedCycle(graph, i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsUndirectedCycle(List<List<Integer>> graph, int node, int parent, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfsUndirectedCycle(graph, neighbor, node, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Back edge found
            }
        }
        return false;
    }

    // Detect cycle in directed graph
    public static boolean hasCycleDirected(List<List<Integer>> graph) {
        int n = graph.size();
        int[] state = new int[n]; // 0: unvisited, 1: visiting, 2: visited

        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                if (dfsDirectedCycle(graph, i, state)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsDirectedCycle(List<List<Integer>> graph, int node, int[] state) {
        state[node] = 1; // Mark as visiting

        for (int neighbor : graph.get(node)) {
            if (state[neighbor] == 1) {
                return true; // Back edge to ancestor
            }
            if (state[neighbor] == 0 && dfsDirectedCycle(graph, neighbor, state)) {
                return true;
            }
        }

        state[node] = 2; // Mark as visited
        return false;
    }

    // ==================== Connected Components ====================

    public static int countConnectedComponents(List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }

        return count;
    }

    // ==================== Union-Find (DSU) ====================

    static class UnionFind {
        int[] parent, rank;
        int components;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return false;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            components--;
            return true;
        }
    }

    // ==================== Demo ====================

    public static void main(String[] args) {
        // Create sample graph
        int n = 5;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges: 0-1, 0-2, 1-3, 2-4
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);

        System.out.println("=== BFS from node 0 ===");
        bfs(graph, 0);

        System.out.println("\n=== DFS from node 0 ===");
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited);
        System.out.println();

        System.out.println("\n=== Shortest paths from node 0 ===");
        int[] dist = bfsShortestPath(graph, 0);
        System.out.println(Arrays.toString(dist));
    }
}
