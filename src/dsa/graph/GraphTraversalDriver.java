package dsa.graph;

public class GraphTraversalDriver {
    public static void main(String[] args) {
        Graph graph1 = new Graph(7);
        graph1.addUndirectedEdges(new int[][]{{0, 1}, {0, 2}, {1, 3}, {3, 5}, {2, 4}, {4, 5}, {4, 6}});

        Graph graph2 = new Graph(7);
        graph2.addDirectedEdges(new int[][]{{0, 1}, {0, 2}, {1, 3}, {3, 5}, {2, 4}, {4, 5}, {4, 6}});

        // Depth First Traversal
        System.out.println("Depth First Traversal (Undirected Graph) : " + graph1.depthFirstTraversal(0));
        graph1.refreshVisited();
        System.out.println("Depth First Traversal (Directed Graph) : " + graph2.depthFirstTraversal(0));
        graph2.refreshVisited();

        // Breadth First Traversal
        System.out.println("Breadth First Traversal (Undirected Graph) : " + graph1.breadthFirstTraversal(0));
        graph1.refreshVisited();
        System.out.println("Breadth First Traversal (Directed Graph) : " + graph2.breadthFirstTraversal(0));
        graph2.refreshVisited();
    }
}
