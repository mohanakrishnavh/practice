package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * InorderSuccessor
 * 
 * Inorder Successor in a BST (LeetCode 285): the smallest value greater than the given node. Walks down, remembering
 * the last node where we went left.
 *
 * <p><b>Complexity:</b> Time O(h), Space O(1).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class InorderSuccessor {
    /**
     * Finds the node with the smallest value greater than {@code p}'s value.
     *
     * @param root root of the BST
     * @param p    node whose successor is wanted
     * @return the successor, or {@code null} if none
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while(root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
}
