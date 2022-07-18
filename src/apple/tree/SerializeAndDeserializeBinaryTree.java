package apple.tree;

import dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public class Codec {

        // Encodes a tree to a single string.
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

        // Decodes your encoded data to tree.
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
}
