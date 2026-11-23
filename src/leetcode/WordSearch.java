package leetcode;

/**
 * WordSearch
 * 
 * Determines whether a word can be formed from adjacent cells of a character grid.
 *
 * <p>Approach: Backtracking DFS from every cell matching the first letter. Visited cells are
 * temporarily marked with '#' so a cell is not reused within one path, and restored on backtrack.
 *
 * <p>Time Complexity: O(rows * cols * 3^L) where L is the word length. Space Complexity: O(L)
 * for the recursion stack.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class WordSearch {
    /**
     * Returns whether {@code word} exists in the board.
     *
     * @param board the grid of characters
     * @param word the word to find
     * @return true if the word can be built from horizontally or vertically adjacent cells
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
     * Tries to match {@code word} starting at character index {@code count} from cell {@code (i, j)}.
     *
     * @param board the grid (cells are marked and restored during the search)
     * @param i the current row
     * @param j the current column
     * @param count the index of the next word character to match
     * @param word the target word
     * @return true if the remainder of the word is found
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

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(WordSearch.exist(board, "ABCCED"));
    }
}
