package dsa.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Node
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class Node {
    public int value;
    public List<Node> children;


    public Node() {
        children = new ArrayList<>();
    }

    public Node(int value) {
        this.value = value;
        children = new ArrayList<>();
    }

    public Node(int value, ArrayList<Node> children) {
        this.value = value;
        this.children = children;
    }
}
