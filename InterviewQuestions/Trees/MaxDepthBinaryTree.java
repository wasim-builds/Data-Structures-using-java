/**
 * LeetCode #104 - Maximum Depth of Binary Tree
 * Difficulty: Easy
 * Time: O(n), Space: O(h) where h is height
 */
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MaxDepthBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Max Depth: " + maxDepth(root)); // 3
    }
}
