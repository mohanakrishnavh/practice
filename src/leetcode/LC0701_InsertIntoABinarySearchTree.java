package leetcode;

import dsa.tree.TreeNode;

public class LC0701_InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;
        while(true) {
            if (val < current.value) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                }

                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                }

                current = current.right;
            }
        }

        return root;
    }
}
