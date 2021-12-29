package com.leetcode.amazon;

import javax.swing.text.html.ListView;

/**
 * https://leetcode.com/problems/game-of-life/
 * 289. Game of Life  (Medium)
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by
 * the British mathematician John Horton Conway in 1970." The board is made up of an m x n grid of cells, where each
 * cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight
 * neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where
 * births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 * Poem Runtime: 1 ms, faster than 50.32% of Java online submissions for Game of Life.
 * Memory Usage: 42.5 MB, less than 5.01% of Java online submissions for Game of Life.
 */
public class MediumGameOfLife {

    private int isLive(int[][] board, int i, int j) {
        return (
                i >= 0 && i < board.length
                && j >=0 && j < board[0].length
                && board[i][j] == 1
        )? 1 : 0;

    }

    private int countLiveNeighbors(int[][] board, int i, int j) {
        int count = 0 ;
        count += isLive(board, i-1, j);
        count += isLive(board, i+1, j);
        count += isLive(board, i-1, j-1);
        count += isLive(board, i, j-1);
        count += isLive(board, i+1, j-1);
        count += isLive(board, i-1, j+1);
        count += isLive(board, i, j+1);
        count += isLive(board, i+1, j+1);

        return count;
    }

    public void gameOfLife(int[][] board) {
        // 2- live -> dead
        // 2,3 live - live
        // 3+ - live -> dead
        // 3 - dead -> live
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                int count = countLiveNeighbors(board, i, j);
                if (board[i][j] == 1)
                    newBoard[i][j] = ((count < 2) || (count > 3)) ? 0 : 1;
                else
                    newBoard[i][j] = (count == 3) ? 1 : 0;
            }

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = newBoard[i][j];
            }
    }
}
