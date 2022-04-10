package dsa.tree.bst;

import dsa.tree.TreeNode;

public class FindCeil {
    public static int findCeil(TreeNode root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.value == key) {
                return root.value;
            }

            if (root.value < key) {
                root = root.right;
            } else {
                ceil = root.value;
                root = root.left;
            }
        }

        return ceil;
    }
}
