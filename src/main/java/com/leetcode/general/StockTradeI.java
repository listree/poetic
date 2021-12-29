package com.leetcode.general;

/**
 * 121. Best Time to Buy and Sell Stock (Easy)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future
 * to sell that stock. Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 * Poet Runtime: 1 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock.
 * Poem Memory: 58.6 MB, less than 91.31% of Java online submissions for Best Time to Buy and Sell Stock.
 */
public class StockTradeI {

    public final static void main(String[] args) {
        StockTradeI tester = new StockTradeI();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(tester.maxProfit(prices));

        int[] prices2 = {7,6,4,3,1};
        System.out.println(tester.maxProfit(prices2));

    }

    public int maxProfit(int[] prices) {
        int maxProfile = 0;

        int startValue = prices[0];
        for(int i = 1; i < prices.length; i++) {

            int currentValue = prices[i];
            if( currentValue > startValue ) {
                int profile = currentValue - startValue;
                maxProfile = Math.max(maxProfile, profile);
            } else {
                startValue = currentValue;
            }
        }

        return maxProfile;

    }

}
