package dsa.tree.bst;

import dsa.tree.TreeNode;

public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        return min < root.val && root.val < max && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
