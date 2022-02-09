package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthFactor {
    public static int kthFactor(int n, int k) {
        if (n < 0 || k < 0) {
            return -1;
        }

        if (k == 1) {
            return 1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(1);
        maxHeap.add(n);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                maxHeap.add(i);

                if (i != Math.sqrt(n)) {
                    maxHeap.add(n / i);
                }

                while (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        if (k > maxHeap.size()) {
            return -1;
        }

        return maxHeap.isEmpty() ? -1 : maxHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(KthFactor.kthFactor(12, 3));
        System.out.println(KthFactor.kthFactor(7, 2));
        System.out.println(KthFactor.kthFactor(4, 4));
        System.out.println(KthFactor.kthFactor(1, 1));
        System.out.println(KthFactor.kthFactor(1000, 3));
    }
}
