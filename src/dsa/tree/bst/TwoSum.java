package dsa.tree.bst;


import dsa.tree.TreeNode;

import java.util.Stack;

public class TwoSum {

    static class BSTIterator {

        Stack<TreeNode> stack;
        boolean reverse;

        public BSTIterator(TreeNode root, boolean reverse) {
            stack = new Stack<>();
            this.reverse = reverse;
            addElements(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            if (reverse) {
                addElements(node.left);
            } else {
                addElements(node.right);
            }

            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void addElements(TreeNode root) {
            TreeNode current = root;
            while(current != null) {
                stack.push(current);
                if (reverse) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            }
        }

    }


    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();
        while (i < j) {
            if (i + j == k) {
                return true;
            }

            if (i + j < k) {
                i = left.next();
            } else {
                j = right.next();
            }
        }

        return false;
    }
}
