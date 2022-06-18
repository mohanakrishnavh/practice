package dsa.dp.tree;

import dsa.tree.TreeNode;

public class BinaryTreeMaximumPathSumFromAnyNode {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        int max = maxPathSumHelper(root, result);

        return result[0];
    }

    private int maxPathSumHelper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(maxPathSumHelper(root.left, result), 0);
        int rightSum = Math.max(maxPathSumHelper(root.right, result), 0);
        result[0] = Math.max(result[0], leftSum + rightSum + root.value);

        return Math.max(Math.max(leftSum, rightSum) + root.value, root.value);
    }
}
