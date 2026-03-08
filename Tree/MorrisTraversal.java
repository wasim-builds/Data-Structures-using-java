package Tree;

public class MorrisTraversal {
    public static java.util.List<Integer> inorder(TreeNode root) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.value);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur; // create thread
                    cur = cur.left;
                } else {
                    pre.right = null; // remove thread
                    res.add(cur.value);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(inorder(root)); // [1,2,3]
    }
}
