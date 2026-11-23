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
            if (color[v] == -1 && hasOddLengthCycle(v, graph, color)) {
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
    private boolean hasOddLengthCycle(int v, int[][] graph, int[] color) {
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
}
