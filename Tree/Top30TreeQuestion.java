package Tree;


public class Top30TreeQuestion {

    // ---------- Common TreeNode definition ----------
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // ---------- Question 1: Height of Binary Tree ----------
    static int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    // ---------- Question 2: Size (Number of Nodes) ----------
    static int size(TreeNode root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    // ---------- Question 3: Inorder Traversal (Print) ----------
    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // ---------- Question 4: Preorder Traversal (Print) ----------
    static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // ---------- Question 5: Postorder Traversal (Print) ----------
    static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // ---------- Question 6: Max Value in Tree ----------
    static int maxValue(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(maxValue(root.left), maxValue(root.right)));
    }

    // ---------- Question 7: Min Value in Tree ----------
    static int minValue(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(minValue(root.left), minValue(root.right)));
    }

    // ---------- Question 8: Check if Identical Trees ----------
    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // ---------- Question 9: Check Balanced Binary Tree ----------
    static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode root) {
        if (root == null) return 0;
        int lh = checkHeight(root.left);
        if (lh == -1) return -1;
        int rh = checkHeight(root.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    // ---------- Question 10: Diameter of Binary Tree ----------
    static int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        diameterHeight(root, max);
        return max[0];
    }

    private static int diameterHeight(TreeNode root, int[] max) {
        if (root == null) return 0;
        int lh = diameterHeight(root.left, max);
        int rh = diameterHeight(root.right, max);
        max[0] = Math.max(max[0], lh + rh);
        return Math.max(lh, rh) + 1;
    }


        // ---------- Question 11: Invert / Mirror Binary Tree ----------
    static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // ---------- Question 12: Level Order Traversal (BFS) ----------
    static java.util.List<java.util.List<Integer>> levelOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) return result;

        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            java.util.List<Integer> level = new java.util.ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    // ---------- Question 13: Zigzag Level Order Traversal ----------
    static java.util.List<java.util.List<Integer>> zigzagLevelOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) return result;

        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            java.util.List<Integer> level = new java.util.ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (leftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }

    // ---------- Question 14: Symmetric (Mirror) Tree ----------
    static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    // ---------- Question 15: Validate BST ----------
    static boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validateBST(TreeNode node, long low, long high) {
        if (node == null) return true;
        if (node.val <= low || node.val >= high) return false;
        return validateBST(node.left, low, node.val) &&
               validateBST(node.right, node.val, high);
    }

    // ---------- Question 16: Lowest Common Ancestor (Binary Tree) ----------
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    // ---------- Question 17: Kth Smallest Element in BST ----------
    static int kthSmallest(TreeNode root, int k) {
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (--k == 0) return curr.val;
            curr = curr.right;
        }
        throw new IllegalArgumentException("k is larger than number of nodes");
    }

    // ---------- Question 18: Path Sum (root-to-leaf, exists?) ----------
    static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }

    // ---------- Question 19: All Root-to-Leaf Paths With Given Sum ----------
    static java.util.List<java.util.List<Integer>> pathSum(TreeNode root, int targetSum) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        java.util.List<Integer> path = new java.util.ArrayList<>();
        dfsPathSum(root, targetSum, path, result);
        return result;
    }

    private static void dfsPathSum(TreeNode node, int sum,
                                   java.util.List<Integer> path,
                                   java.util.List<java.util.List<Integer>> result) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            result.add(new java.util.ArrayList<>(path));
        } else {
            dfsPathSum(node.left, sum - node.val, path, result);
            dfsPathSum(node.right, sum - node.val, path, result);
        }
        path.remove(path.size() - 1);
    }

    // ---------- Question 20: Maximum Path Sum (any nodes) ----------
    static int maxPathSum(TreeNode root) {
        int[] max = new int[] { Integer.MIN_VALUE };
        maxGain(root, max);
        return max[0];
    }

    private static int maxGain(TreeNode node, int[] max) {
        if (node == null) return 0;
        int leftGain = Math.max(0, maxGain(node.left, max));
        int rightGain = Math.max(0, maxGain(node.right, max));
        int priceNewPath = node.val + leftGain + rightGain;
        max[0] = Math.max(max[0], priceNewPath);
        return node.val + Math.max(leftGain, rightGain);
    }

        // ---------- Question 21: Count Nodes in Complete Binary Tree ----------
    static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = leftDepth(root);
        int rightHeight = rightDepth(root);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1; // perfect tree
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int leftDepth(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        return h;
    }

    private static int rightDepth(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.right;
        }
        return h;
    }

    // ---------- Question 22: Check if Subtree ----------
    static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // uses isSameTree from earlier (Question 8)

    // ---------- Question 23: Serialize Binary Tree ----------
    static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePreorder(root, sb);
        return sb.toString();
    }

    private static void serializePreorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        serializePreorder(node.left, sb);
        serializePreorder(node.right, sb);
    }

    // ---------- Question 24: Deserialize Binary Tree ----------
    static TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        java.util.Queue<String> q = new java.util.LinkedList<>();
        for (String s : arr) {
            if (!s.isEmpty()) q.offer(s);
        }
        return buildTree(q);
    }

    private static TreeNode buildTree(java.util.Queue<String> q) {
        if (q.isEmpty()) return null;
        String val = q.poll();
        if (val.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(q);
        node.right = buildTree(q);
        return node;
    }

    // ---------- Question 25: Boundary Traversal of Binary Tree ----------
    static java.util.List<Integer> boundaryOfBinaryTree(TreeNode root) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        if (root == null) return res;
        if (!isLeaf(root)) res.add(root.val);
        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);
        return res;
    }

    private static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private static void addLeftBoundary(TreeNode node, java.util.List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private static void addRightBoundary(TreeNode node, java.util.List<Integer> res) {
        java.util.List<Integer> tmp = new java.util.ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) tmp.add(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
        for (int i = tmp.size() - 1; i >= 0; i--) {
            res.add(tmp.get(i));
        }
    }

    private static void addLeaves(TreeNode node, java.util.List<Integer> res) {
        if (node == null) return;
        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    // ---------- Question 26: Right Side View ----------
    static java.util.List<Integer> rightSideView(TreeNode root) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        if (root == null) return res;
        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode node = null;
            for (int i = 0; i < size; i++) {
                node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(node.val);
        }
        return res;
    }

    // ---------- Question 27: Left View ----------
    static java.util.List<Integer> leftSideView(TreeNode root) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        if (root == null) return res;
        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) res.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }

    // ---------- Question 28: Nodes at Distance K from Target ----------
    static java.util.List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        java.util.Map<TreeNode, TreeNode> parent = new java.util.HashMap<>();
        buildParent(root, null, parent);
        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        java.util.Set<TreeNode> visited = new java.util.HashSet<>();
        q.offer(target);
        visited.add(target);
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (dist == k) {
                java.util.List<Integer> res = new java.util.ArrayList<>();
                for (TreeNode node : q) res.add(node.val);
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && visited.add(node.left)) q.offer(node.left);
                if (node.right != null && visited.add(node.right)) q.offer(node.right);
                TreeNode par = parent.get(node);
                if (par != null && visited.add(par)) q.offer(par);
            }
            dist++;
        }
        return java.util.Collections.emptyList();
    }

    private static void buildParent(TreeNode node, TreeNode par,
                                    java.util.Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        parent.put(node, par);
        buildParent(node.left, node, parent);
        buildParent(node.right, node, parent);
    }

    // ---------- Question 29: Flatten Binary Tree to Linked List ----------
    static void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode rightMost = curr.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    // ---------- Question 30: Minimum Depth of Binary Tree ----------
    static int minDepth(TreeNode root) {
        if (root == null) return 0;
        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    
    // ---------- Helper: Build Sample Tree ----------
    private static TreeNode sampleTree() {
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }

    // ---------- main: choose which question to run ----------
    public static void main(String[] args) {
        TreeNode root = sampleTree();

        
        System.out.println("Height: " + height(root));
        System.out.println("Size: " + size(root));
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
        System.out.println("Max value: " + maxValue(root));
        System.out.println("Min value: " + minValue(root));
        System.out.println("Is balanced: " + isBalanced(root));
        System.out.println("Diameter: " + diameterOfBinaryTree(root));

       
    }
}
