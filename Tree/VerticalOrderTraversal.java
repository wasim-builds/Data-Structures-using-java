package Tree;

public class VerticalOrderTraversal {
    public static java.util.List<java.util.List<Integer>> verticalOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> res = new java.util.ArrayList<>();
        if (root == null) return res;
        java.util.Map<Integer, java.util.List<Integer>> map = new java.util.TreeMap<>();
        java.util.ArrayDeque<java.util.AbstractMap.SimpleEntry<TreeNode, Integer>> q = new java.util.ArrayDeque<>();
        q.add(new java.util.AbstractMap.SimpleEntry<>(root, 0));
        while (!q.isEmpty()) {
            var e = q.poll();
            TreeNode n = e.getKey();
            int col = e.getValue();
            map.computeIfAbsent(col, k -> new java.util.ArrayList<>()).add(n.value);
            if (n.left != null) q.add(new java.util.AbstractMap.SimpleEntry<>(n.left, col - 1));
            if (n.right != null) q.add(new java.util.AbstractMap.SimpleEntry<>(n.right, col + 1));
        }
        for (var entry : map.entrySet()) res.add(entry.getValue());
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        System.out.println(verticalOrder(root));
    }
}
