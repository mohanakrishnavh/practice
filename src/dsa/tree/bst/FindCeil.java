package dsa.tree.bst;

import dsa.tree.TreeNode;

public class FindCeil {
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
