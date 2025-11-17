package dsa.tree.binarytree;

import dsa.tree.TreeNode;
/**
 * SymmetricTree
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

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
