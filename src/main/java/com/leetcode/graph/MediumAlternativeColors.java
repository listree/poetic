package com.leetcode.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 * 1129. Shortest Path with Alternating Colors (Medium)
 * Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  In this graph, each edge is either red or blue, and
 * there could be self-edges or parallel edges. Each [i, j] in red_edges denotes a red directed edge from node i to node j.
 * Similarly, each [i, j] in blue_edges denotes a blue directed edge from node i to node j.
 * Return an array answer of length n, where each answer[X] is the length of the shortest path from node 0 to node X such
 * that the edge colors alternate along the path (or -1 if such a path doesn't exist).
 * \Runtime: 12 ms, faster than 45.95% of Java online submissions for Shortest Path with Alternating Colors.
 * Memory: 49.4 MB, less than 11.79% of Java online submissions for Shortest Path with Alternating Colors.
 */
public class MediumAlternativeColors {

    public final static void main(String[] args) {

        MediumAlternativeColors tester = new MediumAlternativeColors();
        {
            int[][] redEdges = {{0, 1}, {1, 2}};
            int[][] blueEdges = {};
            int n = 3;
            int[] result = tester.shortestAlternatingPaths(n, redEdges, blueEdges);
            // Output: [0,1,-1]
            for (int x : result) System.out.print(x + " ");
            System.out.println();
        }
        {
            int[][] redEdges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
            int[][] blueEdges = {{1, 2}, {2, 3}, {3, 1}};
            int n = 5;
            int[] result = tester.shortestAlternatingPaths(n, redEdges, blueEdges);
            // Output: [0,1,2,3,7]
            for (int x : result) System.out.print(x + " ");
            System.out.println();
        }
        {
            //
            int[][] redEdges = {{2,2},{0,1},{0,3},{0,0},{0,4},{2,1},{2,0},{1,4},{3,4}};
            int[][] blueEdges = {{1,3},{0,0},{0,3},{4,2},{1,0}};
            int n = 5;
            int[] result = tester.shortestAlternatingPaths(n, redEdges, blueEdges);
            // Output: [0,1,2,1,1]
            for (int x : result) System.out.print(x + " ");
            System.out.println();

        }

    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        HashMap<Integer, List<Integer>> redAdj = new HashMap();
        HashMap<Integer, List<Integer>> blueAdj = new HashMap();

        for( int i = 0; i < n; i++) {
            redAdj.put(i, new ArrayList<>());
            blueAdj.put(i, new ArrayList<>());
        }
        for(int[] r : red_edges) {
            redAdj.get(r[0]).add(r[1]);
        }
        for(int[] b: blue_edges) {
            blueAdj.get(b[0]).add(b[1]);
        }

        int[] shortestRed = shortestStartWith(n, redAdj, blueAdj);
        int[] shortestBlue = shortestStartWith(n, blueAdj, redAdj);

        int[] shortestAlter = new int[n];
        for(int i = 0; i < n; i++) {
            shortestAlter[i] = Math.min(shortestRed[i], shortestBlue[i]);
            if( shortestAlter[i] == Integer.MAX_VALUE)
                shortestAlter[i] = -1;
        }
        return shortestAlter;

    }

    public int[] shortestStartWith(int n, Map<Integer, List<Integer>> oddAdj, Map<Integer, List<Integer>> evenAdj) {

        int[] shortestPath = new int[n];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        Queue<Integer> visitingQueue = new LinkedList();
        HashSet<Integer> visitedEdges = new HashSet();
        int marker = -1;

        int level = 0;
        shortestPath[0] = level;
        visitingQueue.add(0);
        visitingQueue.add(marker);
        level++;

        while (!visitingQueue.isEmpty()) {
            int x = visitingQueue.poll();
            // System.out.println(visitingQueue);
            if (x == marker) {
                if( !visitingQueue.isEmpty() ) {
                    visitingQueue.add(marker);
                    level++;
                }
                continue;
            }
            Map<Integer, List<Integer>> checkEdges = (level % 2 == 0) ? evenAdj : oddAdj;
            for (int y : checkEdges.get(x)) {
                int index = (x * n + y) * 10 + ((level % 2 == 0) ? 0 : 1);
                // System.out.println(x + " " + y + " " + index);
                if( ! visitedEdges.contains(index) ) {
                    shortestPath[y] = Math.min(shortestPath[y], level);
                    visitingQueue.add(y);
                    visitedEdges.add(index);
                }
            }
        }
        return shortestPath;
    }

}
