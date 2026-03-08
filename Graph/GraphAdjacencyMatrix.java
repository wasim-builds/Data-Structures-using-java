/**
 * Graph implementation using Adjacency Matrix representation
 * Time Complexity:
 * - Add Edge: O(1)
 * - Remove Edge: O(1)
 * - Has Edge: O(1)
 * Space Complexity: O(V^2) where V is number of vertices
 * 
 * Best for dense graphs where number of edges is close to V^2
 */
public class GraphAdjacencyMatrix {
    private int[][] adjMatrix;
    private int numVertices;
    private boolean isDirected;

    public GraphAdjacencyMatrix(int numVertices, boolean isDirected) {
        this.numVertices = numVertices;
        this.isDirected = isDirected;
        this.adjMatrix = new int[numVertices][numVertices];
    }

    // Add edge between two vertices
    public void addEdge(int source, int destination) {
        if (source >= 0 && source < numVertices &&
                destination >= 0 && destination < numVertices) {
            adjMatrix[source][destination] = 1;

            // If undirected, add edge in both directions
            if (!isDirected) {
                adjMatrix[destination][source] = 1;
            }
        }
    }

    // Add weighted edge
    public void addWeightedEdge(int source, int destination, int weight) {
        if (source >= 0 && source < numVertices &&
                destination >= 0 && destination < numVertices) {
            adjMatrix[source][destination] = weight;

            if (!isDirected) {
                adjMatrix[destination][source] = weight;
            }
        }
    }

    // Remove edge between two vertices
    public void removeEdge(int source, int destination) {
        if (source >= 0 && source < numVertices &&
                destination >= 0 && destination < numVertices) {
            adjMatrix[source][destination] = 0;

            if (!isDirected) {
                adjMatrix[destination][source] = 0;
            }
        }
    }

    // Check if edge exists
    public boolean hasEdge(int source, int destination) {
        if (source >= 0 && source < numVertices &&
                destination >= 0 && destination < numVertices) {
            return adjMatrix[source][destination] != 0;
        }
        return false;
    }

    // Get edge weight
    public int getEdgeWeight(int source, int destination) {
        if (source >= 0 && source < numVertices &&
                destination >= 0 && destination < numVertices) {
            return adjMatrix[source][destination];
        }
        return 0;
    }

    // Print the adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example: Undirected Graph
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(5, false);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Undirected Graph:");
        graph.printGraph();

        System.out.println("\nHas edge 0->2: " + graph.hasEdge(0, 2));
        System.out.println("Has edge 1->3: " + graph.hasEdge(1, 3));

        // Example: Weighted Directed Graph
        GraphAdjacencyMatrix weightedGraph = new GraphAdjacencyMatrix(4, true);

        weightedGraph.addWeightedEdge(0, 1, 5);
        weightedGraph.addWeightedEdge(0, 2, 3);
        weightedGraph.addWeightedEdge(1, 2, 2);
        weightedGraph.addWeightedEdge(2, 3, 7);

        System.out.println("\nWeighted Directed Graph:");
        weightedGraph.printGraph();
    }
}
