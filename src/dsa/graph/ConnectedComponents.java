package dsa.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponents {
    public static int countComponents(int n, int[][] edges) {
        int numberOfComponents = 0;
        boolean[] visited = new boolean[n+1];
        List<List<Integer>> adjList = GraphUtil.getAdjList(n, edges);

        for (int vertex = 0; vertex <= n; vertex++) {
            if (!visited[vertex]) {
                bfs(vertex, adjList, visited);
                numberOfComponents++;
            }
        }

        return numberOfComponents;
    }

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

    public static void main(String[] args) {
        int N = 7;
        int[][] edgeList = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 5}, {5, 7}, {2, 7}, {4,5}};

        System.out.println(countComponents(N, edgeList));
    }
}
