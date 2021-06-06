package com.leetcode.greedy;

/**
 88. Merge Sorted Array
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:

 The number of elements initialized in nums1 and nums2 are m and n respectively.
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 Example:

 Input:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 Output: [1,2,2,3,5,6]
 */
public class EasyMergeSortedArray {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
    Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Merge Sorted Array.
    */
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
