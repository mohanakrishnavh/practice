package dsa.graph.problems;

import dsa.graph.components.ConnectedComponents;

import java.util.LinkedList;
import java.util.Queue;

/**
 * NumberOfProvinces
 *
 * <p>Counts the provinces in a country given as an adjacency <i>matrix</i> (LeetCode 547). A province is a
 * group of cities that are directly or indirectly connected, so this is the connected-components problem
 * (compare {@link ConnectedComponents}, which takes an edge list instead).
 *
 * <p><b>Idea:</b> scan the cities in order. Each unvisited city starts a new province, so run a BFS from it
 * to mark every city reachable, then add one to the count.
 *
 * <p><b>Complexity:</b> Time O(V^2), because each city's whole matrix row is scanned once;
 * Space O(V) for {@code visited} and the queue.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class NumberOfProvinces {
    /**
     * Counts the provinces (connected groups of cities).
     *
     * @param isConnected an n x n symmetric matrix where {@code isConnected[i][j] == 1} means cities
     *                    {@code i} and {@code j} are directly connected (the diagonal is always 1)
     * @return the number of provinces (0 for an empty matrix)
     */
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];

        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                bfs(i, isConnected, visited);
                provinces++;
            }
        }

        return provinces;
    }

    /**
     * Breadth-first search that marks every city reachable from {@code v} as visited.
     * Cities are marked when enqueued, so each is queued at most once.
     *
     * @param v           the start city (must be unvisited)
     * @param isConnected the adjacency matrix
     * @param visited     shared visited flags; updated in place
     */
    private void bfs(int v, int[][] isConnected, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            Integer node = q.poll();
            int[] adj = isConnected[node];
            for (int i = 0; i < adj.length; i++) {
                if (isConnected[node][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    /**
     * Demo: counts provinces for a few simple matrices.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        NumberOfProvinces solver = new NumberOfProvinces();

        System.out.println(solver.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
        System.out.println(solver.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}})); // 3 (all isolated)
        System.out.println(solver.findCircleNum(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}})); // 1 (all connected)
        System.out.println(solver.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})); // 1 (0 and 2 linked via 1)
        System.out.println(solver.findCircleNum(new int[][]{{1}}));                             // 1 (single city)
        System.out.println(solver.findCircleNum(new int[][]{}));                                // 0 (no cities)
    }
}
