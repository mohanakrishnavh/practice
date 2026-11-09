package dsa.tree.bst;

import dsa.tree.TreeNode;

/**
 * LargestBSTSubtree
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class LargestBSTSubtree {

    /**
     * Summary of a subtree: its min, max and the size of the largest BST inside it.
     */
    class NodeValue {
        public int maxNode, minNode, maxSize;

        /**
         * @param minNode smallest value in the subtree
         * @param maxNode largest value in the subtree
         * @param maxSize size of the largest BST in the subtree
         */
        NodeValue(int minNode, int maxNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    };

    /**
     * Post-order computation: if the node fits between the left max and right min the subtree is a BST; otherwise return an impossible range so ancestors fail.
     *
     * @param root current node
     * @return summary for the subtree
     */
    public NodeValue largestBSTSubtreeHelper(TreeNode root) {
        // An empty tree is a BST of size 0.
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Get values from left and right subtree of current tree.
        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);

        // Current node is greater than max in left AND smaller than min in right, it is a BST.
        if (left.maxNode < root.val && root.val < right.minNode) {
            // It is a BST.
            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
                    left.maxSize + right.maxSize + 1);
        }

        // Otherwise, return [-inf, inf] so that parent can't be valid BST
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,
                Math.max(left.maxSize, right.maxSize));
    }

    /**
     * Returns the number of nodes in the largest BST subtree.
     *
     * @param root root of the tree
     * @return size of the largest BST subtree
     */
    public int largestBSTSubtree(TreeNode root) {
        return largestBSTSubtreeHelper(root).maxSize;
    }

}
