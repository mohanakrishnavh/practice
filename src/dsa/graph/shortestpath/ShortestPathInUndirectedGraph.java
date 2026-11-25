package dsa.graph.shortestpath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUndirectedGraph {
    public int shortestPath(List<List<Integer>> adjList, int src, int dest) {
        int V = adjList.size();
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        distance[src] = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int adj: adjList.get(node)) {
                if (distance[node] + 1 < distance[adj]) {
                    distance[adj] = distance[node] + 1;
                    q.offer(adj);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance[dest];
    }

    public static void main(String[] args) {
        ShortestPathInUndirectedGraph solver = new ShortestPathInUndirectedGraph();

        // Example 1: 0 -> 1 -> 2 -> 6 -> 8 has 4 edges
        List<List<Integer>> adj = Arrays.asList(
                Arrays.asList(1, 3), Arrays.asList(0, 2), Arrays.asList(1, 6),
                Arrays.asList(0, 4), Arrays.asList(3, 5), Arrays.asList(4, 6),
                Arrays.asList(2, 5, 7, 8), Arrays.asList(6, 8), Arrays.asList(6, 7));
        int result = solver.shortestPath(adj, 0, 8);
        System.out.println((result == 4 ? "PASS" : "FAIL") + " - Example 1 (expected 4, got " + result + ")");

        // Example 2: vertex 2 has no edges, so there is no path from 3 to 2
        adj = Arrays.asList(
                Arrays.asList(3), Arrays.asList(3), Arrays.asList(), Arrays.asList(0, 1));
        result = solver.shortestPath(adj, 3, 2);
        System.out.println((result == -1 ? "PASS" : "FAIL") + " - Example 2 (expected -1, got " + result + ")");
    }
}
