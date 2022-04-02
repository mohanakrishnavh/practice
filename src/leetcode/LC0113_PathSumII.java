package leetcode;

import dsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC0113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();

        pathSumUtil(root, targetSum, new ArrayList<>(), paths);
        return paths;
    }

    public void pathSumUtil(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }

        path.add(root.value);
        if (root.left == null && root.right == null && root.value == targetSum) {
            paths.add(new ArrayList<>(path));

        } else {
            pathSumUtil(root.left, targetSum - root.value, path, paths);
            pathSumUtil(root.right, targetSum - root.value, path, paths);
        }

        path.remove(path.size() - 1);
    }
}
