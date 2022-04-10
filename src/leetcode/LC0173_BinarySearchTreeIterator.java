package leetcode;

import dsa.tree.TreeNode;

import java.util.Stack;

public class LC0173_BinarySearchTreeIterator {

    Stack<TreeNode> stack;

    public LC0173_BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        pushNodes(root);
    }

    public int next() {
        TreeNode current = stack.pop();
        pushNodes(current.right);
        return current.value;
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
