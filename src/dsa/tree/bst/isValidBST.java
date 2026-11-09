package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * isValidBST
 * 
 * Validate Binary Search Tree (LeetCode 98): every node must lie strictly between bounds inherited from its ancestors.
 * {@code long} bounds handle nodes equal to {@code Integer.MIN_VALUE} or {@code MAX_VALUE}.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(h).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class isValidBST {
    /**
     * Checks whether the tree is a valid BST.
     *
     * @param root root of the tree
     * @return {@code true} if valid
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Checks that each node lies strictly within bounds inherited from its ancestors (long bounds handle {@code Integer} extremes).
     *
     * @param root current node
     * @param min  exclusive lower bound
     * @param max  exclusive upper bound
     * @return {@code true} if the subtree is valid
     */
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        return min < root.val && root.val < max && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
