package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * ConstructBSTFromPreorderTraversal
 * 
 * Construct BST from Preorder Traversal (LeetCode 1008). Each recursive call accepts values up to an upper bound, so
 * the tree is built in a single pass.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(h).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ConstructBSTFromPreorderTraversal {
    /**
     * Builds a BST from its preorder traversal in O(n) using an upper bound per subtree.
     *
     * @param preorder preorder values
     * @return root of the BST
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    /**
     * Consumes values while they stay within {@code bound}; left subtree is bounded by the node, right by the inherited bound.
     *
     * @param preorder preorder values
     * @param bound    upper bound for this subtree
     * @param idx      single-element holder for the current position
     * @return root of the built subtree, or {@code null}
     */
    private TreeNode bstFromPreorderHelper(int[] preorder, int bound, int[] idx) {
        if (idx[0] == preorder.length || preorder[idx[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx[0]++]);
        root.left = bstFromPreorderHelper(preorder, root.val, idx);
        root.right = bstFromPreorderHelper(preorder, bound, idx);

        return root;
    }
}
