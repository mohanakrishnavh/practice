package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode Problem 323: Number of Connected Components in an Undirected Graph
 * Difficulty: Medium
 * 
 * <p>Find the number of connected components.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0323_NumberOfConnectedComponentsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int component = 0;

        // Initializing the adj list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Building the adj list
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // Maintains the nodes visited
        boolean[] visited = new boolean[n];

        // Call the BFS on the graph
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, adjList, visited);
                component++;
            }
        }

        return component;
    }

    public void bfs(int vertex, List<List<Integer>> adjList, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(vertex);
        visited[vertex] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adj : adjList.get(node)) {
                if (!visited[adj]) {
                    q.offer(adj);
                    visited[adj] = true;
                }
            }
        }
    }
}
