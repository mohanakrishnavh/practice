package dsa.dfs;

public class RatMaze {
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

    public static boolean dfs(int[][] maze, int x, int y, int[][] path) {
        int n = maze.length-1;
        int m = maze[0].length-1;

        if (x < 0 || x > n || y < 0 || y > m || maze[x][y] == 0) {
            return false;
        }

        if (x == n && y == m) {
            path[x][y] = 1;
            return true;
        }

        path[x][y] = 1;

        if (dfs(maze, x+1, y, path)) {
            return true;
        }

        if (dfs(maze, x, y+1, path)) {
            return true;
        }

        path[x][y] = 0;

        return false;
    }

    private static void print(int[][] maze) {
        for (int[] row : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(row[j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 0, 1, 1},
                {0, 0, 0, 1}
        };

        System.out.println(hasPath(maze));
    }
}
