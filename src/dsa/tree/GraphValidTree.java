package dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * GraphValidTree
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class GraphValidTree {
    // Graph is a tree if it has no cycle and has only one strongly connected component
    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) {
            return true;
        }

        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = getAdjList(n, edges);
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (hasCycle(i, visited, adjList)) {
                    return false;
                }
                components++;
            }

            if (components > 1) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int start, boolean[] visited, List<List<Integer>> adjList) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, -1});
        visited[start] = true;

        while(!q.isEmpty()) {
            int node = q.peek()[0];
            int previous = q.peek()[1];
            q.remove();

            for(int adj : adjList.get(node)) {
                if (!visited[adj]) {
                    q.add(new int[]{adj, node});
                    visited[adj] = true;
                } else if (adj != previous) {
                    return true;
                }
            }
        }

        return false;
    }

    private List<List<Integer>> getAdjList(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return adjList;
    }
}
