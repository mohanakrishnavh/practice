package leetcode;

import dsa.tree.TreeNode;

import java.util.Stack;

/**
 * LeetCode Problem 230: Kth Smallest Element in a BST
 * Difficulty: Medium
 * 
 * <p>Find the kth smallest element in a BST.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0230_KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            k--;

            if (k == 0) {
                return current.val;
            }

            current = current.right;
        }
    }
}
