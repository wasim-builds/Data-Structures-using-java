/**
 * Disjoint Set Union (Union-Find) Data Structure
 * Time Complexity:
 * - Find: O(α(n)) - nearly O(1) with path compression
 * - Union: O(α(n)) - nearly O(1) with union by rank
 * Space Complexity: O(n)
 * 
 * Where α(n) is the inverse Ackermann function (extremely slow growing)
 
 * Applications:
 * - Kruskal's MST algorithm
 * - Detecting cycles in undirected graphs
 * - Network connectivity
 * - Image processing (connected components)
 */
public class DisjointSetUnion {
    private int[] parent;
    private int[] rank;
    private int components;

    public DisjointSetUnion(int size) {
        parent = new int[size];
        rank = new int[size];
        components = size;

        // Initially, each element is its own parent
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // Union by rank
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false; // Already in same set
        }

        // Union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        components--;
        return true;
    }

    // Check if two elements are in the same set
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    // Get number of disjoint sets
    public int getComponentCount() {
        return components;
    }

    // Get size of the set containing x
    public int getSetSize(int x) {
        int root = find(x);
        int size = 0;

        for (int i = 0; i < parent.length; i++) {
            if (find(i) == root) {
                size++;
            }
        }

        return size;
    }

    // Print all sets
    public void printSets() {
        java.util.Map<Integer, java.util.List<Integer>> sets = new java.util.HashMap<>();

        for (int i = 0; i < parent.length; i++) {
            int root = find(i);
            sets.putIfAbsent(root, new java.util.ArrayList<>());
            sets.get(root).add(i);
        }

        System.out.println("Disjoint Sets:");
        for (java.util.List<Integer> set : sets.values()) {
            System.out.println(set);
        }
    }

    public static void main(String[] args) {
        DisjointSetUnion dsu = new DisjointSetUnion(10);

        System.out.println("Initial components: " + dsu.getComponentCount());

        // Perform unions
        System.out.println("\nPerforming unions:");
        dsu.union(0, 1);
        System.out.println("Union(0, 1)");
        dsu.union(1, 2);
        System.out.println("Union(1, 2)");
        dsu.union(3, 4);
        System.out.println("Union(3, 4)");
        dsu.union(5, 6);
        System.out.println("Union(5, 6)");
        dsu.union(6, 7);
        System.out.println("Union(6, 7)");

        System.out.println("\nComponents after unions: " + dsu.getComponentCount());

        // Check connectivity
        System.out.println("\nConnectivity checks:");
        System.out.println("Connected(0, 2): " + dsu.connected(0, 2));
        System.out.println("Connected(0, 3): " + dsu.connected(0, 3));
        System.out.println("Connected(5, 7): " + dsu.connected(5, 7));

        // Print all sets
        System.out.println();
        dsu.printSets();

        // Detect cycle example
        System.out.println("\n--- Cycle Detection Example ---");
        DisjointSetUnion cycleDSU = new DisjointSetUnion(4);

        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };

        for (int[] edge : edges) {
            if (!cycleDSU.union(edge[0], edge[1])) {
                System.out.println("Cycle detected at edge: " +
                        edge[0] + " - " + edge[1]);
                break;
            }
        }
    }
}
