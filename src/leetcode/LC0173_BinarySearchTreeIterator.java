package leetcode;

import dsa.tree.TreeNode;

import java.util.Stack;

/**
 * LeetCode Problem 173: Binary Search Tree Iterator
 * Difficulty: Medium
 * 
 * <p>Implement an iterator over a BST's inorder traversal.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0173_BinarySearchTreeIterator {

    Stack<TreeNode> stack;

    public LC0173_BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        pushNodes(root);
    }

    public int next() {
        TreeNode current = stack.pop();
        pushNodes(current.right);
        return current.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushNodes(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
