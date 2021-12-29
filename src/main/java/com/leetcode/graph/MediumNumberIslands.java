package com.leetcode.graph;

/**
 * Leet: 200. Number of Islands (Medium)
 * Link:  https://leetcode.com/problems/number-of-islands/
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
 * all four edges of the grid are all surrounded by water.
 * Runtime: 2 ms, faster than 84.98% of Java online submissions for Number of Islands.
 * Memory Usage: 47.2 MB, less than 50.95% of Java online submissions for Number of Islands.
 */
public class MediumNumberIslands {
    public static void main(String[] args) {
        MediumNumberIslands tester = new MediumNumberIslands();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(tester.numIslands(grid1) == 1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(tester.numIslands(grid2) == 3);

        char[][] grid3 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}};
         System.out.println(tester.numIslands(grid3) == 1);

         char[][] grid4 = {
                 {'1', '1', '1', '1', '1', '1', '1'},
                 {'0', '0', '0', '0', '0', '0', '1'},
                 {'1', '1', '1', '1', '1', '0', '1'},
                 {'1', '0', '0', '0', '1', '0','1'},
                 {'1', '0', '1', '0', '1', '0', '1'},
                 {'1', '0', '1', '1', '1', '0', '1'},
                 {'1', '1', '1', '1', '1', '1', '1'}};
        System.out.println(tester.numIslands(grid4) == 1);
    }

    public int numIslands(char[][] grid) {

        int row = grid.length;
        if( row == 0 ) return 0;
        int col = grid[0].length;
        boolean[][] tags = new boolean[row][col];
        int count = 0;

        // Scan to pick islands
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    checkPoint(i - 1, j, grid);
                    checkPoint(i, j - 1, grid);
                    checkPoint(i + 1, j, grid);
                    checkPoint(i, j + 1, grid);
                }
            }
        }

        return count;

    }

    private void checkPoint(int x, int y, char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if( x < 0 || x >= row || y  < 0 || y >= col)
            return;

        if( grid[x][y] == '1') {
            grid[x][y] = '0';
            checkPoint(x - 1, y, grid);
            checkPoint(x, y - 1, grid);
            checkPoint(x + 1, y, grid);
            checkPoint(x, y + 1, grid);
        }
    }

}