package com.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** Question: 1129. Shortest Path with Alternating Colors
 * Description: https://leetcode.com/problems/shortest-path-with-alternating-colors/
 * Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  In this graph, each edge is either red or blue, and
 * there could be self-edges or parallel edges. Each [i, j] in red_edges denotes a red directed edge from node i to node j.
 * Similarly, each [i, j] in blue_edges denotes a blue directed edge from node i to node j.
 * Return an array answer of length n, where each answer[X] is the length of the shortest path from node 0 to node X such
 * that the edge colors alternate along the path (or -1 if such a path doesn't exist).
 */
public class M1129AlternativeColors {

    public final static void main(String[] args) {

        M1129AlternativeColors tester = new M1129AlternativeColors();
        {
            //Example 1 Output: 0 1 -1
            int[][] redEdges = {{0, 1}, {1, 2}};
            int[][] blueEdges = {};
            int n = 3;
            int[] result = tester.shortestAlternatingPaths(n, redEdges, blueEdges);
            // Output: [0,1,-1]
            for (int x : result) System.out.print(x + " ");
        }
        {
            // Example 2 Output: 0 1 -1
            int[][] redEdges = {{0, 1}};
            int[][] blueEdges = {{2, 1}};
            int n = 3;
            int[] result = tester.shortestAlternatingPaths(n, redEdges, blueEdges);
            for (int x : result) System.out.print(x + " ");
        }
        {
            //Example 3: [0,-1,-1]
            int[][] redEdges = {{1, 0}};
            int[][] blueEdges = {{2, 1}};
            int n = 3;
            int[] result = tester.shortestAlternatingPaths(n, redEdges, blueEdges);
            for (int x : result) System.out.print(x + " ");
        }
        {
            //Example 4 Output: [0,1,2]
            int[][] redEdges = {{0, 1}};
            int[][] blueEdges = {{1, 2}};
            int n = 3;
            int[] result = tester.shortestAlternatingPaths(n, redEdges, blueEdges);
            for (int x : result) System.out.print(x + " ");
        }

    }

    /** Failed on test case
     * Input 5
     * [[0,1],[1,2],[2,3],[3,4]]
     * [[1,2],[2,3],[3,1]]
     * Output [0,1,2,3,-1]
     * Expected [0,1,2,3,7]     
     * */
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {

        List<Integer>[] redAdj = new List[n];
        List<Integer>[] blueAdj = new List[n];
        int[] markers = new int[n];

        for(int i = 0 ; i < n; i++ ) {
            redAdj[i] = new ArrayList<Integer>();
            blueAdj[i] = new ArrayList<Integer>();
            markers[i] = -1;
        }

        for( int[] pair : red_edges ) {
            redAdj[pair[0]].add(pair[1]);
        }

        for( int[] pair : blue_edges ) {
            blueAdj[pair[0]].add(pair[1]);
        }

        boolean useRed = true;
        LinkedList<Integer> queue = new LinkedList<Integer>();

        int level = 1;
        queue.add(0);
        markers[0] = 0;
        while( !queue.isEmpty() ) {
            int x = queue.pop();
            if( useRed ) {
                for (int y : redAdj[x]) {
                    if( markers[y] == -1 ) {
                        queue.add(y);
                        markers[y] = level;
                    }
                }
                // todo: only change when level scan done
                useRed = false;
                level++;
            } else {
                for (int y : blueAdj[x]) {
                    if( markers[y] == -1 ) {
                        queue.add(y);
                        markers[y] = level;
                    }
                }
                // todo: only change when level scan done
                useRed = true;
                level++;
            }
        }

        return markers;

    }


}
