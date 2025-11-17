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
public class LC0230_KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            count++;
            if (count == k) {
                return current.val;
            }

            current = current.right;
        }

        return -1;
    }
}
