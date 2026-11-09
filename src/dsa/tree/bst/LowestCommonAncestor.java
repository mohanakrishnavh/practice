package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * LowestCommonAncestor
 * 
 * Lowest Common Ancestor of a BST (LeetCode 235): descend while both targets are on the same side; the first node
 * where they split (or equal a target) is the LCA.
 *
 * <p><b>Complexity:</b> Time O(h), Space O(h) for recursion.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class LowestCommonAncestor {
    /**
     * Finds the lowest common ancestor in a BST: descend until the two values split to different sides.
     *
     * @param root root of the BST
     * @param p    first node
     * @param q    second node
     * @return the lowest common ancestor
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
