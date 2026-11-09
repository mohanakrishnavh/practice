package dsa.tree.binarytree;

import dsa.tree.TreeNode;

/**
 * LowestCommonAncestor
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class LowestCommonAncestor {
    /**
     * Finds the lowest common ancestor of {@code p} and {@code q}: if they are found in different subtrees, the current node is the answer.
     *
     * @param root root of the tree
     * @param p    first node
     * @param q    second node
     * @return the lowest common ancestor
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}
