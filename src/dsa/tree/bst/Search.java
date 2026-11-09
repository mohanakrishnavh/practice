package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * Search
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Search {
    /**
     * Recursive BST search.
     *
     * @param root root of the BST
     * @param val  value to find
     * @return the node with the value, or {@code null}
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    /**
     * Iterative BST search.
     *
     * @param root root of the BST
     * @param val  value to find
     * @return the node with the value, or {@code null}
     */
    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }

        return root;
    }
}
