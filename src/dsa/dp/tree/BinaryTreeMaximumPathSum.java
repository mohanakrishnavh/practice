package dsa.dp.tree;

import dsa.tree.TreeNode;

/**
 * BinaryTreeMaximumPathSum
 * 
 * <p>This class finds the maximum path sum in a binary tree where a path is defined as any
 * sequence of nodes from some starting node to any node in the tree along the parent-child
 * connections. The path must contain at least one node and does not need to go through the root.
 * Uses tree dynamic programming where each node contributes either its left path, right path,
 * or both to form an optimal path. Handles negative node values by taking max with 0.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class BinaryTreeMaximumPathSum {
    /**
     * Finds the maximum path sum in the binary tree.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(h) where h is the height (recursion stack)
     * 
     * @param root the root of the binary tree
     * @return the maximum path sum
     */
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        maxPathSumHelper(root, result);

        return result[0];
    }

    /**
     * Helper method to calculate the maximum path sum.
     * 
     * <p>For each node, calculates:
     * 1. Maximum path through this node (leftSum + rightSum + node.val)
     * 2. Maximum single path from this node (max(leftSum, rightSum) + node.val)
     * 
     * Uses Math.max with 0 to handle negative sums (can skip negative paths).
     * 
     * @param root current node
     * @param result array to store the global maximum
     * @return maximum sum of a single path starting from this node
     */
    private int maxPathSumHelper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }

        // To deal with negative nodes
        int leftSum = Math.max(maxPathSumHelper(root.left, result), 0);
        int rightSum = Math.max(maxPathSumHelper(root.right, result), 0);

        result[0] = Math.max(result[0], leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }
}
