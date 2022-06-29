package leetcode;

import dsa.tree.TreeNode;

public class LC0285_InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }

        TreeNode successor = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root= root.left;
            }
        }

        return successor;
    }
}
