package dsa.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == nums.length) {
            int maximum = Integer.MIN_VALUE;
            for (int num : nums) {
                maximum = Math.max(maximum, num);
            }

            return new int[]{maximum};
        }

        int i = 0;
        int j = 0;
        int index = 0;
        int[] maximum = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        while (j < nums.length) {
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }

            deque.addLast(nums[j]);

            if (j - i + 1 == k) {
                maximum[index++] = deque.peekFirst();

                if (nums[i] == deque.peekFirst()) {
                    deque.pollFirst();
                }

                i++;
            }

            j++;
        }

        return maximum;
    }

    public static void main(String[] args) {
        System.out.println(List.of(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
