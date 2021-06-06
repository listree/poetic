package com.leetcode.dynamic;

/**
 1155. Number of Dice Rolls With Target Sum
 https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

 You have d dice, and each die has f faces numbered 1, 2, ..., f.
 Return the number of possible ways (out of fd total ways) modulo 10^9 + 7
 to roll the dice so the sum of the face up numbers equals target.

 Example 1:
 Input: d = 1, f = 6, target = 3
 Output: 1
 Explanation:
 You throw one die with 6 faces.  There is only one way to get a sum of 3.

 Example 2:
 Input: d = 2, f = 6, target = 7
 Output: 6
 Explanation:
 You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.

 Example 3:
 Input: d = 2, f = 5, target = 10
 Output: 1
 Explanation:
 You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.

 Example 4:
 Input: d = 1, f = 2, target = 3
 Output: 0
 Explanation:
 You throw one die with 2 faces.  There is no way to get a sum of 3.

 Example 5:
 Input: d = 30, f = 30, target = 500
 Output: 222616187
 Explanation:
 The answer must be returned modulo 10^9 + 7.

 Constraints:
 1 <= d, f <= 30
 1 <= target <= 1000
 */
public class MediumNumOfRollsToTarget {

    public final static void main(String[] args) {

        System.out.println( "Example1: 1 = " + numRollsToTarget(1, 6, 3));
        System.out.println( "Example2: 6 = " + numRollsToTarget(2, 6, 7));
        System.out.println( "Example3: 1 = " + numRollsToTarget(2, 5, 10));
        System.out.println( "Example4: 0 = " + numRollsToTarget(1, 2, 3));
        System.out.println( "Example5: 222616187 = " + numRollsToTarget(30, 30, 500));
    }

    /*
    Runtime: 9 ms, faster than 73.40% of Java online submissions for Number of Dice Rolls With Target Sum.
    Memory Usage: 35.3 MB, less than 100.00% of Java online submissions for Number of Dice Rolls With Target Sum.
    */
    public static int numRollsToTarget(int d, int f, int target) {
        int MOD = 1000000007;
        int[][] memo = new int[d + 1][target + 1];
        memo[0][0] = 1;

        for(int i = 1; i <= d; i++) {
            for(int j = 1; j<= target; j++) {
                if(j > i * f) {
                    continue;
                } else {
                    for(int k = 1; k <= f && k <= j ; k++) {
                        memo[i][j] += memo[i - 1][j - k];
                        memo[i][j] = memo[i][j] % MOD;
                    }
                }
            }
        }
        return memo[d][target];
    }
}
