package com.leetcode.dynamic;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * 63. Unique Paths II (Medium)
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or
 * right at any point in time. An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot
 * takes cannot include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 * Runtime: 1 ms, faster than 57.28% of Java online submissions for Unique Paths II.
 * Memory: 42.7 MB, less than 16.98% of Java online submissions for Unique Paths II.
 */
public class MediumUniquePathII {

    public final static void main(String[] args) {
        MediumUniquePathII me = new MediumUniquePathII();
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}};
        System.out.println(me.uniquePathsWithObstacles(obstacleGrid)); // 2

        int[][] obstacleGrid2 = {
                {0,1},
                {0,0}};
        System.out.println(me.uniquePathsWithObstacles(obstacleGrid2)); // 1

        int[][] obstacleGrid3 = {
                {0,0},
                {0,1}};
        System.out.println(me.uniquePathsWithObstacles(obstacleGrid3)); // 0

    }

    int[][] grid;
    int m, n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        grid = new int[m][n];
        for( int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if( obstacleGrid[i][j] == 1)
                    grid[i][j] = 0;
                else
                    grid[i][j] = -1;
            }
        }

        boolean existsObstacle = false;
        for( int i = m - 1 ; i > -1; i--) {
            if( existsObstacle )
                grid[i][n-1] = 0;
            else if( obstacleGrid[i][n-1] == 1 ) {
                existsObstacle = true;
                grid[i][n-1] = 0;
            } else {
                grid[i][n-1] = 1;
            }
        }

        existsObstacle = false;
        for( int j = n - 1 ; j > -1; j--) {
            if( existsObstacle )
                grid[m-1][j] = 0;
            else if( obstacleGrid[m-1][j] == 1 ) {
                existsObstacle = true;
                grid[m-1][j] = 0;
            } else {
                grid[m-1][j] = 1;
            }
        }

        return uniquePathsWithObstacles(0, 0);

    }

    public int uniquePathsWithObstacles(int i, int j) {

        //System.out.println( i + " " + j + " " + m + " "  + n);
        if( grid[i][j] != - 1)
            return grid[i][j];

        int sum = uniquePathsWithObstacles(i + 1, j) + uniquePathsWithObstacles(i, j + 1);
        grid[i][j] = sum;
        return sum;
    }

}
