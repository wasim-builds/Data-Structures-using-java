package Tree;
import java.util.Stack;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BSTStackTraversal {
    Node root;

    // 🔄 Insert node into BST (Iterative)
    void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root, parent = null;
        while (current != null) {
            parent = current;
            if (value < current.value)
                current = current.left;
            else
                current = current.right;
        }
        if (value < parent.value)
            parent.left = newNode;
        else
            parent.right = newNode;
    }

    // ✅ In-order Traversal (Left, Root, Right)
    void inorderTraversal() {
        System.out.print("In-order Traversal: ");
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.right;
        }
        System.out.println();
    }

    // 🌟 Pre-order Traversal (Root, Left, Right)
    void preorderTraversal() {
        System.out.print("Pre-order Traversal: ");
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.value + " ");
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        System.out.println();
    }

    // 🍂 Post-order Traversal (Left, Right, Root) using two stacks
    void postorderTraversal() {
        System.out.print("Post-order Traversal: ");
        if (root == null) return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);
            if (current.left != null) stack1.push(current.left);
            if (current.right != null) stack1.push(current.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BSTStackTraversal bst = new BSTStackTraversal();
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        // 🌿 Insert nodes
        for (int val : values) bst.insert(val);

        // 🔄 Perform all traversals using stack
        bst.inorderTraversal();    // Output: 20 30 40 50 60 70 80
        bst.preorderTraversal();   // Output: 50 30 20 40 70 60 80
        bst.postorderTraversal();  // Output: 20 40 30 60 80 70 50
    }
}