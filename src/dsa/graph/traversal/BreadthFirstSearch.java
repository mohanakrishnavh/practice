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
        int n = 10;
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 4}, {0,8}, {1, 5}, {1, 6},{1, 9}, {2, 4}, {3, 7}, {3, 8}, {5, 8}, {6, 7}, {6, 9}};

        Graph graph = new Graph(n);
        graph.addUndirectedEdges(edges);
        System.out.println(breadthFirstTraversal(graph.size(), graph.getAdjList()));
    }
}
