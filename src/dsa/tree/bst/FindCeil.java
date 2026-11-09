package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * FindCeil
 * 
 * Ceil in a BST: the smallest value greater than or equal to a key. Walks down, remembering the last node that was
 * larger than the key.
 *
 * <p><b>Complexity:</b> Time O(h), Space O(1).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FindCeil {
    /**
     * Finds the smallest value greater than or equal to {@code key}.
     *
     * @param root root of the BST
     * @param key  value to look up
     * @return the ceil, or -1 if none exists
     */
    public static int findCeil(TreeNode root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.val == key) {
                return root.val;
            }

            if (root.val < key) {
                root = root.right;
            } else {
                ceil = root.val;
                root = root.left;
            }
        }

        return ceil;
    }
}
