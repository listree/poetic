package com.leetcode.amazon;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * 36. Valid Sudoku (Medium)
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 * Poem Runtime: 3 ms, faster than 71.15% of Java online submissions for Valid Sudoku.
 * Memory Usage: 42.3 MB, less than 50.42% of Java online submissions for Valid Sudoku.
 */
public class MediumValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if( board.length != 9 )
            return false;

        if( board[0].length != 9 )
            return false;

        for(int i = 0; i < 9; i++) {
            if (!isValidRow(board, i))
                return false;
            if (!isValidColumn(board, i))
                return false;
        }

        for(int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if(!isValidSubBox(board, i, j))
                    return false;
            }
        }

        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        boolean[] exists = new boolean[9];
        for(int i = 0 ; i < 9; i++) {
            if( board[row][i] >= '0' && board[row][i] <= '9') {
                int x = board[row][i] - '1';
                if (exists[x])
                    return false;
                else
                    exists[x] = true;
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int column) {
        boolean[] exists = new boolean[9];
        for(int i = 0 ; i < 9; i++) {
            if( board[i][column] >= '0' && board[i][column] <= '9') {
                int x = board[i][column] - '1';
                if (exists[x])
                    return false;
                else
                    exists[x] = true;
            }
        }
        return true;
    }

    private boolean isValidSubBox(char[][] board, int row, int column) {
        boolean[] exists = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[row + i][column + j];
                if (c >= '0' && c <= '9') {
                    int x = c - '1';
                    if (exists[x])
                        return false;
                    else
                        exists[x] = true;
                }
            }
        }
        return true;
    }

}
