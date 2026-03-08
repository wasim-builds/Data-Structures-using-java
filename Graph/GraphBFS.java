import java.util.*;

/**
 * GRAPH - BFS (Breadth First Search)
 *
 * WHAT IS IT?
 * BFS explores a graph level by level — it visits all neighbors of a node
 * before going deeper. Think of it like ripples spreading out in a pond.
 *
 * HOW IT WORKS:
 * 1. Start from a source node.
 * 2. Add it to a Queue and mark it as visited.
 * 3. While the queue is not empty:
 *    - Poll (remove) the front node.
 *    - Visit all its unvisited neighbors, mark them visited and add to queue.
 *
 * USE CASES:
 * - Shortest path in an UNWEIGHTED graph
 * - Level-order traversal
 * - Finding all connected components
 *
 * TIME:  O(V + E)  — V = vertices, E = edges
 * SPACE: O(V)
 */
public class GraphBFS {

    // Number of vertices
    private int V;
    // Adjacency list representation of the graph
    private List<List<Integer>> adj;

    public GraphBFS(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add an undirected edge between u and v
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // BFS from a given source vertex
    public void bfs(int source) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        System.out.print("BFS traversal from vertex " + source + ": ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // ---------- PRACTICE PROBLEM ----------
    // Find the shortest path (in number of edges) between src and dest
    public int shortestPath(int src, int dest) {
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        distance[src] = 0;
        queue.add(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                    if (neighbor == dest) return distance[neighbor]; // found!
                }
            }
        }
        return -1; // no path found
    }

    public static void main(String[] args) {
        GraphBFS g = new GraphBFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);

        // Graph looks like:
        //  0 - 1 - 3 - 5
        //  |
        //  2 - 4

        g.bfs(0);
        // Output: 0 1 2 3 4 5

        System.out.println("Shortest path from 0 to 5: " + g.shortestPath(0, 5));
        // Output: 3 (0 -> 1 -> 3 -> 5)
    }
}
