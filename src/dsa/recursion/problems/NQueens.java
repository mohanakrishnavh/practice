package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * NQueens
 *
 * <p>Places n queens on an n x n board so that no two attack each other, returning every distinct
 * arrangement as a list of board strings ('Q' = queen, '.' = empty) (LeetCode 51).
 *
 * <p><b>Idea:</b> place one queen per <b>column</b>, left to right. For each column try every row; if the
 * square is safe, place the queen, recurse into the next column, then remove it (backtrack). Because each
 * column gets exactly one queen, only row and diagonal conflicts need checking.
 *
 * <p>Two ways to test safety:
 * <ol>
 *   <li>{@link #solveNQueens}: scan the row and both left-hand diagonals on every placement (O(n) per check).</li>
 *   <li>{@link #solveNQueens2}: keep lookup arrays for rows and the two diagonal directions (O(1) per check).
 *       Squares on the same "/" diagonal share {@code row + col}; squares on the same "\" diagonal share
 *       {@code (n - 1) + col - row} (offset keeps the index non-negative). Both range over 0..2n-2.</li>
 * </ol>
 *
 * <p><b>Complexity:</b> Time O(n!) roughly (heavily pruned), Space O(n^2) for the board (plus O(n) for hash arrays / stack).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> result = new ArrayList<>();
        solve(0, board, result);

        return result;
    }

    private void solve(int column, char[][] board, List<List<String>> result) {
        // Base case: all columns have a queen -> snapshot the board
        if (column == board.length) {
            result.add(buildBoard(board));
            return;
        }

        // Try each row in this column
        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, column)) {
                board[row][column] = 'Q';
                solve(column+1, board, result);
                board[row][column] = '.'; // backtrack
            }
        }
    }

    // Approach 1 : Check the row and diagonals (towards the left)
    // Only the LEFT side needs checking: columns to the right are still empty at this point.
    // Time Complexity: O(n) per safety check (O(n^2) is a loose bound across the whole check loop)
    private boolean isSafe(char[][] board, int row, int column) {
        // Remember the starting square; row/column are reused as walkers below
        int x = row;
        int y = column;

        // Check if row has a queen (walk left along the same row)
        while (column >= 0) {
            if (board[row][column] == 'Q') {
                return false;
            }

            column--;
        }

        // Check if the left-right diagonal has a queen (walk up-left)
        column = y;
        while (row >= 0 && column >= 0) {
            if (board[row][column] == 'Q') {
                return false;
            }

            row--;
            column--;
        }


        // Check if the right-left diagonal has a queen (walk down-left)
        row = x;
        column = y;
        while (row < board.length && column >= 0) {
            if (board[row][column] == 'Q') {
                return false;
            }

            row++;
            column--;
        }

        return true;
    }

    /** Converts the char grid into the list-of-strings format expected as output. */
    private List<String> buildBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }

        return result;
    }

    // Approach 2: Using the precomputed upper and lower diagonal
    // Safety check is O(1) using hash arrays (the "O(n)" figure applies to the recursion's extra space, not each check).
    public List<List<String>> solveNQueens2(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        int leftRow[] = new int[n];                 // leftRow[r] == 1 -> row r already has a queen
        int upperDiagonal[] = new int[2 * n - 1];   // index: (n - 1) + col - row
        int lowerDiagonal[] = new int[2 * n - 1];   // index: row + col
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }



    private void solve(int col, char[][] board, List < List < String >> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if (col == board.length) {
            res.add(buildBoard(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            // Safe only if neither the row nor either diagonal is occupied
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                // Place the queen and mark its row + both diagonals as taken
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                // Backtrack: unmark everything
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
}
