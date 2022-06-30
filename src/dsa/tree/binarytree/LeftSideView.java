package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftSideView {
    // Approach 1 : Level Order Traversal
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (i == 0) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return result;
    }

    // Approach 2 : Depth First Traversal
    public List<Integer> leftSideView2(TreeNode root) {
        List<Integer> leftView = new LinkedList<>();
        leftViewHelper(root, 0, leftView);

        return leftView;
    }

    private void leftViewHelper(TreeNode root, int level, List<Integer> leftView) {
        if (root == null) {
            return;
        }

        // Add the node the first time we reach the level
        if (level == leftView.size()) {
            leftView.add(root.val);
        }

        leftViewHelper(root.left, level+1, leftView);
        leftViewHelper(root.right, level+1, leftView);
    }
}
