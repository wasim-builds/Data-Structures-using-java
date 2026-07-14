import java.util.*;

/**
 * Depth-First Search (DFS) Graph Traversal
 * Time Complexity: O(V + E) where V = vertices, E = edges
 * Space Complexity: O(V) for recursion stack and visited set
 * 
 * Applications:
 * - Detecting cycles
 * - Topological sorting
 * - Finding connected components
 * - Solving maze problems
 * - Path finding
 */
public class DFS {

    // Recursive DFS traversal
    public static void dfsRecursive(Map<Integer, List<Integer>> graph,
            int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (int neighbor : graph.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(graph, neighbor, visited);
            }
        }
    }

    // Iterative DFS using stack
    public static void dfsIterative(Map<Integer, List<Integer>> graph, int startVertex) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        System.out.print("DFS Iterative: ");

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current + " ");

                // Add neighbors in reverse order to maintain left-to-right traversal
                List<Integer> neighbors = graph.getOrDefault(current, new ArrayList<>());
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    if (!visited.contains(neighbors.get(i))) {
                        stack.push(neighbors.get(i));
                    }
                }
            }
        }
        System.out.println();
    }

    // Find all paths from source to destination
    public static List<List<Integer>> findAllPaths(Map<Integer, List<Integer>> graph,
            int start, int end) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        findAllPathsHelper(graph, start, end, visited, currentPath, allPaths);
        return allPaths;
    }

    private static void findAllPathsHelper(Map<Integer, List<Integer>> graph,
            int current, int end,
            Set<Integer> visited,
            List<Integer> currentPath,
            List<List<Integer>> allPaths) {
        visited.add(current);
        currentPath.add(current);

        if (current == end) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    findAllPathsHelper(graph, neighbor, end, visited, currentPath, allPaths);
                }
            }
        }

        // Backtrack
        currentPath.remove(currentPath.size() - 1);
        visited.remove(current);
    }

    // Check if path exists between two vertices
    public static boolean hasPath(Map<Integer, List<Integer>> graph,
            int start, int end, Set<Integer> visited) {
        if (start == end) {
            return true;
        }

        visited.add(start);

        for (int neighbor : graph.getOrDefault(start, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (hasPath(graph, neighbor, end, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Count connected components in undirected graph
    public static int countConnectedComponents(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                dfsRecursive(graph, vertex, visited);
                count++;
                System.out.println(); // New line for each component
            }
        }

        return count;
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

        // DFS Recursive
        System.out.print("DFS Recursive: ");
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(graph, 0, visited);
        System.out.println();

        // DFS Iterative
        dfsIterative(graph, 0);

        // Find all paths
        List<List<Integer>> paths = findAllPaths(graph, 0, 5);
        System.out.println("\nAll paths from 0 to 5:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        // Check if path exists
        boolean pathExists = hasPath(graph, 0, 5, new HashSet<>());
        System.out.println("\nPath exists from 0 to 5: " + pathExists);

        // Disconnected graph for connected components
        Map<Integer, List<Integer>> disconnectedGraph = new HashMap<>();
        disconnectedGraph.put(0, Arrays.asList(1, 2));
        disconnectedGraph.put(1, Arrays.asList(0));
        disconnectedGraph.put(2, Arrays.asList(0));
        disconnectedGraph.put(3, Arrays.asList(4));
        disconnectedGraph.put(4, Arrays.asList(3));
        disconnectedGraph.put(5, new ArrayList<>());

        System.out.println("\nConnected Components:");
        int components = countConnectedComponents(disconnectedGraph);
        System.out.println("Total connected components: " + components);
    }
}
