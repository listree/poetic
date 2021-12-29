package com.leetcode;

import java.util.*;

class GraphNode
{
    public static void main(String args[]) {
        int n = 4;
        int[][] connections = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}};

        bfs g1 = new bfs(4, connections);
        System.out.println("BFS starts");
        g1.bfsTraversal(2);

        System.out.println("DFS starts");
        dfs g2 = new dfs(4, connections);
        g2.dfsTraversal(2);
    }

    public static class graph {

        protected int vertices;   // No. of vertices
        protected List<Integer> edges[]; // Adjacency List of each vertices

        graph(int n, int[][] pairs) {

            vertices = n;
            edges = new List[n];
            for (int i = 0; i < vertices; i++)
                edges[i] = new ArrayList();

            for (int k = 0; k < pairs.length; k++) {
                int[] pair = pairs[k];
                edges[pair[0]].add(pair[1]);
            }
        }
    }

    public static class dfs extends graph {

        boolean markers[] = new boolean[vertices];
        dfs(int n, int[][] pairs) {
            super(n, pairs);
        }

        void dfsTraversal(int v) {
            System.out.println("Visiting: " + v);
            markers[v] = true;
            for (int x : edges[v]) {
                if (!markers[x])
                    dfsTraversal(x);
            }
        }
    }

    public static class bfs extends graph {

        bfs(int n, int[][] pairs) {
            super(n, pairs);
        }

        void bfsTraversal(int s) {

            boolean visited[] = new boolean[vertices];
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // Start with s
            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {
                int x = queue.poll();
                System.out.println("Visiting: " + x);
                for (int n : edges[x]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

}
