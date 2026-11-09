package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * FindFloor
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FindFloor {
    /**
     * Finds the largest value less than or equal to {@code key}.
     *
     * @param root root of the BST
     * @param key  value to look up
     * @return the floor, or -1 if none exists
     */
    public static int findFloor(TreeNode root, int key) {
        int floor = -1;

        while (root != null) {
            if (root.val == key) {
                return root.val;
            }

            if (root.val > key) {
                root = root.left;
            } else {
                floor = root.val;
                root = root.right;
            }
        }

        return floor;
    }
}
