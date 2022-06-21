package leetcode;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

        if (root.value == value) {
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
