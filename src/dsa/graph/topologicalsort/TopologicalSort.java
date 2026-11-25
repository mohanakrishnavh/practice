package dsa.graph.topologicalsort;

import dsa.graph.Graph;

import java.util.*;

/**
 * TopologicalSort
 * 
 * Topological sorting of a directed acyclic graph (DAG): a linear ordering of vertices such
 * that for every edge u -> v, u appears before v.
 *
 * <p>Two implementations are provided: Kahn's algorithm (BFS using in-degrees, which also detects
 * cycles) and a DFS-based approach that pushes a vertex onto a stack once all its descendants are
 * processed. Neither can order a graph with a cycle; Kahn's version reports it by returning null.
 *
 * <p>Time complexity: O(V + E). Space complexity: O(V).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class TopologicalSort {
    /**
     * Computes a topological order using Kahn's algorithm.
     *
     * <p>Vertices with in-degree 0 are processed first; removing one decrements the in-degree of its
     * neighbours, and any neighbour reaching 0 is queued. If fewer than {@code n} vertices were
     * processed, the graph has a cycle.
     *
     * @param n       number of vertices (labelled 0 to n-1)
     * @param adjList adjacency list of the directed graph
     * @return the vertices in topological order, or {@code null} if the graph contains a cycle
     */
    public static List<Integer> topologicalSort(int n, List<List<Integer>> adjList) {
        List<Integer> topologicalOrder = new ArrayList<>();

        // Calculate the indegree of the vertices
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int adj : adjList.get(i)) {
                indegree[adj]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int vertex = q.poll();
            topologicalOrder.add(vertex);
            for (int adj : adjList.get(vertex)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    q.offer(adj);
                }
            }
        }

        // If all the nodes indegree is not equal to zero
        // We have a cycle in the graph
        if (topologicalOrder.size() != n) {
            return null;
        }

        return topologicalOrder;
    }

    /**
     * Computes a topological order using DFS.
     *
     * <p>Cycles are detected with a three-state visited array (0 = unvisited, 2 = on the current
     * DFS path, 1 = fully explored), as in {@code DetectCycleInDirectedGraph}. Reaching a vertex that
     * is still on the current path means a back edge, so no topological order exists.
     *
     * @param n       number of vertices (labelled 0 to n-1)
     * @param adjList adjacency list of the directed graph
     * @return the vertices in topological order, or {@code null} if the graph contains a cycle
     */
    public static List<Integer> topologicalSortUsingDfs(int n, List<List<Integer>> adjList) {
        List<Integer> topologicalOrder = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (topologicalSortDfs(i, adjList, visited, stack)) {
                    return null;
                }
            }
        }

        while (!stack.isEmpty()) {
            topologicalOrder.add(stack.pop());
        }

        return topologicalOrder;
    }

    /**
     * DFS helper: visits all unvisited descendants of {@code vertex}, then pushes {@code vertex} onto the stack.
     * Also detects cycles by watching for a neighbour that is still on the current DFS path.
     *
     * @param vertex    current vertex
     * @param adjList adjacency list of the directed graph
     * @param visited state per vertex: 0 = unvisited, 2 = on the current DFS path, 1 = fully explored;
     *                updated in place
     * @param stack   stack collecting vertices in reverse topological order
     * @return true if a cycle is reachable from {@code vertex}, false otherwise
     */
    private static boolean topologicalSortDfs(int vertex, List<List<Integer>> adjList, int[] visited, Stack<Integer> stack) {
        visited[vertex] = 2;
        for (int adj : adjList.get(vertex)) {
            if (visited[adj] == 0) {
                if (topologicalSortDfs(adj, adjList, visited, stack)) {
                    return true;
                }
            } else if (visited[adj] == 2) {
                // back edge: adj is an ancestor on the current path, so this is a cycle
                return true;
            }
        }
        visited[vertex] = 1;
        stack.push(vertex);
        return false;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][]{{5, 0}, {5, 2}, {2, 3}, {3, 1}, {4, 0}, {4, 1}};
        Graph graph = new Graph(n);
        graph.addDirectedEdges(edges);
        System.out.println(topologicalSort(n, graph.getAdjList()));

        n = 4;
        edges = new int[][]{{0, 1}, {1, 2}, {3, 1}, {2, 3}};
        graph = new Graph(n);
        graph.addDirectedEdges(edges);
        assert (topologicalSort(n, graph.getAdjList()) == null);

        n = 6;
        edges = new int[][]{{5, 0}, {5, 2}, {2, 3}, {3, 1}, {4, 0}, {4, 1}};
        graph = new Graph(n);
        graph.addDirectedEdges(edges);
        System.out.println(topologicalSortUsingDfs(n, graph.getAdjList()));

        // DFS version: valid DAG gives an order, a cycle gives null
        // Sample DAG
        n = 6;
        edges = new int[][]{{5, 0}, {5, 2}, {2, 3}, {3, 1}, {4, 0}, {4, 1}};
        graph = new Graph(n);
        graph.addDirectedEdges(edges);
        List<Integer> order = topologicalSortUsingDfs(n, graph.getAdjList());
        System.out.println((order != null && order.equals(Arrays.asList(5, 4, 2, 3, 1, 0)) ? "PASS" : "FAIL")
                + " - sample DAG: " + order);

        // Diamond: 3 is reached twice but already finished the second time, so no cycle
        n = 4;
        edges = new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        graph = new Graph(n);
        graph.addDirectedEdges(edges);
        order = topologicalSortUsingDfs(n, graph.getAdjList());
        System.out.println((order != null && order.equals(Arrays.asList(0, 2, 1, 3)) ? "PASS" : "FAIL")
                + " - diamond: " + order);

        // Cycle 1 -> 2 -> 3 -> 1
        n = 4;
        edges = new int[][]{{0, 1}, {1, 2}, {3, 1}, {2, 3}};
        graph = new Graph(n);
        graph.addDirectedEdges(edges);
        order = topologicalSortUsingDfs(n, graph.getAdjList());
        System.out.println((order == null ? "PASS" : "FAIL") + " - cycle: " + order);

        // Self-loop
        n = 1;
        edges = new int[][]{{0, 0}};
        graph = new Graph(n);
        graph.addDirectedEdges(edges);
        order = topologicalSortUsingDfs(n, graph.getAdjList());
        System.out.println((order == null ? "PASS" : "FAIL") + " - self-loop: " + order);
    }
}
