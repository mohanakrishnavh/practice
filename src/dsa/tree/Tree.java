package dsa.tree;

/**
 * Abstract base for tree data structures; holds the root node.
 */
public abstract class Tree {

    TreeNode root;

    /**
     * Creates an empty tree (root is {@code null}).
     */
    public Tree() {
        this.root = null;
    }
}
