package dsa.graph;

public class GraphTraversalDriver {
    public static void main(String[] args) {
        Graph g1 = new Graph(6);
        g1.addUndirectedEdge(0, 1);
        g1.addUndirectedEdge(0, 2);
        g1.addUndirectedEdge(0, 3);
        g1.addUndirectedEdge(1, 4);
        g1.addUndirectedEdge(2, 4);
        g1.addUndirectedEdge(2, 5);
        g1.addUndirectedEdge(4, 5);

        System.out.println("Breadth First Traversal : " + g1.breadthFirstTraversal(0));

        Graph g2 = new Graph(7);
        g2.addDirectedEdge(0, 1);
        g2.addDirectedEdge(0, 2);
        g2.addDirectedEdge(1, 3);
        g2.addDirectedEdge(3, 5);
        g2.addDirectedEdge(2, 4);
        g2.addDirectedEdge(4, 5);
        g2.addDirectedEdge(4, 6);
        System.out.println("Depth First Traversal : " + g2.depthFirstTraversal(0));
    }
}
