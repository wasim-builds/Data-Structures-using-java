package Tree;

// Node class
class TreeNode {
    int value;
    TreeNode left, right;

    // Constructor
    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

// Binary Search Tree class
class BinaryTree {
    TreeNode root;

    // Constructor
    public BinaryTree() {
        root = null;
    }
    

    // Insert a node
    public void insert(int value) {
        root = insertRec(root, value);
    }
    /**
     * public void insert(int value){
     *      root=insert(root,value)
     * }
     * 
     * private TreeNode insertRec(TreeNode root, int value){
     *      if(root==null){
     *          root=new TreeNode(value);
     * return root;
     *      }
     * }
     * @param root
     * @param value
     * @return
     */

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

    // Search for a value
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode root, int value) {
        if (root == null) return false;              // not found
        if (root.value == value) return true;        // found
        return value < root.value 
                ? searchRec(root.left, value) 
                : searchRec(root.right, value);
    }

    // Inorder traversal (Left → Root → Right)
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal (Root → Left → Right)
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal (Left → Right → Root)
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }
}

// Main class
public class BinaryTrees {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Traversals
        System.out.print("Inorder: ");
        tree.inorder(); // 20 30 40 50 60 70 80

        System.out.print("Preorder: ");
        tree.preorder(); // 50 30 20 40 70 60 80

        System.out.print("Postorder: ");
        tree.postorder(); // 20 40 30 60 80 70 50

        // Search examples
        System.out.println("Search 60: " + tree.search(60)); // true
        System.out.println("Search 25: " + tree.search(25)); // false
    }
}
