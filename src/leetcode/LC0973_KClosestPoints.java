package leetcode;

import java.util.PriorityQueue;

public class LC0973_KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        if (points.length == k) {
            return points;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            int[] entry = new int[]{distance(points[i]), i};

            if (maxHeap.size() < k) {
                maxHeap.offer(entry);
            } else if (entry[0] < maxHeap.peek()[0]) {
                maxHeap.offer(entry);
                maxHeap.poll();
            }
        }


        int index = 0;
        int[][] kClosestPoints = new int[k][2];
        while (!maxHeap.isEmpty()) {
            kClosestPoints[index++] = points[maxHeap.poll()[1]];
        }

        return kClosestPoints;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
