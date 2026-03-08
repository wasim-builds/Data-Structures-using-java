package Tree;

public class ZigzagLevelOrder {
    public static java.util.List<java.util.List<Integer>> zigzag(TreeNode root) {
        java.util.List<java.util.List<Integer>> res = new java.util.ArrayList<>();
        if (root == null) return res;
        java.util.ArrayDeque<TreeNode> q = new java.util.ArrayDeque<>();
        q.add(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int sz = q.size();
            java.util.LinkedList<Integer> level = new java.util.LinkedList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                if (leftToRight) level.addLast(n.value); else level.addFirst(n.value);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            res.add(new java.util.ArrayList<>(level));
            leftToRight = !leftToRight;
        }
        return res;
    }
}
