package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {

    public int[][] getKClosestPoints(int[][] points, int k) {
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

        return maxHeap.toArray(new int[maxHeap.size()][]);
    }

    private int distance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }

    public static void main(String[] args) {
        KClosestPoints obj = new KClosestPoints();
        int[][] points = obj.getKClosestPoints(new int[][]{{1, 3}, {-2, 2}, {5, 8}, {0, 1}}, 2);

        for (int[] point: points) {
            System.out.println(Arrays.toString(point));
        }
    }
}
