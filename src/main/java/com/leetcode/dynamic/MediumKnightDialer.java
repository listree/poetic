package com.leetcode.dynamic;

import java.util.Arrays;

/**
 * 935. Knight Dialer
 A chess knight can move as indicated in the chess diagram below:
 This time, we place our chess knight on any numbered key of a phone pad (indicated above),
 and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.
 Each time it lands on a key (including the initial placement of the knight),
 it presses the number of that key, pressing N digits total.
 How many distinct numbers can you dial in this manner?
 Since the answer may be large, output the answer modulo 10^9 + 7.

 Example 1:
 Input: 1
 Output: 10

 Example 2:
 Input: 2
 Output: 20

 Example 3:
 Input: 3
 Output: 46

 Note:
 1 <= N <= 5000
 */
public class MediumKnightDialer {

    public final static void main(String[] args) {
        System.out.println(knightDialer(1));
        System.out.println(knightDialer(2));
        System.out.println(knightDialer(3));
        System.out.println(knightDialer(161));
    }

    /*
    Runtime: 16 ms, faster than 88.52% of Java online submissions for Knight Dialer.
    Memory Usage: 32.9 MB, less than 100.00% of Java online submissions for Knight Dialer.
    */
    public static int knightDialer(int N) {
        int[][] from = {{4, 6},           // 0
                {6, 8}, {7, 9}, {4, 8},   // 1, 2, 3
                {0, 3, 9}, {}, {0, 1, 7}, // 4, 5, 6
                {2, 6}, {1, 3}, {2, 4}};  // 7, 8, 9
        int[] result = new int[10];

        //init
        for (int i = 0; i < result.length; i++)
            result[i] = 1;

        // for 2 -> N
        int[] newResult = new int[10];
        for( int k = 1; k < N; k++) {
            for (int i = 0; i < 10; i++) {
                int sum = 0;
                for (int x : from[i]) {
                    sum += result[x];
                    sum = sum  % 1000000007;
                }
                newResult[i] = sum;
            }

            //swap
            for (int i = 0; i < 10; i++) {
                result[i] = newResult[i];
            }
        }

        return _sum(result);
    }

    // Arrays.asList(xs).stream().reduce(0, (a, b) -> a + b);
    static int _sum(int[] xs) {
        int sum = 0;
        for (int i = 0; i < xs.length; i++) {
            sum += xs[i];
            sum = sum % 1000000007;
        }
        return sum;
    }

}
