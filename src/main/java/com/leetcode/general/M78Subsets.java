package com.leetcode.general;

import java.util.*;

/**
 * Question: 78. Subsets
 * Description: https://leetcode.com/problems/subsets/
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class M78Subsets {

    public static void main(String[] args) {
        M78Subsets tester = new M78Subsets();
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> result = (new M78Subsets()).subsets(nums);
        System.out.println(result);
    }
    /*
    Runtime: 1 ms, faster than 52.50% of Java online submissions for Subsets.
    Memory Usage: 38.7 MB, less than 98.76% of Java online submissions for Subsets.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
        return subsets;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> workingSet, List<List<Integer>> subsets) {
        subsets.add(new ArrayList(workingSet));
        for(int i = index; i < nums.length; i++) {
            workingSet.add(nums[i]);
            generateSubsets(i+1, nums, workingSet, subsets);
            workingSet.remove(workingSet.size() - 1);
        }
    }

}
