package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC0785_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfs(i, color, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfs(int node, int[] color, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;

        while(!q.isEmpty()) {
            int n = q.poll();

            for (int it : graph[n]) {
                if (color[it] == -1) {
                    color[it] = 1 - color[n];
                    q.add(it);
                } else if (color[it] == color[n]) {
                    return false;
                }
            }
        }

        return true;
    }
}
