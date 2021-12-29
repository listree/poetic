package com.leetcode.graph;

/**
 * https://leetcode.com/problems/count-pairs-of-nodes/
 * 1782. Count Pairs Of Nodes (Hard)
 * You are given an undirected graph defined by an integer n, the number of nodes, and a 2D integer array edges,
 * the edges in the graph, where edges[i] = [ui, vi] indicates that there is an undirected edge between ui and vi.
 * You are also given an integer array queries.
 * Let incident(a, b) be defined as the number of edges that are connected to either node a or b.
 * The answer to the jth query is the number of pairs of nodes (a, b) that satisfy both of the following conditions:
 * a < b and incident(a, b) > queries[j]
 * Return an array answers such that answers.length == queries.length and answers[j] is the answer of the jth query.
 * Note that there can be multiple edges between the same two nodes.
 * Time Limit Exceeded
 */
public class HardCountPairsTodo {

    public final static void main(String[] args) {
        HardCountPairsTodo tester = new HardCountPairsTodo();
        int n = 4;
        int[][] edges = {{1,2},{2,4},{1,3},{2,3},{2,1}};
        int[] queries = {2,3};
        int[] counts =  tester.countPairs(n, edges, queries);
        for( int x : counts) {
            System.out.println(x);
        }

    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[][] incidents = new int[n+1][n+1];
        int[] counts = new int[queries.length];


        // calculate incidents
        for(int[] edge: edges) {
            int x = Math.min(edge[0], edge[1]);
            int y = Math.max(edge[0], edge[1]);
            for( int k = 1; k <= n; k++) {
                if( x < k )
                    incidents[x][k]++;
                if( k < x )
                    incidents[k][x]++;
                if( y < k )
                    incidents[y][k]++;
                if( k < y )
                    incidents[k][y]++;
            }
            incidents[x][y]--;

        }

        // count
        for( int i = 0; i < queries.length; i++) {
            counts[i] = count(incidents, queries[i]);
        }

        return counts;
    }

    int count(int[][] incidents, int x) {
        int count = 0;
        for(int i = 1; i < incidents.length; i++) {
            for (int j = i + 1; j < incidents.length; j++) {
                if (incidents[i][j] > x)
                    count++;
            }
        }
        return count;
    }

}
