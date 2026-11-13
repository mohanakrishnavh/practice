package dsa.heap.kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * KthSmallestInMSortedList
 * 
 * Finds the kth smallest number across M sorted arrays using a min heap.
 *
 * <p>Problem: Given M sorted arrays and a number k, find the kth smallest number among
 * all the elements of all the arrays.
 *
 * <p>Example:
 * <pre>
 * Input: lists = [[2, 6, 8], [3, 6, 7], [1, 3, 4]], k = 5
 * Output: 4  (merged order: 1, 2, 3, 3, 4, 6, 6, 7, 8)
 * </pre>
 *
 * <p>Approach (K-way merge): Put the first element of every array into a min heap as
 * [value, arrayIndex, elementIndex]. Repeatedly poll the smallest, counting down k, and push
 * the next element from the same array. The kth polled element is the answer.
 *
 * <p>Time Complexity: O(k log M) where M is the number of arrays
 * <p>Space Complexity: O(M) for the heap
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class KthSmallestInMSortedList {
    /**
     * Finds the kth smallest number across all the given sorted arrays.
     *
     * @param lists the sorted arrays (each in ascending order and non-empty)
     * @param k     1-based rank of the element to find
     * @return the kth smallest number, or -1 if there are fewer than k elements in total
     */
    public static int findKthSmallest(List<int[]> lists, int k) {
        // [value, arrayIndex, elementIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < lists.size(); i++) {
            pq.offer(new int[]{lists.get(i)[0], i, 0});
        }

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            k--;

            // If we have found the kth the smallest element
            if (k == 0) {
                return node[0];
            }

            int nextIndex = node[2] + 1;
            if (nextIndex < lists.get(node[1]).length) {
                pq.offer(new int[]{lists.get(node[1])[nextIndex], node[1], nextIndex});
            }
        }

        return -1;
    }

    /**
     * Main method to demonstrate finding the kth smallest number across sorted arrays.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int[] l1 = new int[] { 2, 6, 8 };
        int[] l2 = new int[] { 3, 6, 7 };
        int[] l3 = new int[] { 1, 3, 4 };
        List<int[]> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedList.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
