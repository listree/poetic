package com.leetcode.general;

/**
 * Question: 122. Best Time to Buy and Sell Stock II
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
public class E122StockTrade {
    public static final void main(String[] args) {

        E122StockTrade tester = new E122StockTrade();

        //    Example 1:    Input: [7,1,5,3,6,4]
        //    Output: 7
        //    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        //    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        int[] prices1 = {7,1,5,3,6,4};
        System.out.println(tester.maxProfit(prices1));

        //    Example 2:
        //    Input: [1,2,3,4,5]
        //    Output: 4
        //    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        //    Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
        //    engaging multiple transactions at the same time. You must sell before buying again.
        int[] prices2 = {1,2,3,4,5};
        System.out.println(tester.maxProfit(prices2));

        //    Example 3:
        //    Input: [7,6,4,3,1]
        //    Output: 0
        //    Explanation: In this case, no transaction is done, i.e. max profit = 0.
        int[] prices3 = {7,6,4,3,1};
        System.out.println(tester.maxProfit(prices3));
    }

    /*
    Runtime: 1 ms, faster than 92.31% of Java online submissions for Best Time to Buy and Sell Stock II.
    Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II
    */

    public int maxProfit(int[] prices) {

        int days = prices.length;
        if (days < 2)
            return 0;

        int maxProfit = 0;
        int i = 0;
        int buyPrice = 0;
        int sellPrice = 0;

        while (i < days) {

            // find buy time
            while ( i < (days-1) && prices[i] >= prices[i + 1] ) {
                i++;
            }

            if (i < (days-1) )
                buyPrice = prices[i];
            else
                return maxProfit;

            //find sell time
            while (i < (days-1) && prices[i] <= prices[i + 1]) {
                i++;
            }

            if (i < days) {
                sellPrice = prices[i];
                maxProfit += (sellPrice - buyPrice);
            }
            i++;

        } // while

        return maxProfit;
    }

}