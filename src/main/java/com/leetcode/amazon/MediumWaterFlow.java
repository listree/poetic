package com.leetcode.amazon;

import java.util.*;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * 417. Pacific Atlantic Water Flow (Medium)
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean
 * touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where
 * heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east,
 * and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from
 * any cell adjacent to an ocean into the ocean. Return a 2D list of grid coordinates result where result[i] = [ri, ci]
 * denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 * Peom Runtime: 98 ms, faster than 11.54% of Java online submissions for Pacific Atlantic Water Flow.
 * Memory Usage: 68.3 MB, less than 6.84% of Java online submissions for Pacific Atlantic Water Flow.
 */
public class MediumWaterFlow {

    public final static void main(String[] args) {
        MediumWaterFlow tester = new MediumWaterFlow();
        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

        List<List<Integer>> result = tester.pacificAtlantic(heights);
        //Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
        for(List list: result) {
            System.out.print("(" + list.get(0) + "," + list.get(1) +")");
        }
    }

    static class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String toString() {
            return "(" + row + ","  + col +")";
        }

        public boolean equals(Object another) {
            if( another instanceof Pair )
                return this.row == ((Pair) another).row
                        && this.col == ((Pair) another).col;
            else
                return false;
        }

        public int hashCode() {
            return ("" + row + "" + col).hashCode();
        }

    }

    private void dfs(int row, int col, int[][] heights, HashSet oceanSet, int height) {

        Pair pair = new Pair(row, col);

        if( row < 0
            || row >= heights.length
            || col < 0
            || col >= heights[0].length
        ) return;
        if( oceanSet.contains(pair))
            return;

        if( heights[row][col] < height)
            return;

        oceanSet.add(pair);
        dfs(row - 1, col, heights, oceanSet, heights[row][col]);
        dfs(row + 1, col, heights, oceanSet, heights[row][col]);
        dfs(row, col - 1, heights, oceanSet, heights[row][col]);
        dfs(row, col + 1, heights, oceanSet, heights[row][col]);

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        HashSet pacificFlow = new HashSet<Pair>();
        HashSet atlanticFlow = new HashSet<Pair>();

        int m = heights.length;
        int n = heights[0].length;

        for(int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacificFlow, heights[i][0]);
            dfs(i, n-1, heights, atlanticFlow, heights[i][n-1]);
        }

        for(int j = 0; j < n; j++) {
            dfs(0, j, heights, pacificFlow, heights[0][j]);
            dfs(m-1, j, heights, atlanticFlow, heights[m-1][j]);
        }

        List<List<Integer>> pacificAtlanticList = new ArrayList<List<Integer>>();
        System.out.println(pacificFlow);
        System.out.println(atlanticFlow);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Pair pair = new Pair(i, j);
                if( pacificFlow.contains(pair) && atlanticFlow.contains(pair) )
                    pacificAtlanticList.add(Arrays.asList(i, j));
            }
        }

        return pacificAtlanticList;

    }


}
