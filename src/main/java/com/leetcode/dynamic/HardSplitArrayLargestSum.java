package com.leetcode.dynamic;

/**
 * 410. Split Array Largest Sum (Hard)
 * https://leetcode.com/problems/split-array-largest-sum/
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty
 * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * Runtime: 58 ms, faster than 16.59% of Java online submissions for Split Array Largest Sum.
 * Memory: 42.8 MB, less than 9.48% of Java online submissions for Split Array Largest Sum.
 */
public class HardSplitArrayLargestSum {

    public final static void main(String[] args) {

        HardSplitArrayLargestSum tester = new HardSplitArrayLargestSum();
        int[] nums = {7,2,5,10,8};
        System.out.println(tester.splitArray(nums, 2) == 18); // Output: 18

        int[] nums2 = {1,2,3,4,5};
        System.out.println(tester.splitArray(nums2, 2) == 9); // Output: 9

        int[] nums3 = {1,4,4};
        System.out.println(tester.splitArray(nums3, 3) == 4); // Output: 4

    }

    // Dynamic programming
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m][n];
        dp[0][0] = nums[0];
        for( int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + nums[i];
        }

        for(int j = 1; j < m; j++) { // #splits is j + 1 as j = 1, 2, ..., m-1
            for(int i = j; i < n ; i++) { // split subarray [0, i] into j+1 parts
                int min = Integer.MAX_VALUE;
                for (int k = j - 1; k < i; k++) {
                    min = Math.min(min, Math.max( dp[j-1][k], dp[0][i] - dp[0][k] ));
                }
                dp[j][i] = min;
            }
        }
        return dp[m-1][n-1];
    }

}
