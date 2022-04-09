package dsa.heap;

import java.util.PriorityQueue;

public class ConnectRopes {
    private static int getMinimumCost(int[] ropeLengths) {
        if (ropeLengths.length <= 1) {
            return 0;
        }

        int cost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer ropeLength : ropeLengths) {
            minHeap.offer(ropeLength);
        }

        while (minHeap.size() >= 2) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            cost = cost + first + second;
            minHeap.add(first + second);
        }

        return cost;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumCost(new int[]{1, 2, 3, 4, 5}));
    }
}
