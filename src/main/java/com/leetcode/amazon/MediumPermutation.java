package com.leetcode.amazon;

import java.util.*;

/**
 * Leet 46. Permutations (Medium)
 * Link: https://leetcode.com/problems/permutations/
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * Runtime: 4 ms, faster than 26.63% of Java online submissions for Permutations.
 * Memory Usage: 41.9 MB, less than 11.74% of Java online submissions for Permutations.
 */
public class MediumPermutation {

    public static final void main(String[] args) {
        int[] nums = {1,2,3};
        // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        MediumPermutation tester = new MediumPermutation();
        List<List<Integer>> result = tester.permute(nums);
        for(List<Integer> oneList: result ) {
            for(Integer num: oneList ) {
                System.out.print(num);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        return permute(0, nums);
    }


    public List<List<Integer>> permute(int start, int[] nums) {

        List<List<Integer>> all = new ArrayList();
        if (start == (nums.length - 1)) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[start]);
            all.add(list);
            return all;
        }

        for (int j = start; j < nums.length; j++) {
            swap(start, j, nums); //swap forward, j = start, no op
            List<List<Integer>> past = permute(start + 1, nums); // rest permute
            for( List<Integer> list: past) {
                list.add(0, nums[start]);
                all.add(list);
            }
            swap(start, j, nums);  //swap back
        }

        return all;


    }

    private void swap(int i, int j, int[] chars) {
        if( i == j ) return;
        int temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
