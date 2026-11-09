package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * RightSideView
 * 
 * Binary Tree Right Side View (LeetCode 199): the last node of each level. Provides a level-order (BFS) and a DFS
 * solution that visits right children first.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(w) for BFS and O(h) for DFS.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class RightSideView {
    /**
     * Right side view using level-order traversal: the last node of each level.
     *
     * @param root root of the tree
     * @return rightmost value of each level, top to bottom
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideNodes = new ArrayList<>();
        if (root == null) {
            return rightSideNodes;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) {
                    rightSideNodes.add(node.val);
                }

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return rightSideNodes;
    }

    /**
     * Right side view using DFS (right first): the first node reached at each depth.
     *
     * @param root root of the tree
     * @return rightmost value of each level, top to bottom
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> rightView = new LinkedList<>();
        rightViewHelper(root, 0, rightView);

        return rightView;
    }

    /**
     * Visits right before left and records a value the first time a level is reached.
     *
     * @param root      current node
     * @param level     current depth
     * @param rightView accumulator list
     */
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
