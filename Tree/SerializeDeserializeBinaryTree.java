package Tree;

public class SerializeDeserializeBinaryTree {
    // Serialize using BFS with null markers (#)
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        java.util.ArrayDeque<TreeNode> q = new java.util.ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n == null) {
                sb.append("#,");
            } else {
                sb.append(n.value).append(',');
                q.add(n.left);
                q.add(n.right);
            }
        }
        return sb.toString();
    }

    // Deserialize BFS stream back to tree
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] parts = data.split(",");
        int idx = 0;
        TreeNode root = parse(parts[idx++]);
        java.util.ArrayDeque<TreeNode> q = new java.util.ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n == null) continue;
            n.left = parse(parts[idx++]);
            n.right = parse(parts[idx++]);
            q.add(n.left);
            q.add(n.right);
        }
        return root;
    }

    private static TreeNode parse(String s) {
        if (s.equals("#") || s.isEmpty()) return null;
        return new TreeNode(Integer.parseInt(s));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String ser = serialize(root);
        TreeNode back = deserialize(ser);
        System.out.println(LevelOrderTraversal.levelOrder(back));
    }
}
