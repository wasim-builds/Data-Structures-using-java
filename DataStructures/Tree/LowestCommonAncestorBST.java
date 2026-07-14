package Tree;

public class LowestCommonAncestorBST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (cur != null) {
            if (p.value < cur.value && q.value < cur.value) cur = cur.left;
            else if (p.value > cur.value && q.value > cur.value) cur = cur.right;
            else return cur;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode lca = lowestCommonAncestor(root, root.left, root.right); // 6
        System.out.println(lca.value);
    }
}
