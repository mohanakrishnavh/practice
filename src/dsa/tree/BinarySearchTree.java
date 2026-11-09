package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BinarySearchTree
 * 
 * Binary search tree of ints built on {@link BinaryTree}: iterative insert, min/max lookups and printing traversals.
 * Duplicates go to the left subtree.
 *
 * <p><b>Complexity:</b> insert, min and max are O(h) where h is the tree height.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BinarySearchTree extends BinaryTree {

    /**
     * Creates an empty BST.
     */
    public BinarySearchTree() {
        super();
    }

    /**
     * Inserts a value iteratively; values less than or equal to a node go left, larger values go right.
     *
     * @param value value to insert
     */
    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);

        // Case 1: Tree is Empty
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode currentNode = root;
        while (true) {
            // Case 2: When the value is smaller than the current node
            if (value <= currentNode.val) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return;
                }
                currentNode = currentNode.left;
                // Case 3: When the value is greater than the current node
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    return;
                }
                currentNode = currentNode.right;
            }
        }
    }

    /**
     * Returns the smallest value (leftmost node).
     *
     * @return minimum value, or -1 if the tree is empty
     */
    public int min() {
        if (root == null) {
            return -1;
        }

        TreeNode currentNode = root;
        // Iterate until we find the leftmost element
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.val;
    }

    /**
     * Returns the node holding the smallest value (leftmost node).
     *
     * @return minimum node, or {@code null} if the tree is empty
     */
    public TreeNode minNode() {
        if (root == null) {
            return null;
        }

        TreeNode currentNode = root;
        // Iterate until we find the leftmost element
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode;
    }

    /**
     * Returns the largest value (rightmost node).
     *
     * @return maximum value, or -1 if the tree is empty
     */
    public int max() {
        if (root == null) {
            return -1;
        }

        TreeNode currentNode = root;
        // Iterate until we find the rightmost element
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }

        return currentNode.val;
    }

    /**
     * Returns the node holding the largest value (rightmost node).
     *
     * @return maximum node, or {@code null} if the tree is empty
     */
    public TreeNode maxNode() {
        if (root == null) {
            return null;
        }

        TreeNode currentNode = root;
        // Iterate until we find the rightmost element
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }

        return currentNode;
    }

    /**
     * Prints the values level by level (BFS), space separated.
     */
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("Level Order Traversal : ");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    /**
     * Prints the values in preorder (root, left, right).
     */
    public void preOrderTraversal() {
        System.out.print("PreOrder Traversal : ");
        preOrderTraversalUtil(root);
        System.out.println();
    }

    /**
     * Recursive helper that prints the subtree in preorder.
     *
     * @param root current node
     */
    private void preOrderTraversalUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrderTraversalUtil(root.left);
        preOrderTraversalUtil(root.right);
    }

    /**
     * Prints the values in inorder (left, root, right), i.e. sorted order for a BST.
     */
    public void inOrderTraversal() {
        System.out.print("InOrder Traversal : ");
        inOrderTraversalUtil(root);
        System.out.println();
    }

    /**
     * Recursive helper that prints the subtree in inorder.
     *
     * @param root current node
     */
    private void inOrderTraversalUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversalUtil(root.left);
        System.out.print(root.val + " ");
        inOrderTraversalUtil(root.right);
    }

    /**
     * Prints the values in postorder (left, right, root).
     */
    public void postOrderTraversal() {
        System.out.print("PostOrder Traversal : ");
        postOrderTraversalUtil(root);
        System.out.println();
    }

    /**
     * Recursive helper that prints the subtree in postorder.
     *
     * @param root current node
     */
    private void postOrderTraversalUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversalUtil(root.left);
        postOrderTraversalUtil(root.right);
        System.out.print(root.val + " ");
    }
}
