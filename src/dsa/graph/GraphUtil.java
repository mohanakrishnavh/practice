package dsa.graph;

import java.util.List;

/**
 * GraphUtil
 * 
 * <p>Static convenience helpers that turn an edge list into a graph representation in one call.
 * Each helper builds a throwaway {@link Graph}, adds the edges as <b>undirected</b>, and returns
 * the requested representation (adjacency list or adjacency matrix).
 *
 * <p>Handy for LeetCode-style problems that give {@code n} and an {@code int[][] edges} array.
 * For directed edges, use {@link Graph#addDirectedEdges(int[][])} directly instead.
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class GraphUtil {
    /**
     * Builds an adjacency list for an undirected graph.
     *
     * @param n     the number of vertices (numbered {@code 0..n-1})
     * @param edges pairs {@code {a, b}}; each is added in both directions
     * @return a list where index {@code v} holds the neighbours of vertex {@code v}
     */
    public static List<List<Integer>> getAdjList(int n, int[][] edges) {
        Graph graph = new Graph(n);
        graph.addUndirectedEdges(edges);

        return graph.getAdjList();
    }

    /**
     * Builds an adjacency matrix for an undirected graph.
     *
     * @param n     the number of vertices (numbered {@code 0..n-1})
     * @param edges pairs {@code {a, b}}; each is added in both directions
     * @return a symmetric n x n matrix where {@code [a][b] == 1} means a and b are connected
     */
    public static int[][] getAdjMatrix(int n, int[][] edges) {
        Graph graph = new Graph(n);
        graph.addUndirectedEdges(edges);

        return graph.getAdjMatrix();
    }
}
