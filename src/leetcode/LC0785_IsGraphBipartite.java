package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem 785: Is Graph Bipartite
 * Difficulty: Medium
 * 
 * <p>Determine if a graph is bipartite.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0785_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int v = 0; v < V; v++) {
            if (color[v] == -1 && hasOddLengthCycle(v, graph, color)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasOddLengthCycle(int v, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        color[v] = 1;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (int it : graph[node]) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) {
                    return true;
                }
            }
        }

        return false;
    }
}
