package dsa.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph
 * 
 * <p>A graph over vertices {@code 0..n-1}, stored in two representations at once so algorithms can
 * pick whichever suits them:
 * <ul>
 *   <li><b>Adjacency list</b>: {@code adjList.get(v)} holds the neighbours of {@code v}. Space
 *       O(V + E); best for traversals (BFS/DFS). Its shape depends on whether the graph is weighted:
 *       an unweighted graph ({@link #getAdjList()}) uses {@code List<List<Integer>>} of neighbours, a
 *       weighted graph ({@link #getWeightedAdjList()}) uses {@code List<List<int[]>>} of
 *       {@code {neighbour, weight}} pairs. Only one of the two exists per graph.</li>
 *   <li><b>Adjacency matrix</b> ({@link #getAdjMatrix()}): {@code adjMatrix[a][b]} holds the weight of the
 *       edge from {@code a} to {@code b}, and 0 means no edge. Space O(V^2); gives O(1) edge and weight
 *       lookups.</li>
 * </ul>
 *
 * <p>Whether a graph is weighted is chosen at construction: {@link #Graph(int)} makes an unweighted graph
 * (as before) and {@link #Graph(int, boolean)} with {@code true} makes a weighted one. Edges can be
 * undirected (both directions) or directed (one way), and each single-edge method has two versions: one
 * without a weight and one with. On a weighted graph the version without a weight records
 * {@link #DEFAULT_WEIGHT} (1); the version with a weight is only allowed on a weighted graph and throws
 * {@link IllegalStateException} otherwise, rather than silently dropping the weight.
 *
 * <p>In the plural methods an edge row is {@code {a, b}} or {@code {a, b, weight}}: a row with a weight uses
 * the weighted version, otherwise the unweighted one. For an unweighted graph the matrix is the usual 0/1
 * matrix, so {@code adjMatrix[a][b] == 1} still means an edge.
 *
 * <p><b>NOTE:</b> only the plural methods ({@link #addUndirectedEdges}, {@link #addDirectedEdges})
 * update the matrix. The single-edge methods update the adjacency list only. Duplicate edges are not
 * filtered, so the list will contain repeats if the same edge is added twice, and the matrix keeps the
 * weight of the last one. A zero-weight edge is in the list but looks like "no edge" in the matrix.
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Graph {
    /** Weight given to an edge that is added without one to a weighted graph. */
    public static final int DEFAULT_WEIGHT = 1;

    List<List<Integer>> adjList;
    List<List<int[]>> weightedAdjList;
    int[][] adjMatrix;
    int size;
    boolean weighted;

    /**
     * Creates an unweighted graph with {@code n} vertices (numbered {@code 0..n-1}) and no edges.
     *
     * @param n the number of vertices
     */
    public Graph(int n) {
        this(n, false);
    }

    /**
     * Creates a graph with {@code n} vertices (numbered {@code 0..n-1}) and no edges.
     *
     * @param n        the number of vertices
     * @param weighted true to store the adjacency list as {@code List<List<int[]>>} of
     *                 {@code {neighbour, weight}} pairs, false for {@code List<List<Integer>>}
     */
    public Graph(int n, boolean weighted) {
        this.size = n;
        this.weighted = weighted;

        // Initializing the Adjacency List (only the representation that matches the mode)
        if (weighted) {
            this.weightedAdjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                weightedAdjList.add(i, new ArrayList<>());
            }
        } else {
            this.adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(i, new ArrayList<>());
            }
        }

        // Initializing the Adjacency Matrix
        adjMatrix = new int[n][n];
    }

    /**
     * Returns whether this graph stores edge weights in its adjacency list.
     *
     * @return true for a weighted graph, false for an unweighted one
     */
    public boolean isWeighted() {
        return weighted;
    }

    /**
     * Returns the adjacency list of an unweighted graph (the live list, not a copy).
     *
     * @return a list where index {@code v} holds the neighbours of vertex {@code v}
     * @throws IllegalStateException if the graph is weighted; use {@link #getWeightedAdjList()}
     */
    public List<List<Integer>> getAdjList() {
        if (weighted) {
            throw new IllegalStateException("Graph is weighted; use getWeightedAdjList()");
        }
        return adjList;
    }

    /**
     * Returns the adjacency list of a weighted graph (the live list, not a copy).
     *
     * @return a list where index {@code v} holds {@code {neighbour, weight}} pairs for vertex {@code v}
     * @throws IllegalStateException if the graph is unweighted; use {@link #getAdjList()}
     */
    public List<List<int[]>> getWeightedAdjList() {
        if (!weighted) {
            throw new IllegalStateException("Graph is unweighted; use getAdjList()");
        }
        return weightedAdjList;
    }

    /**
     * Returns the adjacency matrix (the live array, not a copy).
     *
     * @return an n x n matrix where {@code [a][b]} is the weight of the edge from {@code a} to
     *         {@code b} (1 if added without a weight), or 0 if there is no edge
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
     * @param edges rows {@code {a, b}} or {@code {a, b, weight}} of vertices to connect in both
     *              directions; a row with a weight needs a weighted graph
     * @throws IllegalStateException if a row has a weight and the graph is unweighted
     */
    public void addUndirectedEdges(int[][] edges) {
        for (int[] edge : edges) {
            // Building the Adjacency List
            int weight = DEFAULT_WEIGHT;
            if (edge.length > 2) {
                weight = edge[2];
                addUndirectedEdge(edge[0], edge[1], weight);
            } else {
                addUndirectedEdge(edge[0], edge[1]);
            }

            // Building the Adjacency Matrix
            adjMatrix[edge[0]][edge[1]] = weight;
            adjMatrix[edge[1]][edge[0]] = weight;
        }
    }

    /**
     * Adds one undirected edge to the adjacency list only (the matrix is not updated).
     * A self-loop ({@code a == b}) appears twice in that vertex's list. On a weighted graph the
     * edge gets {@link #DEFAULT_WEIGHT}.
     *
     * @param a one endpoint
     * @param b the other endpoint
     */
    public void addUndirectedEdge(int a, int b) {
        if (weighted) {
            addUndirectedEdge(a, b, DEFAULT_WEIGHT);
            return;
        }
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    /**
     * Adds one weighted undirected edge to the adjacency list only (the matrix is not updated).
     * A self-loop ({@code a == b}) appears twice in that vertex's list.
     *
     * @param a      one endpoint
     * @param b      the other endpoint
     * @param weight the edge weight (may be negative or zero)
     * @throws IllegalStateException if the graph is unweighted
     */
    public void addUndirectedEdge(int a, int b, int weight) {
        requireWeighted();
        weightedAdjList.get(a).add(new int[]{b, weight});
        weightedAdjList.get(b).add(new int[]{a, weight});
    }

    /**
     * Adds several directed edges, updating both the adjacency list and the adjacency matrix.
     *
     * @param edges rows {@code {from, to}} or {@code {from, to, weight}}; each edge can only be followed from
     *              the first vertex to the second, and a row with a weight needs a weighted graph
     * @throws IllegalStateException if a row has a weight and the graph is unweighted
     */
    public void addDirectedEdges(int[][] edges) {
        for (int[] edge : edges) {
            // Building the Adjacency List
            int weight = DEFAULT_WEIGHT;
            if (edge.length > 2) {
                weight = edge[2];
                addDirectedEdge(edge[0], edge[1], weight);
            } else {
                addDirectedEdge(edge[0], edge[1]);
            }

            // Building the Adjacency Matrix
            adjMatrix[edge[0]][edge[1]] = weight;
        }
    }

    /**
     * Adds one directed edge to the adjacency list only (the matrix is not updated). On a weighted
     * graph the edge gets {@link #DEFAULT_WEIGHT}.
     *
     * @param a the source vertex
     * @param b the destination vertex
     */
    public void addDirectedEdge(int a, int b) {
        if (weighted) {
            addDirectedEdge(a, b, DEFAULT_WEIGHT);
            return;
        }
        adjList.get(a).add(b);
    }

    /**
     * Adds one weighted directed edge to the adjacency list only (the matrix is not updated).
     *
     * @param a      the source vertex
     * @param b      the destination vertex
     * @param weight the edge weight (may be negative or zero)
     * @throws IllegalStateException if the graph is unweighted
     */
    public void addDirectedEdge(int a, int b, int weight) {
        requireWeighted();
        weightedAdjList.get(a).add(new int[]{b, weight});
    }

    /**
     * Guards the weighted add methods so a weight is never silently dropped.
     *
     * @throws IllegalStateException if the graph is unweighted
     */
    private void requireWeighted() {
        if (!weighted) {
            throw new IllegalStateException("Graph is unweighted; create it with new Graph(n, true) to add weights");
        }
    }
}
