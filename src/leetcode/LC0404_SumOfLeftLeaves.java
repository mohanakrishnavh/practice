package leetcode;


import dsa.tree.TreeNode;

public class LC0404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }

        return helper(root, null);
    }

    public int helper(TreeNode root, TreeNode parent) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null && parent.left == root) {
            return root.val;
        }

        int total = 0;
        total = helper(root.left, root) + helper(root.right, root);

        return total;
    }
}
