package dsa.heap.twoheaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * MedianFinder
 * 
 * Maintains a running median of a stream of numbers using two heaps.
 *
 * <p>Problem: Support adding numbers one at a time and retrieving the median of all
 * numbers added so far.
 *
 * <p>Approach (Two Heaps): A max heap holds the smaller half of the numbers and a min heap
 * holds the larger half. The heaps are kept balanced so the max heap has the same number of
 * elements as the min heap, or one more. The median is then the top of the max heap (odd count)
 * or derived from both tops (even count).
 *
 * <p>Time Complexity: O(log n) per {@code addNum}, O(1) per {@code findMedian}
 * <p>Space Complexity: O(n)
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MedianFinder {

    /** Max heap storing the smaller half of the numbers. */
    PriorityQueue<Integer> maxHeap;
    /** Min heap storing the larger half of the numbers. */
    PriorityQueue<Integer> minHeap;

    /**
     * Creates an empty MedianFinder.
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    /**
     * Adds a number to the data structure and rebalances the two heaps so the max heap
     * holds the same count as the min heap, or one more.
     *
     * @param num the number to add
     */
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    /**
     * Returns the median of all numbers added so far.
     *
     * @return the top of the max heap when the count is odd, or the value derived from
     *         both heap tops when the count is even
     */
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return minHeap.peek() + maxHeap.peek() / 2.0;
        }

        return maxHeap.peek();
    }
}
