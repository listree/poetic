package com.leetcode.dynamic;

/**
 1025. Divisor Game
 Alice and Bob take turns playing a game, with Alice starting first.
 Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
 Choosing any x with 0 < x < N and N % x == 0.
 Replacing the number N on the chalkboard with N - x.
 Also, if a player cannot make a move, they lose the game.
 Return True if and only if Alice wins the game, assuming both players play optimally.
 Example 1:
 Input: 2
 Output: true
 Explanation: Alice chooses 1, and Bob has no more moves.
 Example 2:

 Input: 3
 Output: false
 Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.


 Note:

 1 <= N <= 1000
 */
public class EasyDivisorGame {

    /*
        Runtime: 4 ms, faster than 22.09% of Java online submissions for Divisor Game.
        Memory Usage: 32.8 MB, less than 13.33% of Java online submissions for Divisor Game.
     */
    public boolean divisorGame(int N) {

        boolean[] wins = new boolean[N+1];
        wins[1]  = false;

        for( int i = 2; i <= N; i++) {
            wins[i] = false;
            for( int j = 1; j < i; j++ ) {
                if (i % j == 0) {
                    if (!wins[i - j]) { // solution key: force opponent to lose at i-j
                        wins[i] = true;
                        break;
                    }
                }
            }
        }
        return wins[N];

    }

}
