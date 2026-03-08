
/**
 * Kruskal's Minimum Spanning Tree Algorithm
 * Time Complexity: O(E log E) for sorting
 * Space Complexity: O(V)
 * 
 * Uses Disjoint Set Union (Union-Find)
 */
import java.util.*;

public class KruskalMST {

    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class DisjointSet {
        int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return false;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public static List<Edge> kruskalMST(List<Edge> edges, int vertices) {
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(vertices);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            if (ds.union(edge.source, edge.destination)) {
                mst.add(edge);
                if (mst.size() == vertices - 1)
                    break;
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        List<Edge> mst = kruskalMST(edges, 4);

        System.out.println("Minimum Spanning Tree:");
        int totalWeight = 0;
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination +
                    " : " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight: " + totalWeight);
    }
}
