package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode Problem 994: Rotting Oranges
 * Difficulty: Medium
 * 
 * <p>Find the minimum time for all oranges to rot.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0994_RottingOranges {

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int totalTime = 0;
        int freshOranges = 0;
        // {i, j, timestamp}
        Queue<int[]> q = new LinkedList<>();

        // Initialize the visited array and identify the number of fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});
                }

                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // There are no fresh oranges
        if (freshOranges == 0) {
            return 0;
        }

        int[] dRow = new int[]{0, -1, 0, 1};
        int[] dCol = new int[]{-1, 0, 1, 0};
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];

            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
                    int currentTime = time + 1;
                    q.offer(new int[]{nRow, nCol, currentTime});

                    // Rot the fresh orange
                    grid[nRow][nCol] = 2;
                    freshOranges--;

                    // If the time is greater than the total time, update it.
                    if (currentTime > totalTime) {
                        totalTime = currentTime;
                    }
                }
            }
        }

        // If we are unable to reach a fresh orange
        if (freshOranges != 0) {
            return -1;
        }

        return totalTime;
    }

    public static void main(String[] args){
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        System.out.println(orangesRotting(new int[][]{{0, 2}}));
    }
}
