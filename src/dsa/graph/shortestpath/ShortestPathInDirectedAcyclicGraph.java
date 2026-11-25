package dsa.graph.shortestpath;

import java.util.*;

public class ShortestPathInDirectedAcyclicGraph {
    public List<Integer> shortestPath(int V, int[][] edges) {
        List<List<int[]>> adjList = getAdjList(V, edges);
        List<Integer> distance = new ArrayList<>(Collections.nCopies(V, Integer.MAX_VALUE));

        // Step 1: Find topological ordering
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                topologicalSort(i, adjList, visited, stack);
            }
        }

        // Step 2: Update the distance for all nodes
        distance.set(0, 0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (distance.get(node) != Integer.MAX_VALUE) {
                for (int[] adj : adjList.get(node)) {
                    if (distance.get(node) + adj[1] < distance.get(adj[0])) {
                        distance.set(adj[0], distance.get(node) + adj[1]);
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (distance.get(i) == Integer.MAX_VALUE) distance.set(i, -1);
        }

        return distance;

    }

    private List<List<int[]>> getAdjList(int V, int[][] edges) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        return adjList;
    }

    private void topologicalSort(int vertex, List<List<int[]>> adjList, int[] visited, Stack<Integer> stack) {
        visited[vertex] = 2;

        for (int[] adj : adjList.get(vertex)) {
            if (visited[adj[0]] == 0) {
                topologicalSort(adj[0], adjList, visited, stack);
            }
        }

        visited[vertex] = 1;
        stack.push(vertex);
    }
}
