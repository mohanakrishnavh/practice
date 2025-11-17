package dsa.graph;

import java.util.List;

/**
 * GraphUtil
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class GraphUtil {
    public static List<List<Integer>> getAdjList(int n, int[][] edges) {
        Graph graph = new Graph(n);
        graph.addUndirectedEdges(edges);

        return graph.getAdjList();
    }

    public static int[][] getAdjMatrix(int n, int[][] edges) {
        Graph graph = new Graph(n);
        graph.addUndirectedEdges(edges);

        return graph.getAdjMatrix();
    }
}
