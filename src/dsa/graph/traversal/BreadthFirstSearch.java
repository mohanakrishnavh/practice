package dsa.graph.traversal;

import dsa.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BreadthFirstSearch
 * 
 * <p>Breadth-first traversal of a whole graph, visiting vertices level by level: the start vertex,
 * then all its neighbours, then their neighbours, and so on.
 *
 * <p><b>Idea:</b> use a FIFO queue. Mark a vertex visited when it is <i>enqueued</i> (not when dequeued)
 * so it is never queued twice. The outer loop restarts the search from each still-unvisited vertex, so
 * disconnected graphs are fully covered.
 *
 * <p><b>Complexity:</b> Time O(V + E), Space O(V) for {@code visited}, the queue and the result.
 *
 * <p><b>NOTE:</b> the order of the result depends on the order of neighbours in the adjacency list.
 * BFS from a vertex also finds shortest paths (fewest edges) in an unweighted graph.
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BreadthFirstSearch {
    /**
     * Returns every vertex in breadth-first order, starting a new search from each unvisited vertex.
     *
     * @param n       the number of vertices (numbered {@code 0..n-1})
     * @param adjList the adjacency list of the graph
     * @return the vertices in the order they were visited; each appears exactly once
     */
    public static List<Integer> breadthFirstTraversal(int n, List<List<Integer>> adjList) {
        List<Integer> bfsTraversal = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                bfs(v, adjList, visited, bfsTraversal);
            }
        }

        return bfsTraversal;
    }

    /**
     * Runs one BFS from {@code v}, appending each reached vertex to the traversal as it is dequeued.
     *
     * @param v            the start vertex (must be unvisited)
     * @param adjList      the adjacency list of the graph
     * @param visited      shared visited flags; updated in place
     * @param bfsTraversal the output list; vertices are appended in visit order
     */
    private static void bfs(int v, List<List<Integer>> adjList, boolean[] visited, List<Integer> bfsTraversal) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            bfsTraversal.add(node);

            for (int adj : adjList.get(node)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    q.add(adj);
                }
            }
        }
    }

    /**
     * Demo: runs BFS on a connected 10-vertex graph.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        int n = 10;
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 4}, {0,8}, {1, 5}, {1, 6},{1, 9}, {2, 4}, {3, 7}, {3, 8}, {5, 8}, {6, 7}, {6, 9}};

        Graph graph = new Graph(n);
        graph.addUndirectedEdges(edges);
        System.out.println(breadthFirstTraversal(graph.size(), graph.getAdjList()));
    }
}
