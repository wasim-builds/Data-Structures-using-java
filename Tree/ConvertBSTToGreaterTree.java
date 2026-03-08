package Tree;

public class ConvertBSTToGreaterTree {
    public static TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        reverseInorder(root, sum);
        return root;
    }

    private static void reverseInorder(TreeNode node, int[] sum) {
        if (node == null) return;
        reverseInorder(node.right, sum);
        sum[0] += node.value;
        node.value = sum[0];
        reverseInorder(node.left, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        convertBST(root);
        System.out.println(root.value); // 6
    }
}
