package dsa.graph.problems;

import java.util.Arrays;

/**
 * FloodFill
 *
 * <p>The "paint bucket" tool (LeetCode 733). Starting from a pixel, recolors that pixel and every pixel
 * connected to it horizontally or vertically (not diagonally) that has the <i>same original color</i>.
 * Another connected-components problem on an implicit grid graph (compare {@link NumbersOfIslands}).
 *
 * <p><b>Idea:</b> remember the starting pixel's color, then DFS in four directions, repainting each pixel
 * that still has that color. Painting a pixel also marks it as visited, so no separate {@code visited}
 * array is needed.
 *
 * <p><b>Complexity:</b> Time O(R * C), Space O(R * C) recursion depth in the worst case (the whole image
 * is one region).
 *
 * <p><b>NOTE:</b> the image is modified <b>in place</b> and the same array is returned. If the start pixel
 * already has the target color the method returns immediately; without that check the DFS would never
 * see a color change and would recurse forever.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FloodFill {
    /**
     * Recolors the region of same-colored pixels connected to {@code (sr, sc)}.
     *
     * @param image the image as a rectangular grid of colors; modified in place
     * @param sr    the start pixel's row (must be inside the image)
     * @param sc    the start pixel's column (must be inside the image)
     * @param color the new color
     * @return the same {@code image} array, after filling (returned untouched if it is null or empty,
     *         or if the start pixel already has {@code color})
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], color);

        return image;
    }

    /**
     * Repaints {@code (i, j)} and recurses into its four neighbours while they still have the source color.
     * Stops at the image edge and at pixels of a different color (including already repainted ones).
     *
     * @param image the image being filled, modified in place
     * @param i     the row of the current pixel
     * @param j     the column of the current pixel
     * @param src   the original color of the region being replaced
     * @param color the new color
     */
    private void dfs(int[][] image, int i, int j, int src, int color) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != src) {
            return;
        }

        image[i][j] = color;

        dfs(image, i + 1, j, src, color);
        dfs(image, i - 1, j, src, color);
        dfs(image, i, j + 1, src, color);
        dfs(image, i, j - 1, src, color);
    }

    /**
     * Demo: fills a few simple images and prints the result of each.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        FloodFill solver = new FloodFill();

        // LeetCode example: the connected 1s become 2; the 0s and the diagonal-only 1 are untouched
        print(solver.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2));
        // [[2, 2, 2], [2, 2, 0], [2, 0, 1]]

        // Start pixel already has the target color: image is returned unchanged
        print(solver.floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 0));
        // [[0, 0, 0], [0, 0, 0]]

        // Single pixel
        print(solver.floodFill(new int[][]{{5}}, 0, 0, 9));
        // [[9]]

        // Whole image is one region
        print(solver.floodFill(new int[][]{{1, 1}, {1, 1}}, 0, 1, 3));
        // [[3, 3], [3, 3]]

        // Diagonals do not connect: only the start pixel changes
        print(solver.floodFill(new int[][]{{1, 0}, {0, 1}}, 0, 0, 7));
        // [[7, 0], [0, 1]]

        // Start on a pixel inside a ring: only the inner region is filled
        print(solver.floodFill(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, 1, 1, 4));
        // [[1, 1, 1], [1, 4, 1], [1, 1, 1]]

        // Fill the ring instead: the inner 0 is not reachable, so it stays
        print(solver.floodFill(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, 0, 0, 4));
        // [[4, 4, 4], [4, 0, 4], [4, 4, 4]]

        // Single row
        print(solver.floodFill(new int[][]{{2, 2, 3, 2, 2}}, 0, 0, 8));
        // [[8, 8, 3, 2, 2]]

        // Single column, start in the middle of a region
        print(solver.floodFill(new int[][]{{1}, {1}, {0}, {1}}, 1, 0, 6));
        // [[6], [6], [0], [1]]

        // Empty image: returned as is
        print(solver.floodFill(new int[][]{}, 0, 0, 1));
        // []
    }

    /**
     * Prints an image on one line.
     *
     * @param image the image to print
     */
    private static void print(int[][] image) {
        System.out.println(Arrays.deepToString(image));
    }
}
