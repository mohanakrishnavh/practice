package dsa.tree.binarytree;

import dsa.tree.TreeNode;

public class MaximumWidthTODO {

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] dp = new int[2];
        preorder(root, 0, dp);

        return dp[1] - dp[0];
    }

    private static void preorder(TreeNode root, int x, int[] dp) {
        if (root == null) {
            return;
        }

        dp[0] = Math.min(dp[0], x);
        dp[1] = Math.max(dp[1], x);

        if (root.left != null) {
            preorder(root.left, x-1, dp);
        }

        if (root.right != null) {
            preorder(root.right, x+1, dp);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(widthOfBinaryTree(root));
    }
}
