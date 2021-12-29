package com.leetcode.amazon;

/**
 * https://leetcode.com/problems/minesweeper/
 * 529. Minesweeper (Medium)
 * Let's play the minesweeper game (Wikipedia, online game)!
 * You are given an m x n char matrix board representing the game board where:
 * 'M' represents an unrevealed mine,
 * 'E' represents an unrevealed empty square,
 * 'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
 * digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
 * 'X' represents a revealed mine.
 * You are also given an integer array click where click = [clickr, clickc] represents the next click position among all
 * the unrevealed squares ('M' or 'E').
 * Return the board after revealing this position according to the following rules:
 * If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
 * If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B' and all of its
 * adjacent unrevealed squares should be revealed recursively.
 * If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8')
 * representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 * Poem Runtime: 23 ms, faster than 5.60% of Java online submissions for Minesweeper.
 * Memory Usage: 54.7 MB, less than 5.70% of Java online submissions for Minesweeper.
 */
public class MediumMinesWeeper {
    public static final void main(String[] args) {
        MediumMinesWeeper tester = new MediumMinesWeeper();
        char[][] board = {
                {'E','E','E','E','E'},
                {'E','E','M','E','E'},
                {'E','E','E','E','E'},
                {'E','E','E','E','E'}
        };

        int[] click = {3,0};
        // ["B","1","E","1","B"],
        // ["B","1","M","1","B"],
        // ["B","1","1","1","B"],
        // ["B","B","B","B","B"]
        char[][] result = tester.updateBoard(board, click);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print( board[i][j] + "," );
            }
            System.out.println();
        }

    }

    public char[][] updateBoard(char[][] board, int[] click) {
        updateBoard2(board, click[0], click[1]);
        return board;
    }

    private boolean isBoard(char[][] board, int x, int y) {
        return x > -1 && x < board.length && y > -1 && y < board[0].length;
    }

    private boolean isMine(char[][] board, int x, int y) {
        return isBoard(board, x, y) && (board[x][y] == 'M' || board[x][y] == 'X');
    }

    private int count(char[][] board, int x, int y) {
        int count = 0 ;
        for(int i = x-1; i < x+2; i++) {
            for(int j = y-1; j < y+2; j++) {
                if((i != x || j != y) && isMine(board, i, j))
                    count++;
            }
        }
        return count;

    }

    private void updateBoard2(char[][] board, int x, int y) {
        if( !isBoard( board, x, y) )
            return;

        if( board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }

        if(board[x][y] == 'E') {
            int count = count(board, x, y);
            System.out.println( x + " " + y + " " + count);
            if( count != 0) {
                board[x][y] = (char) ('0' + count);;
            } else {
                board[x][y] = 'B';
                for (int i = x-1; i < x+2; i++) {
                    for (int j = y-1; j < y+2; j++) {
                        if (i != x || j != y)
                            updateBoard2(board, i, j);
                    }
                }
            }
        }

    }

}
