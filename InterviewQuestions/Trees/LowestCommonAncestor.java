package InterviewQuestions.Trees;

/**
 * LeetCode 236: Lowest Common Ancestor of a Binary Tree
 * 
 * Problem: Given a binary tree, find the lowest common ancestor (LCA) of two
 * given nodes.
 * The LCA is the lowest node that has both nodes as descendants.
 * 
 * Example:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * 
 * Approach: Recursive DFS
 * - If current node is p or q, return it
 * - Recursively search left and right subtrees
 * - If both return non-null, current node is LCA
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h) for recursion stack
 */
public class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null one
        return left != null ? left : right;
    }

    // Alternative: Iterative approach with parent pointers
    public static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        java.util.Map<TreeNode, TreeNode> parent = new java.util.HashMap<>();
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();

        parent.put(root, null);
        stack.push(root);

        // Build parent map until both p and q are found
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Get all ancestors of p
        java.util.Set<TreeNode> ancestors = new java.util.HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // Find first ancestor of q that's also ancestor of p
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }

    public static void main(String[] args) {
        // Test Case 1: LCA in middle of tree
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        root.left = node5;
        root.right = node1;
        node5.left = new TreeNode(6);
        node5.right = new TreeNode(2);
        node1.left = new TreeNode(0);
        node1.right = new TreeNode(8);

        TreeNode lca1 = lowestCommonAncestor(root, node5, node1);
        System.out.println("Test 1 - LCA of 5 and 1: " + lca1.val); // Expected: 3

        // Test Case 2: One node is ancestor of other
        TreeNode lca2 = lowestCommonAncestor(root, node5, node5.left);
        System.out.println("Test 2 - LCA of 5 and 6: " + lca2.val); // Expected: 5

        // Test Case 3: Iterative approach
        TreeNode lca3 = lowestCommonAncestorIterative(root, node5, node1);
        System.out.println("Test 3 - LCA (iterative) of 5 and 1: " + lca3.val); // Expected: 3
    }
}
