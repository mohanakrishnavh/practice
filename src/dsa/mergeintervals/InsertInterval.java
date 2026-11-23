package dsa.mergeintervals;

import java.util.ArrayList;
import java.util.List;

/**
 * InsertInterval
 * 
 * Inserts a new interval into a sorted list of non-overlapping intervals, merging where
 * necessary (LeetCode 57).
 *
 * <p>A single pass in three stages: copy intervals that end before the new one starts, merge all
 * intervals that overlap it by widening the new interval, then copy the remaining intervals.
 *
 * <p>Time complexity: O(n). Space complexity: O(n) for the result.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class InsertInterval {
    /**
     * Inserts and merges a new interval. Note that {@code newInterval} is modified in place while merging.
     *
     * @param intervals    sorted, non-overlapping intervals as [start, end] pairs
     * @param newInterval  interval to insert as [start, end]
     * @return the resulting sorted, non-overlapping intervals
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        merged.add(newInterval);

        while(i < intervals.length) {
            merged.add(intervals[i]);
            i++;
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
