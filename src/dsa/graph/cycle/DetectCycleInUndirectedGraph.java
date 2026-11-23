package dsa.graph.cycle;

import dsa.graph.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * DetectCycleInUndirectedGraph
 *
 * <p>Detects whether an undirected graph contains a cycle, using either Breadth-First Search
 * or Depth-First Search. Each traversal tracks the parent of every vertex: if a visited
 * neighbour is encountered that is not the parent, a back edge exists and therefore a cycle.
 * The graph may be disconnected, so a traversal is started from every unvisited vertex.
 *
 * <p>Time complexity: O(V + E). Space complexity: O(V) for the visited array and the
 * queue (BFS) or recursion stack (DFS).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class DetectCycleInUndirectedGraph {
    /**
     * Detects a cycle in an undirected graph using BFS.
     * Handles disconnected graphs by starting a BFS from each unvisited vertex.
     *
     * @param N       number of vertices (labelled 0 to N-1)
     * @param adjList adjacency list representation of the graph
     * @return true if the graph contains a cycle, false otherwise
     */
    public static boolean detectCycleUsingBFS(int N, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i] && checkForCycleBFS(i, adjList, visited)) {
                return true;
            }
        }

        return false;
    }

    /**
     * BFS from a single start vertex, carrying each node's parent in the queue.
     * A visited neighbour that is not the parent indicates a cycle.
     *
     * @param vertex  starting vertex of the traversal
     * @param adjList adjacency list representation of the graph
     * @param visited shared visited array, updated as vertices are discovered
     * @return true if a cycle is found in the component containing {@code vertex}
     */
    private static boolean checkForCycleBFS(int vertex, List<List<Integer>> adjList, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{vertex, -1});
        visited[vertex] = true;

        while (!q.isEmpty()) {
            int node = q.peek()[0];
            int prev = q.peek()[1];
            q.remove();

            for (int adj : adjList.get(node)) {
                if (!visited[adj]) {
                    q.offer(new int[]{adj, node});
                    visited[adj] = true;
                } else if (adj != prev) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Detects a cycle in an undirected graph using DFS.
     * Handles disconnected graphs by starting a DFS from each unvisited vertex.
     *
     * @param N       number of vertices (labelled 0 to N-1)
     * @param adjList adjacency list representation of the graph
     * @return true if the graph contains a cycle, false otherwise
     */
    public static boolean detectCycleUsingDFS(int N, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (checkForCycleDFS(i, -1, adjList, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Recursive DFS that passes the parent of the current vertex down the call chain.
     * A visited neighbour that is not the parent indicates a cycle.
     *
     * @param vertex   current vertex being explored
     * @param previous parent of {@code vertex} in the DFS tree (-1 for the root)
     * @param adjList  adjacency list representation of the graph
     * @param visited  shared visited array, updated as vertices are discovered
     * @return true if a cycle is found in the component reachable from {@code vertex}
     */
    private static boolean checkForCycleDFS(int vertex, int previous, List<List<Integer>> adjList, boolean[] visited) {
        visited[vertex] = true;
        for (int adj : adjList.get(vertex)) {
            if (!visited[adj]) {
                if (checkForCycleDFS(adj, vertex, adjList, visited)) {
                    return true;
                }
            } else {
                if (adj != previous) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Demo driver: runs both algorithms on a graph with a cycle (expected true, true)
     * and on a simple path graph without one (expected false, false).
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int N = 12;
        Graph graph = new Graph(N);
        graph.addUndirectedEdges(new int[][]{{0, 1}, {1, 2}, {2, 4}, {3, 5}, {5, 6}, {6, 7}, {7, 8}, {5, 10}, {10, 9}, {9, 8}, {8, 11}});
        System.out.println(detectCycleUsingBFS(graph.size(), graph.getAdjList()));
        System.out.println(detectCycleUsingDFS(graph.size(), graph.getAdjList()));

        graph = new Graph(4);
        graph.addUndirectedEdges(new int[][]{{0, 1}, {1, 2}, {2, 3}});
        System.out.println(detectCycleUsingBFS(graph.size(), graph.getAdjList()));
        System.out.println(detectCycleUsingDFS(graph.size(), graph.getAdjList()));
    }
}
