import java.util.*;

/**
 * TOPOLOGICAL SORT (Kahn's Algorithm - BFS based)
 *
 * WHAT IS IT?
 * Topological sort gives a linear ordering of tasks in a DIRECTED ACYCLIC GRAPH (DAG)
 * such that task A always comes before task B if there is an edge from A → B.
 *
 * REAL WORLD ANALOGY:
 * Think of it like college course prerequisites. Before taking "Data Structures",
 * you must first complete "Programming Basics". Topological sort gives you a valid
 * study schedule where no course appears before its prerequisite.
 *
 * HOW IT WORKS (Kahn's Algorithm):
 * 1. Calculate in-degree (number of incoming edges) for every node.
 * 2. Add all nodes with in-degree = 0 (no prerequisites) to a Queue.
 * 3. While queue is not empty:
 *    - Poll node → add to result order.
 *    - For each of its children: reduce their in-degree by 1.
 *    - If a child's in-degree becomes 0, add it to the queue.
 * 4. If result size != total nodes → there's a CYCLE (invalid ordering).
 *
 * NOTE: Only works on a DAG (Directed Acyclic Graph). Cycles = impossible ordering.
 *
 * TIME:  O(V + E)
 * SPACE: O(V)
 */
public class TopologicalSort {

    // ---------- Kahn's Algorithm (BFS) ----------
    public static List<Integer> topoSort(int V, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        // Step 1: Build adjacency list and in-degree map
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            adj.get(from).add(to);
            inDegree[to]++;
        }

        // Step 2: Add all nodes with in-degree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        // Step 3: Process the queue
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.add(neighbor);
            }
        }

        // Step 4: Check for cycle
        if (result.size() != V) {
            System.out.println("Cycle detected! Topological sort not possible.");
            return new ArrayList<>();
        }
        return result;
    }

    // ---------- DFS-based Topological Sort ----------
    public static List<Integer> topoSortDFS(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) adj.get(edge[0]).add(edge[1]);

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfsHelper(i, visited, stack, adj);
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    private static void dfsHelper(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) dfsHelper(neighbor, visited, stack, adj);
        }
        stack.push(node); // push AFTER all descendants are processed
    }

    // ---------- PRACTICE PROBLEM ----------
    // Course Schedule: Given N courses and prerequisites, can you finish all courses?
    // This is just cycle detection using Topological Sort!
    public static boolean canFinishCourses(int numCourses, int[][] prerequisites) {
        List<Integer> order = topoSort(numCourses, prerequisites);
        return order.size() == numCourses; // if all courses ordered → no cycle → can finish
    }

    public static void main(String[] args) {
        int V = 6;
        // Edges: 5→2, 5→0, 4→0, 4→1, 2→3, 3→1
        int[][] edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};

        System.out.println("Kahn's Topological Order: " + topoSort(V, edges));
        // Possible output: [4, 5, 0, 2, 3, 1]

        System.out.println("DFS Topological Order:    " + topoSortDFS(V, edges));

        // Course Schedule problem (4 courses, 0 must be before 1, 1 before 2, 2 before 3)
        int[][] prereqs = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println("Can finish all courses: " + canFinishCourses(4, prereqs));
        // Output: true

        // Circular dependency (impossible)
        int[][] cycle = {{1, 0}, {0, 1}};
        System.out.println("Can finish (cyclic): " + canFinishCourses(2, cycle));
        // Output: false
    }
}
