package leetcode;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode Problem 103: Binary Tree Zigzag Level Order Traversal
 * Difficulty: Medium
 * 
 * <p>Return the zigzag level order traversal of a binary tree.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0103_BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            while (size > 0) {
                TreeNode current = q.poll();

                if (current.left != null) {
                    q.offer(current.left);
                }

                if (current.right != null) {
                    q.offer(current.right);
                }

                if (leftToRight) {
                    level.add(current.val);
                } else {
                    level.addFirst(current.val);
                }

                size--;
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
