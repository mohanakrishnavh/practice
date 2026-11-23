package dsa.graph.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * CourseSchedule
 * 
 * <p>Decides whether all courses can be finished given their prerequisites (LeetCode 207).
 * A pair {@code {a, b}} means "to take course {@code a} you must first take course {@code b}".
 * Modelled as a directed graph with an edge {@code b -> a}, all courses can be finished exactly when the
 * graph has <b>no cycle</b>; a cycle means courses that wait on each other forever.
 *
 * <p><b>Idea:</b> Kahn's algorithm (BFS topological sort). Count each course's {@code indegree} (number of
 * unmet prerequisites), start with every course that has none, and repeatedly "take" a course and unlock
 * the courses that depended on it. If every course ends up taken, there was no cycle; if some are never
 * unlocked, they sit on or behind a cycle.
 *
 * <p><b>Complexity:</b> Time O(V + E), Space O(V + E) for the adjacency list, plus O(V) for
 * {@code indegree}, the queue and the order.
 *
 * <p><b>NOTE:</b> see {@link CourseScheduleII} for the version that returns an actual valid order.
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class CourseSchedule {
    /**
     * Checks whether every course can be completed.
     *
     * @param numCourses    the number of courses, labelled {@code 0..numCourses-1}
     * @param prerequisites pairs {@code {a, b}}: course {@code b} must be taken before course {@code a}
     * @return {@code true} if there is an order that satisfies all prerequisites (no cycle);
     *         {@code false} if the prerequisites contain a cycle, including a course that requires itself
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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


        List<Integer> topoOrder = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        //Identify the source nodes and add it to the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Run BFS remove the source nodes that have been processed
        while(!q.isEmpty()) {
            Integer node = q.poll();
            topoOrder.add(node);

            for (int adj : adjList.get(node)) {
                indegree[adj]--;

                if (indegree[adj] == 0) {
                    q.add(adj);
                }
            }
        }

        // Every course was taken only if no cycle blocked any of them
        return topoOrder.size() == numCourses;
    }

    /**
     * Demo: checks a few simple prerequisite setups.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        CourseSchedule solver = new CourseSchedule();

        System.out.println(solver.canFinish(2, new int[][]{{1, 0}}));                          // true  (0 then 1)
        System.out.println(solver.canFinish(2, new int[][]{{1, 0}, {0, 1}}));                  // false (0 and 1 need each other)
        System.out.println(solver.canFinish(1, new int[][]{}));                                // true  (one course, no prerequisites)
        System.out.println(solver.canFinish(3, new int[][]{}));                                // true  (no prerequisites at all)
        System.out.println(solver.canFinish(1, new int[][]{{0, 0}}));                          // false (a course requiring itself)
        System.out.println(solver.canFinish(3, new int[][]{{1, 0}, {2, 1}}));                  // true  (a chain 0 -> 1 -> 2)
        System.out.println(solver.canFinish(3, new int[][]{{1, 0}, {2, 1}, {0, 2}}));          // false (a 3-course cycle)
        System.out.println(solver.canFinish(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));  // true  (a diamond)
        System.out.println(solver.canFinish(4, new int[][]{{1, 0}, {1, 0}}));                  // true  (duplicate prerequisite is harmless)
        System.out.println(solver.canFinish(4, new int[][]{{1, 0}, {3, 2}, {2, 3}}));          // false (one cycle among otherwise fine courses)
        System.out.println(solver.canFinish(5, new int[][]{{1, 0}, {2, 1}, {4, 3}}));          // true  (two separate chains)
        System.out.println(solver.canFinish(0, new int[][]{}));                                // true  (nothing to take)
    }
}
