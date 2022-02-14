package leetcode;

import java.util.PriorityQueue;

public class FindKthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            priorityQueue.add(num);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.isEmpty() ? -1 : priorityQueue.peek();
    }
}
