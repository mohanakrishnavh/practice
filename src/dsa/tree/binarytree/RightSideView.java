package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    // Approach 1 : Level Order Traversal
    public List<Integer> rightSideView(TreeNode root) {
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

                if (i == size-1) {
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
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> rightView = new LinkedList<>();
        rightViewHelper(root, 0, rightView);

        return rightView;
    }

    private void rightViewHelper(TreeNode root, int level, List<Integer> rightView) {
        if (root == null) {
            return;
        }

        // Add the node the first time we reach the level
        if (level == rightView.size()) {
            rightView.add(root.val);
        }

        rightViewHelper(root.right, level+1, rightView);
        rightViewHelper(root.left, level+1, rightView);
    }
}
