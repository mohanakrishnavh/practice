package leetcode;

import dsa.tree.TreeNode;

public class LC0700_SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.value != val) {
            root = val < root.value ? root.left : root.right;
        }

        return root;
    }
}
