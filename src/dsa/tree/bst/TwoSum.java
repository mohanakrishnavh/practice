package dsa.tree.bst;


import dsa.tree.TreeNode;

import java.util.Stack;

/**
 * TwoSum
 * 
 * Two Sum IV - Input is a BST (LeetCode 653): checks whether two nodes sum to a target. Two inorder iterators (ascending
 * and descending) act as two pointers without copying the tree to an array.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(h).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class TwoSum {

    /**
     * In-order iterator that can run ascending or, with {@code reverse}, descending.
     */
    static class BSTIterator {

        Stack<TreeNode> stack;
        boolean reverse;

        /**
         * @param root    root of the BST
         * @param reverse {@code true} to iterate in descending order
         */
        public BSTIterator(TreeNode root, boolean reverse) {
            stack = new Stack<>();
            this.reverse = reverse;
            addElements(root);
        }

        /**
         * @return next value in the iteration order
         */
        public int next() {
            TreeNode node = stack.pop();
            if (reverse) {
                addElements(node.left);
            } else {
                addElements(node.right);
            }

            return node.val;
        }

        /**
         * @return {@code true} if more values remain
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * Pushes the chain of left (or right, if reversed) descendants onto the stack.
         *
         * @param root subtree root
         */
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


    /**
     * Checks whether two distinct nodes sum to {@code k}, using an ascending and a descending iterator as two pointers (O(h) space).
     *
     * @param root root of the BST
     * @param k    target sum
     * @return {@code true} if such a pair exists
     */
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
