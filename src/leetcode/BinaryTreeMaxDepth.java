package leetcode;

import dsa.tree.TreeNode;

public class BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = root.left == null ? Integer.MIN_VALUE : maxDepth(root.left);
        int rightDepth = root.right == null ? Integer.MIN_VALUE : maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
