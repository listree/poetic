package com.leetcode.dynamic;

/**
 * https://leetcode.com/problems/coin-change/
 * 322. Coin Change (Medium)
 * You are given an integer array coins representing coins of different denominations and an integer amount representing
 * a total amount of money. Return the fewest number of coins that you need to make up that amount. If that amount of
 * money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * Runtime: 27 ms, faster than 49.02% of Java online submissions for Coin Change.
 * Memory: 45.8 MB, less than 24.90% of Java online submissions for Coin Change.
 */
public class MediumCoinChange {
    
    public int coinChange(int[] coins, int amount) {

        if (amount <= 0)
            return 0;

        int[] mins = new int[amount + 1];

        mins[0] = 0;
        for (int x = 1; x <= amount; x++)
            mins[x] = -1;

        for (int x = 1; x <= amount; x++) {
            if (mins[x] == -1) {
                int min = Integer.MAX_VALUE;
                for (int y : coins) {
                    int d = x - y;
                    if (d >= 0 && mins[d] >= 0) {
                        min = Math.min(min, mins[d] + 1);
                    }
                }
                if (min != Integer.MAX_VALUE)
                    mins[x] = min;
            }
        }

        return mins[amount];
    }
}
