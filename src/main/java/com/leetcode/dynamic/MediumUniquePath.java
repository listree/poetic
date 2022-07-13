package com.leetcode.dynamic;

import com.leetcode.MatrixNode;

/**
 * https://leetcode.com/problems/unique-paths
 * 62. Unique Paths (Medium)
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down
 * or right at any point in time. * Given the two integers m and n, return the number of possible unique paths that
 * the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
 * Memory: 41.5 MB, less than 17.12% of Java online submissions for Unique Paths.
 */
public class MediumUniquePath {

    public final static void main(String[] args) {
        MediumUniquePath me = new MediumUniquePath();
        System.out.println(me.uniquePaths(1, 1)); // 1
        System.out.println(me.uniquePaths(3, 7)); // 28
        System.out.println(me.uniquePaths(3, 2)); // 3
    }

    int[][] grid;
    public int uniquePaths(int m, int n) {
        grid = new int[m][n];
        for( int i = 0 ; i < m; i++)
            for( int j = 0 ; j < n; j++)
                grid[i][j] = -1;

        for( int i = 0 ; i < m - 1; i++)
            grid[i][n-1] = 1;

        for( int j = 0 ; j < n - 1; j++)
            grid[m-1][j] = 1;

        grid[m-1][n-1] = 1;

        return uniquePaths(0, 0, m, n);

    }

    public int uniquePaths(int i, int j, int m, int n) {

        //System.out.println( i + " " + j + " " + m + " "  + n);
        if( grid[i][j] != - 1)
            return grid[i][j];

        int sum = uniquePaths(i + 1, j, m, n) + uniquePaths(i, j + 1, m, n);
        grid[i][j] = sum;
        return sum;
    }

}
