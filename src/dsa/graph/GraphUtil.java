package dsa.graph;

import java.util.List;

public class GraphUtil {
    public static List<List<Integer>> getAdjList(int N, int[][] edges) {
        Graph graph = new Graph(N);
        graph.addUndirectedEdges(edges);

        return graph.getAdjList();
    }

    public static int[][] getAdjMatrix(int N, int[][] edges) {
        Graph graph = new Graph(N);
        graph.addUndirectedEdges(edges);

        return graph.getAdjMatrix();
    }
}
