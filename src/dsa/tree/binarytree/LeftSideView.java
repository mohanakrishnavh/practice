package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeftSideView
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class LeftSideView {
    /**
     * Left side view using level-order traversal: the first node of each level.
     *
     * @param root root of the tree
     * @return leftmost value of each level, top to bottom
     */
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

    /**
     * Left side view using DFS (left first): the first node reached at each depth.
     *
     * @param root root of the tree
     * @return leftmost value of each level, top to bottom
     */
    public List<Integer> leftSideView2(TreeNode root) {
        List<Integer> leftView = new LinkedList<>();
        leftViewHelper(root, 0, leftView);

        return leftView;
    }

    /**
     * Visits left before right and records a value the first time a level is reached.
     *
     * @param root     current node
     * @param level    current depth
     * @param leftView accumulator list
     */
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
