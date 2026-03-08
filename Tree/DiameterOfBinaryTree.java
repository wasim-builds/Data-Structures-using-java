package Tree;

public class DiameterOfBinaryTree {
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        height(root, ans);
        return ans[0];
    }

    private static int height(TreeNode node, int[] ans) {
        if (node == null) return 0;
        int lh = height(node.left, ans);
        int rh = height(node.right, ans);
        int through = lh + rh; // number of edges on longest path through node
        if (through > ans[0]) ans[0] = through;
        return 1 + (lh > rh ? lh : rh);
    }
}
