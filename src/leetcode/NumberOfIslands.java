package leetcode;

public class NumberOfIslands {
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

    private static void dfs(int row, int col, int[][] mat, boolean[][] visited) {
        if (row >= 0 && row < mat.length && col >= 0 && col < mat[0].length && mat[row][col] == 1 && !visited[row][col]) {
            visited[row][col] = true;
            dfs(row + 1, col, mat, visited);
            dfs(row, col + 1, mat, visited);
            dfs(row - 1, col, mat, visited);
            dfs(row, col - 1, mat, visited);
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1},
                {0, 1, 0},
                {1, 1, 1}};

        System.out.println(NumberOfIslands.numIslands(mat));
    }
}
