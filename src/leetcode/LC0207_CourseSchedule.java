package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode Problem 207: Course Schedule
 * Difficulty: Medium
 * 
 * <p>Determine if all courses can be finished given prerequisites.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0207_CourseSchedule {
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

        return topoOrder.size() == numCourses;
    }
}
