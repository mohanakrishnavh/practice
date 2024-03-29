package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {
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

    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private static void print(int[][] points) {
        for (int[] point : points) {
            System.out.println(Arrays.toString(point));
        }
    }

    public static void main(String[] args) {
        int[][] points = getKClosestPoints(new int[][]{{1, 3}, {-2, 2}, {5, 8}, {0, 1}}, 2);
        print(points);

        int[][] points2 = getKClosestPoints(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        print(points2);
    }
}
