package Tree;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Tree Data Structure Problems ===\n");

        // Build a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 1. Traversals
        System.out.println("1. Inorder Traversal: " + InorderTraversal.class.getSimpleName());
        java.util.ArrayList<Integer> inorder = new java.util.ArrayList<>();
        InorderTraversal.inorder(root, inorder);
        System.out.println("   " + inorder);

        System.out.println("\n2. Preorder Traversal: " + PreorderTraversal.class.getSimpleName());
        java.util.ArrayList<Integer> preorder = new java.util.ArrayList<>();
        PreorderTraversal.preorder(root, preorder);
        System.out.println("   " + preorder);

        System.out.println("\n3. Postorder Traversal: " + PostorderTraversal.class.getSimpleName());
        java.util.ArrayList<Integer> postorder = new java.util.ArrayList<>();
        PostorderTraversal.postorder(root, postorder);
        System.out.println("   " + postorder);

        System.out.println("\n4. Level Order Traversal: " + LevelOrderTraversal.class.getSimpleName());
        System.out.println("   " + LevelOrderTraversal.levelOrder(root));

        System.out.println("\n5. Zigzag Level Order: " + ZigzagLevelOrder.class.getSimpleName());
        System.out.println("   " + ZigzagLevelOrder.zigzag(root));

        // 2. Tree Properties
        System.out.println("\n6. Max Depth: " + MaxDepthBinaryTree.class.getSimpleName());
        System.out.println("   " + MaxDepthBinaryTree.maxDepth(root));

        System.out.println("\n7. Diameter: " + DiameterOfBinaryTree.class.getSimpleName());
        System.out.println("   " + DiameterOfBinaryTree.diameterOfBinaryTree(root));

        System.out.println("\n8. Is Balanced: " + BalancedBinaryTree.class.getSimpleName());
        System.out.println("   " + BalancedBinaryTree.isBalanced(root));

        System.out.println("\n9. Invert Tree: " + InvertBinaryTree.class.getSimpleName());
        TreeNode inverted = InvertBinaryTree.invertTree(deepCopy(root));
        System.out.println("   Inverted root left: " + inverted.left.value + ", right: " + inverted.right.value);

        System.out.println("\n10. Is Symmetric: " + SymmetricTree.class.getSimpleName());
        TreeNode sym = new TreeNode(1);
        sym.left = new TreeNode(2);
        sym.right = new TreeNode(2);
        sym.left.left = new TreeNode(3);
        sym.left.right = new TreeNode(4);
        sym.right.left = new TreeNode(4);
        sym.right.right = new TreeNode(3);
        System.out.println("    " + SymmetricTree.isSymmetric(sym));

        // 3. Path Sums
        System.out.println("\n11. Path Sum: " + PathSum.class.getSimpleName());
        TreeNode pathRoot = new TreeNode(5);
        pathRoot.left = new TreeNode(4);
        pathRoot.right = new TreeNode(8);
        pathRoot.left.left = new TreeNode(11);
        pathRoot.left.left.left = new TreeNode(7);
        pathRoot.left.left.right = new TreeNode(2);
        System.out.println("    " + PathSum.hasPathSum(pathRoot, 22));

        System.out.println("\n12. Path Sum II: " + PathSumII.class.getSimpleName());
        System.out.println("    " + PathSumII.pathSum(pathRoot, 22));

        System.out.println("\n13. Sum Root to Leaf: " + SumRootToLeafNumbers.class.getSimpleName());
        TreeNode numRoot = new TreeNode(1);
        numRoot.left = new TreeNode(2);
        numRoot.right = new TreeNode(3);
        System.out.println("    " + SumRootToLeafNumbers.sumNumbers(numRoot)); // 12 + 13 = 25

        // 4. LCA
        System.out.println("\n14. LCA (Binary Tree): " + LowestCommonAncestorBinaryTree.class.getSimpleName());
        TreeNode lcaRoot = new TreeNode(3);
        lcaRoot.left = new TreeNode(5);
        lcaRoot.right = new TreeNode(1);
        lcaRoot.left.left = new TreeNode(6);
        lcaRoot.left.right = new TreeNode(2);
        lcaRoot.left.right.left = new TreeNode(7);
        lcaRoot.left.right.right = new TreeNode(4);
        lcaRoot.right.left = new TreeNode(0);
        lcaRoot.right.right = new TreeNode(8);
        TreeNode lca = LowestCommonAncestorBinaryTree.lowestCommonAncestor(lcaRoot, lcaRoot.left, lcaRoot.left.right.right);
        System.out.println("    LCA(5, 4) = " + lca.value);

        System.out.println("\n15. LCA (BST): " + LowestCommonAncestorBST.class.getSimpleName());
        TreeNode bstRoot = new TreeNode(6);
        bstRoot.left = new TreeNode(2);
        bstRoot.right = new TreeNode(8);
        bstRoot.left.left = new TreeNode(0);
        bstRoot.left.right = new TreeNode(4);
        bstRoot.left.right.left = new TreeNode(3);
        bstRoot.left.right.right = new TreeNode(5);
        bstRoot.right.left = new TreeNode(7);
        bstRoot.right.right = new TreeNode(9);
        TreeNode bstLca = LowestCommonAncestorBST.lowestCommonAncestor(bstRoot, bstRoot.left, bstRoot.right);
        System.out.println("    LCA(2, 8) = " + bstLca.value);

        // 5. Serialization
        System.out.println("\n16. Serialize/Deserialize: " + SerializeDeserializeBinaryTree.class.getSimpleName());
        String serialized = SerializeDeserializeBinaryTree.serialize(root);
        TreeNode deserialized = SerializeDeserializeBinaryTree.deserialize(serialized);
        System.out.println("    Serialized and restored, level order: " + LevelOrderTraversal.levelOrder(deserialized));

        // 6. Construction
        System.out.println("\n17. Build from Preorder+Inorder: " + ConstructBinaryTreeFromPreorderInorder.class.getSimpleName());
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode builtPre = ConstructBinaryTreeFromPreorderInorder.buildTree(pre, in);
        System.out.println("    Root = " + builtPre.value);

        System.out.println("\n18. Build from Inorder+Postorder: " + ConstructBinaryTreeFromInorderPostorder.class.getSimpleName());
        int[] inord = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        TreeNode builtPost = ConstructBinaryTreeFromInorderPostorder.buildTree(inord, post);
        System.out.println("    Root = " + builtPost.value);

        // 7. Views/Transformations
        System.out.println("\n19. Right Side View: " + BinaryTreeRightSideView.class.getSimpleName());
        TreeNode viewRoot = new TreeNode(1);
        viewRoot.left = new TreeNode(2);
        viewRoot.right = new TreeNode(3);
        viewRoot.left.right = new TreeNode(5);
        viewRoot.right.right = new TreeNode(4);
        System.out.println("    " + BinaryTreeRightSideView.rightSideView(viewRoot));

        System.out.println("\n20. Count Complete Tree Nodes: " + CountCompleteTreeNodes.class.getSimpleName());
        TreeNode completeRoot = new TreeNode(1);
        completeRoot.left = new TreeNode(2);
        completeRoot.right = new TreeNode(3);
        completeRoot.left.left = new TreeNode(4);
        completeRoot.left.right = new TreeNode(5);
        completeRoot.right.left = new TreeNode(6);
        System.out.println("    " + CountCompleteTreeNodes.countNodes(completeRoot));

        System.out.println("\n21. Subtree of Another Tree: " + SubtreeOfAnotherTree.class.getSimpleName());
        TreeNode mainTree = new TreeNode(3);
        mainTree.left = new TreeNode(4);
        mainTree.right = new TreeNode(5);
        mainTree.left.left = new TreeNode(1);
        mainTree.left.right = new TreeNode(2);
        TreeNode subTree = new TreeNode(4);
        subTree.left = new TreeNode(1);
        subTree.right = new TreeNode(2);
        System.out.println("    " + SubtreeOfAnotherTree.isSubtree(mainTree, subTree));

        System.out.println("\n22. Flatten Tree: " + FlattenBinaryTreeToLinkedList.class.getSimpleName());
        TreeNode flatRoot = new TreeNode(1);
        flatRoot.left = new TreeNode(2);
        flatRoot.right = new TreeNode(5);
        flatRoot.left.left = new TreeNode(3);
        flatRoot.left.right = new TreeNode(4);
        flatRoot.right.right = new TreeNode(6);
        FlattenBinaryTreeToLinkedList.flatten(flatRoot);
        System.out.print("    Flattened: ");
        TreeNode cur = flatRoot;
        while (cur != null) { System.out.print(cur.value + " "); cur = cur.right; }
        System.out.println();

        System.out.println("\n23. Vertical Order: " + VerticalOrderTraversal.class.getSimpleName());
        TreeNode vertRoot = new TreeNode(3);
        vertRoot.left = new TreeNode(9);
        vertRoot.right = new TreeNode(8);
        vertRoot.left.left = new TreeNode(4);
        vertRoot.left.right = new TreeNode(0);
        vertRoot.right.left = new TreeNode(1);
        vertRoot.right.right = new TreeNode(7);
        System.out.println("    " + VerticalOrderTraversal.verticalOrder(vertRoot));

        // 8. BST Utilities
        System.out.println("\n24. Validate BST: " + ValidateBinarySearchTree.class.getSimpleName());
        System.out.println("    " + ValidateBinarySearchTree.isValidBST(bstRoot));

        System.out.println("\n25. Kth Smallest in BST: " + KthSmallestElementBST.class.getSimpleName());
        System.out.println("    " + KthSmallestElementBST.kthSmallest(bstRoot, 3));

        System.out.println("\n26. Convert Sorted Array to BST: " + ConvertSortedArrayToBST.class.getSimpleName());
        int[] arr = {-10,-3,0,5,9};
        TreeNode bstFromArr = ConvertSortedArrayToBST.sortedArrayToBST(arr);
        System.out.println("    Root = " + bstFromArr.value);

        System.out.println("\n27. Convert BST to Greater Tree: " + ConvertBSTToGreaterTree.class.getSimpleName());
        TreeNode gstRoot = new TreeNode(2);
        gstRoot.left = new TreeNode(1);
        gstRoot.right = new TreeNode(3);
        ConvertBSTToGreaterTree.convertBST(gstRoot);
        System.out.println("    Node 2 becomes: " + gstRoot.value);

        System.out.println("\n28. Recover BST: " + RecoverBinarySearchTree.class.getSimpleName());
        TreeNode recoverRoot = new TreeNode(3);
        recoverRoot.left = new TreeNode(1);
        recoverRoot.right = new TreeNode(4);
        recoverRoot.right.left = new TreeNode(2);
        RecoverBinarySearchTree.recoverTree(recoverRoot);
        System.out.println("    Recovered, valid BST: " + ValidateBinarySearchTree.isValidBST(recoverRoot));

        // 9. Advanced Traversals
        System.out.println("\n29. Morris Traversal: " + MorrisTraversal.class.getSimpleName());
        TreeNode morrisRoot = new TreeNode(2);
        morrisRoot.left = new TreeNode(1);
        morrisRoot.right = new TreeNode(3);
        System.out.println("    " + MorrisTraversal.inorder(morrisRoot));

        System.out.println("\n30. Binary Tree Traversal (Iterative): " + BinaryTreeTraversal.class.getSimpleName());
        TreeNode traversalRoot = new TreeNode(1);
        traversalRoot.left = new TreeNode(2);
        traversalRoot.right = new TreeNode(3);
        traversalRoot.left.left = new TreeNode(4);
        traversalRoot.left.right = new TreeNode(5);
        System.out.println("    Inorder: " + BinaryTreeTraversal.inorderIterative(traversalRoot));
        System.out.println("    Preorder: " + BinaryTreeTraversal.preorderIterative(traversalRoot));
        System.out.println("    Postorder: " + BinaryTreeTraversal.postorderIterative(traversalRoot));

        System.out.println("\n=== All Tree Problems Completed ===");
    }

    private static TreeNode deepCopy(TreeNode node) {
        if (node == null) return null;
        TreeNode copy = new TreeNode(node.value);
        copy.left = deepCopy(node.left);
        copy.right = deepCopy(node.right);
        return copy;
    }
}
