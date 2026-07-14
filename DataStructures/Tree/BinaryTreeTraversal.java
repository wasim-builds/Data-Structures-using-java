package Tree;

public class BinaryTreeTraversal {
    public static java.util.List<Integer> inorderIterative(TreeNode root) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        java.util.ArrayDeque<TreeNode> stack = new java.util.ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) { stack.push(cur); cur = cur.left; }
            cur = stack.pop();
            res.add(cur.value);
            cur = cur.right;
        }
        return res;
    }

    public static java.util.List<Integer> preorderIterative(TreeNode root) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        if (root == null) return res;
        java.util.ArrayDeque<TreeNode> stack = new java.util.ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            res.add(n.value);
            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);
        }
        return res;
    }

    public static java.util.List<Integer> postorderIterative(TreeNode root) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        java.util.ArrayDeque<TreeNode> stack = new java.util.ArrayDeque<>();
        TreeNode cur = root, last = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) { stack.push(cur); cur = cur.left; }
            else {
                TreeNode peek = stack.peek();
                if (peek.right != null && last != peek.right) {
                    cur = peek.right;
                } else {
                    res.add(peek.value);
                    last = stack.pop();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(inorderIterative(root));   // [4,2,5,1,3]
        System.out.println(preorderIterative(root));  // [1,2,4,5,3]
        System.out.println(postorderIterative(root)); // [4,5,2,3,1]
    }
}
