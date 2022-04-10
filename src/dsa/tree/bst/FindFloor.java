package dsa.tree.bst;

import dsa.tree.TreeNode;

public class FindFloor {
    public static int findFloor(TreeNode root, int key) {
        int floor = -1;

        while (root != null) {
            if (root.value == key) {
                return root.value;
            }

            if (root.value > key) {
                root = root.left;
            } else {
                floor = root.value;
                root = root.right;
            }
        }

        return floor;
    }
}
