package leetcode;


import dsa.tree.TreeNode;

/**
 * LeetCode Problem 404: Sum of Left Leaves
 * Difficulty: Easy
 * 
 * <p>Find the sum of all left leaves in a binary tree.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }

        return helper(root, null);
    }

    public int helper(TreeNode root, TreeNode parent) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null && parent.left == root) {
            return root.val;
        }

        int total = 0;
        total = helper(root.left, root) + helper(root.right, root);

        return total;
    }
}
