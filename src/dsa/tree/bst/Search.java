package dsa.tree.bst;

import dsa.tree.TreeNode;

public class Search {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }

        return root;
    }
}
