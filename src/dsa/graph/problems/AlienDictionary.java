package dsa.graph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * AlienDictionary
 *
 * <p>LeetCode 269 (Hard).
 *
 * <p>Given a list of words sorted lexicographically by the rules of an alien language, derive the
 * order of the letters. Comparing each pair of adjacent words, the first differing character gives
 * an edge {@code a -> b} meaning "a comes before b". A topological sort of these edges (Kahn's
 * algorithm) gives a valid letter order. If the edges contain a cycle, or a longer word is followed
 * by its own prefix, no valid order exists and an empty string is returned.
 *
 * <p>Several orders can be valid, so the one returned may differ from the example in the problem.
 *
 * <p>Time Complexity: O(C), where C is the total number of characters across all words.
 * <p>Space Complexity: O(U + min(U^2, N)), where U is the number of unique letters and N the number of words.
 *
 * @see leetcode.LC0269_AlienDictionary
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class AlienDictionary {

    /**
     * Derives the letter order of an alien language from a sorted word list.
     *
     * @param words words sorted by the alien dictionary order
     * @return a valid letter order, or {@code ""} if the input is invalid (cycle or bad prefix order)
     */
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Step 1a: Store all the unique chars in the adjList
        // Step 1b: Initialize the indegree of all nodes to 0
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adjList.put(ch, new ArrayList<>());
                indegree.put(ch, 0);
            }
        }

        // Step 2a: Identify all edges and establish the connections
        // Step 2b: Compute the indegree of the chars/nodes
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Check word2 is not a prefix of word1
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            // Find the first non-match and create the edge
            int length = Math.min(word1.length(), word2.length());
            for (int j = 0; j < length; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j), indegree.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        // Step 3: Apply Topological ordering
        // Step 3a: Initialize the queue with nodes where indegree is 0 (no dependency)
        Queue<Character> q = new LinkedList<>();
        for (Character ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                q.offer(ch);
            }
        }

        // Step 3b: Iterate until all the nodes have been processed to get topological order
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Character ch = q.poll();
            sb.append(ch);

            for (Character adj : adjList.get(ch)) {
                indegree.put(adj, indegree.get(adj) - 1);

                if (indegree.get(adj) == 0) {
                    q.offer(adj);
                }
            }
        }

        // Step 4: Return the topologically sorted order of unique letters
        // If all nodes are in the order, there is no cycle i.e. it is a DAG
        return sb.length() == indegree.size() ? sb.toString() : "";
    }


    /**
     * Test driver using the three LeetCode examples.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        AlienDictionary solver = new AlienDictionary();

        // Example 1
        String r1 = solver.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        System.out.println((r1.equals("wertf") ? "PASS" : "FAIL") + " - Example 1 (got \"" + r1 + "\")");

        // Example 2
        String r2 = solver.alienOrder(new String[]{"z", "x"});
        System.out.println((r2.equals("zx") ? "PASS" : "FAIL") + " - Example 2 (got \"" + r2 + "\")");

        // Example 3: z < x and x < z form a cycle, so the order is invalid
        String r3 = solver.alienOrder(new String[]{"z", "x", "z"});
        System.out.println((r3.isEmpty() ? "PASS" : "FAIL") + " - Example 3 (got \"" + r3 + "\")");
    }
}
