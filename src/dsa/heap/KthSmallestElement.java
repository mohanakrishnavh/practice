package dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    /**
     * Returns the kth smallest element in an unsorted array
     *
     * Time Complexity : O(n) - n is the length of the array
     * Space Complexity : O(k) - k is the size of the heap
     */
    public static int getKthSmallestElement(int[] nums, int k) {
        if (nums.length == 0 || k <= 0 || k > nums.length) {
            return -1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            maxHeap.add(i);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.isEmpty() ? -1 : maxHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(KthSmallestElement.getKthSmallestElement(new int[]{7, 10, 4, 3, 20, 15}, 3));
    }
}
