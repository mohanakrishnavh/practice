package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * FindFloor
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class FindFloor {
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
