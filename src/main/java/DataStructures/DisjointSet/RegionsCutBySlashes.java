package DataStructures.DisjointSet;

/**
 * Regions Cut By Slashes (LeetCode 959)
 * An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '.
 * Return the number of regions.
 */
public class RegionsCutBySlashes {
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

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(4 * n * n);
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int root = 4 * (r * n + c);
                char val = grid[r].charAt(c);
                
                if (val != '\\') {
                    uf.union(root + 0, root + 3);
                    uf.union(root + 1, root + 2);
                }
                if (val != '/') {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 2, root + 3);
                }
                
                if (r + 1 < n) {
                    uf.union(root + 2, root + 4 * n + 0);
                }
                if (c + 1 < n) {
                    uf.union(root + 1, root + 4 + 3);
                }
            }
        }
        
        return uf.count;
    }
}
