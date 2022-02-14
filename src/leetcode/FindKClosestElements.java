package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        for (int value : arr) {
            priorityQueue.add(new int[]{Math.abs(x - value), value});

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        List<Integer> closestElements = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            closestElements.add(priorityQueue.poll()[1]);
        }

        Collections.sort(closestElements);
        return closestElements;
    }
}
