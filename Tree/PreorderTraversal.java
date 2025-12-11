package Tree;

public class PreorderTraversal {
    public static void preorder(TreeNode root, java.util.List<Integer> out) {
        if (root == null) return;
        out.add(root.value);
        preorder(root.left, out);
        preorder(root.right, out);
    }
}
