package dsa.graph.traversal;

import dsa.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * DepthFirstSearch
 * 
 * <p>Recursive depth-first traversal of a whole graph: from a vertex, go as deep as possible along one
 * neighbour before backtracking and trying the next. The mirror image of {@link BreadthFirstSearch}.
 *
 * <p><b>Idea:</b> mark a vertex visited, record it, then recurse into each unvisited neighbour. The call
 * stack plays the role BFS gives to a queue. The outer loop restarts the search from each still-unvisited
 * vertex, so disconnected graphs are fully covered.
 *
 * <p><b>Complexity:</b> Time O(V + E), Space O(V) for {@code visited} and the result, plus O(V)
 * recursion depth in the worst case (a long path).
 *
 * <p><b>NOTE:</b> the order of the result depends on the order of neighbours in the adjacency list.
 * Very deep graphs can overflow the Java call stack; an explicit stack avoids that.
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class DepthFirstSearch {
    /**
     * Returns every vertex in depth-first (preorder) order, starting a new search from each unvisited vertex.
     *
     * @param n       the number of vertices (numbered {@code 0..n-1})
     * @param adjList the adjacency list of the graph
     * @return the vertices in the order they were visited; each appears exactly once
     */
    public static List<Integer> depthFirstTraversal(int n, List<List<Integer>> adjList) {
        List<Integer> dfsTraversal = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                dfs(vertex, adjList, visited, dfsTraversal);
            }
        }

        return dfsTraversal;
    }

    /**
     * Visits {@code vertex}, then recursively visits each of its unvisited neighbours.
     *
     * @param vertex       the vertex being visited
     * @param adjList      the adjacency list of the graph
     * @param visited      shared visited flags; updated in place
     * @param dfsTraversal the output list; vertices are appended in visit order
     */
    private static void dfs(int vertex, List<List<Integer>> adjList, boolean[] visited, List<Integer> dfsTraversal) {
        dfsTraversal.add(vertex);
        visited[vertex] = true;

        for (int adj : adjList.get(vertex)) {
            if (!visited[adj]) {
                dfs(adj, adjList, visited, dfsTraversal);
            }
        }
    }

    /**
     * Demo: runs DFS on a graph with two components (0-1-2-4-6-7 with a 2-7 shortcut, and 3-5).
     *
     * @param args unused
     */
    public static void main(String[] args) {
        int N = 8;
        int[][] edgeList = new int[][]{{0, 1}, {1, 2}, {2, 4}, {4, 6}, {6, 7}, {2, 7}, {3, 5}};

        Graph graph = new Graph(N);
        graph.addUndirectedEdges(edgeList);
        System.out.println(depthFirstTraversal(graph.size(), graph.getAdjList()));
    }
}
