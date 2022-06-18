package dsa.dp.tree;

import dsa.tree.TreeNode;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        int h = height(root, result);

        // returns the numbers of nodes in the diameter of the tree
        return result[0];
    }

    private int height(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left, result);
        int rightHeight = height(root.right, result);
        // If the diameter is represented using edges
        // result[0] = Math.max(result[0], leftHeight + rightHeight);
        result[0] = Math.max(result[0], 1 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
