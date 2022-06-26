package com.leetcode.general;

/**
 * 123. Best Time to Buy and Sell Stock III  (Hard)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * Poet Runtime: 7 ms, faster than 49.64% of Java online submissions for Best Time to Buy and Sell Stock III.
 * Poem Memory: 80.5 MB, less than 44.06% of Java online submissions for Best Time to Buy and Sell Stock III.
 */

public class HardStockTradeIII {

    public final static void main(String[] args) {
        HardStockTradeIII tester = new HardStockTradeIII();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(tester.maxProfit(prices));

        int[] prices2 = {1,2,3,4,5};
        System.out.println(tester.maxProfit(prices2));

        int[] prices3 = {7,6,4,3,1};
        System.out.println(tester.maxProfit(prices3));

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        //highest profit in 0 ... i
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        // DP from left to right
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        // DP from right to left
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }

        return profit;
    }
}
