import java.util.*;

/**
 * Graph implementation using Adjacency List representation
 * Time Complexity: 
 *   - Add Edge: O(1)
 *   - Remove Edge: O(V) where V is number of vertices
 *   - Has Edge: O(V)
 * Space Complexity: O(V + E) where E is number of edges
 */
public class GraphAdjacencyList {
    private Map<Integer, List<Integer>> adjList;
    private boolean isDirected;
    
    public GraphAdjacencyList(boolean isDirected) {
        this.adjList = new HashMap<>();
        this.isDirected = isDirected;
    }
    
    // Add vertex to the graph
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }
    
    // Add edge between two vertices
    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        
        adjList.get(source).add(destination);
        
        // If undirected, add edge in both directions
        if (!isDirected) {
            adjList.get(destination).add(source);
        }
    }
    
    // Remove edge between two vertices
    public void removeEdge(int source, int destination) {
        List<Integer> sourceNeighbors = adjList.get(source);
        List<Integer> destNeighbors = adjList.get(destination);
        
        if (sourceNeighbors != null) {
            sourceNeighbors.remove(Integer.valueOf(destination));
        }
        
        if (!isDirected && destNeighbors != null) {
            destNeighbors.remove(Integer.valueOf(source));
        }
    }
    
    // Check if edge exists
    public boolean hasEdge(int source, int destination) {
        List<Integer> neighbors = adjList.get(source);
        return neighbors != null && neighbors.contains(destination);
    }
    
    // Get all neighbors of a vertex
    public List<Integer> getNeighbors(int vertex) {
        return adjList.getOrDefault(vertex, new ArrayList<>());
    }
    
    // Get all vertices
    public Set<Integer> getVertices() {
        return adjList.keySet();
    }
    
    // Print the graph
    public void printGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            System.out.println(adjList.get(vertex));
        }
    }
    
    public static void main(String[] args) {
        // Example: Undirected Graph
        GraphAdjacencyList graph = new GraphAdjacencyList(false);
        
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        System.out.println("Undirected Graph:");
        graph.printGraph();
        
        System.out.println("\nNeighbors of vertex 2: " + graph.getNeighbors(2));
        System.out.println("Has edge 0->2: " + graph.hasEdge(0, 2));
        
        // Example: Directed Graph
        GraphAdjacencyList directedGraph = new GraphAdjacencyList(true);
        
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(0, 2);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 0);
        directedGraph.addEdge(2, 3);
        
        System.out.println("\nDirected Graph:");
        directedGraph.printGraph();
    }
}
