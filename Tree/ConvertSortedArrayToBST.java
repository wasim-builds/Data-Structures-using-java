package Tree;

public class ConvertSortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] a, int l, int r) {
        if (l > r) return null;
        int m = l + (r - l) / 2;
        TreeNode node = new TreeNode(a[m]);
        node.left = build(a, l, m - 1);
        node.right = build(a, m + 1, r);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root.value); // 0
    }
}
