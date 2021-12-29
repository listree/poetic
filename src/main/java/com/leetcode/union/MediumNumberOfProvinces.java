package com.leetcode.union;

import java.util.*;

/**
 * https://leetcode.com/problems/number-of-provinces/
 * 547. Number of Provinces (Medium)
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly
 * connected, and isConnected[i][j] = 0 otherwise. Return the total number of provinces.
 * Runtime: 2 ms, faster than 61.20% of Java online submissions for Number of Provinces.
 * Memory: 54.6 MB, less than 19.29% of Java online submissions for Number of Provinces.
 */
public class MediumNumberOfProvinces {

    public final static void main(String[] args) {
        MediumNumberOfProvinces solution = new MediumNumberOfProvinces();
        int[][] isConnected = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };

        System.out.println(solution.findCircleNum(isConnected));

    }

    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length];
        for(int i = 0; i < isConnected.length; i++)
            parent[i] = i;

        for(int i = 0; i < isConnected.length; i++) {
            for(int j = i+1; j < isConnected[i].length; j++) {
                if( isConnected[i][j] == 1)
                    union(i, j);
            }
        }

        HashSet set = new HashSet<Integer>();
        for(int i = 0 ; i < isConnected.length; i++) {
            set.add(find(i));
        }

        return set.size();

    }

    private int[] parent;
    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        parent[find(x)] = find(y);
    }

}
