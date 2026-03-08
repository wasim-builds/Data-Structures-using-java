import java.util.*;

/**
 * DIJKSTRA'S ALGORITHM — Shortest Path in a Weighted Graph
 *
 * WHAT IS IT?
 * Dijkstra finds the shortest distance from a source node to ALL other nodes
 * in a graph where edges have non-negative weights (distances/costs).
 *
 * REAL WORLD ANALOGY:
 * Think of Google Maps. You want the fastest route from your home to college.
 * Roads have different travel times (weights). Dijkstra finds the path
 * with the minimum total travel time.
 *
 * HOW IT WORKS (Greedy + Priority Queue):
 * 1. Set distance to source = 0, all others = infinity.
 * 2. Use a Min-Heap (Priority Queue) — always process the nearest unvisited node first.
 * 3. For the current node, update distances to all neighbors:
 *    if (current distance + edge weight) < known distance → update it.
 * 4. Repeat until all nodes are processed.
 *
 * KEY RULE: A node's distance is FINAL once it's popped from the priority queue.
 *
 * DOES NOT WORK WITH: Negative edge weights (use Bellman-Ford instead).
 *
 * TIME:  O((V + E) log V)
 * SPACE: O(V)
 */
public class Dijkstra {

    static final int INF = Integer.MAX_VALUE;

    // Edge class to store destination and weight
    static class Edge {
        int dest, weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Pair class to store (distance, node) in the priority queue
    static class Pair implements Comparable<Pair> {
        int dist, node;
        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.dist, other.dist); // min-heap by distance
        }
    }

    public static int[] dijkstra(int V, List<List<Edge>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Min-heap: always process the node with smallest known distance first
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentDist = current.dist;
            int node = current.node;

            // If we already found a better path, skip this outdated entry
            if (currentDist > dist[node]) continue;

            for (Edge edge : adj.get(node)) {
                int newDist = dist[node] + edge.weight;
                if (newDist < dist[edge.dest]) {
                    dist[edge.dest] = newDist;
                    pq.add(new Pair(newDist, edge.dest));
                }
            }
        }
        return dist; // dist[i] = shortest distance from src to node i
    }

    // ---------- PRACTICE PROBLEM ----------
    // Find the shortest path distance from source to a specific destination
    public static int shortestPath(int V, List<List<Edge>> adj, int src, int dest) {
        int[] dist = dijkstra(V, adj, src);
        return dist[dest] == INF ? -1 : dist[dest];
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add weighted directed edges: addEdge(u, v, weight)
        // Graph:
        //    0 --4-- 1
        //    |       |
        //    8       2
        //    |       |
        //    2 --5-- 3 --6-- 4

        adj.get(0).add(new Edge(1, 4));
        adj.get(0).add(new Edge(2, 8));
        adj.get(1).add(new Edge(3, 2));
        adj.get(2).add(new Edge(3, 5));
        adj.get(3).add(new Edge(4, 6));

        int[] distances = dijkstra(V, adj, 0);

        System.out.println("Shortest distances from node 0:");
        for (int i = 0; i < V; i++) {
            System.out.println("  To node " + i + " : " + (distances[i] == INF ? "Unreachable" : distances[i]));
        }
        // Output:
        // To node 0 : 0
        // To node 1 : 4
        // To node 2 : 8
        // To node 3 : 6   (0→1→3, cost = 4+2 = 6)
        // To node 4 : 12  (0→1→3→4, cost = 4+2+6 = 12)

        System.out.println("\nShortest path from 0 to 4: " + shortestPath(V, adj, 0, 4));
        // Output: 12
    }
}
