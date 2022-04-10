package leetcode;

import dsa.tree.TreeNode;

public class LC0098_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        return min < root.value && root.value < max && isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);
    }
}
