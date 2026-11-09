package dsa.tree.binarytree;

import dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * RootToNodePath
 * 
 * <p>TODO: Add class description
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class RootToNodePath {
    /**
     * Returns the values on the path from the root to the node with value {@code x}.
     *
     * @param root root of the tree
     * @param x    target value
     * @return the path, or an empty/partial list if not found
     */
    public List<Integer> getPath(TreeNode root, int x) {
        List<Integer> path = new LinkedList<>();
        hasPath(root, x, path);

        return path;
    }

    /**
     * DFS with backtracking: adds the node to {@code path}, and removes it again if neither subtree contains {@code x}.
     *
     * <p>Note: the second recursive call passes {@code root} instead of {@code root.right}, which recurses forever
     * whenever the target is not in the left subtree.
     *
     * @param root current node
     * @param x    target value
     * @param path current path, updated in place
     * @return {@code true} if {@code x} was found below this node
     */
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
