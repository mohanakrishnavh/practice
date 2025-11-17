package dsa.dfs;

/**
 * RatMaze
 * 
 * <p>This class solves the classic Rat in a Maze problem using Depth-First Search (DFS)
 * with backtracking. A rat starts at the top-left corner (0,0) and needs to reach the
 * bottom-right corner of the maze. The rat can only move right or down through cells
 * marked with 1, and cannot pass through cells marked with 0 (walls/obstacles).
 * 
 * <p>The solution finds one valid path (if it exists) and marks it in a separate path matrix.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class RatMaze {
    /**
     * Determines if there exists a path from the top-left to bottom-right corner of the maze.
     * 
     * <p>Uses DFS with backtracking to explore possible paths. If a valid path is found,
     * it prints the path matrix where 1 indicates the path taken.
     * 
     * <p>Time Complexity: O(2^(n*m)) in worst case (exploring all possible paths)
     * <p>Space Complexity: O(n*m) for the path matrix and recursion stack
     * 
     * @param maze a 2D array where 1 represents an open cell and 0 represents a blocked cell
     * @return true if a path exists from top-left to bottom-right, false otherwise
     */
    public static boolean hasPath(int[][] maze) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }

        int[][] path = new int[maze.length][maze[0].length];
        if (dfs(maze, 0, 0, path)) {
            print(path);
            return true;
        }

        return false;
    }

    /**
     * Performs DFS to find a path from the current position to the destination.
     * 
     * <p>The rat can only move right (x+1, y) or down (x, y+1). Uses backtracking:
     * marks the current cell in the path, explores all possible moves recursively,
     * and unmarks the cell if no path is found through it.
     * 
     * @param maze the maze grid where 1 is open and 0 is blocked
     * @param x the current row position
     * @param y the current column position
     * @param path the matrix tracking the current path being explored
     * @return true if a path to the destination exists from (x,y), false otherwise
     */
    public static boolean dfs(int[][] maze, int x, int y, int[][] path) {
        int n = maze.length - 1;
        int m = maze[0].length - 1;

        if (x < 0 || x > n || y < 0 || y > m || maze[x][y] == 0) {
            return false;
        }

        if (x == n && y == m) {
            path[x][y] = 1;
            return true;
        }

        path[x][y] = 1;

        if (dfs(maze, x + 1, y, path)) {
            return true;
        }

        if (dfs(maze, x, y + 1, path)) {
            return true;
        }

        path[x][y] = 0;

        return false;
    }

    /**
     * Prints the path matrix showing the route taken by the rat.
     * 
     * @param maze the path matrix where 1 indicates the cells in the path
     */
    private static void print(int[][] maze) {
        for (int[] row : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(row[j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 0, 1, 1},
                {0, 0, 0, 1}
        };

        System.out.println(hasPath(maze));
    }
}
