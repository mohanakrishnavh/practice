package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC0703_KthLargestElementInAStream {
    PriorityQueue<Integer> pq;
    int k;

    public LC0703_KthLargestElementInAStream(int k, int[] nums) {
        this.pq = new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;

        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public static void main(String[] args) {
        LC0703_KthLargestElementInAStream kthLargest = new LC0703_KthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    public int add(int val) {
        pq.add(val);

        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
