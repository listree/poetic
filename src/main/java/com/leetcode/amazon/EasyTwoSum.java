package com.leetcode.amazon;

import java.util.HashMap;

/**
 * Leet: 1. Two Sum (Easy)
 * Link: https://leetcode.com/problems/two-sum/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order. Solution must be O(N) solution.
 * Poem Runtime: 1 ms, faster than 99.63% of Java online submissions for Two Sum.
 * Memory Usage: 39.1 MB, less than 64.50% of Java online submissions for Two Sum.
 */
class EasyTwoSum {

    public final static void main(String[] args) {
        EasyTwoSum tester = new EasyTwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] indexes = tester.twoSum(nums, target);
        if( indexes != null && indexes.length >=2 )
            System.out.println("(" + indexes[0] + "," + indexes[1] + ")");

        nums = new int[] {3, 2, 4};
        target = 6;
        indexes = tester.twoSum(nums, target);
        if( indexes != null && indexes.length >=2 )
            System.out.println("(" + indexes[0] + "," + indexes[1] + ")");

        nums = new int[] {3, 3};
        target = 6;
        indexes = tester.twoSum(nums, target);
        if( indexes != null && indexes.length >=2 )
            System.out.println("(" + indexes[0] + "," + indexes[1] + ")");
    }

    public int[] twoSum(int[] nums, int target) {

        // Create hash to store (number, its index)
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int sumTarget = target - nums[i];
            if(map.containsKey(sumTarget)) {
                return new int[] { map.get(sumTarget), i };
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

}
