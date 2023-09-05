package dsa.tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dsa.tree.BinaryTree;
import dsa.tree.TreeNode;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        List<String> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node == null) {
                    result.add("#");
                    continue;
                }

                result.add(String.valueOf(node.val));
                q.add(node.left);
                q.add(node.right);
            }
        }

        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 0;
        while (!q.isEmpty() && index < nodes.length) {
            TreeNode node = q.poll();
            if (!nodes[index+1].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(nodes[index+1]));
                q.offer(node.left);
            }
            if (!nodes[index+2].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(nodes[index+2]));
                q.offer(node.right);
            }

            index += 2;
        }

        return root;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        // Level 1
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        // Level 2
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
        String data = codec.serialize(root);
        System.out.println(data);
        System.out.println(BinaryTree.levelOrderTraversal(codec.deserialize(data)));
    }

}
