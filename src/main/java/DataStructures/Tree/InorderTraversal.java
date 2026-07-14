package Tree;

public class InorderTraversal {
    public static void inorder(TreeNode root, java.util.List<Integer> out) {
        if (root == null) return;
        inorder(root.left, out);
        out.add(root.value);
        inorder(root.right, out);
    }
}
