package dsa.array.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = 0, idx = 0;
        int[] max = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        while (right < nums.length) {
            while (!deque.isEmpty() && deque.peekLast() < nums[right]) {
                deque.pollLast();
            }
            deque.addLast(nums[right]);

            if (right - left + 1 == k) {
                max[idx++] = deque.peekFirst();

                if (nums[left] == deque.peekFirst()) {
                    deque.pollFirst();
                }
                left++;
            }
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(List.of(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
