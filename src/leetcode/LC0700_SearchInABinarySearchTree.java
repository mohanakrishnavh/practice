package leetcode;

import dsa.tree.TreeNode;

public class LC0700_SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }

        return root;
    }
}
