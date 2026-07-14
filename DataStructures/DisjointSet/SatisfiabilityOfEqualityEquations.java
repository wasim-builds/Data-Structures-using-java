/**
 * Satisfiability of Equality Equations (LeetCode 990)
 * You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4.
 * Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.
 */
public class SatisfiabilityOfEqualityEquations {
    static class UnionFind {
        int[] parent;
        public UnionFind() {
            parent = new int[26];
            for (int i = 0; i < 26; i++) parent[i] = i;
        }
        public int find(int p) {
            if (p == parent[p]) return p;
            return parent[p] = find(parent[p]);
        }
        public void union(int p, int q) {
            parent[find(p)] = find(q);
        }
    }

    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind();
        
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                uf.union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }
        
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                if (uf.find(eq.charAt(0) - 'a') == uf.find(eq.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
