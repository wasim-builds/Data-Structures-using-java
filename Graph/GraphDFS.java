import java.util.*;

/**
 * GRAPH - DFS (Depth First Search)
 *
 * WHAT IS IT?
 * DFS dives as deep as possible down one path before backtracking.
 * Think of it like exploring a maze — you go down one corridor fully
 * before coming back to try the next one.
 *
 * HOW IT WORKS (Recursive):
 * 1. Start at a node, mark it as visited.
 * 2. Recurse into each unvisited neighbor.
 * 3. When you hit a dead end, backtrack and try the next neighbor.
 *
 * USE CASES:
 * - Detecting cycles in a graph
 * - Finding connected components
 * - Solving mazes / puzzles
 * - Topological ordering (base for it)
 *
 * TIME:  O(V + E)
 * SPACE: O(V)  — recursive call stack
 */
public class GraphDFS {

    private int V;
    private List<List<Integer>> adj;

    public GraphDFS(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // DFS from a source vertex
    public void dfs(int source) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS traversal from vertex " + source + ": ");
        dfsHelper(source, visited);
        System.out.println();
    }

    private void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // ---------- PRACTICE PROBLEM ----------
    // Count total number of connected components in the graph
    // (How many separate "islands" of nodes exist?)
    public int countConnectedComponents() {
        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsHelper(i, visited); // fill up one entire component
                count++;
            }
        }
        return count;
    }

    // ---------- PRACTICE PROBLEM ----------
    // Detect a cycle in an UNDIRECTED graph using DFS
    public boolean hasCycle() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (cycleDetect(i, visited, -1)) return true;
            }
        }
        return false;
    }

    private boolean cycleDetect(int node, boolean[] visited, int parent) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (cycleDetect(neighbor, visited, node)) return true;
            } else if (neighbor != parent) {
                // found a visited node that isn't our direct parent → cycle!
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);

        // Graph:
        //  0 - 1 - 3 - 5
        //  |
        //  2 - 4

        g.dfs(0);
        // Output: 0 1 3 5 2 4

        System.out.println("Connected components: " + g.countConnectedComponents());
        // Output: 1 (all nodes connected)

        System.out.println("Has cycle: " + g.hasCycle());
        // Output: false

        // Add a cycle
        g.addEdge(4, 1);
        System.out.println("Has cycle (after adding edge 4-1): " + g.hasCycle());
        // Output: true
    }
}
