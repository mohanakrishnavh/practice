package dsa.graph.bipartite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Bipartite
 * 
 * Checks whether a graph is bipartite, i.e. whether its vertices can be split into two sets such
 * that every edge connects vertices from different sets (equivalently, the graph has no odd-length cycle).
 *
 * <p>Uses BFS two-colouring: each vertex gets the opposite colour of the vertex it was discovered
 * from. If an edge joins two vertices of the same colour, the graph is not bipartite. Every
 * component is checked, so disconnected graphs are supported (LeetCode 785).
 *
 * <p>Time complexity: O(V + E). Space complexity: O(V).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Bipartite {

    /**
     * Determines whether the graph is bipartite.
     *
     * @param graph adjacency list where {@code graph[i]} holds the neighbours of vertex {@code i}
     * @return true if the graph can be two-coloured, false otherwise
     */
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int v = 0; v < V; v++) {
            if (color[v] == -1 && bfs(v, graph, color)) {
                return false;
            }
        }

        return true;
    }

    /**
     * BFS-colours the component containing {@code v}, detecting a same-colour edge.
     *
     * @param v     starting vertex
     * @param graph adjacency list of the graph
     * @param color colour per vertex: -1 uncoloured, 0 or 1 coloured; updated in place
     * @return true if an odd-length cycle (colour conflict) is found in this component
     */
    private boolean bfs(int v, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        color[v] = 1;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (int it : graph[node]) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Runs one test case and prints PASS or FAIL.
     *
     * @param name     a short description of the case
     * @param graph    adjacency list of the graph
     * @param expected whether the graph should be bipartite
     */
    private static void check(String name, int[][] graph, boolean expected) {
        boolean actual = new Bipartite().isBipartite(graph);
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " - " + name + " (expected " + expected + ", got " + actual + ")");
    }

    /**
     * Test driver covering typical and edge cases.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        // Bipartite graphs
        check("4-cycle (even cycle)", new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}, true);
        check("6-cycle (even cycle)", new int[][]{{1, 5}, {0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 0}}, true);
        check("single edge", new int[][]{{1}, {0}}, true);
        check("path", new int[][]{{1}, {0, 2}, {1, 3}, {2}}, true);
        check("star", new int[][]{{1, 2, 3}, {0}, {0}, {0}}, true);
        // Trees and forests have no cycles, so they are always bipartite
        check("two separate components, both bipartite", new int[][]{{1}, {0}, {3}, {2}}, true);

        // Not bipartite
        // Triangle 0-1-2: vertices 1 and 2 get the same colour but share an edge
        check("triangle (odd cycle)", new int[][]{{1, 2}, {0, 2}, {0, 1}}, false);
        check("5-cycle (odd cycle)", new int[][]{{1, 4}, {0, 2}, {1, 3}, {2, 4}, {3, 0}}, false);
        // LeetCode 785 example 1: triangle 0-1-2 plus vertex 3 attached to 0 and 2
        check("LeetCode 785 example 1", new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}, false);
        // The odd cycle is in a component not reachable from vertex 0, so every component must be checked
        check("odd cycle only in a later component", new int[][]{{1}, {0}, {3, 4}, {2, 4}, {2, 3}}, false);
        // A self-loop connects a vertex to itself, i.e. a cycle of length 1
        check("self-loop", new int[][]{{0}}, false);

        // Trivial inputs
        check("empty graph", new int[][]{}, true);
        check("single vertex, no edges", new int[][]{{}}, true);
        check("two isolated vertices", new int[][]{{}, {}}, true);
    }
}
