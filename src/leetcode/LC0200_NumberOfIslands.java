package leetcode;

/**
 * LeetCode Problem 200: Number of Islands
 * Difficulty: Medium
 * 
 * <p>Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 * 
 * <p>An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * <p>Example 1:
 * <pre>
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>m == grid.length</li>
 *   <li>n == grid[i].length</li>
 *   <li>1 <= m, n <= 300</li>
 *   <li>grid[i][j] is '0' or '1'</li>
 * </ul>
 * 
 * <p>Time Complexity: O(m * n) where m is number of rows and n is number of columns
 * <p>Space Complexity: O(m * n) in worst case for the recursion stack (when entire grid is land)
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0200_NumberOfIslands {
    
    /**
     * Counts the number of distinct islands in the grid using Depth-First Search (DFS).
     * 
     * <p>Algorithm:
     * <ol>
     *   <li>Iterate through each cell in the grid</li>
     *   <li>When we find a '1' (unvisited land), increment island counter</li>
     *   <li>Perform DFS from that cell to mark all connected land cells as visited</li>
     *   <li>DFS marks cells as '0' to avoid revisiting them</li>
     *   <li>Continue until all cells are processed</li>
     * </ol>
     * 
     * <p>The DFS explores all four directions (up, down, left, right) from each land cell,
     * effectively "sinking" the entire island by marking all connected land as water.
     * 
     * @param grid the 2D character grid representing the map ('1' for land, '0' for water)
     * @return the total number of distinct islands in the grid
     */
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    /**
     * Performs depth-first search to mark all connected land cells as visited.
     * 
     * <p>This method recursively explores all adjacent land cells (up, down, left, right)
     * and marks them as '0' (water) to indicate they've been visited and are part of
     * the current island being counted.
     * 
     * <p>Base cases:
     * <ul>
     *   <li>Index out of bounds</li>
     *   <li>Current cell is water ('0')</li>
     * </ul>
     * 
     * @param i    the row index of the current cell
     * @param j    the column index of the current cell
     * @param grid the 2D grid being explored
     */
    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }
}
