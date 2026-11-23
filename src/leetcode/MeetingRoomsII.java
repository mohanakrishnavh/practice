package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * MeetingRoomsII
 * 
 * Computes the minimum number of conference rooms needed for a set of meetings.
 *
 * <p>Approach: Sort meetings by start time and keep a min heap of meetings ordered by end time,
 * one per occupied room. If the next meeting starts after the earliest-ending one finishes,
 * reuse that room; otherwise allocate a new one. The heap size is the answer.
 *
 * <p>Time Complexity: O(n log n). Space Complexity: O(n).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MeetingRoomsII {
    /**
     * Returns the minimum number of rooms required.
     *
     * @param intervals meeting time intervals as {@code [start, end]} pairs (sorted in place)
     * @return the number of rooms, or 0 if there are no meetings
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] earliest = minHeap.remove();

            if (current[0] >= earliest[1]) {
                earliest[1] = current[1];
            } else {
                minHeap.add(current);
            }

            minHeap.add(earliest);
        }

        return minHeap.size();
    }
}
