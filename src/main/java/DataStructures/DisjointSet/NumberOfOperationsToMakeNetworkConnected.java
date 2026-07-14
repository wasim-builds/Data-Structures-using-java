package DataStructures.DisjointSet;

/**
 * Number of Operations to Make Network Connected (LeetCode 1319)
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network.
 * Return the minimum number of times you need to extract a cable and attach it to another computer to make all computers connected. If it's not possible, return -1.
 */
public class NumberOfOperationsToMakeNetworkConnected {
    static class UnionFind {
        int[] parent;
        int count;
        
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            count = n;
        }
        
        public int find(int p) {
            if (p == parent[p]) return p;
            return parent[p] = find(parent[p]);
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                count--;
            }
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        
        UnionFind uf = new UnionFind(n);
        for (int[] conn : connections) {
            uf.union(conn[0], conn[1]);
        }
        
        return uf.count - 1;
    }
}
