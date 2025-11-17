package leetcode;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 2096: Step-By-Step Directions From a Binary Tree Node to Another
 * Difficulty: Medium
 * 
 * <p>Find the shortest path between two nodes.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC2096_StepByStepDirectionFromOneBinaryTreeNodeToAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> startPath = new ArrayList<>();
        List<Character> destPath = new ArrayList<>();

        hasPath(root, startValue, startPath);
        hasPath(root, destValue, destPath);

        int startIndex = startPath.size() - 1;
        int destIndex = destPath.size() - 1;
        while (startIndex >= 0 && destIndex >= 0 && startPath.get(startIndex) == destPath.get(destIndex)) {
            startPath.remove(startIndex);
            destPath.remove(destIndex);
            startIndex--;
            destIndex--;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < startPath.size(); i++) {
            builder.append("U");
        }

        for (int i = destPath.size() - 1; i >= 0; i--) {
            builder.append(destPath.get(i));
        }

        return builder.toString();
    }

    private boolean hasPath(TreeNode root, int value, List<Character> path) {
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        }

        boolean left = hasPath(root.left, value, path);
        if (left) {
            path.add('L');
            return true;
        }

        boolean right = hasPath(root.right, value, path);
        if (right) {
            path.add('R');
            return true;
        }

        return false;
    }
}
