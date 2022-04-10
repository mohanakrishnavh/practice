package dsa.tree.bst;

import dsa.tree.TreeNode;

public class Delete {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.value) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.value) {
            root.right = deleteNode(root.right, key);
        } else {
            // Case 1 : No Children
            if (root.left == null && root.right == null) {
                root = null;
            }

            // Case 2 : One Child
            else if (root.left == null) {
                root = root.right;
            }
            else if (root.right == null) {
                root = root.left;
            }

            // Case 3 : Two Children
            else {
                TreeNode node = findMin(root.right);
                root.value = node.value;
                root.right = deleteNode(root.right, node.value);
            }
        }

        return root;
    }

    private TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode current = root;
        while(current.left != null) {
            current = current.left;
        }

        return current;
    }
}
