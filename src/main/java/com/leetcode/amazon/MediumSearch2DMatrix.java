package com.leetcode.amazon;

/**
 * Leet 74. Search a 2D Matrix (Medium)
 * Link: https://leetcode.com/problems/search-a-2d-matrix/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
 * Memory Usage: 38 MB, less than 99.00% of Java online submissions for Search a 2D Matrix.
 */
public class MediumSearch2DMatrix {

    public static void main(String[] args) {

        MediumSearch2DMatrix tester = new MediumSearch2DMatrix();

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println("Your answer:" + tester.searchMatrix(matrix, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        // 1. position on which row, improve by binary search
        if(  matrix[0][0] > target ) {
            return false;
        }

        int i = 1;
        for(; i < matrix.length; i++) {
            int x = matrix[i][0];
            if( x > target)
                break;
        }

        // 2. on target row position number, improve by binary search
        int row = i - 1;
        for(int j = 0 ; j < matrix[row].length; j++) {
            if( target == matrix[row][j])
            return true;
        }

        return false;

    }

}
