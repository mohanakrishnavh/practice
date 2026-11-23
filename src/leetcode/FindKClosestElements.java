package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * FindKClosestElements
 * 
 * Finds the {@code k} elements closest to a given value {@code x}.
 *
 * <p>Approach: Maintain a max heap of size {@code k} keyed by (distance to {@code x}, value).
 * Whenever the heap grows beyond {@code k}, the farthest element (larger value on ties) is
 * evicted. The survivors are sorted before being returned.
 *
 * <p>Time Complexity: O(n log k). Space Complexity: O(k).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FindKClosestElements {
    /**
     * Returns the {@code k} closest elements to {@code x}, in ascending order.
     *
     * @param arr the input array
     * @param k how many elements to return
     * @param x the target value
     * @return a sorted list of the k closest values (smaller values win distance ties)
     */
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
