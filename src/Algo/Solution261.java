package Algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * You have a graph of n nodes labeled from 0 to n - 1. You are given
 * an integer n and a list of edges where edges[i] = [ai, bi] indicates
 * that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree,
 * and false otherwise.
 */
public class Solution261 {

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;
        List<Integer>[] adjacencyList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbour : adjacencyList[node]) {
                if (visited.contains(neighbour)) continue;
                visited.add(neighbour);
                stack.push(neighbour);
            }
        }

        return visited.size() == n;
    }

}
