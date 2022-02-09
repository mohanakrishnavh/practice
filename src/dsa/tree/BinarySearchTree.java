package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

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
            if (value <= currentNode.value) {
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

    public int min() {
        if (root == null) {
            return -1;
        }

        TreeNode currentNode = root;
        // Iterate until we find the leftmost element
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.value;
    }

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

    public int max() {
        if (root == null) {
            return -1;
        }

        TreeNode currentNode = root;
        // Iterate until we find the rightmost element
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }

        return currentNode.value;
    }

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

    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("Level Order Traversal : ");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    public void preOrderTraversal() {
        System.out.print("PreOrder Traversal : ");
        preOrderTraversalUtil(root);
        System.out.println();
    }

    private void preOrderTraversalUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preOrderTraversalUtil(root.left);
        preOrderTraversalUtil(root.right);
    }

    public void inOrderTraversal() {
        System.out.print("InOrder Traversal : ");
        inOrderTraversalUtil(root);
        System.out.println();
    }

    private void inOrderTraversalUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversalUtil(root.left);
        System.out.print(root.value + " ");
        inOrderTraversalUtil(root.right);
    }

    public void postOrderTraversal() {
        System.out.print("PostOrder Traversal : ");
        postOrderTraversalUtil(root);
        System.out.println();
    }

    private void postOrderTraversalUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversalUtil(root.left);
        postOrderTraversalUtil(root.right);
        System.out.print(root.value + " ");
    }
}
