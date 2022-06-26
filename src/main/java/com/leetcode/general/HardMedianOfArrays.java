package com.leetcode.general;

/**
 * Question: 4. Median of Two Sorted Arrays (Hard)
 * Description: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * Poem Runtime: 2 ms, faster than 99.88% of Java online submissions for Median of Two Sorted Arrays.
 * Memory Usage: 39.9 MB, less than 89.42% of Java online submissions for Median of Two Sorted Arrays.
 */
public class HardMedianOfArrays {

    public static final void main(String[] args) {

        HardMedianOfArrays tester = new HardMedianOfArrays();
        int[] x1 = {1,3};
        int[] y1 = {2};
        System.out.println(tester.findMedianSortedArrays(x1,y1));


        int[] x2 = {1,2};
        int[] y2 = {3,4};
        System.out.println(tester.findMedianSortedArrays(x2,y2));

        int[] x3 = {0,0};
        int[] y3 = {0,0};
        System.out.println(tester.findMedianSortedArrays(x3,y3));

        int[] x4 = {};
        int[] y4 = {1};
        System.out.println(tester.findMedianSortedArrays(x4,y4));

        int[] x5 = {2};
        int[] y5 = {};
        System.out.println(tester.findMedianSortedArrays(x5,y5));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int total = nums1.length + nums2.length;
        // {1,2}, {3} => 1, {1,2}, {3,4} => 1
        int middle = total % 2 == 1 ? (total / 2 + 1) : (total / 2);

        int i = 0;
        int j = 0;
        int value = -1;
        while( middle > 0 ) {
            int[] result = findNext(i, j, nums1, nums2);
            i = result[0];
            j = result[1];
            value = result[2];
            middle--;
        }

        if( total % 2 == 1 ) {
            return (double) value;
        } else {
            int[] result = findNext(i,j, nums1, nums2);
            return ((double) (value + result[2])) / 2.0;
        }

    }

    private int[] findNext(int index1, int index2, int[] nums1, int[] nums2) {
        if( index1 >= nums1.length )
            return new int[]{index1, index2+1, nums2[index2]};

        if( index2 >= nums2.length )
            return new int[]{index1+1, index2, nums1[index1]};

        if( nums1[index1] < nums2[index2] )
            return new int[]{index1+1, index2, nums1[index1]};
        else
            return new int[]{index1, index2+1, nums2[index2]};
    }

}
