package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * KClosestPoints
 * 
 * Finds the k points closest to the origin (0, 0) using a max heap.
 *
 * <p>Problem: Given an array of 2D points and an integer k, return the k points with the
 * smallest Euclidean distance from the origin.
 *
 * <p>Example:
 * <pre>
 * Input: points = [[1, 3], [-2, 2], [5, 8], [0, 1]], k = 2
 * Output: [[-2, 2], [0, 1]]  (order may vary)
 * </pre>
 *
 * <p>Approach: Keep a max heap of size k ordered by squared distance. Add each point and,
 * when the heap grows beyond k, remove the farthest point. Squared distance is used since
 * it preserves ordering and avoids computing square roots.
 *
 * <p>Time Complexity: O(n log k)
 * <p>Space Complexity: O(k)
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class KClosestPoints {
    /**
     * Returns the k points closest to the origin.
     *
     * @param points array of [x, y] points
     * @param k      number of closest points to return
     * @return the k closest points in no particular order; the input array itself
     *         if it has k or fewer points
     */
    public static int[][] getKClosestPoints(int[][] points, int k) {
        if (points.length <= k) {
            return points;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> distance(b) - distance(a));
        for (int[] point : points) {
            maxHeap.add(point);

            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        // toArray accepts the dimension of the new array which it needs
        // to create. For example, here the output array contains maxHeap.size() rows
        // and 2 columns
        return maxHeap.toArray(new int[maxHeap.size()][2]);
    }

    /**
     * Computes the squared Euclidean distance of a point from the origin.
     *
     * @param point an [x, y] point
     * @return x*x + y*y
     */
    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    /**
     * Prints each point on its own line.
     *
     * @param points array of [x, y] points to print
     */
    private static void print(int[][] points) {
        for (int[] point : points) {
            System.out.println(Arrays.toString(point));
        }
    }

    /**
     * Main method to demonstrate finding the k closest points.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int[][] points = getKClosestPoints(new int[][]{{1, 3}, {-2, 2}, {5, 8}, {0, 1}}, 2);
        print(points);

        int[][] points2 = getKClosestPoints(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        print(points2);
    }
}
