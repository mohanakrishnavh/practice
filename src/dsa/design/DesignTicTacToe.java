package dsa.design;

/**
 * DesignTicTacToe
 * 
 * <p>This class provides an optimized implementation of a Tic-Tac-Toe game that can determine
 * the winner in O(1) time per move. Uses arrays to track the sum of moves in each row, column,
 * and diagonal. Player 1 adds +1 and Player 2 adds -1, so when any line reaches ±n, that player wins.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class DesignTicTacToe {
    /**
     * Implementation of a Tic-Tac-Toe game with optimized winner detection.
     */
    public class TicTacToe {
        int[] rows;
        int[] cols;
        int diagonal;
        int antiDiagonal;

        /**
         * Initializes the Tic-Tac-Toe game with a board of size n x n.
         * 
         * <p>Time Complexity: O(n)
         * <p>Space Complexity: O(n)
         * 
         * @param n the size of the board (n x n)
         */
        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
        }

        /**
         * Makes a move for a player at the specified position and checks if this move wins the game.
         * 
         * <p>Uses a clever technique where Player 1 adds +1 and Player 2 adds -1 to the respective
         * row, column, and diagonals. When the absolute value of any sum equals n, that player wins.
         * 
         * <p>Time Complexity: O(1) per move
         * <p>Space Complexity: O(1) per move
         * 
         * @param row the row index (0-indexed)
         * @param col the column index (0-indexed)
         * @param player the player number (1 or 2)
         * @return the player number if they win with this move, otherwise 0
         */
        public int move(int row, int col, int player) {
            int currentPlayer = (player == 1) ? 1 : -1;
            // update currentPlayer in rows and cols arrays
            rows[row] += currentPlayer;
            cols[col] += currentPlayer;
            // update diagonal
            if (row == col) {
                diagonal += currentPlayer;
            }
            //update anti diagonal
            if (col == (cols.length - row - 1)) {
                antiDiagonal += currentPlayer;
            }
            int n = rows.length;
            // check if the current player wins
            if (Math.abs(rows[row]) == n ||
                    Math.abs(cols[col]) == n ||
                    Math.abs(diagonal) == n ||
                    Math.abs(antiDiagonal) == n) {
                return player;
            }
            // No one wins
            return 0;
        }
    }
}
