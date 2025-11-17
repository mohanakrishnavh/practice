package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * NQueens
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
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
        if (column == board.length) {
            result.add(buildBoard(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, column)) {
                board[row][column] = 'Q';
                solve(column+1, board, result);
                board[row][column] = '.';
            }
        }
    }

    // Approach 1 : Check the row and diagonals (towards the left)
    // Time Complexity: O(n^2)
    private boolean isSafe(char[][] board, int row, int column) {
        int x = row;
        int y = column;

        // Check if row has a queen
        while (column >= 0) {
            if (board[row][column] == 'Q') {
                return false;
            }

            column--;
        }

        // Check if the left-right diagonal has a queen
        column = y;
        while (row >= 0 && column >= 0) {
            if (board[row][column] == 'Q') {
                return false;
            }

            row--;
            column--;
        }


        // Check if the right-left diagonal has a queen
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

    private List<String> buildBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }

        return result;
    }

    // Approach 2: Using the precomputed upper and lower diagonal
    // Time Complexity : O(n)
    public List<List<String>> solveNQueens2(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }



    private void solve(int col, char[][] board, List < List < String >> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if (col == board.length) {
            res.add(buildBoard(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
}
