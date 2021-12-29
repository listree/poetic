package com.leetcode.amazon;
import java.util.*;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 215. Kth Largest Element in an Array (Medium)
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Runtime: 4 ms, faster than 81.28% of Java online submissions for Kth Largest Element in an Array.
 * Memory: 45 MB, less than 36.28% of Java online submissions for Kth Largest Element in an Array.
 */
public class KthLargestElement {

    public final static void main(String[] args) {
        KthLargestElement tester = new KthLargestElement();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(tester.findKthLargest(nums, 2));
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(tester.findKthLargest(nums2, 4));

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        for(int x: nums) {
            if( queue.size() == k ) {
                if( x > queue.peek() ) {
                    queue.poll();
                    queue.add(x);
                }
            }  else {
                queue.add(x);
            }
        }
        return queue.peek();

    }
}
