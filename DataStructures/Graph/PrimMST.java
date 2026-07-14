
/**
 * Prim's Minimum Spanning Tree Algorithm
 * Time Complexity: O(E log V) with priority queue
 * Space Complexity: O(V)
 */
import java.util.*;

public class PrimMST {

    static class Edge {
        int destination, weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static int primMST(Map<Integer, List<Edge>> graph, int vertices) {
        boolean[] inMST = new boolean[vertices];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int totalWeight = 0;

        // Start from vertex 0
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int vertex = current.vertex;

            if (inMST[vertex])
                continue;

            inMST[vertex] = true;
            totalWeight += current.weight;

            System.out.println("Added vertex " + vertex + " with weight " + current.weight);

            // Add all adjacent edges
            for (Edge edge : graph.getOrDefault(vertex, new ArrayList<>())) {
                if (!inMST[edge.destination]) {
                    pq.offer(new Node(edge.destination, edge.weight));
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(new Edge(1, 2), new Edge(3, 6)));
        graph.put(1, Arrays.asList(new Edge(0, 2), new Edge(2, 3), new Edge(3, 8), new Edge(4, 5)));
        graph.put(2, Arrays.asList(new Edge(1, 3), new Edge(4, 7)));
        graph.put(3, Arrays.asList(new Edge(0, 6), new Edge(1, 8)));
        graph.put(4, Arrays.asList(new Edge(1, 5), new Edge(2, 7)));

        int totalWeight = primMST(graph, 5);
        System.out.println("\nTotal MST weight: " + totalWeight);
    }
}
