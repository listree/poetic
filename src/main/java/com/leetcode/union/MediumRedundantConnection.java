package com.leetcode.union;

/**
 * https://leetcode.com/problems/redundant-connection/
 * 684. Redundant Connection (Medium)
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
 * The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
 * The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge
 * between nodes ai and bi in the graph. Return an edge that can be removed so that the resulting graph is a tree of n
 * nodes. If there are multiple answers, return the answer that occurs last in the input.
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Redundant Connection.
 * Memory Usage: 42.3 MB, less than 93.89% of Java online submissions for Redundant Connection.
 */
public class MediumRedundantConnection {
    public final static void main(String[] args)  {
        MediumRedundantConnection tester = new MediumRedundantConnection();
        int[][] edges = {{1,2},{1,3},{2,3}};
        int[] result = tester.findRedundantConnection(edges);
        System.out.println(result[0] + " " + result[1]);
        int[][] edges2 = {{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}};
        int[] result2 = tester.findRedundantConnection(edges2);
        System.out.println(result2[0] + " " + result2[1]);
        int[][] edges3 = {{3,7},{1,4},{2,8},{1,6},{7,9},{6,10},{1,7},{2,3},{8,9},{5,9}};
        int[] result3 = tester.findRedundantConnection(edges3);
        System.out.println(result3[0] + " " + result3[1]);
    }

    // union find way
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            // for(int x : components)
            //    System.out.print(x);
            // System.out.println();

            if (find(edge[0]) != find(edge[1]))
                union(edge[0], edge[1]);
            else
                return edge; // found redundant !!!
        }
        return edges[0];
    }

    private int[] parent;
    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        parent[find(y)] = find(x);
    }

}
