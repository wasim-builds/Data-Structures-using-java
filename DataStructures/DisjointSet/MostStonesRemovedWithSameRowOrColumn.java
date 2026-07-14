import java.util.HashMap;
import java.util.Map;

/**
 * Most Stones Removed with Same Row or Column (LeetCode 947)
 * On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
 * A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
 * Return the largest possible number of stones that can be removed.
 */
public class MostStonesRemovedWithSameRowOrColumn {
    static class UnionFind {
        Map<Integer, Integer> parent = new HashMap<>();
        int count = 0;
        
        public int find(int p) {
            if (!parent.containsKey(p)) {
                parent.put(p, p);
                count++;
            }
            if (p != parent.get(p)) {
                parent.put(p, find(parent.get(p)));
            }
            return parent.get(p);
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent.put(rootP, rootQ);
                count--;
            }
        }
    }

    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        for (int[] stone : stones) {
            uf.union(stone[0], ~stone[1]);
        }
        return stones.length - uf.count;
    }
}
