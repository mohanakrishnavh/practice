package leetcode;

import dsa.tree.TreeNode;

import java.util.Stack;

/**
 * LeetCode Problem 114: Flatten Binary Tree to Linked List
 * Difficulty: Medium
 * 
 * <p>Flatten a binary tree to a linked list in-place.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }


            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }

            current.left = null;
        }
    }
}
