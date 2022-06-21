package dsa.graph.traversal;

import dsa.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public static List<Integer> breadthFirstTraversal(int n, List<List<Integer>> adjList) {
        List<Integer> bfsTraversal = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                bfs(vertex, adjList, visited, bfsTraversal);
            }
        }

        return bfsTraversal;
    }

    private static void bfs(int vertex, List<List<Integer>> adjList, boolean[] visited, List<Integer> bfsTraversal) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(vertex);
        visited[vertex] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            bfsTraversal.add(node);

            for (int adj : adjList.get(node)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    q.add(adj);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 8;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 5}, {5, 7}, {2, 7}, {4, 5}};

        Graph graph = new Graph(N);
        graph.addUndirectedEdges(edges);
        System.out.println(breadthFirstTraversal(graph.size(), graph.getAdjList()));
    }
}
