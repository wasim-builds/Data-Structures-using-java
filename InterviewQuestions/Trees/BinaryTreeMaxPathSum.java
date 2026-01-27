package InterviewQuestions.Trees;

/**
 * LeetCode 124: Binary Tree Maximum Path Sum
 * 
 * Problem: A path in a binary tree is a sequence of nodes where each pair of
 * adjacent nodes
 * has an edge. A path does not need to go through the root. Find the maximum
 * path sum.
 * 
 * Example:
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: Path is 15 -> 20 -> 7
 * 
 * Approach: Post-order DFS
 * - For each node, calculate max path sum through it
 * - Track global maximum
 * - Return max single path to parent
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h) for recursion
 */
public class BinaryTreeMaxPathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSum;
    }

    private static int maxPathSumHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Get max sum from left and right subtrees (ignore negative paths)
        int leftMax = Math.max(0, maxPathSumHelper(node.left));
        int rightMax = Math.max(0, maxPathSumHelper(node.right));

        // Update global max with path through current node
        int pathThroughNode = node.val + leftMax + rightMax;
        maxSum = Math.max(maxSum, pathThroughNode);

        // Return max single path to parent (can only use one side)
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        // Test Case 1: Path doesn't go through root
        TreeNode root1 = new TreeNode(-10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Test 1: " + maxPathSum(root1)); // Expected: 42 (15->20->7)

        // Test Case 2: Single node
        TreeNode root2 = new TreeNode(-3);
        System.out.println("Test 2: " + maxPathSum(root2)); // Expected: -3

        // Test Case 3: All positive
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        System.out.println("Test 3: " + maxPathSum(root3)); // Expected: 6 (2->1->3)

        // Test Case 4: Mix of positive and negative
        TreeNode root4 = new TreeNode(2);
        root4.left = new TreeNode(-1);
        System.out.println("Test 4: " + maxPathSum(root4)); // Expected: 2
    }
}
