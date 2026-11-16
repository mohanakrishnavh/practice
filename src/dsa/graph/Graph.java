package dsa.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph
 * 
 * <p>A graph over vertices {@code 0..n-1}, stored in two representations at once so algorithms can
 * pick whichever suits them:
 * <ul>
 *   <li><b>Adjacency list</b> ({@link #getAdjList()}): {@code adjList.get(v)} holds the neighbours of
 *       {@code v}. Space O(V + E); best for traversals (BFS/DFS).</li>
 *   <li><b>Adjacency matrix</b> ({@link #getAdjMatrix()}): {@code adjMatrix[a][b] == 1} means an edge
 *       from {@code a} to {@code b}. Space O(V^2); gives O(1) edge lookups.</li>
 * </ul>
 *
 * <p>Edges are unweighted and can be added as undirected (both directions) or directed (one way).
 *
 * <p><b>NOTE:</b> only the plural methods ({@link #addUndirectedEdges}, {@link #addDirectedEdges})
 * update the matrix. The single-edge methods update the adjacency list only. Duplicate edges are
 * not filtered, so the list will contain repeats if the same edge is added twice.
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Graph {
    List<List<Integer>> adjList;
    int[][] adjMatrix;
    int size;

    /**
     * Creates a graph with {@code n} vertices (numbered {@code 0..n-1}) and no edges.
     *
     * @param n the number of vertices
     */
    public Graph(int n) {
        this.size = n;
        this.adjList = new ArrayList<>();

        // Initializing the Adjacency List
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // Initializing the Adjacency Matrix
        adjMatrix = new int[n][n];
    }

    /**
     * Returns the adjacency list (the live list, not a copy).
     *
     * @return a list where index {@code v} holds the neighbours of vertex {@code v}
     */
    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    /**
     * Returns the adjacency matrix (the live array, not a copy).
     *
     * @return an n x n matrix where {@code [a][b] == 1} means an edge from {@code a} to {@code b}
     */
    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    /**
     * Private duplicate of {@link #size()}; nothing in this class calls it.
     *
     * @return the number of vertices
     */
    private int getSize() {
        return size;
    }

    /**
     * Returns the number of vertices.
     *
     * @return the vertex count passed to the constructor
     */
    public int size() {
        return size;
    }

    /**
     * Adds several undirected edges, updating both the adjacency list and the adjacency matrix.
     *
     * @param edges pairs {@code {a, b}} of vertices to connect in both directions
     */
    public void addUndirectedEdges(int[][] edges) {
        for (int[] edge : edges) {
            // Building the Adjacency List
            addUndirectedEdge(edge[0], edge[1]);

            // Building the Adjacency Matrix
            adjMatrix[edge[0]][edge[1]] = 1;
            adjMatrix[edge[1]][edge[0]] = 1;
        }
    }

    /**
     * Adds one undirected edge to the adjacency list only (the matrix is not updated).
     * A self-loop ({@code a == b}) appears twice in that vertex's list.
     *
     * @param a one endpoint
     * @param b the other endpoint
     */
    public void addUndirectedEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    /**
     * Adds several directed edges, updating both the adjacency list and the adjacency matrix.
     *
     * @param edges pairs {@code {from, to}}; each edge can only be followed from the first vertex to the second
     */
    public void addDirectedEdges(int[][] edges) {
        for (int[] edge : edges) {
            // Building the Adjacency List
            addDirectedEdge(edge[0], edge[1]);

            // Building the Adjacency Matrix
            adjMatrix[edge[0]][edge[1]] = 1;
        }
    }

    /**
     * Adds one directed edge to the adjacency list only (the matrix is not updated).
     *
     * @param a the source vertex
     * @param b the destination vertex
     */
    public void addDirectedEdge(int a, int b) {
        adjList.get(a).add(b);
    }
}
