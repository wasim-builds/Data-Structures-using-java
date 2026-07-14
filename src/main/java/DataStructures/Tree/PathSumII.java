package Tree;

public class PathSumII {
    public static java.util.List<java.util.List<Integer>> pathSum(TreeNode root, int targetSum) {
        java.util.List<java.util.List<Integer>> res = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> path = new java.util.ArrayList<>();
        dfs(root, targetSum, path, res);
        return res;
    }

    private static void dfs(TreeNode node, int rem, java.util.ArrayList<Integer> path,
                             java.util.List<java.util.List<Integer>> res) {
        if (node == null) return;
        path.add(node.value);
        if (node.left == null && node.right == null && rem == node.value) {
            res.add(new java.util.ArrayList<>(path));
        } else {
            dfs(node.left, rem - node.value, path, res);
            dfs(node.right, rem - node.value, path, res);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 22));
    }
}
