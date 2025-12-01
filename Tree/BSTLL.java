package Tree;


import java.util.ArrayList;
import java.util.List;

/**
 * A class to demonstrate the three main recursive DFS traversals on a binary tree.
 */
public class BSTLL {

    /**
     * Definition for a binary tree node.
     * This is a static nested class so it can be accessed from main.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // ==========================================================
    // 1. Pre-order Traversal (Root -> Left -> Right)
    // ==========================================================
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);             // Visit Root
        preorderHelper(node.left, result);  // Traverse Left
        preorderHelper(node.right, result); // Traverse Right
    }

    // ==========================================================
    // 2. In-order Traversal (Left -> Root -> Right)
    // ==========================================================
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);  // Traverse Left
        result.add(node.val);             // Visit Root
        inorderHelper(node.right, result); // Traverse Right
    }

    // ==========================================================
    // 3. Post-order Traversal (Left -> Right -> Root)
    // ==========================================================
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorderHelper(node.left, result);  // Traverse Left
        postorderHelper(node.right, result); // Traverse Right
        result.add(node.val);             // Visit Root
    }

    // ==========================================================
    // Main method to create a tree and test the traversals
    // ==========================================================
    public static void main(String[] args) {
        // Create a sample tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BSTLL traverser = new BSTLL();

        // Perform and print each traversal
        List<Integer> preorderResult = traverser.preorderTraversal(root);
        System.out.println("Pre-order (Root -> Left -> Right): " + preorderResult);

        List<Integer> inorderResult = traverser.inorderTraversal(root);
        System.out.println("In-order  (Left -> Root -> Right): " + inorderResult);

        List<Integer> postorderResult = traverser.postorderTraversal(root);
        System.out.println("Post-order(Left -> Right -> Root): " + postorderResult);
    }
}