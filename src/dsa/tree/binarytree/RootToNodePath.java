package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * RootToNodePath
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class RootToNodePath {
    public List<Integer> getPath(TreeNode root, int x) {
        List<Integer> path = new LinkedList<>();
        hasPath(root, x, path);

        return path;
    }

    private boolean hasPath(TreeNode root, int x, List<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.val);
        if (root.val == x) {
            return true;
        }

        if (hasPath(root.left, x, path) || hasPath(root, x, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}
