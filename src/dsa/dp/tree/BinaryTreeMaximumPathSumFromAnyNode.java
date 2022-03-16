package dsa.dp.tree;

import dsa.tree.TreeNode;

public class BinaryTreeMaximumPathSumFromAnyNode {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        int max = maxPathSumHelper(root, result);

        return result[0];
    }

    public int maxPathSumHelper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }

        int leftSum = maxPathSumHelper(root.left, result);
        int rightSum = maxPathSumHelper(root.right, result);
        result[0] = Math.max(result[0], leftSum + rightSum + root.value);

        return Math.max(Math.max(leftSum, rightSum) + root.value, root.value);
    }
}
