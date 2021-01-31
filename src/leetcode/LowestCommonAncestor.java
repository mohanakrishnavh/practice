package leetcode;

import dsa.tree.TreeNode;

public class LowestCommonAncestor {
    public TreeNode getLCABinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = getLCABinaryTree(root.left, p, q);
        TreeNode right = getLCABinaryTree(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        } else {
            return left;
        }
    }


    public TreeNode getLCABinarySearchTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.value < root.value && q.value < root.value) {
            return getLCABinarySearchTree(root.left, p, q);
        }

        if (p.value > root.value && q.value > root.value) {
            return getLCABinarySearchTree(root.right, p, q);
        }

        return root;
    }
}
