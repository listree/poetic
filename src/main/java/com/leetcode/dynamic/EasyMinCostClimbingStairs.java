package com.leetcode.dynamic;

/**
 746. Min Cost Climbing Stairs

 On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 Once you pay the cost, you can either climb one or two steps.
 You need to find minimum cost to reach the top of the floor,
 and you can either start from the step with index 0, or the step with index 1.

 Example 1:
 Input: cost = [10, 15, 20]
 Output: 15
 Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

 Example 2:
 Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 Output: 6
 Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

 Note:
 cost will have a length in the range [2, 1000].
 Every cost[i] will be an integer in the range [0, 999].
 */
public class EasyMinCostClimbingStairs {

    public final static void main(String[] args) {

        int[] cost = {10, 15, 20};
        int result = minCostClimbingStairs(cost);
        System.out.println( "Result must be 15 = " + result);

        int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int result2 = minCostClimbingStairs(cost1);
        System.out.println( "Result must be 6 = " + result2);

    }

    /* None Rec DP
    Runtime: 1 ms, faster than 99.95% of Java online submissions for Min Cost Climbing Stairs.
    Memory Usage: 38.8 MB, less than 67.86% of Java online submissions for Min Cost Climbing Stairs.
    */
    public static int minCostClimbingStairs(int[] cost) {

        int m1 = 0, m2 = 0;
        for (int i = cost.length - 1; i > -1; i--) {
            int m0 = cost[i] + Math.min(m1, m2);
            m2 = m1;
            m1 = m0;
        }
        return Math.min(m1, m2);
    }


}
