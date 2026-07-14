package Tree;

public class SumRootToLeafNumbers {
    // Returns the sum of all numbers formed by root-to-leaf paths.
    // Each path forms a number by concatenating node values (assuming digits 0-9).
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int curr) {
        if (node == null) return 0;
        int next = curr * 10 + node.value;
        if (node.left == null && node.right == null) return next;
        return dfs(node.left, next) + dfs(node.right, next);
    }
}
