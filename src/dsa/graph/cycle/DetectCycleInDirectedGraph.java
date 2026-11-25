package dsa.graph.cycle;

import java.util.ArrayList;
import java.util.List;

/**
 * DetectCycleInDirectedGraph
 *
 * <p>Detects whether a directed graph contains a cycle using DFS with a single three-state
 * marker array {@code vis}: 0 = unvisited, 2 = on the current recursion path, 1 = fully explored.
 * Reaching a node that is already on the current path (state 2) means a back edge exists,
 * hence a cycle. A node that was visited on an earlier, completed path is
 * not a cycle (state 1), which is what distinguishes this from the undirected case.
 *
 * <p>Time complexity: O(V + E). Space complexity: O(V) for the marker array and recursion stack.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class DetectCycleInDirectedGraph {

    /**
     * Detects a cycle in a directed graph.
     * Handles disconnected graphs by starting a DFS from each unvisited node.
     *
     * @param n   number of vertices (labelled 0 to n-1)
     * @param adjList adjacency list of the directed graph
     * @return true if the graph contains a cycle, false otherwise
     */
    public boolean isCyclic(int n, List<List<Integer>> adjList) {
        int[] visited = new int[n];
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                if(hasCycle(i, adjList, visited)) return true;
            }
        }

        return false;
    }

    /**
     * DFS helper that explores everything reachable from {@code vertex}.
     * Marks the vertex as on the current path (2) and, when backtracking, as fully explored (1).
     *
     * @param vertex    current vertex being explored
     * @param adjList     adjacency list of the directed graph
     * @param visited state per vertex: 0 = unvisited, 2 = on the current DFS path, 1 = fully explored
     * @return true if a cycle is reachable from {@code vertex}, false otherwise
     */
    private boolean hasCycle(int vertex, List<List<Integer>> adjList, int[] visited) {
        visited[vertex] = 2;

        // traverse for adjacent nodes
        for(int adj : adjList.get(vertex)) {
            // when the vertex is not visited
            if(visited[adj] == 0) {
                if(hasCycle(adj, adjList, visited)) {
                    return true;
                }
            } else if (visited[adj] == 2) {
                return true;
            }
        }

        visited[vertex] = 1;
        return false;
    }

    /**
     * Runs one test case and prints PASS or FAIL. The graph is given directly as an
     * adjacency list, where {@code adj[i]} holds the nodes that node {@code i} points to.
     *
     * @param name     a short description of the case
     * @param adj      adjacency list of the directed graph
     * @param expected whether the graph should contain a cycle
     */
    private static void check(String name, int[][] adj, boolean expected) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] neighbours : adj) {
            List<Integer> row = new ArrayList<>();
            for (int n : neighbours) row.add(n);
            list.add(row);
        }
        boolean actual = new DetectCycleInDirectedGraph().isCyclic(adj.length, list);
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " - " + name + " (expected " + expected + ", got " + actual + ")");
    }

    /**
     * Test driver covering typical and edge cases.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        // Graphs with a cycle
        // 0 -> 1 -> 2 -> 0 forms a cycle, 2 -> 3 is a dead end
        check("cycle 0->1->2->0 with a branch to 3", new int[][]{{1}, {2}, {0, 3}, {}}, true);
        check("simple 3-cycle", new int[][]{{1}, {2}, {0}}, true);
        check("self-loop", new int[][]{{0}}, true);
        check("2-cycle", new int[][]{{1}, {0}}, true);
        // Cycle 2->3->4->2 is only reachable via the tail 0->1->2
        check("cycle with a tail leading into it", new int[][]{{1}, {2}, {3}, {4}, {2}}, true);
        // The cycle is in a component not reachable from vertex 0
        check("cycle only in a later component", new int[][]{{1}, {}, {3}, {4}, {2}}, true);

        // Acyclic graphs
        check("simple path", new int[][]{{1}, {2}, {3}, {}}, false);
        // Diamond: node 3 is reached twice but is finished (state 1) the second time,
        // so it must not be reported as a cycle
        check("diamond (revisit without cycle)", new int[][]{{1, 2}, {3}, {3}, {}}, false);
        check("two disjoint DAG components", new int[][]{{1}, {}, {3}, {}}, false);

        // Trivial inputs
        check("empty graph", new int[][]{}, false);
        check("single vertex, no edges", new int[][]{{}}, false);
        check("isolated vertices", new int[][]{{}, {}, {}}, false);
    }
}
