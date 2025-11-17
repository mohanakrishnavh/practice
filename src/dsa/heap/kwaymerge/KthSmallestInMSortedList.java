package dsa.heap.kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * KthSmallestInMSortedList
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class KthSmallestInMSortedList {
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
