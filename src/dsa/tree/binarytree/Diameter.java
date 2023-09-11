package dsa.tree.binarytree;

import dsa.tree.TreeNode;

public class Diameter {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] dp = new int[1];
        height(root, dp);
        return dp[0] - 1;
    }

    private int height(TreeNode root, int[] dp) {
        if (root == null) {
            return 0;
        }


        int leftHeight = height(root.left, dp);
        int rightHeight = height(root.right, dp);

        dp[0] = Math.max(dp[0], 1 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
