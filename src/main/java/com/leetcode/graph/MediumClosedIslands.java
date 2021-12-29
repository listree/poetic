package com.leetcode.graph;

/**
 * https://leetcode.com/problems/number-of-closed-islands/
 * 1254. Number of Closed Islands (Medium)
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s
 * and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * Return the number of closed islands.
 * Runtime: 23 ms, faster than 5.36% of Java online submissions for Number of Closed Islands.
 * Memory Usage: 47.8 MB, less than 14.25% of Java online submissions for Number of Closed Islands.
 */
public class MediumClosedIslands {

    public final static void main(String[] args) {
        MediumClosedIslands tester = new MediumClosedIslands();
        int[][] grid = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };
        System.out.println( tester.closedIsland(grid) ); // 2

        int[][] grid2 = {
                {0,0,1,0,0},
                {0,1,0,1,0},
                {0,1,1,1,0}
        };
        System.out.println( tester.closedIsland(grid2) ); // 1

        int[][] grid3 = {
                {0,0,1,1,0,1,0,0,1,0},
                {1,1,0,1,1,0,1,1,1,0},
                {1,0,1,1,1,0,0,1,1,0},
                {0,1,1,0,0,0,0,1,0,1},
                {0,0,0,0,0,0,1,1,1,0},
                {0,1,0,1,0,1,0,1,1,1},
                {1,0,1,0,1,1,0,0,0,1},
                {1,1,1,1,1,1,0,0,0,0},
                {1,1,1,0,0,1,0,1,0,1},
                {1,1,1,0,1,1,0,1,1,0}};
        System.out.println( tester.closedIsland(grid3) ); // 5

        int[][] grid4 = {
            {1,1,0,1,1,1,1,1,1,1},
            {0,0,1,0,0,1,0,1,1,1},
            {1,0,1,0,0,0,1,0,1,0},
            {1,1,1,1,1,0,0,1,0,0},
            {1,0,1,0,1,1,1,1,1,0},
            {0,0,0,0,1,1,0,0,0,0},
            {1,0,1,0,0,0,0,1,1,0},
            {1,1,0,0,1,1,0,0,0,0},
            {0,0,0,1,1,0,1,1,1,0},
            {1,1,0,1,0,1,0,0,1,0}};
        System.out.println( tester.closedIsland(grid4) ); // 4

    }

    public int closedIsland(int[][] grid) {
        int sum = 0;
        for(int i = 0 ; i < grid.length; i++)
            for(int j = 0 ; j < grid[0].length; j++) {
                if( grid[i][j] == 0) {
                    if(dfs(grid, i, j)) {// check island
                        System.out.println(" " + i + " " +j);
                        sum++;
                    }
                }
            }
        return sum;
    }

    private boolean check(int[][] grid, int x, int y) {
        return x > -1 && x < grid.length && y > -1 && y < grid[0].length && grid[x][y] == 0;

    }
    private boolean dfs(int[][] grid, int i, int j) {

        grid[i][j] = -1;
        boolean island = true;
        if (i == 0 || i == (grid.length - 1) || j == 0 || (j == grid[0].length - 1)) {
            island = false;
        }

        int x = i + 1; int y = j;
        if ( check(grid, x, y) ) {
            boolean next = dfs(grid, x, y);
            island = island && next;
        }

        x = i -1; y = j;
        if ( check(grid, x, y) ) {
            boolean next = dfs(grid, x, y);
            island = island && next;
        }

        x = i; y = j -1;
        if ( check(grid, x, y) ) {
            boolean next = dfs(grid, x, y);
            island = island && next;
        }

        x = i; y = j + 1;
        if ( check(grid, x, y) ) {
            boolean next = dfs(grid, x, y);
            island = island && next;
        }

        return island;
    }

}
