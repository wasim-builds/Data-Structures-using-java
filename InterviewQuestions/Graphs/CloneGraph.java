package InterviewQuestions.Graphs;

import java.util.*;

/**
 * LeetCode 133: Clone Graph
 * 
 * Problem: Given a reference of a node in a connected undirected graph, return
 * a deep copy (clone) of the graph.
 * 
 * Approach: DFS with HashMap
 * - Use HashMap to track visited nodes and their clones
 * - Recursively clone neighbors
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V) for hashmap
 */
public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    private static Map<Node, Node> visited = new HashMap<>();

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If node already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create clone of current node
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        // Clone all neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }

    // Alternative: BFS approach
    public static Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Clone the starting node
        map.put(node, new Node(node.val));
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // Clone neighbor
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                // Add cloned neighbor to current node's clone
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    public static void main(String[] args) {
        // Test Case 1: Simple graph [[2,4],[1,3],[2,4],[1,3]]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        visited = new HashMap<>(); // Reset for new test
        Node cloned = cloneGraph(node1);
        System.out.println("Test 1 - Original node 1: " + node1.val);
        System.out.println("Test 1 - Cloned node 1: " + cloned.val);
        System.out.println("Test 1 - Different objects: " + (node1 != cloned));
        System.out.println("Test 1 - Same neighbors count: " + (node1.neighbors.size() == cloned.neighbors.size()));

        // Test Case 2: Single node
        Node single = new Node(1);
        Node clonedSingle = cloneGraphBFS(single);
        System.out.println("\nTest 2 - Single node cloned: " + (clonedSingle.val == 1));
        System.out.println("Test 2 - Different objects: " + (single != clonedSingle));
    }
}
