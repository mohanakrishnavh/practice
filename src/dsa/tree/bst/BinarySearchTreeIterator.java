package dsa.tree.bst;

import dsa.tree.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        addElements(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        addElements(node.right);

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void addElements(TreeNode root) {
        TreeNode current = root;
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
    }
}
