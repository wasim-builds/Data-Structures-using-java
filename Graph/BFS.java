import java.util.*;

/**
 * Breadth-First Search (BFS) Graph Traversal
 * Time Complexity: O(V + E) where V = vertices, E = edges
 * Space Complexity: O(V) for queue and visited set
 * 
 * Applications:
 * - Shortest path in unweighted graph
 * - Level order traversal
 * - Finding connected components
 * - Detecting cycles in undirected graphs
 */
public class BFS {

    // BFS traversal starting from a given vertex
    public static void bfsTraversal(Map<Integer, List<Integer>> graph, int startVertex) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.offer(startVertex);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // Visit all neighbors
            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }

    // BFS to find shortest path in unweighted graph
    public static List<Integer> shortestPath(Map<Integer, List<Integer>> graph,
            int start, int end) {
        if (start == end) {
            return Arrays.asList(start);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();

        visited.add(start);
        queue.offer(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                // Reconstruct path
                return reconstructPath(parent, start, end);
            }

            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }

        return new ArrayList<>(); // No path found
    }

    // Helper method to reconstruct path
    private static List<Integer> reconstructPath(Map<Integer, Integer> parent,
            int start, int end) {
        List<Integer> path = new ArrayList<>();
        Integer current = end;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    // BFS level order traversal (returns nodes at each level)
    public static List<List<Integer>> levelOrderTraversal(Map<Integer, List<Integer>> graph,
            int startVertex) {
        List<List<Integer>> levels = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                int current = queue.poll();
                currentLevel.add(current);

                for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }

            levels.add(currentLevel);
        }

        return levels;
    }

    public static void main(String[] args) {
        // Create a sample graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 2, 3));
        graph.put(2, Arrays.asList(0, 1, 4));
        graph.put(3, Arrays.asList(1, 4, 5));
        graph.put(4, Arrays.asList(2, 3));
        graph.put(5, Arrays.asList(3));

        // BFS Traversal
        bfsTraversal(graph, 0);

        // Shortest Path
        List<Integer> path = shortestPath(graph, 0, 5);
        System.out.println("Shortest path from 0 to 5: " + path);

        // Level Order Traversal
        List<List<Integer>> levels = levelOrderTraversal(graph, 0);
        System.out.println("Level Order Traversal:");
        for (int i = 0; i < levels.size(); i++) {
            System.out.println("Level " + i + ": " + levels.get(i));
        }
    }
}
