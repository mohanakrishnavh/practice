package dsa.heap.kwaymerge;

import java.util.PriorityQueue;

/**
 * KthSmallestNumberInASortedMatrix
 * 
 * Finds the kth smallest number in a row-wise and column-wise sorted matrix.
 *
 * <p>Problem: Given an n x n matrix whose rows and columns are each sorted in ascending
 * order, find the kth smallest element in the matrix.
 *
 * <p>Example:
 * <pre>
 * Input: matrix = [[1, 5, 9], [10, 11, 13], [12, 13, 15]], k = 8
 * Output: 13
 * </pre>
 *
 * <p>Approach (K-way merge): Treat each row as a sorted list. Push the first cell of every
 * row into a min heap ordered by cell value, then repeatedly poll the smallest cell, counting
 * down k, and push the next cell in the same row. The kth polled cell is the answer.
 *
 * <p>Time Complexity: O(n + k log n)
 * <p>Space Complexity: O(n) for the heap
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class KthSmallestNumberInASortedMatrix {
    /**
     * Finds the kth smallest element in the sorted matrix.
     *
     * @param matrix an n x n matrix with sorted rows and columns
     * @param k      1-based rank of the element to find
     * @return the kth smallest element, or -1 if k exceeds the number of elements
     */
    public int kthSmallest(int[][] matrix, int k) {
        // [row, column]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, 0});
        }

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            k--;

            // If we have found the kth the smallest element
            if (k == 0) {
                return matrix[node[0]][node[1]];
            }

            int nextIndex = node[1] + 1;
            if (nextIndex < n) {
                pq.offer(new int[]{node[0], nextIndex});
            }
        }

        return -1;
    }
}
