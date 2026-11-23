package dsa.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * CourseScheduleII
 * 
 * <p>Returns an order in which all courses can be taken given their prerequisites (LeetCode 210).
 * A pair {@code {a, b}} means "to take course {@code a} you must first take course {@code b}".
 * This is a topological sort of the graph with an edge {@code b -> a}; it exists only if the graph has
 * no cycle. The yes/no version of the question is {@link CourseSchedule}.
 *
 * <p><b>Idea:</b> Kahn's algorithm (BFS). Count each course's {@code indegree} (unmet prerequisites),
 * queue every course that has none, then repeatedly take a course, write it to the answer and unlock the
 * courses that depended on it. If fewer than {@code numCourses} courses were taken, a cycle blocked the rest.
 *
 * <p><b>Complexity:</b> Time O(V + E), Space O(V + E) for the adjacency list, plus O(V) for
 * {@code indegree}, the queue and the answer.
 *
 * <p><b>NOTE:</b> several valid orders usually exist. This one is deterministic: courses with no
 * prerequisites are taken in increasing numeric order, and newly unlocked courses queue behind them (FIFO).
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class CourseScheduleII {
    /**
     * Finds an order in which every course can be taken.
     *
     * @param numCourses    the number of courses, labelled {@code 0..numCourses-1}
     * @param prerequisites pairs {@code {a, b}}: course {@code b} must be taken before course {@code a}
     * @return a valid order containing every course exactly once, or an <b>empty array</b> if the
     *         prerequisites contain a cycle (including a course that requires itself) so no order exists
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list
        // Update the indegree of the sink node
        for (int[] prerequisite: prerequisites) {
            // Add the sink node to the adjList of the source node
            adjList.get(prerequisite[1]).add(prerequisite[0]);

            // Updating the indegree of the sink node
            indegree[prerequisite[0]]++;
        }


        int[] topoOrder = new int[numCourses];
        int processed = 0;
        Queue<Integer> q = new LinkedList<>();

        //Identify the source nodes and add it to the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Run BFS and remove the source nodes that have been processed
        while(!q.isEmpty()) {
            Integer node = q.poll();
            topoOrder[processed++] = node;

            for (int adj : adjList.get(node)) {
                indegree[adj]--;

                if (indegree[adj] == 0) {
                    q.add(adj);
                }
            }
        }

        // Fewer courses taken than exist -> a cycle blocked some of them -> no valid order
        return processed != numCourses ? new int[]{} : topoOrder;
    }

    /**
     * Demo: prints the order found for a few simple prerequisite setups.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        CourseScheduleII solver = new CourseScheduleII();

        System.out.println(Arrays.toString(solver.findOrder(2, new int[][]{{1, 0}})));                         // [0, 1]
        System.out.println(Arrays.toString(solver.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}))); // [0, 1, 2, 3] (diamond)
        System.out.println(Arrays.toString(solver.findOrder(2, new int[][]{{1, 0}, {0, 1}})));                 // [] (0 and 1 need each other)
        System.out.println(Arrays.toString(solver.findOrder(1, new int[][]{})));                               // [0]
        System.out.println(Arrays.toString(solver.findOrder(3, new int[][]{})));                               // [0, 1, 2] (no prerequisites)
        System.out.println(Arrays.toString(solver.findOrder(1, new int[][]{{0, 0}})));                         // [] (a course requiring itself)
        System.out.println(Arrays.toString(solver.findOrder(3, new int[][]{{1, 0}, {2, 1}})));                 // [0, 1, 2] (chain)
        System.out.println(Arrays.toString(solver.findOrder(3, new int[][]{{0, 1}, {1, 2}})));                 // [2, 1, 0] (chain pointing the other way)
        System.out.println(Arrays.toString(solver.findOrder(3, new int[][]{{1, 0}, {2, 1}, {0, 2}})));         // [] (a 3-course cycle)
        System.out.println(Arrays.toString(solver.findOrder(4, new int[][]{{1, 0}, {3, 2}, {2, 3}})));         // [] (a cycle among otherwise fine courses)
        System.out.println(Arrays.toString(solver.findOrder(5, new int[][]{{1, 0}, {2, 1}, {4, 3}})));         // [0, 3, 1, 4, 2] (two chains interleave)
        System.out.println(Arrays.toString(solver.findOrder(4, new int[][]{{1, 0}, {1, 0}})));                 // [0, 2, 3, 1] (duplicate prerequisite is harmless)
        System.out.println(Arrays.toString(solver.findOrder(0, new int[][]{})));                               // [] (nothing to take)
    }
}
