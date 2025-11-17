package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem 547: Number of Provinces
 * Difficulty: Medium
 * 
 * <p>Find the total number of provinces.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0547_NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected[0].length];
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                bfsTraversal(i, isConnected, visited);
                provinces++;
            }
        }

        return provinces;
    }

    private void bfsTraversal(int vertex, int[][] isConnected, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(vertex);
        visited[vertex] = true;
        while(!q.isEmpty()) {
            int vertexIndex = q.poll();
            int[] adjList = isConnected[vertexIndex];
            for (int i = 0; i < adjList.length; i++) {
                if (adjList[i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
