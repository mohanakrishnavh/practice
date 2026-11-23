package dsa.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * RottingOranges
 *
 * <p>Finds how many minutes it takes for every fresh orange to rot (LeetCode 994). Each minute, every fresh
 * orange that is horizontally or vertically adjacent to a rotten one becomes rotten. Cells are
 * {@code 0} = empty, {@code 1} = fresh orange, {@code 2} = rotten orange.
 *
 * <p><b>Idea:</b> multi-source BFS. Put <i>all</i> rotten oranges in the queue at time 0 so the rot spreads
 * from every source at once, level by level. Each queue entry carries its own minute, and the answer is the
 * largest minute reached. Counting the fresh oranges first and comparing with how many got rotted detects
 * the oranges that can never be reached.
 *
 * <p><b>Complexity:</b> Time O(R * C), Space O(R * C) for {@code visited} and the queue.
 *
 * <p><b>NOTE:</b> the input grid is left unchanged (a separate {@code visited} array is used). A null or
 * empty grid returns {@code -1}.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class RottingOranges {
    /**
     * Returns the minimum number of minutes until no fresh orange remains.
     *
     * @param grid a rectangular grid of {@code 0} (empty), {@code 1} (fresh) and {@code 2} (rotten)
     * @return the minutes needed; {@code 0} if there are no fresh oranges to begin with;
     *         {@code -1} if some fresh orange can never rot (or the grid is null or empty)
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        // Each queue entry is {row, column, minute at which this orange became rotten}
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }

                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // Case 0: No fresh oranges to rotten
        if (freshCount == 0) {
            return 0;
        }

        int time = 0, count = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] item = q.poll();
            int t = item[2];
            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {
                int nrow = item[0] + drow[i];
                int ncol = item[1] + dcol[i];
                int nt = t + 1;

                if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && !visited[nrow][ncol] && grid[nrow][ncol] == 1) {
                    q.offer(new int[]{nrow, ncol, nt});
                    visited[nrow][ncol] = true;
                    count++;
                }
            }
        }

        // Case 2: Unable to reach all fresh oranges
        if (freshCount != count) {
            return -1;
        }

        // Case 3: Rotting all fresh oranges
        return time;
    }

    /**
     * Demo: runs a few simple grids and prints the minutes each takes (or -1 if impossible).
     *
     * @param args unused
     */
    public static void main(String[] args) {
        RottingOranges solver = new RottingOranges();

        System.out.println(solver.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}})); // 4 (LeetCode example)
        System.out.println(solver.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}})); // -1 (bottom-left is cut off)
        System.out.println(solver.orangesRotting(new int[][]{{0, 2}}));                          // 0 (no fresh oranges)
        System.out.println(solver.orangesRotting(new int[][]{{0}}));                             // 0 (only an empty cell)
        System.out.println(solver.orangesRotting(new int[][]{{1}}));                             // -1 (fresh, but nothing is rotten)
        System.out.println(solver.orangesRotting(new int[][]{{2}}));                             // 0 (single rotten orange)
        System.out.println(solver.orangesRotting(new int[][]{{2, 1}}));                          // 1
        System.out.println(solver.orangesRotting(new int[][]{{2, 1, 1, 1, 1}}));                 // 4 (a single row)
        System.out.println(solver.orangesRotting(new int[][]{{2}, {1}, {1}}));                   // 2 (a single column)
        System.out.println(solver.orangesRotting(new int[][]{{2, 1, 2}}));                       // 1 (two sources rot the middle together)
        System.out.println(solver.orangesRotting(new int[][]{{2, 1, 1, 1, 2}}));                 // 2 (sources at both ends meet in the middle)
        System.out.println(solver.orangesRotting(new int[][]{{2, 0, 1}}));                       // -1 (an empty cell blocks the spread)
        System.out.println(solver.orangesRotting(new int[][]{{1, 1}, {1, 2}}));                  // 2 (rot spreads outward from a corner)
        System.out.println(solver.orangesRotting(new int[][]{{2, 1}, {1, 1}, {1, 2}}));          // 1 (every fresh orange touches a source)
        System.out.println(solver.orangesRotting(new int[][]{}));                                // -1 (empty grid)
    }
}
