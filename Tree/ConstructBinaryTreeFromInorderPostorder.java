package Tree;

public class ConstructBinaryTreeFromInorderPostorder {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        java.util.HashMap<Integer, Integer> idx = new java.util.HashMap<>();
        for (int i = 0; i < inorder.length; i++) idx.put(inorder[i], i);
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, idx);
    }

    private static TreeNode build(int[] in, int is, int ie, int[] post, int ps, int pe,
                                  java.util.HashMap<Integer, Integer> idx) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(post[pe]);
        int k = idx.get(root.value);
        int leftSize = k - is;
        root.left = build(in, is, k - 1, post, ps, ps + leftSize - 1, idx);
        root.right = build(in, k + 1, ie, post, ps + leftSize, pe - 1, idx);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(LevelOrderTraversal.levelOrder(root));
    }
}
