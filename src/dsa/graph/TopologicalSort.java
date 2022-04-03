package dsa.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class TopologicalSort {
    // Kahn's Algorithm to find the topological order of nodes in a DAG
    public static List<Integer> topologicalSort(int N, List<List<Integer>> adjList) {
        List<Integer> topologicalOrder = new ArrayList<>();

        // Calculate the indegree of the vertices
        int[] indegree = new int[N];
        for (int i = 0; i < N; i++) {
            for (int adj : adjList.get(i)) {
                indegree[adj]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
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
        if (topologicalOrder.size() != N) {
            return null;
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
        int N = 6;
        int[][] edges = new int[][]{{5, 0}, {5,2}, {2,3},{3,1}, {4,0}, {4,1}};
        Graph graph = new Graph(N);
        graph.addDirectedEdges(edges);
        System.out.println(topologicalSort(N, graph.getAdjList()));

        N = 4;
        edges = new int[][]{{0,1}, {1, 2}, {3,1}, {2,3}};
        graph = new Graph(N);
        graph.addDirectedEdges(edges);
        assert (topologicalSort(N, graph.getAdjList()) == null);
    }
}
