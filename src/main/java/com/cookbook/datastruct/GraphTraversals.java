package com.cookbook.datastruct;

import java.util.LinkedList;
import java.util.List;

class GraphTraversals
{
    public static void main(String args[]) {
        int[][] pairs = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}};

        GraphBFS g = new GraphBFS(4, pairs);
        g.bfsTraversal(2);

        GraphDFS g2 = new GraphDFS(4, pairs);
        for (int i = 0; i < 4; i++) {
            System.out.println("DFS starts with: " + i);
            g2.dfsTraversal(2);
        }

    }

    public static class GraphDFS {
        private int vertices;   // No. of vertices
        private List<Integer> edges[]; // Adjacency List of each vertices

        GraphDFS(int n, int[][] pairs) {

            vertices = n;
            edges = new LinkedList[n];
            for (int i = 0; i < vertices; i++)
                edges[i] = new LinkedList();

            for (int k = 0; k < pairs.length; k++) {
                int[] pair = pairs[k];
                edges[pair[0]].add(pair[1]);
            }
        }

        void dfsTraversal(int i) {
            boolean markers[] = new boolean[vertices];
            dfsWithMarkers(i, markers);
        }

        void dfsWithMarkers(int v, boolean markers[]) {
            markers[v] = true;
            System.out.println("Visiting: " + v);

            for (int x : edges[v]) {
                if (!markers[x])
                    dfsWithMarkers(x, markers);
            }
        }
    }

    public static class GraphBFS {

        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; //Adjacency Lists

        // Constructor
        GraphBFS(int v, int[][] pairs) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();

            for (int k = 0; k < pairs.length; k++) {
                adj[pairs[k][0]].add(pairs[k][1]);
            }
        }

        // prints BFS traversal from a given source s
        void bfsTraversal(int s) {
            boolean visited[] = new boolean[V];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // Mark the current node as visited and enqueue it
            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {

                s = queue.poll();
                System.out.println("Visiting: " + s);

                for (int n : adj[s]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

}