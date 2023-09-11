package leetcode;

import dsa.tree.TreeNode;

import java.util.Stack;

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
