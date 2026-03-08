package InterviewQuestions.Trees;

import java.util.*;

/**
 * LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Problem: Given two integer arrays preorder and inorder, construct and return
 * the binary tree.
 * 
 * Example:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 
 * Approach: Recursive construction
 * - First element of preorder is root
 * - Find root in inorder to split left/right subtrees
 * - Recursively build left and right subtrees
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) for hashmap + O(h) recursion
 */
public class ConstructTreeFromPreorderInorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int preorderIndex;
    private static Map<Integer, Integer> inorderMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();

        // Build hashmap for quick lookup of root index in inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int left, int right) {
        // Base case
        if (left > right) {
            return null;
        }

        // Get root value from preorder
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find root index in inorder to split left/right
        int inorderIndex = inorderMap.get(rootValue);

        // Build left and right subtrees
        root.left = buildTreeHelper(preorder, left, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorderIndex + 1, right);

        return root;
    }

    // Helper: Print tree (preorder)
    private static void printPreorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // Helper: Print tree (inorder)
    private static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // Test Case 1: Standard tree
        int[] preorder1 = { 3, 9, 20, 15, 7 };
        int[] inorder1 = { 9, 3, 15, 20, 7 };
        TreeNode root1 = buildTree(preorder1, inorder1);
        System.out.print("Test 1 - Preorder: ");
        printPreorder(root1);
        System.out.print("\nTest 1 - Inorder: ");
        printInorder(root1);
        System.out.println();

        // Test Case 2: Single node
        int[] preorder2 = { 1 };
        int[] inorder2 = { 1 };
        TreeNode root2 = buildTree(preorder2, inorder2);
        System.out.print("\nTest 2 - Preorder: ");
        printPreorder(root2);
        System.out.println();

        // Test Case 3: Left-skewed tree
        int[] preorder3 = { 1, 2, 3 };
        int[] inorder3 = { 3, 2, 1 };
        TreeNode root3 = buildTree(preorder3, inorder3);
        System.out.print("\nTest 3 - Preorder: ");
        printPreorder(root3);
        System.out.print("\nTest 3 - Inorder: ");
        printInorder(root3);
        System.out.println();
    }
}
