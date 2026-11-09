package dsa.tree.binarytree;

import dsa.tree.TreeNode;
/**
 * BalancedBinaryTree
 * 
 * Balanced Binary Tree (LeetCode 110): a tree is height-balanced if at every node the subtree heights differ by at
 * most 1.
 *
 * <p><b>Complexity:</b> Time O(n^2) in the worst case because height is recomputed per node, Space O(h).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BalancedBinaryTree {
    /**
     * Checks that at every node the left and right subtree heights differ by at most 1.
     *
     * @param root root of the tree
     * @return {@code true} if the tree is height-balanced
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    /**
     * Height of a subtree in edges (an empty subtree is -1).
     *
     * @param root root of the subtree
     * @return height
     */
    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
