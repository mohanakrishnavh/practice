package leetcode;

import dsa.tree.TreeNode;

public class LC0235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.value < root.value && q.value < root.value) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.value > root.value && q.value > root.value) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
