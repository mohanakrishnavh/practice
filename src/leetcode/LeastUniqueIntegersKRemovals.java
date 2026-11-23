package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LeastUniqueIntegersKRemovals
 * 
 * Finds the least number of unique integers left after removing exactly {@code k} elements.
 *
 * <p>Approach (greedy): Count occurrences and use a min heap ordered by count. Removing the
 * least frequent values first eliminates the most distinct integers per removal.
 *
 * <p>Time Complexity: O(n + d log d) where d is the number of distinct values.
 * Space Complexity: O(d).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class LeastUniqueIntegersKRemovals {
    /**
     * Returns the minimum number of distinct integers after removing {@code k} elements.
     *
     * @param arr the input array
     * @param k the number of elements to remove
     * @return the count of unique integers remaining
     */
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

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(LeastUniqueIntegersKRemovals.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        System.out.println(LeastUniqueIntegersKRemovals.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }
}
