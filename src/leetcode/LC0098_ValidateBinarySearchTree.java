package leetcode;

import dsa.tree.TreeNode;

/**
 * LeetCode Problem 98: Validate Binary Search Tree
 * Difficulty: Medium
 * 
 * <p>Determine if a binary tree is a valid BST.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0098_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        return min < root.val && root.val < max && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
