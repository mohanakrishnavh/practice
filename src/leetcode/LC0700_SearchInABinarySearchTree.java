package leetcode;

import dsa.tree.TreeNode;

/**
 * LeetCode Problem 700: Search in a Binary Search Tree
 * Difficulty: Easy
 * 
 * <p>Find a node in a BST with a given value.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0700_SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }

        return root;
    }
}
