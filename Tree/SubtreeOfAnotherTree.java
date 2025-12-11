package Tree;

public class SubtreeOfAnotherTree {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (same(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean same(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        if (a.value != b.value) return false;
        return same(a.left, b.left) && same(a.right, b.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        TreeNode sub = new TreeNode(4);
        sub.left = new TreeNode(1);
        sub.right = new TreeNode(2);
        System.out.println(isSubtree(root, sub)); // true
    }
}
