package dsa.heap.kwaymerge;

import java.util.PriorityQueue;

/**
 * KthSmallestNumberInASortedMatrix
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class KthSmallestNumberInASortedMatrix {
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
