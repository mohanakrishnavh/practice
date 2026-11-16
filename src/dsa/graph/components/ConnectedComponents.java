package dsa.graph.components;

import dsa.graph.GraphUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ConnectedComponents
 * 
 * <p>Counts the connected components of an undirected graph (LeetCode 323).
 * A component is a maximal group of vertices that can all reach each other; an isolated vertex
 * is a component on its own.
 *
 * <p><b>Idea:</b> scan the vertices in order. Every time an unvisited vertex is found it starts a
 * brand-new component, so run a BFS from it to mark everything reachable, then add one to the count.
 *
 * <p><b>Complexity:</b> Time O(V + E), Space O(V + E) for the adjacency list plus O(V) for
 * {@code visited} and the BFS queue.
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ConnectedComponents {
    /**
     * Counts the connected components of an undirected graph.
     *
     * @param n     the number of vertices (numbered {@code 0..n-1})
     * @param edges pairs {@code {a, b}} describing undirected edges
     * @return the number of connected components (0 when {@code n == 0})
     */
    public static int countComponents(int n, int[][] edges) {
        int components = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = GraphUtil.getAdjList(n, edges);

        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                bfs(vertex, adjList, visited);
                components++;
            }
        }

        return components;
    }

    /**
     * Breadth-first search that marks every vertex reachable from {@code vertex} as visited.
     * Vertices are marked when they are enqueued, so each is queued at most once.
     *
     * @param vertex  the start vertex (must be unvisited)
     * @param adjList the adjacency list of the graph
     * @param visited shared visited flags; updated in place
     */
    private static void bfs(int vertex, List<List<Integer>> adjList, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(vertex);
        visited[vertex] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adj : adjList.get(node)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    q.add(adj);
                }
            }
        }
    }

    /**
     * Demo: counts components for connected, isolated-vertex, edgeless and multi-component graphs.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        int N = 8;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 5}, {5, 7}, {2, 7}, {4, 5}};

        System.out.println(countComponents(N, edges));                                   // 2 (vertex 6 is isolated)
        System.out.println(countComponents(0, new int[][]{}));                           // 0 (no vertices)
        System.out.println(countComponents(1, new int[][]{}));                           // 1
        System.out.println(countComponents(4, new int[][]{}));                           // 4 (no edges: every vertex alone)
        System.out.println(countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));     // 2
        System.out.println(countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}})); // 1 (a path)
        System.out.println(countComponents(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));     // 1 (a cycle)
    }
}
