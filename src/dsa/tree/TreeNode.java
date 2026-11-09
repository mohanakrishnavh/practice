package dsa.tree;

/**
 * TreeNode
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    /**
     * Creates a leaf node with the given value.
     *
     * @param val value stored in the node
     */
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
