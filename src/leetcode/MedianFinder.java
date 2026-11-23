package leetcode;

import java.util.PriorityQueue;

/**
 * MedianFinder
 * 
 * Maintains the median of a stream of integers using two heaps.
 *
 * <p>Approach: A max heap ({@code small}) holds the lower half and a min heap ({@code large})
 * holds the upper half, kept balanced so {@code large} is never smaller than {@code small}.
 * The median is the top of {@code large}, or the average of both tops for an even count.
 *
 * <p>Time Complexity: O(log n) per {@code addNum}, O(1) per {@code findMedian}.
 * Space Complexity: O(n).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    /**
     * Creates an empty MedianFinder.
     */
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }

    /**
     * Adds a number to the data stream.
     *
     * @param num the number to add
     */
    public void addNum(int num) {
        large.add(num);
        small.add(large.remove());

        if (small.size() > large.size()) {
            large.add(small.remove());
        }
    }

    /**
     * Returns the median of all numbers added so far.
     *
     * @return the current median
     */
    public double findMedian() {
        if (large.size() > small.size()) {
            return large.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}
