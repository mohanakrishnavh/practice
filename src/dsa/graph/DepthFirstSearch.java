package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static List<Integer> depthFirstTraversal(int N, List<List<Integer>> adjList) {
        List<Integer> dfsTraversal = new ArrayList<>();
        boolean[] visited = new boolean[N];

        for (int vertex = 0; vertex < N; vertex++) {
            if (!visited[vertex]) {
                dfs(vertex, adjList, visited, dfsTraversal);
            }
        }

        return dfsTraversal;
    }

    private static void dfs(int vertex, List<List<Integer>> adjList, boolean[] visited, List<Integer> dfsTraversal) {
        dfsTraversal.add(vertex);
        visited[vertex] = true;

        for (int adj : adjList.get(vertex)) {
            if (!visited[adj]) {
                dfs(adj, adjList, visited, dfsTraversal);
            }
        }
    }

    public static void main(String[] args) {
        int N = 8;
        int[][] edgeList = new int[][]{{0, 1}, {1, 2}, {2, 4}, {4, 6}, {6, 7}, {2, 7}, {3, 5}};

        Graph graph = new Graph(N);
        graph.addUndirectedEdges(edgeList);
        System.out.println(depthFirstTraversal(graph.size(), graph.getAdjList()));
    }
}
