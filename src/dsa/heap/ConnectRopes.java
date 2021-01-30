package dsa.heap;

import java.util.PriorityQueue;

public class ConnectRopes {
    public int getMinimumCost(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int cost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer element : arr) {
            minHeap.add(element);
        }

        while(minHeap.size() >= 2) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            cost = cost+first+second;
            minHeap.add(first+second);
        }

        return cost;
    }

    public static void main(String[] args) {
        ConnectRopes obj = new ConnectRopes();
        System.out.println(obj.getMinimumCost(new int[]{1, 2, 3, 4, 5}));
    }
}
