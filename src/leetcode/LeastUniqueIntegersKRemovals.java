package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastUniqueIntegersKRemovals {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i : arr) {
            counts.compute(i, (K, V) -> {
                if (V == null) {
                    V = 0;
                }
                V++;
                return V;
            });
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> counts.get(a) - counts.get(b));
        minHeap.addAll(counts.keySet());

        int removed = 0;
        while (!minHeap.isEmpty() && removed != k) {
            int num = minHeap.poll();
            int count = counts.get(num);
            while (count > 0 && removed != k) {
                count--;
                removed++;
            }

            if (count > 0) {
                minHeap.add(num);
                counts.put(num, count);
            }
        }

        return minHeap.size();
    }

    public static void main(String[] args) {
        System.out.println(LeastUniqueIntegersKRemovals.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        System.out.println(LeastUniqueIntegersKRemovals.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }
}
