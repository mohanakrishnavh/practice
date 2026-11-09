package dsa.tree;

/**
 * Abstract base for tree data structures; holds the root node.
 */
/**
 * Tree
 *
 * <p>Abstract base class for tree data structures; holds the root node. Extended by {@link BinaryTree}.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
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
