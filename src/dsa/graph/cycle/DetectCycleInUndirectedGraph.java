package dsa.graph.cycle;

import dsa.graph.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {
    public static boolean hasCycleUsingBfs(int N, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (bfs(i, adjList, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean bfs(int vertex, List<List<Integer>> adjList, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{vertex, -1});
        visited[vertex] = true;

        while (!q.isEmpty()) {
            int node = q.peek()[0];
            int previous = q.peek()[1];
            q.poll();

            for (int adj : adjList.get(node)) {
                if (!visited[adj]) {
                    q.offer(new int[]{adj, node});
                    visited[adj] = true;
                } else {
                    if (adj != previous) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean hasCycleUsingDfs(int N, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adjList, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(int vertex, int previous, List<List<Integer>> adjList, boolean[] visited) {
        visited[vertex] = true;
        for (int adj : adjList.get(vertex)) {
            if (!visited[adj]) {
                if (dfs(adj, vertex, adjList, visited)) {
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

    public static void main(String[] args) {
        int N = 12;
        Graph graph = new Graph(N);
        graph.addUndirectedEdges(new int[][]{{0, 1}, {1, 2}, {2, 4}, {3, 5}, {5, 6}, {6, 7}, {7, 8}, {5, 10}, {10, 9}, {9, 8}, {8, 11}});
        System.out.println(hasCycleUsingBfs(graph.size(), graph.getAdjList()));
        System.out.println(hasCycleUsingDfs(graph.size(), graph.getAdjList()));

        graph = new Graph(4);
        graph.addUndirectedEdges(new int[][]{{0, 1}, {1, 2}, {2, 3}});
        System.out.println(hasCycleUsingBfs(graph.size(), graph.getAdjList()));
        System.out.println(hasCycleUsingDfs(graph.size(), graph.getAdjList()));
    }
}
