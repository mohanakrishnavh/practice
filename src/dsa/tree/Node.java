package dsa.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Node
 * 
 * N-ary tree node: an integer value plus a list of child nodes.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Node {
    public int value;
    public List<Node> children;


    /**
     * Creates a node with value 0 and no children.
     */
    public Node() {
        children = new ArrayList<>();
    }

    /**
     * Creates a leaf node with the given value.
     *
     * @param value value stored in the node
     */
    public Node(int value) {
        this.value = value;
        children = new ArrayList<>();
    }

    /**
     * Creates a node with the given value and children.
     *
     * @param value    value stored in the node
     * @param children child nodes
     */
    public Node(int value, ArrayList<Node> children) {
        this.value = value;
        this.children = children;
    }
}
