package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<List<Integer>> adjList;
    int[][] adjMatrix;
    int size;

    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    private int getSize() {
        return size;
    }

    public int size() {
        return size;
    }

    public Graph(int N) {
        this.size = N;
        this.adjList = new ArrayList<>();

        // Initializing the Adjacency List
        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // Initializing the Adjacency Matrix
        adjMatrix = new int[N][N];
    }

    public void addUndirectedEdges(int[][] edges) {
        for (int[] edge : edges) {
            // Building the Adjacency List
            addUndirectedEdge(edge[0], edge[1]);

            // Building the Adjacency Matrix
            adjMatrix[edge[0]][edge[1]] = 1;
            adjMatrix[edge[1]][edge[0]] = 1;
        }
    }

    public void addUndirectedEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    public void addDirectedEdges(int[][] edges) {
        for (int[] edge : edges) {
            // Building the Adjacency List
            addDirectedEdge(edge[0], edge[1]);

            // Building the Adjacency Matrix
            adjMatrix[edge[0]][edge[1]] = 1;
        }
    }

    public void addDirectedEdge(int a, int b) {
        adjList.get(a).add(b);
    }
}
