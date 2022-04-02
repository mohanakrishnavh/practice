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

    public int getSize() {
        return size;
    }

    public Graph(int size) {
        this.size = size;
        this.adjList = new ArrayList<>();

        // Initializing the Adjacency List
        for (int i = 0; i <= size; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // Initializing the Adjacency Matrix
        adjMatrix = new int[size+1][size+1];
    }

    public void addUndirectedEdges(int[][] edgeList) {
        for (int[] edge : edgeList) {
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

    public void addDirectedEdges(int[][] edgeList) {
        for (int[] edge : edgeList) {
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
