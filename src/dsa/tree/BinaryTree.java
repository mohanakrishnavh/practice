package dsa.tree;

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * <p>
     * Note: This doesn't handle duplicates.
     * Alternate Implementation: Inorder Traversal will return the data in sorted order.
     */
    public boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        return root.value > minValue && root.value < maxValue && isBSTUtil(root.left, minValue, root.value) && isBSTUtil(root.right, root.value, maxValue);
    }
}
