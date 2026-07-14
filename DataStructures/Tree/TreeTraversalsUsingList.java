/**
 * A complete, runnable example of binary tree traversals in Java.
 * This file includes the TreeNode definition and the traversal logic.
 */
package Tree;
public class TreeTraversalsUsingList {

    /**
     * Defines the structure of a single node in the binary tree.
     * This nested class is static so it can be accessed without creating an instance of TreeTraversal.
     */
    public static class TreeNode {
        int val;          // The value of the node
        TreeNode left;    // Pointer to the left child
        TreeNode right;   // Pointer to the right child

        // Constructor to create a new node
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // --- Traversal Methods ---

    /**
     * Performs Preorder Traversal (Root -> Left -> Right).
     * @param node The root node of the tree/subtree to traverse.
     */
    public void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " "); // Process the current node
        preorderTraversal(node.left);     // Recurse on the left subtree
        preorderTraversal(node.right);    // Recurse on the right subtree
    }

    /**
     * Performs Inorder Traversal (Left -> Root -> Right).
     * @param node The root node of the tree/subtree to traverse.
     */
    public void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);      // Recurse on the left subtree
        System.out.print(node.val + " "); // Process the current node
        inorderTraversal(node.right);     // Recurse on the right subtree
    }

    /**
     * Performs Postorder Traversal (Left -> Right -> Root).
     * @param node The root node of the tree/subtree to traverse.
     */
    public void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);    // Recurse on the left subtree
        postorderTraversal(node.right);   // Recurse on the right subtree
        System.out.print(node.val + " "); // Process the current node
    }


    /**
     * The main method to build a tree and test the traversals.
     */
    public static void main(String[] args) {
        // Create an instance of the main class to access its methods
        TreeTraversalsUsingList tree = new TreeTraversalsUsingList();

        // Manually build a sample binary tree:
        /*
              1
             / \
            2   3
           / \
          4   5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Building the sample tree...");
        System.out.println("Root is: " + root.val);
        System.out.println("------------------------------------");

        // --- Run and Print Traversals ---

        System.out.print("Preorder Traversal (Root -> Left -> Right):  ");
        tree.preorderTraversal(root);
        System.out.println(); // For a new line

        System.out.print("Inorder Traversal (Left -> Root -> Right):   ");
        tree.inorderTraversal(root);
        System.out.println(); // For a new line

        System.out.print("Postorder Traversal (Left -> Right -> Root): ");
        tree.postorderTraversal(root);
        System.out.println(); // For a new line
    }
}