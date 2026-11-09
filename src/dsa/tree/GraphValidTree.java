package dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * GraphValidTree
 * 
 * Graph Valid Tree (LeetCode 261): an undirected graph with {@code n} nodes is a tree iff it is connected and has no
 * cycle. BFS explores each component, tracking the parent to detect cycles, and fails on a cycle or a second component.
 *
 * <p><b>Complexity:</b> Time O(n + e), Space O(n + e).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class GraphValidTree {
    // Graph is a tree if it has no cycle and has only one strongly connected component
    /**
     * Checks whether an undirected graph is a valid tree: connected (one component) and acyclic.
     *
     * @param n     number of nodes, labelled {@code 0..n-1}
     * @param edges undirected edges {@code [a, b]}
     * @return {@code true} if the graph is a tree
     */
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

    /**
     * BFS from {@code start} marking nodes visited; a visited neighbour that is not the node we came from means a cycle.
     *
     * @param start   node to start the BFS from
     * @param visited shared visited flags, updated as the component is explored
     * @param adjList adjacency list of the graph
     * @return {@code true} if the component containing {@code start} has a cycle
     */
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

    /**
     * Builds an undirected adjacency list.
     *
     * @param n     number of nodes
     * @param edges undirected edges {@code [a, b]}
     * @return adjacency list indexed by node
     */
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
