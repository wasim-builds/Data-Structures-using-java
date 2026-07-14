
/**
 * Bellman-Ford Algorithm - Shortest Path with Negative Weights
 * Time Complexity: O(V*E)
 * Space Complexity: O(V)
 * 
 * Can detect negative weight cycles
 * Works with negative edge weights (unlike Dijkstra)
 */
import java.util.*;

public class BellmanFord {

    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static int[] bellmanFord(List<Edge> edges, int vertices, int source) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < vertices - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE &&
                        distance[edge.source] + edge.weight < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE &&
                    distance[edge.source] + edge.weight < distance[edge.destination]) {
                System.out.println("Graph contains negative weight cycle");
                return null;
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, -1));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 2));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -3));

        int[] distances = bellmanFord(edges, 5, 0);

        if (distances != null) {
            System.out.println("Shortest distances from source 0:");
            for (int i = 0; i < distances.length; i++) {
                System.out.println("To vertex " + i + ": " +
                        (distances[i] == Integer.MAX_VALUE ? "INF" : distances[i]));
            }
        }
    }
}
