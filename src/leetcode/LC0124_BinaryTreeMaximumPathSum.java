package leetcode;

import dsa.tree.TreeNode;

/**
 * LeetCode Problem 124: Binary Tree Maximum Path Sum
 * Difficulty: Hard
 * 
 * <p>Find the maximum path sum in a binary tree.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0124_BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        int max = maxPathSumHelper(root, result);

        return result[0];
    }

    public int maxPathSumHelper(TreeNode root, int[] result) {
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
