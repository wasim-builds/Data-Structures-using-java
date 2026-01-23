import java.util.*;

/**
 * Topological Sort for Directed Acyclic Graph (DAG)
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * 
 * Applications:
 * - Task scheduling
 * - Course prerequisites
 * - Build systems
 * - Dependency resolution
 */
public class TopologicalSort {

    // Topological sort using DFS
    public static List<Integer> topologicalSortDFS(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                topologicalSortDFSHelper(graph, vertex, visited, stack);
            }
        }

        // Pop all elements from stack to get topological order
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private static void topologicalSortDFSHelper(Map<Integer, List<Integer>> graph,
            int vertex,
            Set<Integer> visited,
            Stack<Integer> stack) {
        visited.add(vertex);

        for (int neighbor : graph.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                topologicalSortDFSHelper(graph, neighbor, visited, stack);
            }
        }

        stack.push(vertex);
    }

    // Topological sort using Kahn's Algorithm (BFS approach)
    public static List<Integer> topologicalSortBFS(Map<Integer, List<Integer>> graph) {
        // Calculate in-degree for each vertex
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int vertex : graph.keySet()) {
            inDegree.putIfAbsent(vertex, 0);
            for (int neighbor : graph.get(vertex)) {
                inDegree.put(neighbor, inDegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        // Add all vertices with in-degree 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int vertex : graph.keySet()) {
            if (inDegree.get(vertex) == 0) {
                queue.offer(vertex);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            // Reduce in-degree for neighbors
            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);

                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If result doesn't contain all vertices, graph has a cycle
        if (result.size() != graph.size()) {
            return new ArrayList<>(); // Cycle detected, no topological sort possible
        }

        return result;
    }

    // Check if topological sort is possible (i.e., graph is DAG)
    public static boolean canFinishAllTasks(int numTasks, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < numTasks; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        List<Integer> topoSort = topologicalSortBFS(graph);
        return topoSort.size() == numTasks;
    }

    public static void main(String[] args) {
        // Example: Course prerequisites
        // 0 -> 1 -> 3
        // 0 -> 2 -> 3
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Arrays.asList(3));
        graph.put(3, new ArrayList<>());

        System.out.println("Graph (Course Prerequisites):");
        System.out.println("0 -> 1, 2");
        System.out.println("1 -> 3");
        System.out.println("2 -> 3");

        List<Integer> topoSortDFS = topologicalSortDFS(graph);
        System.out.println("\nTopological Sort (DFS): " + topoSortDFS);

        List<Integer> topoSortBFS = topologicalSortBFS(graph);
        System.out.println("Topological Sort (BFS/Kahn's): " + topoSortBFS);

        // Example: Task scheduling
        Map<Integer, List<Integer>> taskGraph = new HashMap<>();
        taskGraph.put(5, Arrays.asList(2, 0));
        taskGraph.put(4, Arrays.asList(0, 1));
        taskGraph.put(2, Arrays.asList(3));
        taskGraph.put(3, Arrays.asList(1));
        taskGraph.put(0, new ArrayList<>());
        taskGraph.put(1, new ArrayList<>());

        System.out.println("\nTask Scheduling Example:");
        System.out.println("Topological Order: " + topologicalSortDFS(taskGraph));

        // Check if all tasks can be finished
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        boolean canFinish = canFinishAllTasks(4, prerequisites);
        System.out.println("\nCan finish all tasks: " + canFinish);
    }
}
