package dsa.recursion.recursion;

import dsa.tree.TreeNode;

public class HeightOfBinaryTree {
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + leftHeight + rightHeight;
    }
}
