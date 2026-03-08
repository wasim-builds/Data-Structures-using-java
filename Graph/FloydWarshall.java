/**
 * Floyd-Warshall Algorithm - All Pairs Shortest Path
 * Time Complexity: O(V^3)
 * Space Complexity: O(V^2)
 * 
 * Finds shortest paths between all pairs of vertices
 * Can detect negative cycles
 */
public class FloydWarshall {

    private static final int INF = 99999;

    public static int[][] floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize distance matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Check for negative cycles
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Graph contains negative weight cycle");
                return null;
            }
        }

        return dist;
    }

    public static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.printf("%3d ", dist[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 }
        };

        int[][] result = floydWarshall(graph);
        if (result != null) {
            printSolution(result);
        }
    }
}
