package com.leetcode.graph;

/**
 * https://leetcode.com/problems/max-area-of-island/
 * 695. Max Area of Island (Medium)
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * Runtime: 2 ms, faster than 91.91% of Java online submissions for Max Area of Island.
 * Memory Usage: 48.2 MB, less than 19.71% of Java online submissions for Max Area of Island.
 */
public class MediumMaxAreaIsland {
    public final static void main(String[ ] args) {
        MediumMaxAreaIsland tester = new MediumMaxAreaIsland();
        int[][] grid =
            {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
            };
        System.out.println( tester.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int max = 0;
        for( int i = 0; i < row; i++ ) {
            for( int j = 0; j < column; j++ ) {
                if( grid[i][j] == 1) {
                    int currentMax = dfs(grid, i, j);
                    max = Math.max( max, currentMax);
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int i, int j) {

        if (grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = -1;
        int area = 1;

        int x = i - 1; int y = j;
        if ( x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
            area = area + dfs(grid, x, y);
        }
        x = i + 1; y = j;
        if ( x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
            area = area + dfs(grid, x, y);
        }
        x = i; y = j - 1;
        if ( x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
            area = area + dfs(grid, x, y);
        }
        x = i; y = j + 1;
        if ( x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
            area = area + dfs(grid, x, y);
        }

        return area;
    }

}
