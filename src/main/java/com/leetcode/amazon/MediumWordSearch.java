package com.leetcode.amazon;

/**
 * https://leetcode.com/problems/word-search/
 * 79. Word Search (Medium)
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 * Runtime: 363 ms, faster than 13.01% of Java online submissions for Word Search.
 * Memory: 42.7 MB, less than 26.64% of Java online submissions for Word Search.
 */

public class MediumWordSearch {

    public final static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        MediumWordSearch me = new MediumWordSearch();
        System.out.println( me.exist(board, word) ); // true

    }

    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (search(board, i, j, word) )
                    return true;
            }
        }
        return false;

    }

    private boolean search(char[][] board, int i, int j, String word) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;

        if (word.length() == 0) {
            return true;
        }

        if (board[i][j] != word.charAt(0))
            return false;

        if( word.length() == 1 )
            return true;

        char c = board[i][j];
        board[i][j] = '-'; // mark as visited
        if (search(board, i - 1, j, word.substring(1)))
            return true;

        if (search(board, i + 1, j, word.substring(1)))
            return true;

        if (search(board, i, j-1, word.substring(1)))
            return true;

        if (search(board, i, j+1, word.substring(1)))
            return true;

        board[i][j] = c; // revoke mark

        return false;
    }

}