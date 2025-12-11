package Tree;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        return root == null || mirror(root.left, root.right);
    }

    private static boolean mirror(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        if (a.value != b.value) return false;
        return mirror(a.left, b.right) && mirror(a.right, b.left);
    }
}
