/**
 * Fenwick Tree (Binary Indexed Tree)
 * Time Complexity:
 * - Build: O(n log n)
 * - Query: O(log n)
 * - Update: O(log n)
 * Space Complexity: O(n)
 * 
 * More space-efficient than Segment Tree
 */
public class FenwickTree {
    private int[] tree;
    private int n;

    public FenwickTree(int size) {
        n = size;
        tree = new int[n + 1];
    }

    public FenwickTree(int[] arr) {
        n = arr.length;
        tree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            update(i, arr[i]);
        }
    }

    // Update value at index
    public void update(int index, int delta) {
        index++; // 1-indexed

        while (index <= n) {
            tree[index] += delta;
            index += index & (-index); // Add last set bit
        }
    }

    // Get prefix sum from 0 to index
    public int query(int index) {
        index++; // 1-indexed
        int sum = 0;

        while (index > 0) {
            sum += tree[index];
            index -= index & (-index); // Remove last set bit
        }

        return sum;
    }

    // Get range sum from left to right
    public int rangeQuery(int left, int right) {
        if (left == 0)
            return query(right);
        return query(right) - query(left - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11 };
        FenwickTree ft = new FenwickTree(arr);

        System.out.println("Sum [0, 2]: " + ft.rangeQuery(0, 2)); // 9
        System.out.println("Sum [1, 4]: " + ft.rangeQuery(1, 4)); // 24

        ft.update(2, 5); // Add 5 to index 2
        System.out.println("After update, sum [1, 4]: " + ft.rangeQuery(1, 4)); // 29
    }
}
