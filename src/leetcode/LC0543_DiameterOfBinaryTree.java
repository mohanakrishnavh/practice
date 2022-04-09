package leetcode;

import dsa.tree.TreeNode;

public class LC0543_DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        int h = height(root, result);

        // result[0] returns the numbers of nodes in the diameter of the tree
        // Tree with N nodes has (N-1) edges
        return result[0] - 1;
    }

    public int height(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left, result);
        int rightHeight = height(root.right, result);

        result[0] = Math.max(result[0], 1 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
