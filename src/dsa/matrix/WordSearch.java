package dsa.matrix;

/**
 * WordSearch
 * 
 * Checks whether a word can be formed by a path of sequentially adjacent (up, down, left,
 * right) cells in a character grid, using each cell at most once (LeetCode 79).
 *
 * <p>Backtracking DFS: a search is started from each cell matching the first letter. Visited cells are
 * temporarily overwritten with '#' and restored on backtrack.
 *
 * <p>Time complexity: O(m * n * 4^L) where L is the word length. Space complexity: O(L) for the recursion.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class WordSearch {

    /**
     * Returns whether the word exists in the grid.
     *
     * @param board the character grid
     * @param word  the word to find
     * @return true if the word can be traced in the grid, false otherwise (also false for null/empty input)
     */
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Backtracking helper that tries to match {@code word[count..]} starting at cell (i, j).
     *
     * @param board the character grid; cells are temporarily modified and restored
     * @param i     current row
     * @param j     current column
     * @param count index of the next word character to match
     * @param word  the word being searched for
     * @return true if the remainder of the word can be matched from this cell
     */
    private static boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(board, i + 1, j, count + 1, word) ||
                dfs(board, i - 1, j, count + 1, word) ||
                dfs(board, i, j + 1, count + 1, word) ||
                dfs(board, i, j - 1, count + 1, word);
        board[i][j] = temp;

        return found;
    }

}
