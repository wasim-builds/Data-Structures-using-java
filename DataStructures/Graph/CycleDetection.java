import java.util.*;

/**
 * Cycle Detection in Graphs
 * 
 * For Undirected Graph:
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * 
 * For Directed Graph:
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
public class CycleDetection {

    // Detect cycle in undirected graph using DFS
    public static boolean hasCycleUndirected(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();

        for (int vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                if (hasCycleUndirectedDFS(graph, vertex, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasCycleUndirectedDFS(Map<Integer, List<Integer>> graph,
            int current, int parent,
            Set<Integer> visited) {
        visited.add(current);

        for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (hasCycleUndirectedDFS(graph, neighbor, current, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // Visited neighbor that is not parent means cycle
                return true;
            }
        }

        return false;
    }

    // Detect cycle in directed graph using DFS (using colors)
    public static boolean hasCycleDirected(Map<Integer, List<Integer>> graph) {
        Set<Integer> white = new HashSet<>(graph.keySet()); // Not visited
        Set<Integer> gray = new HashSet<>(); // Currently visiting
        Set<Integer> black = new HashSet<>(); // Completely visited

        for (int vertex : graph.keySet()) {
            if (white.contains(vertex)) {
                if (hasCycleDirectedDFS(graph, vertex, white, gray, black)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasCycleDirectedDFS(Map<Integer, List<Integer>> graph,
            int current,
            Set<Integer> white,
            Set<Integer> gray,
            Set<Integer> black) {
        // Move vertex from white to gray
        white.remove(current);
        gray.add(current);

        for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
            if (black.contains(neighbor)) {
                continue; // Already processed
            }

            if (gray.contains(neighbor)) {
                return true; // Back edge found - cycle detected
            }

            if (hasCycleDirectedDFS(graph, neighbor, white, gray, black)) {
                return true;
            }
        }

        // Move vertex from gray to black
        gray.remove(current);
        black.add(current);

        return false;
    }

    // Detect cycle in directed graph using recursion stack
    public static boolean hasCycleDirectedSimple(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (int vertex : graph.keySet()) {
            if (hasCycleDirectedHelper(graph, vertex, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasCycleDirectedHelper(Map<Integer, List<Integer>> graph,
            int current,
            Set<Integer> visited,
            Set<Integer> recStack) {
        if (recStack.contains(current)) {
            return true; // Cycle detected
        }

        if (visited.contains(current)) {
            return false; // Already processed
        }

        visited.add(current);
        recStack.add(current);

        for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
            if (hasCycleDirectedHelper(graph, neighbor, visited, recStack)) {
                return true;
            }
        }

        recStack.remove(current);
        return false;
    }

    public static void main(String[] args) {
        // Test undirected graph with cycle
        Map<Integer, List<Integer>> undirectedWithCycle = new HashMap<>();
        undirectedWithCycle.put(0, Arrays.asList(1, 2));
        undirectedWithCycle.put(1, Arrays.asList(0, 2));
        undirectedWithCycle.put(2, Arrays.asList(0, 1, 3));
        undirectedWithCycle.put(3, Arrays.asList(2));

        System.out.println("Undirected graph with cycle: " +
                hasCycleUndirected(undirectedWithCycle));

        // Test undirected graph without cycle (tree)
        Map<Integer, List<Integer>> undirectedNoCycle = new HashMap<>();
        undirectedNoCycle.put(0, Arrays.asList(1, 2));
        undirectedNoCycle.put(1, Arrays.asList(0, 3));
        undirectedNoCycle.put(2, Arrays.asList(0));
        undirectedNoCycle.put(3, Arrays.asList(1));

        System.out.println("Undirected graph without cycle: " +
                hasCycleUndirected(undirectedNoCycle));

        // Test directed graph with cycle
        Map<Integer, List<Integer>> directedWithCycle = new HashMap<>();
        directedWithCycle.put(0, Arrays.asList(1));
        directedWithCycle.put(1, Arrays.asList(2));
        directedWithCycle.put(2, Arrays.asList(0, 3));
        directedWithCycle.put(3, new ArrayList<>());

        System.out.println("\nDirected graph with cycle: " +
                hasCycleDirected(directedWithCycle));

        // Test directed graph without cycle (DAG)
        Map<Integer, List<Integer>> directedNoCycle = new HashMap<>();
        directedNoCycle.put(0, Arrays.asList(1, 2));
        directedNoCycle.put(1, Arrays.asList(3));
        directedNoCycle.put(2, Arrays.asList(3));
        directedNoCycle.put(3, new ArrayList<>());

        System.out.println("Directed graph without cycle (DAG): " +
                hasCycleDirected(directedNoCycle));
    }
}
