package dsa.graph.problems;

/**
 * NumbersOfIslands
 *
 * <p>Counts the islands in a grid of {@code '1'} (land) and {@code '0'} (water) (LeetCode 200). An island is
 * a group of land cells connected horizontally or vertically (not diagonally). This is the connected-components
 * problem on an implicit graph where each cell is a vertex and its four neighbours are its edges
 * (compare {@link NumberOfProvinces}).
 *
 * <p><b>Idea:</b> scan every cell. Each unvisited land cell starts a new island, so run a DFS from it to mark
 * the whole island as visited, then add one to the count.
 *
 * <p><b>Complexity:</b> Time O(R * C), each cell is visited a constant number of times;
 * Space O(R * C) for {@code visited}, plus up to O(R * C) recursion depth for one huge island.
 *
 * <p><b>NOTE:</b> the input grid is left unchanged (a separate {@code visited} array is used).
 * A grid with zero rows ({@code new char[0][]}) throws {@link ArrayIndexOutOfBoundsException}.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class NumbersOfIslands {
    /**
     * Counts the islands in the grid.
     *
     * @param grid a rectangular grid of {@code '1'} (land) and {@code '0'} (water); must have at least one row
     * @return the number of islands
     */
    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    dfs(i, j, grid, visited);
                }
            }
        }

        return islands;
    }

    /**
     * Depth-first search that marks every land cell connected to {@code (i, j)} as visited.
     * Stops at the grid edge, at water, and at cells that were already visited.
     *
     * @param i       the row of the current cell
     * @param j       the column of the current cell
     * @param grid    the land / water grid
     * @param visited shared visited flags; updated in place
     */
    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        dfs(i + 1, j, grid, visited);
        dfs(i - 1, j, grid, visited);
        dfs(i, j + 1, grid, visited);
        dfs(i, j - 1, grid, visited);
    }

    /**
     * Demo: counts islands for a few simple grids.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        NumbersOfIslands solver = new NumbersOfIslands();

        System.out.println(solver.numIslands(grid("11110", "11010", "11000", "00000"))); // 1
        System.out.println(solver.numIslands(grid("11000", "11000", "00100", "00011"))); // 3
        System.out.println(solver.numIslands(grid("000", "000")));                       // 0 (all water)
        System.out.println(solver.numIslands(grid("111", "111")));                       // 1 (all land)
        System.out.println(solver.numIslands(grid("1")));                                // 1 (single land cell)
        System.out.println(solver.numIslands(grid("10", "01")));                         // 2 (diagonals do not connect)
        System.out.println(solver.numIslands(grid("0")));                                // 0 (single water cell)
        System.out.println(solver.numIslands(grid("101", "010", "101")));                // 5 (checkerboard: every land cell alone)
        System.out.println(solver.numIslands(grid("1101011")));                          // 3 (single row)
        System.out.println(solver.numIslands(grid("1", "1", "0", "1")));                 // 2 (single column)
        System.out.println(solver.numIslands(grid("111", "101", "111")));                // 1 (ring around water)
        System.out.println(solver.numIslands(grid("11111", "10001", "10101", "10001", "11111"))); // 2 (island inside a ring)
        System.out.println(solver.numIslands(grid("11100", "00100", "00111", "00001", "11111"))); // 1 (snake-shaped island)
        System.out.println(solver.numIslands(grid("")));                                 // 0 (a row with no columns)
    }

    /**
     * Builds a grid from rows written as strings, to keep the demo readable.
     *
     * @param rows one string per row, using '1' for land and '0' for water
     * @return the grid
     */
    private static char[][] grid(String... rows) {
        char[][] grid = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            grid[i] = rows[i].toCharArray();
        }

        return grid;
    }
}
