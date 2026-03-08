package Tree;

public class RecoverBinarySearchTree {
    public static void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, prev = null;
        java.util.ArrayDeque<TreeNode> stack = new java.util.ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) { stack.push(cur); cur = cur.left; }
            cur = stack.pop();
            if (prev != null && prev.value > cur.value) {
                y = cur;
                if (x == null) x = prev;
            }
            prev = cur;
            cur = cur.right;
        }
        if (x != null && y != null) {
            int tmp = x.value; x.value = y.value; y.value = tmp;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2); // swapped 2 and 3
        recoverTree(root);
        System.out.println(ValidateBinarySearchTree.isValidBST(root)); // true
    }
}
