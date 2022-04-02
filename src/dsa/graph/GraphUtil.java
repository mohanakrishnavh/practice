package dsa.graph;

import java.util.List;

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
