package dsa.graph.shortestpath;

import java.net.Inet4Address;
import java.util.*;

/**
 * DijkstrasAlgorithm
 *
 * <p>Finds the shortest (minimum total weight) distance from source vertex 0 to every vertex of a
 * weighted graph whose edge weights are all non-negative.
 *
 * <p><b>Idea:</b> keep {@code distance[v]}, the best known cost from the source to {@code v}, and a
 * min-priority queue of {@code {vertex, distance}} pairs ordered by distance. Repeatedly take the
 * closest unsettled vertex and relax its edges: if going through it gives a neighbour a smaller
 * distance, update that distance and push the neighbour onto the queue. With non-negative weights,
 * the first time a vertex leaves the queue its distance is final.
 *
 * <p>Time complexity: O((V + E) log V) with a binary heap. Space complexity: O(V + E).
 *
 * <p>Example: V = 5, edges {0-1:2, 1-4:5, 1-2:4, 0-3:1, 3-2:3, 2-4:1} gives distances
 * [0, 2, 4, 1, 5]; vertex 4 is reached by 0 -> 3 -> 2 -> 4 with total weight 1 + 3 + 1 = 5.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class DijkstrasAlgorithm {

    /**
     * Returns the shortest distance from vertex 0 to every vertex.
     *
     * @param V     number of vertices (labelled 0 to V-1)
     * @param edges undirected edges as {@code {u, v, weight}} with non-negative weights
     * @return a list where index {@code v} is the shortest distance from vertex 0 to {@code v}, or
     *         {@code Integer.MAX_VALUE} if {@code v} is unreachable
     */
    public List<Integer> shortestPath(int V, int[][] edges) {
        List<List<int[]>> adjList = getAdjList(V, edges);

        List<Integer> distance = new ArrayList<>(Collections.nCopies(V, Integer.MAX_VALUE));
        distance.set(0, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            for (int[] adj : adjList.get(node[0])) {
                if (distance.get(node[0]) + adj[1] < distance.get(adj[0])) {
                    distance.set(adj[0], distance.get(node[0]) + adj[1]);

                    pq.offer(new int[]{adj[0], distance.get(adj[0])});
                }
            }

        }

        return distance;
    }


    /**
     * Builds an undirected weighted adjacency list for vertices {@code 0..V-1}; each edge is added
     * in both directions.
     *
     * @param V     number of vertices
     * @param edges undirected edges as {@code {u, v, weight}}
     * @return a list where index {@code v} holds {@code {neighbour, weight}} pairs for vertex {@code v}
     */
    private List<List<int[]>> getAdjList(int V, int[][] edges) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        return adjList;
    }

    /**
     * Test driver using the three examples from the problem, re-labelled to start at vertex 0.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        DijkstrasAlgorithm solver = new DijkstrasAlgorithm();

        // Example 1: vertex 4 is reached by 0 -> 3 -> 2 -> 4 with total weight 1 + 3 + 1 = 5
        int[][] edges = {{0, 1, 2}, {1, 4, 5}, {1, 2, 4}, {0, 3, 1}, {3, 2, 3}, {2, 4, 1}};
        List<Integer> distance = solver.shortestPath(5, edges);
        List<Integer> expected = Arrays.asList(0, 2, 4, 1, 5);
        System.out.println((expected.equals(distance) ? "PASS" : "FAIL") + " - Example 1 (expected " + expected + ", got " + distance + ")");

        // Example 2: vertex 5 has two shortest paths of weight 3 (0 -> 1 -> 3 -> 5 and 0 -> 2 -> 3 -> 5)
        edges = new int[][]{{0, 1, 1}, {0, 2, 1}, {1, 3, 1}, {2, 3, 1}, {3, 5, 1}, {1, 4, 2}, {4, 5, 1}};
        distance = solver.shortestPath(6, edges);
        expected = Arrays.asList(0, 1, 1, 2, 3, 3);
        System.out.println((expected.equals(distance) ? "PASS" : "FAIL") + " - Example 2 (expected " + expected + ", got " + distance + ")");

        // Example 3: vertices 3 and 4 are only connected to each other, so they are unreachable from 0
        edges = new int[][]{{0, 1, 4}, {1, 2, 2}, {3, 4, 1}};
        distance = solver.shortestPath(5, edges);
        expected = Arrays.asList(0, 4, 6, Integer.MAX_VALUE, Integer.MAX_VALUE);
        System.out.println((expected.equals(distance) ? "PASS" : "FAIL") + " - Example 3 (expected " + expected + ", got " + distance + ")");
    }
}
