package leetcode;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 336: Find Leaves of Binary Tree
 * Difficulty: Medium
 * 
 * <p>Collect and remove all leaves, repeat until tree is empty.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0336_FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();

        if (root == null) {
            return leaves;
        }

        boolean isLeaf = false;
        while (!isLeaf) {
            List<Integer> currentLeaves = new ArrayList<>();
            isLeaf = findLeavesHelper(root, currentLeaves);
            leaves.add(currentLeaves);
        }

        return leaves;
    }

    private boolean findLeavesHelper(TreeNode root, List<Integer> currentLeaves) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            currentLeaves.add(root.val);
            return true;
        }

        boolean left = findLeavesHelper(root.left, currentLeaves);
        boolean right = findLeavesHelper(root.right, currentLeaves);

        if (left == true) {
            root.left = null;
        }

        if (right == true) {
            root.right = null;
        }

        return false;
    }
}
