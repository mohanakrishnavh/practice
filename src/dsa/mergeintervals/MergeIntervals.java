package dsa.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MergeIntervals
 * 
 * Merges all overlapping intervals in a collection (LeetCode 56).
 *
 * <p>The intervals are sorted by start time; then a running [start, end] is extended while the next
 * interval begins at or before the current end, and emitted otherwise.
 *
 * <p>Time complexity: O(n log n) for the sort. Space complexity: O(n) for the result.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MergeIntervals {
    /**
     * Merges overlapping intervals. The input array is sorted in place.
     *
     * @param intervals intervals as [start, end] pairs
     * @return non-overlapping intervals covering the same ranges, sorted by start
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        // Sort the interval by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        // Initialize with first interval
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                merged.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // Add the last interval
        merged.add(new int[]{start, end});

        return merged.toArray(new int[merged.size()][]);
    }
}
