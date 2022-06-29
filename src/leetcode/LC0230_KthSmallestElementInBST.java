package leetcode;

import dsa.tree.TreeNode;

import java.util.Stack;

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
