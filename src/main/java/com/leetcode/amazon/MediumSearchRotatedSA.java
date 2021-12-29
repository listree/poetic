package com.leetcode.amazon;

/**
 * Leet: 33. Search in Rotated Sorted Array (Medium)
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums. You must write an algorithm with O(log n) runtime complexity.
 * Runtime: 1 ms, faster than 29.60% of Java online submissions for Search in Rotated Sorted Array.
 * Memory Usage: 39.6 MB, less than 12.34% of Java online submissions for Search in Rotated Sorted Array.
*/

public class MediumSearchRotatedSA {

    public final static void main(String[] args) {
        MediumSearchRotatedSA tester = new MediumSearchRotatedSA();
        //int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {4,5,6,7,8,1,2,3};
        System.out.println(tester.search(nums, 8));

    }

    public int search(int[] nums, int target) {
        if( nums.length == 0 )
            return -1;

        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int left, int right, int target) {

        if( nums[left] == target)
            return left;

        if( nums[right] == target)
            return right;

        if( right == left )
            return (target == nums[left]) ? left : -1;

        int middle = (left + right) / 2;

        if( possibleMatch(nums[left], nums[middle], target) )
            return search(nums, left, middle, target);

        if( possibleMatch(nums[middle+1], nums[right], target) )
            return search(nums, middle+1, right, target);

        return -1;

    }

    private boolean possibleMatch(int leftValue, int rightValue, int target) {
        if( leftValue < rightValue ) { // strictly ascending
            return leftValue <= target && rightValue >= target;
        } else { // rotated ascending
            return !(target > rightValue && target < leftValue);
        }
    }

}
