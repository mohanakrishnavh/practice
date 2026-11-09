package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * Insert
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Insert {

    /**
     * Inserts a value iteratively as a new leaf (equal values go left).
     *
     * @param root root of the BST
     * @param val  value to insert
     * @return root of the BST
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;
        while (true) {
            if (val <= current.val) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(val);
                    break;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }

}
