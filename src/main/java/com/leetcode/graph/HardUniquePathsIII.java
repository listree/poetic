package com.leetcode.graph;

/**
 * https://leetcode.com/problems/unique-paths-iii/
 * 980. Unique Paths III (Hard)
 * You are given an m x n integer array grid where grid[i][j] could be:
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square,
 * that walk over every non-obstacle square exactly once.
 * Runtime: 1 ms, faster than 91.36% of Java online submissions for Unique Paths III.
 * Memory: 41.3 MB, less than 67.90% of Java online submissions for Unique Paths III.
 */
public class HardUniquePathsIII {

    public final static void main(String[] args) {
        HardUniquePathsIII ha = new HardUniquePathsIII();
        int[][] grid = {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1}
        };
        System.out.println("uniquePathsIII=" + ha.uniquePathsIII(grid)); // 2

        int[][] grid2 = {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,0,2}
        };
        System.out.println("uniquePathsIII=" + ha.uniquePathsIII(grid2)); // 4

        int[][] grid3 = {
                {0,1},
                {2,0}
        };
        System.out.println("uniquePathsIII=" + ha.uniquePathsIII(grid3)); // 0

    }

    int countPaths = 0;
    int totalEmpties =  0;
    int visitedEmpties =  0;
    public int uniquePathsIII(int[][] grid) {
        countPaths = 0;
        totalEmpties =  0;
        visitedEmpties =  0;
        int startX = 0;
        int startY = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    totalEmpties++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        check(grid, startX, startY);
        return countPaths;
    }


    public void check(int[][] grid, int x, int y) {

        //System.out.println("Visit: " + x + " " + y);
        if( x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return;

        if( grid[x][y] == 2 ) {
            //System.out.println("Hit End, countEmpties=" + visitedEmpties);
            if(visitedEmpties == totalEmpties )
                countPaths++;
            return;
        }

        if( grid[x][y] == Integer.MIN_VALUE ) {
            return;
        }

        if( grid[x][y] == Integer.MAX_VALUE ) {
            // System.out.println("Revisit Empty, stop");
            return;
        }

        if( grid[x][y] == 0 || grid[x][y] == 1) {
            if( grid[x][y] == 0 )
                visitedEmpties++;

            grid[x][y] = grid[x][y] == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            // if( visitedEmpties > 10)
            //    return;

            check(grid, x, y - 1);
            check(grid, x, y + 1);
            check(grid, x + 1, y);
            check(grid, x - 1, y);
            if( grid[x][y] == Integer.MAX_VALUE) {
                grid[x][y] = 0;
                visitedEmpties--;
            }
        }

    }

}
