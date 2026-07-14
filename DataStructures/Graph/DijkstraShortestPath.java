import java.util.*;

/**
 * Dijkstra's Shortest Path Algorithm
 * Time Complexity: O((V + E) log V) with priority queue
 * Space Complexity: O(V)
 * 
 * Finds shortest path from source to all vertices in weighted graph
 * Works only with non-negative edge weights
 */
public class DijkstraShortestPath {

    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Find shortest path from source to all vertices
    public static Map<Integer, Integer> dijkstra(Map<Integer, List<Edge>> graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();

        // Initialize distances
        for (int vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            if (visited.contains(currentVertex)) {
                continue;
            }

            visited.add(currentVertex);

            // Explore neighbors
            for (Edge edge : graph.getOrDefault(currentVertex, new ArrayList<>())) {
                int neighbor = edge.destination;
                int newDistance = distances.get(currentVertex) + edge.weight;

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    pq.offer(new Node(neighbor, newDistance));
                }
            }
        }

        return distances;
    }

    // Find shortest path from source to destination with path reconstruction
    public static List<Integer> shortestPathWithRoute(Map<Integer, List<Edge>> graph,
            int source, int destination) {
        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();

        // Initialize
        for (int vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        parent.put(source, null);

        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            if (visited.contains(currentVertex)) {
                continue;
            }

            visited.add(currentVertex);

            if (currentVertex == destination) {
                break;
            }

            for (Edge edge : graph.getOrDefault(currentVertex, new ArrayList<>())) {
                int neighbor = edge.destination;
                int newDistance = distances.get(currentVertex) + edge.weight;

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    parent.put(neighbor, currentVertex);
                    pq.offer(new Node(neighbor, newDistance));
                }
            }
        }

        // Reconstruct path
        List<Integer> path = new ArrayList<>();
        Integer current = destination;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);

        if (path.get(0) != source) {
            return new ArrayList<>(); // No path exists
        }

        return path;
    }

    public static void main(String[] args) {
        // Create weighted graph
        Map<Integer, List<Edge>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(new Edge(1, 4), new Edge(2, 1)));
        graph.put(1, Arrays.asList(new Edge(3, 1)));
        graph.put(2, Arrays.asList(new Edge(1, 2), new Edge(3, 5)));
        graph.put(3, Arrays.asList(new Edge(4, 3)));
        graph.put(4, new ArrayList<>());

        int source = 0;

        // Find shortest distances from source
        Map<Integer, Integer> distances = dijkstra(graph, source);

        System.out.println("Shortest distances from vertex " + source + ":");
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println("To vertex " + entry.getKey() + ": " +
                    (entry.getValue() == Integer.MAX_VALUE ? "INF" : entry.getValue()));
        }

        // Find shortest path with route
        int destination = 4;
        List<Integer> path = shortestPathWithRoute(graph, source, destination);
        System.out.println("\nShortest path from " + source + " to " + destination + ": " + path);
        System.out.println("Distance: " + distances.get(destination));
    }
}
