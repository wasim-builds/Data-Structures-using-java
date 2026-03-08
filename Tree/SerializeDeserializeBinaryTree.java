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
                if (n.left != null || n.right != null) {
                    q.add(n.left);
                    q.add(n.right);
                }
            }
        }
        return sb.toString();
    }

    // Deserialize BFS stream back to tree
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] parts = data.split(",");
        java.util.Queue<String> q = new java.util.LinkedList<>(java.util.Arrays.asList(parts));
        return buildDeserialize(q);
    }

    private static TreeNode buildDeserialize(java.util.Queue<String> q) {
        String val = q.poll();
        if (val == null || val.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        java.util.Queue<TreeNode> nodeQ = new java.util.LinkedList<>();
        nodeQ.add(root);
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            if (!q.isEmpty()) {
                String l = q.poll();
                if (l != null && !l.isEmpty() && !l.equals("#")) {
                    node.left = new TreeNode(Integer.parseInt(l));
                    nodeQ.add(node.left);
                }
            }
            if (!q.isEmpty()) {
                String r = q.poll();
                if (r != null && !r.isEmpty() && !r.equals("#")) {
                    node.right = new TreeNode(Integer.parseInt(r));
                    nodeQ.add(node.right);
                }
            }
        }
        return root;
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
