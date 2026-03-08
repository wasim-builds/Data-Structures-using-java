import java.util.*;

// Helper classes for Tree and LinkedList patterns
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class DSAPatterns {

    // ---------------------------------------------------------
    // 1. SLIDING WINDOW
    // Find the maximum sum of any contiguous subarray of size 'k'
    // ---------------------------------------------------------
    public static int maxSumSubarrayOfSizeK(int k, int[] arr) {
        int maxSum = 0, windowSum = 0;
        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            
            // slide the window if we've hit size k
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return maxSum;
    }

    // ---------------------------------------------------------
    // 2. TWO POINTERS
    // Find if there is a pair in a SORTED array that sums to target
    // ---------------------------------------------------------
    public static int[] twoSumSorted(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == target) return new int[] { left, right };
            if (currentSum < target) left++; // need larger sum
            else right--; // need smaller sum
        }
        return new int[] { -1, -1 };
    }

    // ---------------------------------------------------------
    // 3. FAST & SLOW POINTERS
    // Detect if a linked list has a cycle
    // ---------------------------------------------------------
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true; // found the cycle
        }
        return false;
    }

    // ---------------------------------------------------------
    // 4. PREFIX SUM
    // Answer range sum queries in O(1) time
    // ---------------------------------------------------------
    public static int queryRangeSum(int[] prefixSum, int left, int right) {
        if (left == 0) return prefixSum[right];
        return prefixSum[right] - prefixSum[left - 1];
    }
    public static int[] buildPrefixSum(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    // ---------------------------------------------------------
    // 5. BIT MANIPULATION
    // Find the single number in an array where every other number appears twice
    // ---------------------------------------------------------
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR: a ^ a = 0, a ^ 0 = a
        }
        return result;
    }

    // ---------------------------------------------------------
    // 6. MERGE INTERVALS
    // Merge all overlapping intervals
    // ---------------------------------------------------------
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            
            if (currentEnd >= nextBegin) { // overlapping
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // non-overlapping
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    // ---------------------------------------------------------
    // 7. TREE BFS (Breadth-First Search)
    // Level order traversal of a binary tree
    // ---------------------------------------------------------
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            result.add(currentLevel);
        }
        return result;
    }

    // ---------------------------------------------------------
    // 8. TREE DFS (Depth-First Search)
    // Find if the tree has a path from root-to-leaf such that sum == target
    // ---------------------------------------------------------
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true; // Reached leaf, sum matches
        }
        return hasPathSum(root.left, targetSum - root.val) || 
               hasPathSum(root.right, targetSum - root.val);
    }

    // ---------------------------------------------------------
    // 9. MODIFIED BINARY SEARCH
    // Binary search on a sorted array
    // ---------------------------------------------------------
    public static int binarySearch(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // prevents integer overflow
            if (key == arr[mid]) return mid;
            if (key < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    // ---------------------------------------------------------
    // 10. GRAPH DFS / BFS (Matrix/Adjacency List)
    // Find the number of islands (Connected Components) in a 2D matrix
    // ---------------------------------------------------------
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsGraph(grid, i, j); // Sink the island
                }
            }
        }
        return count;
    }
    private static void dfsGraph(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0'; // mark as visited
        dfsGraph(grid, i + 1, j); // down
        dfsGraph(grid, i - 1, j); // up
        dfsGraph(grid, i, j + 1); // right
        dfsGraph(grid, i, j - 1); // left
    }

    // ---------------------------------------------------------
    // 11. TOPOLOGICAL SORT (Graphs)
    // Find a valid ordering of tasks given their dependencies
    // ---------------------------------------------------------
    public static List<Integer> topologicalSort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0) return sortedOrder;

        // 1. Initialize the graph and in-degrees
        Map<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges
        Map<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list
        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // 2. Build the graph
        for (int[] edge : edges) {
            int parent = edge[0], child = edge[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // 3. Find all sources (vertices with 0 in-degree)
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) sources.add(entry.getKey());
        }

        // 4. For each source, add it to the sortedOrder and subtract one from all its children
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) sources.add(child); // new source found
            }
        }

        // topological sort is not possible if the graph has a cycle
        if (sortedOrder.size() != vertices) return new ArrayList<>();

        return sortedOrder;
    }
}
