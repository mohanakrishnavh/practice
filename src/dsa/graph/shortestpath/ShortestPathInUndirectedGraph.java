package dsa.graph.shortestpath;

import dsa.graph.GraphUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ShortestPathInUndirectedGraph
 *
 * <p>Finds the shortest path (fewest edges) between two vertices of an unweighted, undirected
 * graph. Since every edge costs 1, BFS from the source reaches each vertex by its shortest route
 * first, so a vertex's distance only needs to be set when a shorter one is found. Vertices that
 * cannot be reached from the source end up with distance -1.
 *
 * <p>Time complexity: O(V + E). Space complexity: O(V) for the distance array and the queue.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ShortestPathInUndirectedGraph {

    /**
     * Returns the number of edges on the shortest path from {@code src} to {@code dest}.
     *
     * @param adjList adjacency list of the undirected graph (vertices labelled 0 to V-1)
     * @param src     the starting vertex
     * @param dest    the target vertex
     * @return the fewest edges from {@code src} to {@code dest}, or -1 if {@code dest} is unreachable
     */
    public int shortestPath(List<List<Integer>> adjList, int src, int dest) {
        int V = adjList.size();
        // distance[v] = fewest edges from src to v, MAX_VALUE until v is reached
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        // BFS from the source, which is at distance 0
        q.add(src);
        distance[src] = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int adj: adjList.get(node)) {
                // found a shorter route to adj through node
                if (distance[node] + 1 < distance[adj]) {
                    distance[adj] = distance[node] + 1;
                    q.offer(adj);
                }
            }
        }

        // vertices never reached have no path from src
        for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance[dest];
    }

    /**
     * Test driver using the two examples from the problem.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        ShortestPathInUndirectedGraph solver = new ShortestPathInUndirectedGraph();

        // Example 1: 0 -> 1 -> 2 -> 6 -> 8 has 4 edges
        int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {2, 6}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {6, 8}, {7, 8}};
        List<List<Integer>> adj = GraphUtil.getAdjList(9, edges);
        int result = solver.shortestPath(adj, 0, 8);
        System.out.println((result == 4 ? "PASS" : "FAIL") + " - Example 1 (expected 4, got " + result + ")");

        // Example 2: vertex 2 has no edges, so there is no path from 3 to 2
        edges = new int[][]{{3, 0}, {3, 1}};
        adj = GraphUtil.getAdjList(4, edges);
        result = solver.shortestPath(adj, 3, 2);
        System.out.println((result == -1 ? "PASS" : "FAIL") + " - Example 2 (expected -1, got " + result + ")");
    }
}
