package com.leetcode.dynamic;

/**
 931. Minimum Falling Path Sum
 Given a square array of integers A, we want the minimum sum of a falling path through A.
 A falling path starts at any element in the first row, and chooses one element from each row.
 The next row's choice must be in a column that is different from the previous row's column by at most one.
 Example 1:

 Input: [[1,2,3],[4,5,6],[7,8,9]]
 Output: 12
 Explanation:
 The possible falling paths are:
 [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 The falling path with the smallest sum is [1,4,7], so the answer is 12.
 */
public class MediumMinFallingPathSum {

    public static void main (String[] args) {
        int A[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int result = minFallingPathSum(A);
        System.out.print( "Answer: " + result + " - Result: " + (result == 12));
    }

    /**
     * Runtime: 4 ms, faster than 38.86% of Java online submissions for Minimum Falling Path Sum.
     * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Minimum Falling Path Sum.
     */
    static int minFallingPathSum(int[][] A) {

        int N = A.length;
        for (int row = N - 2; row > -1; row--) {
            for (int column = 0; column < N; column++) {

                int min1, min2;

                if (column != 0)
                    min1 = Math.min(A[row + 1][column - 1], A[row + 1][column]);
                else
                    min1 = Integer.MAX_VALUE;

                if (column != (N - 1))
                    min2 = Math.min(A[row + 1][column], A[row + 1][column + 1]);
                else
                    min2 = Integer.MAX_VALUE;

                A[row][column] += Math.min(min1, min2);

            }
        }

        int min = Integer.MAX_VALUE;
        for (int column = 0; column < N; column++) {
            min = Math.min(min, A[0][column]);
        }

        return min;
    }
}

