package Tree;

public class ConstructBinaryTreeFromPreorderInorder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        java.util.HashMap<Integer, Integer> idx = new java.util.HashMap<>();
        for (int i = 0; i < inorder.length; i++) idx.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, idx);
    }

    private static TreeNode build(int[] pre, int ps, int pe, int[] in, int is, int ie,
                                  java.util.HashMap<Integer, Integer> idx) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(pre[ps]);
        int k = idx.get(root.value);
        int leftSize = k - is;
        root.left = build(pre, ps + 1, ps + leftSize, in, is, k - 1, idx);
        root.right = build(pre, ps + leftSize + 1, pe, in, k + 1, ie, idx);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(LevelOrderTraversal.levelOrder(root));
    }
}
