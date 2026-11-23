package dsa.graph.cycle;

import java.util.ArrayList;

/**
 * DetectCycleInDirectedGraph
 *
 * <p>Detects whether a directed graph contains a cycle using DFS with two marker arrays:
 * {@code vis} records every node ever visited, while {@code pathVis} records only the nodes
 * on the current recursion path. Reaching a node that is already on the current path means a
 * back edge exists, hence a cycle. A node that was visited on an earlier, completed path is
 * not a cycle, which is what distinguishes this from the undirected case.
 *
 * <p>Time complexity: O(V + E). Space complexity: O(V) for the marker arrays and recursion stack.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class DetectCycleInDirectedGraph {

    /**
     * DFS helper that explores everything reachable from {@code node}.
     * Marks the node as visited and as on the current path, and unmarks it from the path
     * when backtracking.
     *
     * @param node    current node being explored
     * @param adj     adjacency list of the directed graph
     * @param vis     1 if a node has been visited at any point, else 0
     * @param pathVis 1 if a node is on the current DFS path, else 0
     * @return true if a cycle is reachable from {@code node}, false otherwise
     */
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[node] = 1;
        pathVis[node] = 1;

        // traverse for adjacent nodes
        for(int it : adj.get(node)) {
            // when the node is not visited
            if(vis[it] == 0) {
                if(dfsCheck(it, adj, vis, pathVis))
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if(pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }

    /**
     * Detects a cycle in a directed graph.
     * Handles disconnected graphs by starting a DFS from each unvisited node.
     *
     * @param V   number of vertices (labelled 0 to V-1)
     * @param adj adjacency list of the directed graph
     * @return true if the graph contains a cycle, false otherwise
     */
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                if(dfsCheck(i, adj, vis, pathVis)) return true;
            }
        }
        return false;
    }
}
