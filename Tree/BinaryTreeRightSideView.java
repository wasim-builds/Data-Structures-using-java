package Tree;

public class BinaryTreeRightSideView {
    public static java.util.List<Integer> rightSideView(TreeNode root) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        if (root == null) return res;
        java.util.ArrayDeque<TreeNode> q = new java.util.ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            TreeNode last = null;
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                last = n;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            res.add(last.value);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(rightSideView(root)); // [1,3,4]
    }
}
