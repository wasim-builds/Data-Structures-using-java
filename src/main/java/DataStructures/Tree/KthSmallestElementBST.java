package Tree;

public class KthSmallestElementBST {
    public static int kthSmallest(TreeNode root, int k) {
        java.util.ArrayDeque<TreeNode> stack = new java.util.ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) { stack.push(cur); cur = cur.left; }
            cur = stack.pop();
            if (--k == 0) return cur.value;
            cur = cur.right;
        }
        throw new IllegalArgumentException("k out of range");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(kthSmallest(root, 3)); // 3
    }
}
