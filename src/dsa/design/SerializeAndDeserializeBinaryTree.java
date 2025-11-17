package dsa.design;

import dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * SerializeAndDeserializeBinaryTree
 * 
 * <p>This class provides methods to serialize a binary tree into a string representation
 * and deserialize it back into the tree structure. Uses level-order traversal (BFS) to
 * encode the tree structure, with "n" representing null nodes. This approach preserves
 * the complete tree structure including the positions of null nodes.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class SerializeAndDeserializeBinaryTree {
    /**
     * Encodes a binary tree to a single string using level-order traversal.
     * 
     * <p>Performs BFS traversal, appending each node's value to the result string.
     * Null nodes are represented by "n" to preserve tree structure.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(n) for the queue and result string
     * 
     * @param root the root of the binary tree
     * @return a string representation of the tree
     * 
     * @example
     * Input tree: 1(2,3(4,5))
     * Output: "1 2 3 n n 4 5 "
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                result.append("n ");
                continue;
            }

            result.append(node.val + " ");

            q.add(node.left);
            q.add(node.right);
        }

        return result.toString();
    }

    /**
     * Decodes the encoded string data back to a binary tree.
     * 
     * <p>Uses level-order construction: creates nodes from the string and uses a queue
     * to track parent nodes. For each parent, assigns left and right children from the
     * next two values in the string.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(n) for the queue
     * 
     * @param data the string representation of the tree
     * @return the root of the reconstructed binary tree
     * 
     * @example
     * Input: "1 2 3 n n 4 5 "
     * Output: Tree with structure 1(2,3(4,5))
     */
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < values.length && !q.isEmpty(); i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }

            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }

        return root;
    }
}
