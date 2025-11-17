package leetcode;

import java.util.PriorityQueue;

/**
 * MedianFinder
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.add(num);
        small.add(large.remove());

        if (small.size() > large.size()) {
            large.add(small.remove());
        }
    }

    public double findMedian() {
        if (large.size() > small.size()) {
            return large.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}
