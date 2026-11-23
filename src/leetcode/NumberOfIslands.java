package leetcode;

/**
 * NumberOfIslands
 * 
 * Counts the islands in a binary grid.
 *
 * <p>Problem: An island is a group of 1s connected horizontally or vertically; 0s are water.
 *
 * <p>Approach: Scan every cell; each unvisited land cell starts a new island and a DFS marks
 * all of its connected land as visited.
 *
 * <p>Time Complexity: O(rows * cols). Space Complexity: O(rows * cols) for the visited grid
 * and recursion stack.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class NumberOfIslands {
    /**
     * Returns the number of islands in the grid.
     *
     * @param grid a matrix of 0s (water) and 1s (land)
     * @return the island count, or 0 for a null or empty grid
     */
    public static int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int island = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(i, j, grid, visited);
                    island++;
                }
            }
        }

        return island;
    }

    /**
     * Marks every land cell connected to {@code (row, col)} as visited.
     *
     * @param row the current row
     * @param col the current column
     * @param mat the grid
     * @param visited tracks cells already explored
     */
    private static void dfs(int row, int col, int[][] mat, boolean[][] visited) {
        if (row >= 0 && row < mat.length && col >= 0 && col < mat[0].length && mat[row][col] == 1 && !visited[row][col]) {
            visited[row][col] = true;
            dfs(row + 1, col, mat, visited);
            dfs(row, col + 1, mat, visited);
            dfs(row - 1, col, mat, visited);
            dfs(row, col - 1, mat, visited);
        }
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1},
                {0, 1, 0},
                {1, 1, 1}};

        System.out.println(NumberOfIslands.numIslands(mat));
    }
}
