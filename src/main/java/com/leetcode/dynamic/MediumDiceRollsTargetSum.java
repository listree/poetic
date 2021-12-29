package com.leetcode.dynamic;

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum
 * 1155. Number of Dice Rolls With Target Sum  (Medium)
 * You have n dice and each die has k faces numbered from 1 to k.
 * Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice
 * so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.
 * Runtime: 36 ms, faster than 53.07% of Java online submissions for Number of Dice Rolls With Target Sum.
 * Memory: 42.5 MB, less than 55.50% of Java online submissions for Number of Dice Rolls With Target Sum.
 */
public class MediumDiceRollsTargetSum {

    public final static void main(String[] args) {

        MediumDiceRollsTargetSum tester = new MediumDiceRollsTargetSum();
        System.out.println(tester.numRollsToTarget(1, 6, 3)); // ans: 1
        System.out.println(tester.numRollsToTarget(2, 6, 7)); // ans: 6
        System.out.println(tester.numRollsToTarget(30, 30, 500)); // ans: 222616187

    }

    public int numRollsToTarget(int n, int k, int target) {

        int[][] mem = new int[n+1][target+1];
        for( int x = 1; x <= k; x++) {
            if( x <= target)
                mem[1][x] = 1;
        }

        for( int m = 2; m <= n; m++) {
            for( int t = m; t <= target; t++) {
                int count = 0;
                for( int h = 1; h <= k; h++) {
                    if( (t-h) > 0 ) {
                        count = count + mem[m - 1][t - h];
                        count = count % 1000000007;
                    }
                }
                mem[m][t] = count;
            }
        }

        return mem[n][target];
    }

}
