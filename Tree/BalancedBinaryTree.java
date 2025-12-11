package Tree;

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    private static int check(TreeNode node) {
        if (node == null) return 0;
        int lh = check(node.left);
        if (lh == -1) return -1;
        int rh = check(node.right);
        if (rh == -1) return -1;
        if (lh - rh > 1 || rh - lh > 1) return -1;
        return 1 + (lh > rh ? lh : rh);
    }
}
