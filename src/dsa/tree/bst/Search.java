package dsa.tree.bst;

import dsa.tree.TreeNode;

public class Search {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.value == val) {
            return root;
        }

        return val < root.value ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null && root.value != val) {
            root = val < root.value ? root.left : root.right;
        }

        return root;
    }
}
