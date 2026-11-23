package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * KthFactor
 * 
 * Finds the k-th smallest factor of {@code n}.
 *
 * <p>Approach: Walk candidate divisors up to sqrt(n); each divisor {@code i} also yields the
 * paired factor {@code n / i}. A max heap capped at size {@code k} keeps the k smallest factors,
 * so its top is the k-th smallest.
 *
 * <p>Time Complexity: O(sqrt(n) log k). Space Complexity: O(k).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class KthFactor {
    /**
     * Returns the k-th factor of {@code n} in ascending order.
     *
     * @param n the number to factorise
     * @param k the 1-based factor position
     * @return the k-th factor, or -1 if {@code n} has fewer than {@code k} factors
     */
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

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(KthFactor.kthFactor(12, 3));
        System.out.println(KthFactor.kthFactor(7, 2));
        System.out.println(KthFactor.kthFactor(4, 4));
        System.out.println(KthFactor.kthFactor(1, 1));
        System.out.println(KthFactor.kthFactor(1000, 3));
    }
}
