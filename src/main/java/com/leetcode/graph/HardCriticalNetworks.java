package com.leetcode.graph;
import java.util.*;

/**
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * 1192. Critical Connections in a Network (Hard)
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network
 * where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers
 * directly or indirectly through the network.
 * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
 * Return all critical connections in the network in any order.
 * Runtime: 242 ms, faster than 43.19% of Java online submissions for Critical Connections in a Network.
 * Memory: 335.3 MB, less than 42.55% of Java online submissions for Critical Connections in a Network.
 */
public class HardCriticalNetworks {

    public final static void main(String[] args) {
        HardCriticalNetworks tester = new HardCriticalNetworks();
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(new Integer[]{0,1}));
        List<List<Integer>> result = tester.criticalConnections(2, connections);
        System.out.println(result); // Output: [[0,1]]

        connections.add(Arrays.asList(new Integer[]{1,2}));
        connections.add(Arrays.asList(new Integer[]{2,0}));
        connections.add(Arrays.asList(new Integer[]{1,3}));
        List<List<Integer>> result2 = tester.criticalConnections(4, connections);
        System.out.println(result2); // Output: [[1,3]]

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        int[] count = new int[1];
        count[0] = 1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] time = new int[n];
        int[] low = new int[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        System.out.println(connections.size());
        for (List<Integer> conn : connections) {
            if( !graph.containsKey(conn.get(0)) )
                graph.put(conn.get(0), new ArrayList<Integer>());
            if( !graph.containsKey(conn.get(1)) )
                graph.put(conn.get(1), new ArrayList<Integer>());
            graph.get(conn.get(0)).add(conn.get(1));
            graph.get(conn.get(1)).add(conn.get(0));
        }

        dfs(graph, 0, -1, count, time, low, result);
        return result;
    }

    void dfs(HashMap<Integer, List<Integer>> graph, int cur, int pre, int[] count, int[] time, int[] low, List<List<Integer>> result) {
        count[0] = count[0] + 1;
        time[cur] = count[0];
        low[cur] = count[0];
        for (int next : graph.getOrDefault(cur, new ArrayList<Integer>())) {
            if (time[next] == 0) {
                dfs(graph, next, cur, count, time, low, result);
                low[cur] = Math.min(low[cur], low[next]);
            } else if (next != pre) {
                low[cur] = Math.min(low[cur], time[next]);
            }
            if (low[next] > time[cur]) {
                List<Integer> edge = new ArrayList<>();
                edge.add(cur);
                edge.add(next);
                result.add(edge);
            }
        }
    }


}
