package com.leetcode.amazon;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * 53. Maximum Subarray (Easy)
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.  A subarray is a contiguous part of an array.
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
 * Memory: 51.4 MB, less than 94.94% of Java online submissions for Maximum Subarray.
 */
public class EasyMaxSumSub {

    public final static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        EasyMaxSumSub tester = new EasyMaxSumSub();
        System.out.println(tester.maxSubArray(nums)); // must be 6

    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        
        int i = 0;
        while( i < nums.length ) {
            sum += nums[i];
            if( sum > max)
                max = sum;
            if( sum < 0 )
                sum = 0;
            i++;
        }
        return max;

    }

}
