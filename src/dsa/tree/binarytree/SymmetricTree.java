package dsa.tree.binarytree;

import dsa.tree.TreeNode;
/**
 * SymmetricTree
 * 
 * Symmetric Tree (LeetCode 101): checks that the left and right subtrees of the root are mirror images by comparing
 * outer and inner children in pairs.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(h).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SymmetricTree {

    /**
     * Checks whether the tree is a mirror image of itself.
     *
     * @param root root of the tree
     * @return {@code true} if symmetric
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    /**
     * Checks whether two subtrees are mirror images: equal values, and outer/inner children mirror each other.
     *
     * @param t1 first subtree
     * @param t2 second subtree
     * @return {@code true} if they mirror each other
     */
    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }

        return isSymmetric(t1.right, t2.left) && isSymmetric(t1.left, t2.right);
    }
}
