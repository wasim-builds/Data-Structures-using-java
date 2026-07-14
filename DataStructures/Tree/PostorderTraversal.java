package Tree;

public class PostorderTraversal {
    public static void postorder(TreeNode root, java.util.List<Integer> out) {
        if (root == null) return;
        postorder(root.left, out);
        postorder(root.right, out);
        out.add(root.value);
    }
}
