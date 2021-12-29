package com.leetcode.greedy;

/**
 * 88. Merge Sorted Array (Easy)
 * https://leetcode.com/problems/merge-sorted-array/
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Poem Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
 * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Merge Sorted Array.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mn = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while( i < m && j < n) {
            if( nums1[i] < nums2[j] ) {
                mn[k++] = nums1[i++];
            } else {
                mn[k++] = nums2[j++];
            }
        }

        while( i < m ) {
            mn[k++] = nums1[i++];
        }

        while( j < n ) {
            mn[k++] = nums2[j++];
        }

        k = 0;
        while( k < (m+n) ) {
            nums1[k] = mn[k];
            k++;
        }
    }


}
