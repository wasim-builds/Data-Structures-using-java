package Tree;
class TreeNode {
    int value;
    TreeNode left, right;

    // Constructor to create a new node
    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}
class BinaryTree {
    TreeNode root;

    // Constructor to create an empty tree
    public BinaryTree() {
        root = null;
    }

    // Insert a node in the binary tree
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive function to insert a new value
    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Inorder traversal (Left, Root, Right)
    public void inorder() {
        inorderRec(root);
    }

    // Recursive function for inorder traversal
    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal (Root, Left, Right)
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal (Left, Right, Root)
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }
}

public class BinaryTrees {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Perform tree traversals
        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.print("\nPreorder traversal: ");
        tree.preorder();

        System.out.print("\nPostorder traversal: ");
        tree.postorder();
    }
}