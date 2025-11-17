package dsa.graph.topologicalsort;

import dsa.graph.Graph;

import java.util.*;

/**
 * TopologicalSort
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class TopologicalSort {
    // Kahn's Algorithm to find the topological order of nodes in a DAG
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

    // Topological Sorting using DFS
    public static List<Integer> topologicalSortUsingDfs(int n, List<List<Integer>> adjList) {
        List<Integer> topologicalOrder = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topologicalSortDfs(i, adjList, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            topologicalOrder.add(stack.pop());
        }

        return topologicalOrder;
    }

    private static void topologicalSortDfs(int node, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int adj : adjList.get(node)) {
            if (!visited[adj]) {
                topologicalSortDfs(adj, adjList, visited, stack);
            }
        }
        stack.push(node);
    }

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
    }
}
