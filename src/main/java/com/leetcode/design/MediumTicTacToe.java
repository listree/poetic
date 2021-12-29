package com.leetcode.design;

/**
 * https://leetcode.com/problems/design-tic-tac-toe/
 * 348. Design Tic-Tac-Toe (Medium)
 * Assume the following rules are for the tic-tac-toe game on an n x n board between two players:
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves are allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * Implement the TicTacToe class:
 * TicTacToe(int n) Initializes the object the size of the board n.
 * int move(int row, int col, int player) Indicates that the player with id player plays at the cell (row, col) of the board.
 * The move is guaranteed to be a valid move.
 * Runtime: 5 ms, faster than 57.82% of Java online submissions for Design Tic-Tac-Toe.
 * Memory: 47.8 MB, less than 54.45% of Java online submissions for Design Tic-Tac-Toe.
 */
public class MediumTicTacToe {

    int[][] mark;
    int n;
    public MediumTicTacToe(int n) {
        this.n = n;
        this.mark = new int[n][n];
    }

    public int move(int row, int col, int player) {
        mark[row][col] = player;
        if( checkRow(row, player) )
            return player;
        if( checkColumn(col, player) )
            return player;
        if( checkDiagonal(player) )
            return player;
        if( checkDiagonal2(player) )
            return player;

        return 0;
    }

    boolean checkRow(int row, int player) {
        for (int i = 0; i < n; i++) {
            if (mark[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    boolean checkColumn(int column, int player) {
        for (int i = 0; i < n; i++) {
            if (mark[i][column] != player) {
                return false;
            }
        }
        return true;
    }

    boolean checkDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if( mark[i][i] != player )
                return false;
        }
        return true;
    }

    boolean checkDiagonal2(int player) {
        for (int i = n; i > 0 ; i--) {
            if( mark[n-i][i-1] != player )
                return false;
        }
        return true;
    }

}